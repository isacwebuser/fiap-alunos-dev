package com.isac.students.Students.controller;

import com.isac.students.Students.student.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroAluno dadosCadastroAluno) {
        try {
            this.alunoRepository.save(new Aluno(dadosCadastroAluno));
            return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Revisar valores enviados nos campos Matrícula e/ou Curso", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Page<ListaDadosAluno> listarAlunos(Pageable pagination) {
        return alunoRepository.findAllByAtivoTrue(pagination).map(ListaDadosAluno::new);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizarAluno(@RequestBody @Valid DadosAtualizarAluno dadosAtualizarAluno) {
        try {
            var dadosAluno = this.alunoRepository.getReferenceById(dadosAtualizarAluno.id());
            dadosAluno.atualizarDadosAluno(dadosAtualizarAluno);
            return new ResponseEntity<>("Atualizado com sucesso", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        var student = this.alunoRepository.getReferenceById(id);
        student.deleteIdLogical();
        return new ResponseEntity<>("Aluno deletado com sucesso", HttpStatus.ACCEPTED);
    }
}
