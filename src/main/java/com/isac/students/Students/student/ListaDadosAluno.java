package com.isac.students.Students.student;

public record ListaDadosAluno(
        Long id,
        String nome,
        Curso curso,
        String telefone,
        String cpf,
        String matricula
) {
    public  ListaDadosAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getCurso(), aluno.getTelefone(), aluno.getCpf(), aluno.getMatricula());
    }
}
