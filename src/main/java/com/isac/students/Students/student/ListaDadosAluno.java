package com.isac.students.Students.student;

import com.isac.students.Students.controller.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListaDadosAluno(
        String nome,
        Curso curso,
        String telefone,
        String cpf,
        String matricula
) {
    public  ListaDadosAluno(Aluno aluno){
        this(aluno.getNome(), aluno.getCurso(), aluno.getTelefone(), aluno.getCpf(), aluno.getMatricula());
    }
}
