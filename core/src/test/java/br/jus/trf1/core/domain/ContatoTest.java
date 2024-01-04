package br.jus.trf1.core.domain;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        assertThrows(RuntimeException.class, () -> {
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