package br.com.supertreino.api.controller;

import br.com.supertreino.api.model.fichatreino.FichaTreino;
import br.com.supertreino.api.model.fichatreino.Treino;
import br.com.supertreino.api.model.fichatreino.dto.DadosCadastroTreino;
import br.com.supertreino.api.repository.FichaTreinoRepository;
import br.com.supertreino.api.repository.TreinoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichatreino")
public class FichaTreinoController {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<FichaTreino> criarFichaTreino() {
        FichaTreino fichaTreino = new FichaTreino();
        fichaTreinoRepository.save(fichaTreino);
        return ResponseEntity.ok(fichaTreino);
    }

    @PostMapping("/{fichaId}/treinos")
    @Transactional
    public ResponseEntity<Treino> adicionarTreino(@PathVariable Long fichaId, @RequestBody @Valid DadosCadastroTreino dados) {
        FichaTreino fichaTreino = fichaTreinoRepository.findById(fichaId).orElseThrow(() -> new IllegalArgumentException("Ficha de treino não encontrada"));
        Treino treino = new Treino(dados, fichaTreino);
        fichaTreino.adicionarTreino(treino);
        treinoRepository.save(treino);
        fichaTreinoRepository.save(fichaTreino);
        return ResponseEntity.ok(treino);
    }

    @GetMapping("/{fichaId}/treinos")
    public ResponseEntity<List<Treino>> listarTreinos(@PathVariable Long fichaId) {
        FichaTreino fichaTreino = fichaTreinoRepository.findById(fichaId).orElseThrow(() -> new IllegalArgumentException("Ficha de treino não encontrada"));
        return ResponseEntity.ok(fichaTreino.getTreinoList());
    }
}
