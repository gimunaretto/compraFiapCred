package com.fiap.compra.service;

import com.fiap.compra.dto.CompraAlunoDTO;
import com.fiap.compra.entity.Aluno;
import com.fiap.compra.entity.CompraAluno;
import com.fiap.compra.entity.model.StatusCompra;
import com.fiap.compra.repository.AlunoRepository;
import com.fiap.compra.repository.CompraAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    private AlunosService alunosService;

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    CompraAlunoRepository compraRepository;

    public ComprasServiceImpl() {
    }

    @Override
    public CompraAluno efetuarCompra(long id, CompraAlunoDTO compraDTO) {

        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            CompraAluno compra = compraDTO._toEntity();
            compra.setAluno(aluno);
            compra.setStatusCompra(StatusCompra.AGUARDANDO);

            if (aluno.getLimite() >= compraDTO.getValor()) {
                compra.setStatusCompra(StatusCompra.APROVADO);
                aluno.setLimite((int) Math.round(aluno.getLimite() - compraDTO.getValor()));
            } else {
                compra.setStatusCompra(StatusCompra.CANCELADO);

            }
            compra.setData(LocalDate.now());
            compraRepository.save(compra);
            alunoRepository.save(aluno);
            return compra;

        } else {
            return null;
        }

    }


//    public CompraAlunoDTO efetuarCompra(long id, CompraAlunoDTO compra) {
//        compra.setAluno(  alunosService.get(id).get());
//
//        // TO-DO: Consumir o endpoint da AUTORIZADA!
//        // localhost:8083/api/alunos/1295/comprar
//        // body = CompraAlunoDTO
//
//        // MOCKAR A LOGICA DE AUTORIZAÇÃO
//        if (!Objects.isNull(compra) &&
//                !Objects.isNull(compra.getAluno()) &&
//                compra.getAluno().getLimite() >= compra.getValor()){
//            compra.setStatusCompra(StatusCompra.APROVADO);
//        } else {
//            compra.setStatusCompra(StatusCompra.CANCELADO);
//        }
//
//        return compra;
//    }


}
