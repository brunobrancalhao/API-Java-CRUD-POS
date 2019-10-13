package br.com.informatica.Informatica.business;

import br.com.informatica.Informatica.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AlunoBusiness {
    Page<Aluno> findAll(Pageable pageable);
    Aluno findById(int id);
    Aluno save(Aluno aluno);
    ResponseEntity<Aluno> deleteById(int id);
    Aluno put(int id, Aluno aluno);
}
