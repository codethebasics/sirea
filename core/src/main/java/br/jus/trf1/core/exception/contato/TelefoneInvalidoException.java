package br.jus.trf1.core.exception.contato;

import br.jus.trf1.core.exception.contato.errors.ContatoErroEnum;

/**
 * @author bruno.carneiro (tr301605)
 */
public class TelefoneInvalidoException extends ContatoException {
    public TelefoneInvalidoException() {
        super(ContatoErroEnum.TELEFONE_INVALIDO.getMensagem());
    }

    public TelefoneInvalidoException(String message) {
        super(message);
    }

    public TelefoneInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelefoneInvalidoException(Throwable cause) {
        super(ContatoErroEnum.TELEFONE_INVALIDO.getMensagem(), cause);
    }
}
