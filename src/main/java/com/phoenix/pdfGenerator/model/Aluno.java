package com.phoenix.pdfGenerator.model;

import com.phoenix.pdfGenerator.enumerated.StatusMatricula;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name ="tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    private String nome;

    private String curso;

    private LocalDate dataNascimento;

    private String endereco;

    private LocalDate dataInicialCurso;

    private String email;

    private String telefone;
    private StatusMatricula statusMatricula;
}
