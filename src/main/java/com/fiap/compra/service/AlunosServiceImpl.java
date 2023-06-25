package com.fiap.compra.service;

import com.fiap.compra.dto.AlunoDTO;
import com.fiap.compra.entity.Aluno;
import com.fiap.compra.entity.CompraAluno;
import com.fiap.compra.repository.AlunoRepository;
import com.fiap.compra.repository.CompraAlunoRepository;
import com.fiap.compra.utils.Utilitarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class AlunosServiceImpl implements AlunosService {

    @Autowired
    AlunoRepository alunoRepository;
    
    @Autowired
    CompraAlunoRepository compraAlunoRepository;

    public AlunosServiceImpl() {
    }

    @Override
    public void cadastroInicial(MultipartFile arquivo) throws IOException {

        try {
            AtomicReference<Long> i = new AtomicReference<>(0L);
            BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo.getInputStream()));

            List<Aluno> alunos =
                reader.lines().collect(Collectors.toList())
                        .stream()
                        .filter( linha -> !linha.trim().isEmpty() && !linha.startsWith("------"))
                        .map( linha -> {
                            Aluno aluno = new Aluno();
                            aluno.setId(i.getAndSet(i.get() + 1));
                            aluno.setNome(linha.substring(0, 41).trim());
                            aluno.setRa(linha.substring(42, 55).trim().replace(" ", "").replace("-", ""));
                            aluno.setCartao(Utilitarios.gerarCartao());
                            aluno.setLimite(Utilitarios.gerarLimite());
                            return aluno;
                        })
                        .collect(Collectors.toList());

            alunoRepository.saveAll(alunos);

            reader.close();

        }
        catch (Exception e) {
            throw e;
        }

    }

    @Override
    @Transactional
    public Optional<Aluno> get(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno;
    }

    @Override
    @Transactional
    public Page<Aluno> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Aluno> listAlunos = alunoRepository.getAllAlunos(pageable);
        return listAlunos;
    }

    @Override
    public Aluno create(AlunoDTO alunoDTO) {
        Aluno aluno = alunoDTO._toEntity();
        alunoRepository.save(aluno);
        return aluno;
    }

    @Override
    public void update(Long id, AlunoDTO alunoDTO) {
        Aluno a = alunoRepository.findById(id).get();
        a.setNome(alunoDTO.getNome());
        Integer limite = alunoDTO.getLimite();
        if(limite != null) {
            a.setLimite(alunoDTO.getLimite());
        }
        alunoRepository.save(a);
    }
    public void delete(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(!aluno.isEmpty()) {
            aluno.get().setDeletedAt(LocalDate.now());
            alunoRepository.save(aluno.get());
        } else
            throw new RuntimeException("Não localizado");
        }

    @Override
    public List<CompraAluno> getExtrato(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            return compraAlunoRepository.findByAlunoId(aluno.getId());
        } else {
        }
        return null;
    }

}
