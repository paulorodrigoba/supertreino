package br.com.supertreino.api.repository;

import br.com.supertreino.api.model.exercicio.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioMusculacaoRepository extends JpaRepository<Exercicio, Long> {}
