package br.jus.trf1.core.exception.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.exception.contato.errors.ContatoErroEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneInvalidoExceptionTest {

    @Test
    void dadoUmTelefoneInvalido_quandoSetarTelefone_entaoLancaTelefoneInvalidoException() {
        // given / when / then
        Exception exception = assertThrows(TelefoneInvalidoException.class, () -> {
            new Contato(DDDEnum.DF_61, "33471304", "9857704", "bruno.ferreira@trf1.jus.br");
        });

        assertEquals(ContatoErroEnum.TELEFONE_INVALIDO.getMensagem(), exception.getMessage());
    }

}