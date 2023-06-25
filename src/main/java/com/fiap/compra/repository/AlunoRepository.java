package com.fiap.compra.repository;

import com.fiap.compra.entity.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findClienteByRa (String ra);

    @Query("select a from Aluno a where a.deletedAt = null")
    Page<Aluno> getAllAlunos(Pageable pageable);
}
