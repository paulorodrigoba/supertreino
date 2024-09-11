package br.com.supertreino.api.model.fichatreino;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ficha_treino")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FichaTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "fichaTreino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treino> treinoList = new ArrayList<>();

    public void adicionarTreino(Treino treino) {
        if (treinoList.size() < 7) {
            treinoList.add(treino);
        } else {
            throw new IllegalStateException("Não é possível adicionar mais de 7 treinos.");
        }
    }

}
