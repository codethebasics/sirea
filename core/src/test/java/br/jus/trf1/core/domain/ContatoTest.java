package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.*;
import br.jus.trf1.core.exception.contato.EmailInvalidoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * @author bruno.carneiro (tr301605)
 */
class ContatoTest {

    @Test
    @DisplayName("Dado um email inválido, quando setar o email então lança exception")
    void givenInvalidEmail_whenSetEmail_thenThrowsRuntimeException() {
        // given
        String emailInvalido = "fulano@detal";
        Contato contato = new Contato();

        // when / then
        assertThrows(EmailInvalidoException.class, () -> {
            contato.setEmail(emailInvalido);
        }, "Um email inválido não deveria ser cadastrado");
    }

    @Test
    @DisplayName("Dado um email válido, quando setar o email, então espera que o email seja setado")
    void givenValidEmail_whenSetEmail_thenExpectEmailToBeSet() {
        // given
        String emailValido = "fulano@trf1.jus.br";
        Contato contato = new Contato();

        // when
        contato.setEmail(emailValido);

        // then
        assertEquals("fulano@trf1.jus.br", emailValido);
    }
}