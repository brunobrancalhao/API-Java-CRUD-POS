package br.com.informatica.Informatica.controller;

import br.com.informatica.Informatica.business.AlunoBusiness;
import br.com.informatica.Informatica.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {
    private AlunoBusiness alunoBusiness;

    @Autowired
    public AlunoController(AlunoBusiness alunoBusiness) {
        this.alunoBusiness = alunoBusiness;
    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> findAll(@PageableDefault(size=10) Pageable pageable, @RequestParam(required = false) String nome) {

        if(nome != null){
            return ResponseEntity.ok().body(alunoBusiness.findAllByNomeContains(pageable,nome));
        } else {
            return ResponseEntity.ok().body(alunoBusiness.findAll(pageable));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> find(@PathVariable int id) {
        Aluno alu = alunoBusiness.findById(id);

        if (alu == null) {

        }

        return ResponseEntity.ok().body(alunoBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> post(@RequestBody Aluno aluno) {
        Aluno info = alunoBusiness.save(aluno);
        if(info == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(info);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(info);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> put(@PathVariable int id, @RequestBody Aluno aluno) {
        Aluno alu = alunoBusiness.put(id, aluno);

        if(alu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(alu);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable int id) {
        try {
            return alunoBusiness.deleteById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
