package br.com.fullstack.M1S09.repository;

import br.com.fullstack.M1S09.entities.BibliotecarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioEntity, Long> {

    @Query(value = "update bibliotecario set " +
            " nome = :nome," +
            " email = :email, " +
            " senha = :senha " +
            " where id = :id",
            nativeQuery = true

    )
    BibliotecarioEntity update(@Param("id") Long id,
                       @Param("nome") String nome,
                       @Param("email") String email,
                       @Param("senha") String senha);
}