package br.jus.trf1.core.exception.endereco;

import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;

public class UFInvalidaException extends EnderecoException {

    public UFInvalidaException() {
        super(EnderecoErroEnum.ENDERECO_SEM_UF.getMensagem());
    }

    public UFInvalidaException(String message) {
        super(message);
    }

    public UFInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public UFInvalidaException(Throwable cause) {
        super(cause);
    }
}
