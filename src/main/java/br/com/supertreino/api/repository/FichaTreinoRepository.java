package br.com.supertreino.api.repository;

import br.com.supertreino.api.model.fichatreino.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
}

