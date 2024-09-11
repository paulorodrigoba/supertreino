package br.com.supertreino.api.model.exercicio;

import jakarta.validation.constraints.NotNull;

public record DadosUpdateExercicio(
        @NotNull
        Long id,
        String nomeExercicio,
        GrupoMuscular grupoMuscular
) {
}
