package com.fiap.compra.service;

import com.fiap.compra.dto.CompraAlunoDTO;
import com.fiap.compra.entity.CompraAluno;
import org.springframework.stereotype.Service;

@Service
public interface ComprasService {

    CompraAluno efetuarCompra(long id, CompraAlunoDTO compra);


}
