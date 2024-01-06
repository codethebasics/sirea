package br.jus.trf1.core.exception;

/**
 * @author bruno.carneiro (tr301605)
 */
public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
