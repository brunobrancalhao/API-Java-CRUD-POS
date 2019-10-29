package br.com.informatica.Informatica.exception;

public class TurmaNotFoundException extends RuntimeException {

    public TurmaNotFoundException(int id) {
        super("Turma nao encontrada: " + id);
    }
}
