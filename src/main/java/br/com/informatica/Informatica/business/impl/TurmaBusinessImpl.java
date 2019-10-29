package br.com.informatica.Informatica.business.impl;

import br.com.informatica.Informatica.business.TurmaBusiness;
import br.com.informatica.Informatica.exception.TurmaNotFoundException;
import br.com.informatica.Informatica.model.Turma;
import br.com.informatica.Informatica.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TurmaBusinessImpl implements TurmaBusiness {

    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaBusinessImpl(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Override
    public Page<Turma> findAll(Pageable pageable) {
        return turmaRepository.findAll(pageable);
    }

    @Override
    public Turma findById(int id) {
        return turmaRepository.findById(id).orElseThrow(() -> new TurmaNotFoundException(id));
    }

    @Override
    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public ResponseEntity<Turma> deleteById(int id) {
        turmaRepository.deleteById(id);
        return null;
    }

    @Override
    public Turma put(int id, Turma turma) {
        try {
            Turma tur = turmaRepository.findById(id).get();
            turma.setId(id);
            return turmaRepository.save(turma);

        } catch (Exception ex) {
            return null;
        }
    }

}
