package br.jus.trf1.core.exception.contato;

import br.jus.trf1.core.exception.CategoriaErroEnum;

public class ContatoException extends RuntimeException {
    public ContatoException() {
        super(CategoriaErroEnum.CONTATO.getDescricao());
    }

    public ContatoException(String message) {
        super(message);
    }

    public ContatoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContatoException(Throwable cause) {
        super(CategoriaErroEnum.CONTATO.getDescricao(), cause);
    }
}
