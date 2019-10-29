package br.com.informatica.Informatica.exception;

public class AlunoNotFoundException extends RuntimeException {

    public AlunoNotFoundException(int id) {
        super("Aluno nao encontrado: " + id);
    }
}
