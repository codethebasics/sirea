package br.jus.trf1.core.exception.endereco;

import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;

public class LogradouroInvalidoException extends EnderecoException {
    public LogradouroInvalidoException() {
        super(EnderecoErroEnum.ENDERECO_SEM_LOGRADOURO.getMensagem());
    }

    public LogradouroInvalidoException(String message) {
        super(message);
    }

    public LogradouroInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogradouroInvalidoException(Throwable cause) {
        super(cause);
    }
}
