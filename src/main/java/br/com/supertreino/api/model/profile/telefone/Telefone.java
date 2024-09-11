package br.com.supertreino.api.model.profile.telefone;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {
    private String celular;
    private String fixo;
    private String recado;
    private String whatsapp;

    public Telefone(DadosTelefone dados) {
        this.celular = dados.celular();
        this.fixo = dados.fixo();
        this.recado = dados.recado();
        this.whatsapp = dados.whatsapp();
    }

    public void atualizarInformacoes(DadosTelefone dados) {
        if (dados.celular() != null) {
            this.celular = dados.celular();
        }
        if (dados.fixo() != null) {
            this.fixo = dados.fixo();
        }
        if (dados.recado() != null) {
            this.recado = dados.recado();
        }
        if (dados.whatsapp() != null) {
            this.whatsapp = dados.whatsapp();
        }
    }
}
