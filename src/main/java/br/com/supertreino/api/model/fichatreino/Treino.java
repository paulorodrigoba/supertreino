package br.com.supertreino.api.model.fichatreino;

import br.com.supertreino.api.model.exercicio.Exercicio;
import br.com.supertreino.api.model.fichatreino.dto.DadosAtualizacaoTreino;
import br.com.supertreino.api.model.fichatreino.dto.DadosCadastroTreino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "treino")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTreino;

    private int repeticoes;

    private double carga;

    @ManyToMany
    @JoinTable(
            name = "treino_exercicio",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private List<Exercicio> exercicios;

    @ManyToOne
    @JoinColumn(name = "ficha_treino_id")
    private FichaTreino fichaTreino;

    public Treino(DadosCadastroTreino dados, FichaTreino fichaTreino) {
        this.nomeTreino = dados.nomeTreino();
        this.repeticoes = dados.repeticoes();
        this.carga = dados.carga();
        this.exercicios = dados.exercicios();
        this.fichaTreino = fichaTreino;
    }

    public void atualizarInformacoes(DadosAtualizacaoTreino dados) {
        if (dados.nomeTreino() != null) {
            this.nomeTreino = dados.nomeTreino();
        }
        if (dados.repeticoes() != null) {
            this.repeticoes = dados.repeticoes();
        }
        if (dados.carga() != null) {
            this.carga = dados.carga();
        }
        if (dados.exercicios() != null) {
            this.exercicios = dados.exercicios();
        }
    }
}
