package br.com.supertreino.api.model.profile;

import br.com.supertreino.api.model.profile.endereco.DadosEndereco;
import br.com.supertreino.api.model.profile.telefone.DadosTelefone;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPerfil(
        @NotNull
        Long id,
        String nome,
        String sobrenome,
        DadosTelefone telefone,
        DadosEndereco endereco
) {
}
