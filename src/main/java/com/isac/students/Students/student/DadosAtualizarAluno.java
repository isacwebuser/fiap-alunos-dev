package com.isac.students.Students.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
        @NotNull
        Long id,
        String nome,
        Curso curso,
        String telefone,
        String cpf,
        String matricula
) {
}
