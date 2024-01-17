package br.jus.trf1.usecase.pessoa.exceptions;

public class CriarPessoaException extends RuntimeException {
    public CriarPessoaException() {
    }

    public CriarPessoaException(String message) {
        super(message);
    }

    public CriarPessoaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CriarPessoaException(Throwable cause) {
        super(cause);
    }

    public CriarPessoaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
