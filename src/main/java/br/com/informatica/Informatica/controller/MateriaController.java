package br.com.informatica.Informatica.controller;

import br.com.informatica.Informatica.business.MateriaBusiness;
import br.com.informatica.Informatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/materias")
public class MateriaController {
    private MateriaBusiness materiaBusiness;

    @Autowired
    public MateriaController(MateriaBusiness materiaBusiness) {
        this.materiaBusiness = materiaBusiness;
    }

    @GetMapping
    public ResponseEntity<Page<Materia>> findAll(@PageableDefault(size=10) Pageable pageable) {
        return ResponseEntity.ok().body(materiaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> find(@PathVariable int id) {
        Materia mat = materiaBusiness.findById(id);

        if (mat == null) {

        }

        return ResponseEntity.ok().body(materiaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Materia> post(@RequestBody Materia materia) {

        return (ResponseEntity<Materia>) ResponseEntity
                .status(HttpStatus.CREATED)
                .body(materiaBusiness.save(materia));
    }




}
