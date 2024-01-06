package br.jus.trf1.core.exception;

/**
 * @author bruno.carneiro (tr301605)
 */
public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
