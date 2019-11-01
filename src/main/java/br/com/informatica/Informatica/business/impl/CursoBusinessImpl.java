package br.com.informatica.Informatica.business.impl;

import br.com.informatica.Informatica.business.CursoBusiness;
import br.com.informatica.Informatica.exception.NotFoundException;
import br.com.informatica.Informatica.model.Curso;
import br.com.informatica.Informatica.repository.CursoRepository;
import br.com.informatica.Informatica.repository.MateriaRepository;
import br.com.informatica.Informatica.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoBusinessImpl implements CursoBusiness {

    private CursoRepository cursoRepository;
    private MateriaRepository materiaRepository;
    private TurmaRepository turmaRepository;

    @Autowired
    public CursoBusinessImpl(CursoRepository cursoRepository, MateriaRepository materiaRepository, TurmaRepository turmaRepository) {
        this.cursoRepository = cursoRepository;
        this.materiaRepository = materiaRepository;
        this.turmaRepository = turmaRepository;
    }

    @Override
    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    @Override
    public Curso findById(int id) {
        return cursoRepository.findById(id).orElseThrow(() -> new NotFoundException("Erro: Curso com ID " + id + " não foi encontrado!"));
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(int id) {
        cursoRepository.findById(id).orElseThrow(() -> new NotFoundException("Erro: Curso com ID " + id + " não foi encontrado!"));
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso put(int id, Curso curso) {
        try {
            Curso cur = cursoRepository.findById(id).get();
            curso.setId(id);
            return cursoRepository.save(curso);

        } catch (Exception ex) {
            return null;
        }
    }
}
