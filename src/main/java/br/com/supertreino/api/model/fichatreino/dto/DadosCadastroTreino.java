package br.com.supertreino.api.model.fichatreino;

import br.com.supertreino.api.model.exercicio.Exercicio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;


public record DadosCadastroTreino(
        @NotBlank String nomeTreino,
        @NotNull int repeticoes,
        @NotNull double carga,
        @NotNull List<Exercicio> exercicios
) {
}

