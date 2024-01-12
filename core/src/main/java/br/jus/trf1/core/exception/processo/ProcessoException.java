package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.CategoriaErroEnum;

public class ProcessoException extends RuntimeException {
    public ProcessoException() {
        super(CategoriaErroEnum.PROCESSO.getDescricao());
    }

    public ProcessoException(Throwable cause) {
        super(CategoriaErroEnum.PROCESSO.getDescricao(), cause);
    }

    public ProcessoException(String message) {
        super(message);
    }

    public ProcessoException(String message, Throwable cause) {
        super(message, cause);
    }
}
