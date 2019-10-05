package br.com.informatica.Informatica.business;

import br.com.informatica.Informatica.model.Professor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfessorBusiness {
    List<Professor> findAll();
    Professor findById(int id);
    Professor save(Professor professor);
    void deleteById(int id);
    Professor put(int id, Professor professor);
}
