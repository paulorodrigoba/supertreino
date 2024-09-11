package br.com.supertreino.api.repository;

import br.com.supertreino.api.model.profile.Perfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
