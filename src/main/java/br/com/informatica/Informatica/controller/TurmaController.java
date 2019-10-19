package br.com.informatica.Informatica.controller;

import br.com.informatica.Informatica.business.TurmaBusiness;
import br.com.informatica.Informatica.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/turmas")
public class TurmaController {
    private TurmaBusiness turmaBusiness;

    @Autowired
    public TurmaController(TurmaBusiness turmaBusiness) {
        this.turmaBusiness = turmaBusiness;
    }

    @GetMapping
    public ResponseEntity<Page<Turma>> findAll(@PageableDefault(size=10) Pageable pageable) {

        return ResponseEntity.ok().body(turmaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findBy(@PathVariable int id) {
        return ResponseEntity.ok().body(turmaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Turma> post(@RequestBody Turma turma) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(turmaBusiness.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> put(@PathVariable int id, @RequestBody Turma turma) {
        Turma info = turmaBusiness.put(id, turma);

        if(info == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(info);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(info);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turma> delete(@PathVariable int id) {
        try {
            return turmaBusiness.deleteById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
