package br.com.informatica.Informatica.controller;

import br.com.informatica.Informatica.business.ProfessorBusiness;
import br.com.informatica.Informatica.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/professores")
public class ProfessorController {
    private ProfessorBusiness professorBusiness;

    @Autowired
    public ProfessorController(ProfessorBusiness professorBusiness) {
        this.professorBusiness = professorBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.ok().body(professorBusiness.findAll());
    }

    @GetMapping("/{id}")
    public String findBy(@PathVariable int id) {
        return String.valueOf(id);
    }

    @PostMapping
    public ResponseEntity<Professor> post(@RequestBody Professor empresa) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empresa);
    }

}
