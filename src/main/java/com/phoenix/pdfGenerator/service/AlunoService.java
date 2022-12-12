package com.phoenix.pdfGenerator.service;

import com.phoenix.pdfGenerator.enumerated.StatusMatricula;
import com.phoenix.pdfGenerator.model.Aluno;
import com.phoenix.pdfGenerator.repository.AlunoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepositoy alunoRepositoy;

    public Aluno saveAluno(Aluno aluno){
        aluno.setStatusMatricula(StatusMatricula.ATIVO);
        return alunoRepositoy.save(aluno);
    }

    public List<Aluno> findAllAlunos(){
        return alunoRepositoy.findAll();
    }

    public Aluno findByMatricula(Long matricula){
        Aluno aluno = alunoRepositoy.findById(matricula).get();
        return aluno;
    }

    public void deleteAluno(Long id){
        Aluno aluno = findByMatricula(id);
        alunoRepositoy.delete(aluno);
    }

    public void inativaMatricula(Aluno aluno){
        aluno.setStatusMatricula(StatusMatricula.INATIVO);
        alunoRepositoy.save(aluno);
    }
}
