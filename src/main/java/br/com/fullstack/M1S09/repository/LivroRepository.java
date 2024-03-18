package br.com.fullstack.M1S09.repository;

import br.com.fullstack.M1S09.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    @Query(value = "update livro set " +
            " titulo = :titulo," +
            " autor = :autor, " +
            " anoPublicacao = :anoPublicacao " +
            " where id = :id",
            nativeQuery = true

    )
    LivroEntity update(@Param("id") Long id,
                        @Param("titulo") String titulo,
                        @Param("autor") String autor,
                        @Param("anoPublicacao") String anoPublicacao);
}