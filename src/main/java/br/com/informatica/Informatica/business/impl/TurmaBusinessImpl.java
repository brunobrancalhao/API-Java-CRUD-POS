package br.com.informatica.Informatica.business.impl;

import br.com.informatica.Informatica.business.TurmaBusiness;
import br.com.informatica.Informatica.exception.NotFoundException;
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
        return turmaRepository.findById(id).orElseThrow(() -> new NotFoundException("Erro: Turma com ID " + id + " Não foi encontrada"));
    }

    @Override
    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public void deleteById(int id) {
        turmaRepository.findById(id).orElseThrow(() -> new NotFoundException("Erro: Turma com ID " + id + " não foi encontrado!"));
        turmaRepository.deleteById(id);
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
