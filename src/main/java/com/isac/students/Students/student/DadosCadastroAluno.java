package com.isac.students.Students.student;

import com.isac.students.Students.controller.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @NotNull
        Curso curso,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotBlank
        String matricula

) {
}
