package br.com.supertreino.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosUpdateExercicio(
        @NotNull
        Long id,
        String nomeExercicio,
        GrupoMuscular grupoMuscular
) {

}
