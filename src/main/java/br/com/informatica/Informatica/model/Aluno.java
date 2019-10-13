package br.com.informatica.Informatica.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    public Aluno() {
    }

    public Aluno(int id, String nome, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
