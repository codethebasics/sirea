package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumeroProcessoInvalidoExceptionTest {

    @Test
    void dadoUmProcessoInvalido_quandoCriarProcesso_deveLancarNumeroProcessoInvalidoException() {
        // given / when / then
        Exception exception = assertThrows(NumeroProcessoInvalidoException.class, () -> {
            new Processo("0002984-22.2014.4.01.3603");
        });

        assertEquals(exception.getMessage(), ProcessoErrosEnum.NUMERO_PROCESSO_INVALIDO.getMensagem());
    }
}