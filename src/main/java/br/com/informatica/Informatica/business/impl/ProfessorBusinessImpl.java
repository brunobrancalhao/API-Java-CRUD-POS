package br.com.informatica.Informatica.business.impl;

import br.com.informatica.Informatica.business.ProfessorBusiness;
import br.com.informatica.Informatica.model.Professor;
import br.com.informatica.Informatica.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorBusinessImpl implements ProfessorBusiness {
    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorBusinessImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findById(int id) {
        return professorRepository.findById(id).get();
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteById(int id) {
        professorRepository.deleteById(id);
    }

    @Override
    public Professor put(int id, Professor professor) {

        Professor profe = professorRepository.findById(id).get();
        if(profe == null) {
            return null;
        } else {
            professor.setId(id);
            return professorRepository.save(professor);
        }
    }
}
