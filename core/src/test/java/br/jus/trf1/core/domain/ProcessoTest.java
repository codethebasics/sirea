package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.RegiaoTRFEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários do Processo
 *
 * @author bruno.carneiro (tr301605)
 * @since 01/2024
 */
class ProcessoTest {

    @Test
    void dadoUmProcessoValido_quandoValidarProcesso_entaoRetornaTrue() {

        // given
        Processo processo = new Processo(
                "0033603",
                "86",
                "2022",
                OrgaoJudiciarioEnum.JF,
                RegiaoTRFEnum.TRF1,
                "8000");

        // when
        boolean isProcessoValid = processo.isNumeroProcessoValid();

        // then
        assertTrue(isProcessoValid, "Espera-se que o processo seja válido");

    }

    @Test
    void dadoUmProcessoValido_quandoEfetuarPreparacao_entaoRetornaProcessoFormatado() {
        // given
        String processo = "0082952-92.2021.4.01.8000";

        // when
        String processoFormatado = Processo.Modulo97Base10.preparacao(processo);

        // then
        assertEquals("00829522021401800092", processoFormatado);
    }

    @Test
    void dadoUmProcessoEUmDigitoVerificadorValido_quandoCalcular_entaoRetornaVerdadeiro() {
        // given
        String digitoVerificador = "84";
        String processo = "00256212023401800084";

        // when
        boolean isValido = Processo.Modulo97Base10.calculo(processo, digitoVerificador);

        // then
        assertTrue(isValido, "Espera-se que o processo seja válido");
    }

    @Test
    void dadoUmNumero_quandoCalcularMod_entaoRetornaFatorial() {
        // given
        BigInteger numero = new BigInteger("123456789");

        // when
        BigInteger mod97Result = Processo.Modulo97Base10.calcularMod97(numero);

        // then
        assertEquals(BigInteger.valueOf(39L), mod97Result);
    }

    @Test
    void dadoUmNumeroDeProcessoInvalido_quandoCriarProcesso_entaoDeveLancarException() {

        // given / when / then
        assertThrows(RuntimeException.class, () -> {
            new Processo(
                    "0025621",
                    "84",
                    "2022",
                    OrgaoJudiciarioEnum.JF,
                    RegiaoTRFEnum.TRF1,
                    "8000");
        }, "Espera-se que uma excetion seja lançada");
    }
}