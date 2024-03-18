package br.com.fullstack.M1S09.repository;

import br.com.fullstack.M1S09.entities.VisitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteEntity, Long> {

    @Query(value = "update visitante set " +
            " nome = :nome," +
            " telefone = :telefone, " +
            " where id = :id",
            nativeQuery = true

    )
    VisitanteEntity update(@Param("id") Long id,
                           @Param("nome") String titulo,
                           @Param("telefone") String autor);
}