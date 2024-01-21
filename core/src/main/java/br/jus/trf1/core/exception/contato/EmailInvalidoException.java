package br.jus.trf1.core.exception.contato;

import br.jus.trf1.core.exception.contato.erros.ContatoErroEnum;

/**
 * @author bruno.carneiro (tr301605)
 */
public class EmailInvalidoException extends ContatoException {
    public EmailInvalidoException() {
        super(ContatoErroEnum.EMAIL_INVALIDO.getMensagem());
    }

    public EmailInvalidoException(String message) {
        super(message);
    }

    public EmailInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailInvalidoException(Throwable cause) {
        super(cause);
    }
}
