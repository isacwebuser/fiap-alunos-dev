package com.isac.students.Students.student;

import com.isac.students.Students.controller.Curso;
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
}
