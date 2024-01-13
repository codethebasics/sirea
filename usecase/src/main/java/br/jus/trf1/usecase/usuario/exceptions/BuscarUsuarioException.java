package br.jus.trf1.usecase.usuario.exceptions;

public class BuscarUsuarioException extends Exception {
    public BuscarUsuarioException() {
    }

    public BuscarUsuarioException(String message) {
        super(message);
    }

    public BuscarUsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuscarUsuarioException(Throwable cause) {
        super(cause);
    }
}
