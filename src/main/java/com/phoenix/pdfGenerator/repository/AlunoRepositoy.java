package com.phoenix.pdfGenerator.repository;

import com.phoenix.pdfGenerator.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositoy extends JpaRepository<Aluno,Long> {
}
