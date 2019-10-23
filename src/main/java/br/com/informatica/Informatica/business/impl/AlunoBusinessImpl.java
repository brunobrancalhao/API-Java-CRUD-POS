package br.com.informatica.Informatica.business.impl;

import br.com.informatica.Informatica.business.AlunoBusiness;
import br.com.informatica.Informatica.model.Aluno;
import br.com.informatica.Informatica.repository.AlunoRepository;
import br.com.informatica.Informatica.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoBusinessImpl implements AlunoBusiness {

    private AlunoRepository alunoRepository;
    private TurmaRepository turmaRepository;

    @Autowired
    public AlunoBusinessImpl(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    @Override
    public Page<Aluno> findAll(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    @Override
    public Page<Aluno> findAllByNomeContains(Pageable pageable, String nome) {
        return alunoRepository.findAllByNomeContains(pageable,nome);
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public TurmaRepository getTurmaRepository() {
        return turmaRepository;
    }

    public void setTurmaRepository(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Override
    public Aluno findById(int id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public ResponseEntity<Aluno> deleteById(int id) {
        alunoRepository.deleteById(id);
        return null;
    }

    @Override
    public Aluno put(int id, Aluno aluno) {
        try {
            Aluno alu = alunoRepository.findById(id).get();
            aluno.setId(id);
            return alunoRepository.save(aluno);

        } catch (Exception ex) {
            return null;
        }
    }
}
