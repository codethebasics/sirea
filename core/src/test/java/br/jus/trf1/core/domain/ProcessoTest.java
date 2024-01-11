package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1;
import br.jus.trf1.core.enums.TribunalEnum;
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
                "0002984",
                "22",
                "2015",
                OrgaoJudiciarioEnum.JF,
                TribunalEnum.TRF1,
                "3603");

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
                    "0002984",
                    "22",
                    "2016",
                    OrgaoJudiciarioEnum.JF,
                    TribunalEnum.TRF1,
                    OrigensTRF1.SUBSECAO_JUDICIARIA_DE_SINOP);
        }, "Espera-se que uma excetion seja lançada");
    }

    @Test
    void dadoUmNumeroDeProcessoCompleto_quandoObterNumeroDoProcessoFormatado_EntaoDeveRetornarNumeroProcessoFormatado() {

        // given
        Processo processo = new Processo(
                "0002984",
                "22",
                "2015",
                OrgaoJudiciarioEnum.JF,
                TribunalEnum.TRF1,
                OrigensTRF1.SUBSECAO_JUDICIARIA_DE_SINOP);

        // when
        String numeroProcessoFormatado = processo.getNumeroProcessoFormatado();

        // then
        assertEquals("0002984-22.2015.4.01.3603", numeroProcessoFormatado, "Espera-se que o número do processo esteja formatado");
    }

    @Test
    void dadoUmNumeroDeProcessoCompleto_quandoObterNumeroDoProcessoSemZerosAEsquerda_entaoDeveRetornarNumeroProcessoSemZerosAEsquerda() {

        // given
        Processo processo = new Processo(
                "0002984",
                "22",
                "2015",
                OrgaoJudiciarioEnum.JF,
                TribunalEnum.TRF1,
                OrigensTRF1.SUBSECAO_JUDICIARIA_DE_SINOP);

        // when
        String numeroProcessoFormatado = processo.getNumeroProcessoSemZerosAEsquerda();

        // then
        assertEquals("29842220154013603", numeroProcessoFormatado, "Espera-se que o número do processo esteja formatado");
    }

    @Test
    void dadoUmNumeroDeProcessoCompleto_quandoObterNumeroDoProcessoFormatadoSemZerosAEsquerda_entaoDeveRetornarNumeroProcessoFormatadoSemZerosAEsquerda() {

        // given
        Processo processo = new Processo(
                "0002984",
                "22",
                "2015",
                OrgaoJudiciarioEnum.JF,
                TribunalEnum.TRF1,
                OrigensTRF1.SUBSECAO_JUDICIARIA_DE_SINOP);

        // when
        String numeroProcessoFormatado = processo.getNumeroProcessoFormatadoSemZerosAEsquerda();

        // then
        assertEquals("2984-22.2015.4.01.3603", numeroProcessoFormatado, "Espera-se que o número do processo esteja formatado");
    }

    @Test
    void dadoUmProcesso_quandoFormatarNumeroProcesso_entaoDeveRetornarProcessoFormatado() {
        // given
        String processo = "00000000000000000000";

        // when
        String processoFormatado = Processo.formatarNumeroProcesso(processo);

        // then
        assertEquals("0000000-00.0000.0.00.0000", processoFormatado);
    }

    @Test
    void dadoUmNumeroDeProcessoValido_quandoInstanciarProcessoPeloNumero_entaoDeveCriarProcesso() {
        // given
        String numeroProcesso = "0002984-22.2015.4.01.3603";

        // when
        Processo processo = new Processo(numeroProcesso);

        // then
        assertNotNull(processo, "Espera-se que o processo seja criado");
    }
}