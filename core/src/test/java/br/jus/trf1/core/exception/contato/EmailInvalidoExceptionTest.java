package br.jus.trf1.core.exception.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.exception.contato.errors.ContatoErroEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailInvalidoExceptionTest {

    @Test
    void dadoUmEmailInvalido_quandoSetarEmail_entaoLancaEmailInvalidoException() {
        // given / when / then
        Exception exception = assertThrows(EmailInvalidoException.class, () -> {
            new Contato(DDDEnum.DF_61, "33471304", "985770401", "email");
        });

        assertEquals(ContatoErroEnum.EMAIL_INVALIDO.getMensagem(), exception.getMessage());
    }
}