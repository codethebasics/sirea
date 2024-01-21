package br.jus.trf1.core.exception.endereco;

import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;

public class CEPInvalidoException extends EnderecoException {
    public CEPInvalidoException() {
        super(EnderecoErroEnum.ENDERECO_SEM_CEP.getMensagem());
    }

    public CEPInvalidoException(String message) {
        super(message);
    }

    public CEPInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CEPInvalidoException(Throwable cause) {
        super(cause);
    }
}
