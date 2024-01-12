package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;

public class OrigemDesconhecidaException extends NumeroProcessoInvalidoException {

    public OrigemDesconhecidaException() {
        super(ProcessoErrosEnum.ORIGEM_NAO_EXISTE.getMensagem());
    }

    public OrigemDesconhecidaException(Throwable cause) {
        super(ProcessoErrosEnum.ORIGEM_NAO_EXISTE.getMensagem(), cause);
    }

    public OrigemDesconhecidaException(String message) {
        super(message);
    }

    public OrigemDesconhecidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
