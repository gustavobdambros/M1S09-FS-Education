package br.com.fullstack.M1S09.repository;

import br.com.fullstack.M1S09.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {

    @Query(value = "update membro set " +
            " nome = :nome," +
            " endereco = :endereco, " +
            " telefone = :telefone " +
            " where id = :id",
            nativeQuery = true

    )
    MembroEntity update(@Param("id") Long id,
                          @Param("nome") String nome,
                          @Param("endereco") String endereco,
                          @Param("telefone") String telefone);
                          }