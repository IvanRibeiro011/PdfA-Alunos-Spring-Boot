package com.phoenix.pdfGenerator;

import com.phoenix.pdfGenerator.controller.AlunoController;
import com.phoenix.pdfGenerator.dtos.AlunoDto;
import com.phoenix.pdfGenerator.enumerated.StatusMatricula;
import com.phoenix.pdfGenerator.model.Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PdfAGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfAGeneratorApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("").allowedOrigins("").allowedHeaders("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS",
						"HEAD", "TRACE", "CONNECT");
			}
		};
	}
}
