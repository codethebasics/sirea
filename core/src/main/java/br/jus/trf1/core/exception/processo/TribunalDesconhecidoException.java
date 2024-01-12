package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;

public class TribunalDesconhecidoException extends NumeroProcessoInvalidoException {
    public TribunalDesconhecidoException() {
        super(ProcessoErrosEnum.TRIBUNAL_NAO_EXISTE.getMensagem());
    }

    public TribunalDesconhecidoException(Throwable cause) {
        super(ProcessoErrosEnum.TRIBUNAL_NAO_EXISTE.getMensagem(), cause);
    }

    public TribunalDesconhecidoException(String message) {
        super(message);
    }

    public TribunalDesconhecidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
