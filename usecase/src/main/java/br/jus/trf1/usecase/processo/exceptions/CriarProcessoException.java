package br.jus.trf1.usecase.processo.exceptions;

import br.jus.trf1.core.exception.processo.ProcessoException;

public class CriarProcessoException extends ProcessoException {
    public CriarProcessoException(String message) {
        super(message);
    }

    public CriarProcessoException(String message, Throwable cause) {
        super(message, cause);
    }
}
