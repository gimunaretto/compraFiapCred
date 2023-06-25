package com.fiap.compra.entity;

import com.fiap.compra.dto.AlunoDTO;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "aluno", schema = "fiap")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String ra;

    @Column(nullable = false, unique = true)
    private String cartao;

    @Column(nullable = false)
    private Integer limite;

    @Column(nullable = true)
    private LocalDate deletedAt;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<CompraAluno> comprasAluno;

    public Aluno() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<CompraAluno> getComprasAluno() {
        return comprasAluno;
    }

    public void setComprasAluno(List<CompraAluno> comprasAluno) {
        this.comprasAluno = comprasAluno;
    }

    public AlunoDTO _toDto() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(id);
        alunoDTO.setNome(nome);
        alunoDTO.setRa(ra);
        alunoDTO.setCartao(cartao);
        alunoDTO.setLimite(limite);
        alunoDTO.setDeletedAt(deletedAt);
        return alunoDTO;
    }
}
