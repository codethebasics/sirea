package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;

public class DigitoVerificadorInvalidoException extends NumeroProcessoInvalidoException {
    public DigitoVerificadorInvalidoException() {
        super(ProcessoErrosEnum.DIGITO_VERIFICADOR_INVALIDO.getMensagem());
    }

    public DigitoVerificadorInvalidoException(Throwable cause) {
        super(ProcessoErrosEnum.DIGITO_VERIFICADOR_INVALIDO.getMensagem(), cause);
    }

    public DigitoVerificadorInvalidoException(String message) {
        super(message);
    }

    public DigitoVerificadorInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
