package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;

public class AnoInvalidoException extends NumeroProcessoInvalidoException {
    public AnoInvalidoException() {
        super(ProcessoErrosEnum.ANO_INVALIDO.getMensagem());
    }

    public AnoInvalidoException(Throwable cause) {
        super(ProcessoErrosEnum.ANO_INVALIDO.getMensagem(), cause);
    }

    public AnoInvalidoException(String message) {
        super(message);
    }

    public AnoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
