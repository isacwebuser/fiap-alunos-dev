package com.isac.students.Students.controller;

import com.isac.students.Students.student.Aluno;
import com.isac.students.Students.student.AlunoRepository;
import com.isac.students.Students.student.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public String cadastrar(@RequestBody DadosCadastroAluno dadosCadastroAluno) {
        this.alunoRepository.save(new Aluno(dadosCadastroAluno));
        return "Sucesso";
    }
}
