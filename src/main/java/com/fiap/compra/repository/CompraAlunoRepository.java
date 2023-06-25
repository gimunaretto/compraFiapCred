package com.fiap.compra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.compra.entity.CompraAluno;

@Repository
public interface CompraAlunoRepository extends JpaRepository<CompraAluno, Long> {
    List<CompraAluno> findByAlunoId(Long id);
}
