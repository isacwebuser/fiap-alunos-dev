package com.isac.students.Students.student;

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
