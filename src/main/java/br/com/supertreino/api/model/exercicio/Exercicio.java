package br.com.supertreino.api.model.exercicio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicio_musculacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeExercicio;

    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;

    public Exercicio(DadosExercicio dados) {
        this.nomeExercicio = dados.nomeExercicio();
        this.grupoMuscular = dados.grupoMuscular();
    }

    public void atualizarInformacoes(DadosUpdateExercicio dados) {
        this.nomeExercicio = dados.nomeExercicio();
        this.grupoMuscular = dados.grupoMuscular();
    }

    public void excluir() {
    }
}
