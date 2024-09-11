package br.com.supertreino.api.model.profile;

import br.com.supertreino.api.model.profile.endereco.Endereco;
import br.com.supertreino.api.model.profile.telefone.Telefone;

public record DadosDetalhesPerfil(Long id, String nome, String email, String cpf, String nascimento, Telefone telefone, Endereco endereco) {

    public DadosDetalhesPerfil(Perfil perfil) {
        this(perfil.getId(), perfil.getNomecompleto(), perfil.getEmail(),
                perfil.getCpf(), perfil.getNascimento(), perfil.getTelefone(), perfil.getEndereco());
    }
}
