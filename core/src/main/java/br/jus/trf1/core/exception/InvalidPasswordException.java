package br.jus.trf1.core.exception;

/**
 * @author bruno.carneiro (tr301605)
 */
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
