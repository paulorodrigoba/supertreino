package br.com.supertreino.api.model.fichatreino.dto;

import br.com.supertreino.api.model.exercicio.Exercicio;
import br.com.supertreino.api.model.fichatreino.Treino;

import java.util.List;

public record DadosListagemTreino(
        Long id,
        String nomeTreino,
        int repeticoes,
        double carga,
        List<Exercicio> exercicios
) {
    public DadosListagemTreino(Treino treino) {
        this(treino.getId(), treino.getNomeTreino(), treino.getRepeticoes(), treino.getCarga(), treino.getExercicios());
    }
}
