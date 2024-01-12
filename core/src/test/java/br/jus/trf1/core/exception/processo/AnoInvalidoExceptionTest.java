package br.jus.trf1.core.exception.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.exception.processo.errors.ProcessoErrosEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnoInvalidoExceptionTest {

    @Test
    void dadoUmProcessoComAnoDeAjuizamentoInvalido_quandoCriarProcesso_entaoLancaAnoInvalidoException() {
        // given / when / then
        Exception exception = assertThrows(AnoInvalidoException.class, () -> {
            Processo processo = new Processo("0002984-22.2015.4.01.3603");
            processo.setAnoDeAjuizamento("777");
        });

        assertEquals(exception.getMessage(), ProcessoErrosEnum.ANO_INVALIDO.getMensagem());
    }
}