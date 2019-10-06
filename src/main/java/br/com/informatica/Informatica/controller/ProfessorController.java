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
    public ResponseEntity<Professor> findBy(@PathVariable int id) {
        return ResponseEntity.ok().body(professorBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> post(@RequestBody Professor professor) {

        return (ResponseEntity<Professor>) ResponseEntity
                .status(HttpStatus.CREATED)
                .body(professorBusiness.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> delete(@PathVariable int id) {
        try {
            return professorBusiness.deleteById(id);
         } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> put(@PathVariable int id, @RequestBody Professor professor) {
        Professor info = professorBusiness.put(id, professor);

        if(info == null) {
            return (ResponseEntity<Professor>) ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(info);
        }
        return (ResponseEntity<Professor>) ResponseEntity
                .status(HttpStatus.CREATED)
                .body(info);

    }

}
