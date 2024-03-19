package br.com.fullstack.M1S09.repository;

import br.com.fullstack.M1S09.entities.EmprestimoEntity;
import br.com.fullstack.M1S09.entities.LivroEntity;
import br.com.fullstack.M1S09.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

    @Query(value = "update emprestimo set " +
            " livroId = :livroId," +
            " membroId = :membroId, " +
            " dataEmprestimo = :dataEmprestimo " +
            " dataDevolucao = :dataDevolucao " +
            " where id = :id",

            nativeQuery = true

    )
    EmprestimoEntity update(@Param("id") Long id,
                       @Param("livroId") LivroEntity livroId,
                       @Param("membroId") MembroEntity membroId,
                       @Param("dataEmprestimo") Date dataEmprestimo,
                       @Param("dataDevolucao") Date dataDevolucao);
}