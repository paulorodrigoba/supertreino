package br.com.supertreino.api.model.profile;

import br.com.supertreino.api.model.profile.endereco.DadosEndereco;
import br.com.supertreino.api.model.profile.endereco.Endereco;
import br.com.supertreino.api.model.profile.telefone.DadosTelefone;
import br.com.supertreino.api.model.profile.telefone.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPerfil(
        @NotBlank
        String cpf,
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        String nomecompleto,
        @NotBlank @Email
        String email,
        double altura,
        double peso,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Data deve estar no formato dd/MM/yyyy")
        String nascimento,
        String bio,
        Boolean ativo,
        @Valid
        DadosTelefone telefone,
        @Valid
        DadosEndereco endereco
) {
}
