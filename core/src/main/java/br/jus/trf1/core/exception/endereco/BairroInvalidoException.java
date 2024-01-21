package br.jus.trf1.core.exception.endereco;

import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;

public class BairroInvalidoException extends EnderecoException {
    public BairroInvalidoException() {
        super(EnderecoErroEnum.ENDERECO_SEM_BAIRRO.getMensagem());
    }

    public BairroInvalidoException(String message) {
        super(message);
    }

    public BairroInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BairroInvalidoException(Throwable cause) {
        super(cause);
    }
}
