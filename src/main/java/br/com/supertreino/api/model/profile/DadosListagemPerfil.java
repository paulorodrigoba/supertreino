package br.com.supertreino.api.model.profile;

public record DadosListagemPerfil(Long id, String nomecompleto, String email) {

    public DadosListagemPerfil(Perfil perfil) {
        this(perfil.getId(), perfil.getNomecompleto(), perfil.getEmail());
    }
}
