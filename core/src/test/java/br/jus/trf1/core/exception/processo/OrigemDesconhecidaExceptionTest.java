package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrigemDesconhecidaExceptionTest {

    @Test
    void dadoUmProcessoComOrigemDesconhecida_quandoCriarProcesso_entaoLancaOrigemDesconhecidaException() {
        // given / when / then
        Exception exception = assertThrows(OrigemDesconhecidaException.class, () -> {
            new Processo("0002984-22.2015.4.01.8000");
        });

        assertEquals(ProcessoErrosEnum.ORIGEM_NAO_EXISTE.getMensagem(), exception.getMessage());
    }
}