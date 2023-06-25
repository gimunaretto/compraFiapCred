package com.fiap.compra.entity;

import com.fiap.compra.dto.CompraAlunoDTO;
import com.fiap.compra.entity.model.StatusCompra;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "compra_aluno", schema = "fiap")
public class CompraAluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data = LocalDate.now();

    @Column(nullable = false)
    private StatusCompra statusCompra;

    @Column(nullable = false)
    private String estabelecimento;

    @Column(nullable = false)
    private Double valor;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    public CompraAluno() {}

    public CompraAluno(CompraAlunoDTO compraAlunoDTO) {
        this.data = compraAlunoDTO.getData();
        this.valor = compraAlunoDTO.getValor();
        this.aluno = compraAlunoDTO.getAluno();
        this.estabelecimento = compraAlunoDTO.getEstabelecimento();
        this.statusCompra = compraAlunoDTO.getStatusCompra();
    }

    public CompraAlunoDTO _toDto() {
        CompraAlunoDTO compraAlunoDTO = new CompraAlunoDTO();
        compraAlunoDTO.setId(id);
        compraAlunoDTO.setAluno(aluno);
        compraAlunoDTO.setData(data);
        compraAlunoDTO.setStatusCompra(statusCompra);
        compraAlunoDTO.setValor(valor);
        compraAlunoDTO.setEstabelecimento(estabelecimento);
        return compraAlunoDTO;
    }

    public CompraAluno(Long id, LocalDate data, StatusCompra statusCompra, String estabelecimento, Double valor, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.statusCompra = statusCompra;
        this.estabelecimento = estabelecimento;
        this.valor = valor;
        this.aluno = aluno;
    }

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

    public StatusCompra getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(StatusCompra statusCompra) {
        this.statusCompra = statusCompra;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
