package com.phoenix.pdfGenerator.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.phoenix.pdfGenerator.enumerated.StatusMatricula;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
public class AlunoDto {

    @NotBlank(message="Este campo não pode ser nulo!")
    private String nome;
    @NotBlank(message="Este campo não pode ser nulo!")
    private String curso;
    @NotBlank(message="Este campo não pode ser nulo!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    @NotBlank(message="Este campo não pode ser nulo!")
    private String endereco;
    @NotBlank(message="Este campo não pode ser nulo!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicialCurso;
    @NotBlank(message="Este campo não pode ser nulo!")
    @Email
    private String email;
    @NotBlank(message="Este campo não pode ser nulo!")
    private String telefone;
    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;
}
