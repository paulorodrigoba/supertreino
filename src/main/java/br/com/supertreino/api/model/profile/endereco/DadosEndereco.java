package br.com.supertreino.api.model.profile.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
@Valid
public record DadosEndereco(
        String logradouro,
        String bairro,
        @Pattern(regexp = "\\d{8}")
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
}
