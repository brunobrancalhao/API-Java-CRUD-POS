package br.com.informatica.Informatica.repository;

import br.com.informatica.Informatica.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Dictionary;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
