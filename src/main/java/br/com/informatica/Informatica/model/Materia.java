package br.com.informatica.Informatica.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materia")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = true, updatable = true, nullable = false)
    private Professor professor;

    public Materia(){

    }

    public Materia(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}