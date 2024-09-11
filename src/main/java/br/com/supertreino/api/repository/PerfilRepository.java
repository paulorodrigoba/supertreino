package br.com.supertreino.api.model.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Page<Perfil> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo
            from Perfil p
            where
            p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
