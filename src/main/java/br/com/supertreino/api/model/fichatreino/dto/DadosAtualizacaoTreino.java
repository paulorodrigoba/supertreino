package br.com.supertreino.api.model.fichatreino.dto;

import br.com.supertreino.api.model.exercicio.Exercicio;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DadosAtualizacaoTreino(
        @NotNull Long id,
        String nomeTreino,
        Integer repeticoes,
        Double carga,
        List<Exercicio> exercicios
) {
}
