package br.com.supertreino.api.controller;

import br.com.supertreino.api.model.profile.*;
import br.com.supertreino.api.repository.PerfilRepository;
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
@RequestMapping("perfil")
public class PerfilController {
    @Autowired
    private PerfilRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPerfil dados, UriComponentsBuilder uriBuilder) {
        var perfil = new Perfil(dados);
        repository.save(perfil);
        var uri = uriBuilder.path("/perfil/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesPerfil(perfil));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPerfil>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPerfil::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPerfil dados) {
        var perfil = repository.getReferenceById(dados.id());
        perfil.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhesPerfil(perfil));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var perfil = repository.getReferenceById(id);
        perfil.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var perfil = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesPerfil(perfil));
    }
}
