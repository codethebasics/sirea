package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;

public class OrgaoDesconhecidoException extends NumeroProcessoInvalidoException {
    public OrgaoDesconhecidoException() {
        super(ProcessoErrosEnum.ORGAO_NAO_EXISTE.getMensagem());
    }

    public OrgaoDesconhecidoException(Throwable cause) {
        super(ProcessoErrosEnum.ORGAO_NAO_EXISTE.getMensagem(), cause);
    }

    public OrgaoDesconhecidoException(String message) {
        super(message);
    }

    public OrgaoDesconhecidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
