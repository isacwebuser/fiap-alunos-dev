package com.isac.students.Students.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "students")
@Entity(name = "student")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String matricula;

    public Aluno(DadosCadastroAluno cadastroAluno) {
        this.nome = cadastroAluno.nome();
        this.telefone = cadastroAluno.telefone();
        this.cpf = cadastroAluno.cpf();
        this.curso = cadastroAluno.curso();
        this.matricula = cadastroAluno.matricula();

    }

    public void atualizarDadosAluno(DadosAtualizarAluno dadosAtualizarAluno) {
        if (dadosAtualizarAluno.nome() != null) {
            this.nome = dadosAtualizarAluno.nome();
        }
        if (dadosAtualizarAluno.cpf() != null) {
            this.cpf = dadosAtualizarAluno.cpf();
        }
        if (dadosAtualizarAluno.curso() != null) {
            this.curso = dadosAtualizarAluno.curso();
        }
        if (dadosAtualizarAluno.matricula() != null) {
            this.matricula = dadosAtualizarAluno.matricula();
        }
        if (dadosAtualizarAluno.telefone() != null) {
            this.telefone = dadosAtualizarAluno.telefone();
        }
        
    }
}
