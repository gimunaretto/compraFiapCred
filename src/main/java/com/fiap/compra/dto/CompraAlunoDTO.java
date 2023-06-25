package com.fiap.compra.dto;

import com.fiap.compra.entity.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.compra.entity.CompraAluno;
import com.fiap.compra.entity.model.StatusCompra;

import java.io.Serializable;
import java.time.LocalDate;

public class CompraAlunoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate data;
    private String estabelecimento;
    private Double valor;
    private StatusCompra statusCompra;

    @JsonIgnore
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusCompra getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(StatusCompra statusCompra) {
        this.statusCompra = statusCompra;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public CompraAlunoDTO() {

    }

    public CompraAluno _toEntity() {
        CompraAluno compraAluno = new CompraAluno();
        compraAluno.setId(id);
        compraAluno.setAluno(aluno);
        compraAluno.setData(data);
        compraAluno.setStatusCompra(statusCompra);
        compraAluno.setValor(valor);
        compraAluno.setEstabelecimento(estabelecimento);
        return compraAluno;
    }

    public CompraAlunoDTO(CompraAlunoDTO compraAlunoDTO) {
        this.id = compraAlunoDTO.getId();
        this.data = compraAlunoDTO.getData();
        this.aluno = compraAlunoDTO.getAluno();
        this.statusCompra = compraAlunoDTO.getStatusCompra();
        this.valor = compraAlunoDTO.getValor();
        this.estabelecimento = compraAlunoDTO.estabelecimento;
    }
}
