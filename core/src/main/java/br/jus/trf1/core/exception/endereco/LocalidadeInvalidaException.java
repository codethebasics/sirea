package br.jus.trf1.core.exception.endereco;

import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;

public class LocalidadeInvalidaException extends EnderecoException {
    public LocalidadeInvalidaException() {
        super(EnderecoErroEnum.ENDERECO_SEM_LOCALIDADE.getMensagem());
    }

    public LocalidadeInvalidaException(String message) {
        super(message);
    }

    public LocalidadeInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalidadeInvalidaException(Throwable cause) {
        super(cause);
    }
}
