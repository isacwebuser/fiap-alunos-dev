package com.isac.students.Students.controller;

import com.isac.students.Students.student.Aluno;
import com.isac.students.Students.student.AlunoRepository;
import com.isac.students.Students.student.DadosCadastroAluno;
import com.isac.students.Students.student.ListaDadosAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<ListaDadosAluno> listarAlunos(Pageable pagination) {
        return alunoRepository.findAll(pagination).map(ListaDadosAluno::new);
    }
}
