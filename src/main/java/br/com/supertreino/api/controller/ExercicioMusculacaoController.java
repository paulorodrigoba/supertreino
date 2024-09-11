package br.com.supertreino.api.controller;

import br.com.supertreino.api.infra.ResourceNotFoundException;
import br.com.supertreino.api.model.exercicio.*;
import br.com.supertreino.api.repository.ExercicioMusculacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/exercicios")
public class ExercicioMusculacaoController {

    @Autowired
    private ExercicioMusculacaoRepository repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoExercicio> cadastrar(
            @RequestBody @Valid DadosExercicio dados,
            UriComponentsBuilder uriBuilder) {
        var exercicio = new Exercicio(dados);
        repositorio.save(exercicio);
        var uri = uriBuilder.path("/exercicios/{id}").buildAndExpand(exercicio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoExercicio(exercicio));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoExercicio>> listar(
            @PageableDefault(size = 10, sort = {"nomeExercicio"}) Pageable paginacao) {
        var page = repositorio.findAll(paginacao).map(DadosDetalhamentoExercicio::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoExercicio> atualizar(
            @RequestBody @Valid DadosUpdateExercicio dados) {
        var exercicio = repositorio.findById(dados.id()).orElseThrow(() ->
                new ResourceNotFoundException("Exercício não encontrado para o id: " + dados.id()));
        exercicio.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoExercicio(exercicio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var exercicio = repositorio.getReferenceById(id);
        exercicio.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var exercicio = repositorio.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoExercicio(exercicio));
    }


}
