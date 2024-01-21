package br.jus.trf1.core.exception.endereco;

import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;

public class EnderecoException extends RuntimeException {

    public EnderecoException() {
        super(EnderecoErroEnum.ENDERECO_INVALIDO.getMensagem());
    }

    public EnderecoException(String message) {
        super(message);
    }

    public EnderecoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnderecoException(Throwable cause) {
        super(cause);
    }
}
