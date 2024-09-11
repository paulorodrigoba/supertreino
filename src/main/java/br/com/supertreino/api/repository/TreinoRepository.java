package br.com.supertreino.api.repository;

import br.com.supertreino.api.model.fichatreino.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
