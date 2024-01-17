package br.jus.trf1.usecase.pessoa.exceptions;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException() {
    }

    public PessoaNaoEncontradaException(String message) {
        super(message);
    }

    public PessoaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PessoaNaoEncontradaException(Throwable cause) {
        super(cause);
    }
}
