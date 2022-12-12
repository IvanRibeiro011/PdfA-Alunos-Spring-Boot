package com.phoenix.pdfGenerator.controller;

import com.phoenix.pdfGenerator.dtos.AlunoDto;
import com.phoenix.pdfGenerator.model.Aluno;
import com.phoenix.pdfGenerator.service.AlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable("id") Long id){
        Aluno aluno = alunoService.findByMatricula(id);
        return new ResponseEntity<>(aluno,HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Aluno>> findAllAlunos(){
        return new ResponseEntity<>(alunoService.findAllAlunos(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Aluno> createAluno(@RequestBody AlunoDto alunoDto){
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto,aluno);
        alunoService.saveAluno(aluno);
        return new ResponseEntity<>(aluno,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable("id") Long id,@RequestBody Aluno aluno){
        if(alunoService.findByMatricula(id) != null){
            Aluno alunoCop = new Aluno();
            BeanUtils.copyProperties(aluno,alunoCop);
            alunoCop.setMatricula(alunoService.findByMatricula(id).getMatricula());
            alunoService.saveAluno(alunoCop);
            return new ResponseEntity<>(alunoCop,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable("id") Long id){
           try{
               alunoService.deleteAluno(id);
               return new ResponseEntity<>("Aluno deletado com sucesso!" , HttpStatus.OK);
        }
           catch (Exception e){
               return new ResponseEntity<>("Ocorreu um erro" , HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }

    @PutMapping("/inativar/{matricula}")
    public ResponseEntity<String> inativaMatricula(@PathVariable("matricula") Long matricula){
        if(alunoService.findByMatricula(matricula) != null){
            Aluno aluno = alunoService.findByMatricula(matricula);
            alunoService.inativaMatricula(aluno);
            return new ResponseEntity<>("Aluno Inativado!" , HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
