package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;

public class NumeroProcessoInvalidoException extends ProcessoException {

    public NumeroProcessoInvalidoException() {
        super(ProcessoErrosEnum.NUMERO_PROCESSO_INVALIDO.getMensagem());
    }

    public NumeroProcessoInvalidoException(Throwable cause) {
        super(ProcessoErrosEnum.NUMERO_PROCESSO_INVALIDO.getMensagem(), cause);
    }

    public NumeroProcessoInvalidoException(String message) {
        super(message);
    }

    public NumeroProcessoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
