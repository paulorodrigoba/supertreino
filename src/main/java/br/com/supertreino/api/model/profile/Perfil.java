package br.com.supertreino.api.model.profile;

import br.com.supertreino.api.model.profile.endereco.Endereco;
import br.com.supertreino.api.model.profile.telefone.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "perfis")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    private String nomecompleto;

    @Column(nullable = false, unique = true)
    private String email;

    private double altura;
    private double peso;

    @Column(nullable = false)
    private String nascimento;

    private String bio;
    private Boolean ativo;

    @Embedded
    private Telefone telefone;

    @Embedded
    private Endereco endereco;

    public Perfil(DadosCadastroPerfil dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.nomecompleto = dados.nome() + " " + dados.sobrenome();
        this.cpf = dados.cpf();
        this.nascimento = dados.nascimento();
        this.altura = dados.altura();
        this.peso = dados.peso();
        this.bio = dados.bio();
        this.email = dados.email();
        this.telefone = new Telefone(dados.telefone());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPerfil dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.sobrenome() != null) {
            this.sobrenome = dados.sobrenome();
        }
        if (dados.telefone() != null) {
            this.telefone.atualizarInformacoes(dados.telefone());
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
