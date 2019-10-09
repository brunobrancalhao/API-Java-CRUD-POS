package br.com.informatica.Informatica.business.impl;

import br.com.informatica.Informatica.business.MateriaBusiness;
import br.com.informatica.Informatica.model.Materia;
import br.com.informatica.Informatica.model.Professor;
import br.com.informatica.Informatica.repository.MateriaRepository;
import br.com.informatica.Informatica.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MateriaBusinessImpl  implements MateriaBusiness {
    private MateriaRepository materiaRepository;
    private ProfessorRepository professorRepository;

    @Autowired
    public MateriaBusinessImpl(MateriaRepository materiaRepository, ProfessorRepository professorRepository) {
        this.materiaRepository = materiaRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Page<Materia> findAll(Pageable pageable) {
        return materiaRepository.findAll(pageable);
    }

    @Override
    public Materia findById(int id) {
        return materiaRepository.findById(id).get();
    }

    @Override
    public Materia save(Materia materia) {
        try {
            Professor prof = professorRepository.findById(materia.getProfessor().getId()).get();
            return materiaRepository.save(materia);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public ResponseEntity<Materia> deleteById(int id) {
        materiaRepository.deleteById(id);
        return null;
    }

    @Override
    public Materia put(int id, Materia materia) {
        try {
            Materia mat = materiaRepository.findById(id).get();
            materia.setId(id);
            return materiaRepository.save(materia);

        } catch (Exception ex) {
            return null;
        }
    }
}
