package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;
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
    @DisplayName("Dado um processo válido, quando validar processo então deve retornar true")
    void dadoUmProcessoValido_quandoValidarProcesso_entaoRetornaTrue() {

        // given
        Processo processo = new Processo.Builder()
                .numeroSequencial("0002984")
                .digitoVerificador("22")
                .anoDeAjuizamento("2015")
                .orgaoDoPoderJudiciario(OrgaoJudiciarioEnum.JF)
                .tribunal(TribunalEnum.TRF1)
                .origem(OrigensTRF1Enum.SUBSECAO_JUDICIARIA_DE_SINOP)
                .build();

        // when
        boolean isProcessoValid = processo.isNumeroProcessoValid();

        // then
        assertTrue(isProcessoValid, "Espera-se que o processo seja válido");

    }

    @Test
    @DisplayName("Dado um processo valido, quando efetuar preparação então retorna processo formatado")
    void dadoUmProcessoValido_quandoEfetuarPreparacao_entaoRetornaProcessoFormatado() {
        // given
        String processo = "0082952-92.2021.4.01.8000";

        // when
        String processoFormatado = Processo.Modulo97Base10.preparacao(processo);

        // then
        assertEquals("00829522021401800092", processoFormatado);
    }

    @Test
    @DisplayName("Dado um processo e um dígito verificador válido, quando calcular então deve retornar verdadeiro")
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
    @DisplayName("Dado um número, quando calcular Mod então retorna fatorial")
    void dadoUmNumero_quandoCalcularMod_entaoRetornaFatorial() {
        // given
        BigInteger numero = new BigInteger("123456789");

        // when
        BigInteger mod97Result = Processo.Modulo97Base10.calcularMod97(numero);

        // then
        assertEquals(BigInteger.valueOf(39L), mod97Result);
    }

    @Test
    @DisplayName("Dado um número de processo inválido, quando criar processo então deve lançar Exception")
    void dadoUmNumeroDeProcessoInvalido_quandoCriarProcesso_entaoDeveLancarException() {

        // given / when
        String message = assertThrows(RuntimeException.class, () -> new Processo.Builder()
                .numeroSequencial("0002984")
                .digitoVerificador("22")
                .anoDeAjuizamento("2015")
                .orgaoDoPoderJudiciario(OrgaoJudiciarioEnum.JF)
                .tribunal(TribunalEnum.TRF1)
                .origem(OrigensTRF1Enum.SECAO_JUDICIARIA_DO_DISTRITO_FEDERAL)
                .build(), "Espera-se que uma excetion seja lançada").getMessage();

        // then
        assertEquals("Número do processo inválido", message);
    }

    @Test
    @DisplayName("Dado um número de processo completo, quando obter número do processo formatado então deve retornar número do processo formatado")
    void dadoUmNumeroDeProcessoCompleto_quandoObterNumeroDoProcessoFormatado_EntaoDeveRetornarNumeroProcessoFormatado() {

        // given
        Processo processo = new Processo.Builder()
                .numeroSequencial("0002984")
                .digitoVerificador("22")
                .anoDeAjuizamento("2015")
                .orgaoDoPoderJudiciario(OrgaoJudiciarioEnum.JF)
                .tribunal(TribunalEnum.TRF1)
                .origem(OrigensTRF1Enum.SUBSECAO_JUDICIARIA_DE_SINOP)
                .build();

        // when
        String numeroProcessoFormatado = processo.getNumeroProcessoFormatado();

        // then
        assertEquals("0002984-22.2015.4.01.3603", numeroProcessoFormatado, "Espera-se que o número do processo esteja formatado");
    }

    @Test
    @DisplayName("Dado um número de processo completo, quando obter número do processo sem zeros à esquerda então deve retornar número do processo sem zeros à esquerda")
    void dadoUmNumeroDeProcessoCompleto_quandoObterNumeroDoProcessoSemZerosAEsquerda_entaoDeveRetornarNumeroProcessoSemZerosAEsquerda() {

        // given
        Processo processo = new Processo.Builder()
                .numeroSequencial("0002984")
                .digitoVerificador("22")
                .anoDeAjuizamento("2015")
                .orgaoDoPoderJudiciario(OrgaoJudiciarioEnum.JF)
                .tribunal(TribunalEnum.TRF1)
                .origem(OrigensTRF1Enum.SUBSECAO_JUDICIARIA_DE_SINOP)
                .build();

        // when
        String numeroProcessoFormatado = processo.getNumeroProcessoSemZerosAEsquerda();

        // then
        assertEquals("29842220154013603", numeroProcessoFormatado, "Espera-se que o número do processo esteja formatado");
    }

    @Test
    @DisplayName("Dado um número de processo completo, quando obter número do processo formatado sem zeros à esquerda então deve retornar número do processo formatado sem zeros à esquerda")
    void dadoUmNumeroDeProcessoCompleto_quandoObterNumeroDoProcessoFormatadoSemZerosAEsquerda_entaoDeveRetornarNumeroProcessoFormatadoSemZerosAEsquerda() {

        // given
        Processo processo = new Processo.Builder()
                .numeroSequencial("0002984")
                .digitoVerificador("22")
                .anoDeAjuizamento("2015")
                .orgaoDoPoderJudiciario(OrgaoJudiciarioEnum.JF)
                .tribunal(TribunalEnum.TRF1)
                .origem(OrigensTRF1Enum.SUBSECAO_JUDICIARIA_DE_SINOP)
                .build();

        // when
        String numeroProcessoFormatado = processo.getNumeroProcessoFormatadoSemZerosAEsquerda();

        // then
        assertEquals("2984-22.2015.4.01.3603", numeroProcessoFormatado, "Espera-se que o número do processo esteja formatado");
    }

    @Test
    @DisplayName("Dado um processo sem formatação, quando formatar então deve retornar processo formatado")
    void dadoUmProcesso_quandoFormatarNumeroProcesso_entaoDeveRetornarProcessoFormatado() {
        // given
        String processo = "00000000000000000000";

        // when
        String processoFormatado = Processo.formatarNumeroProcesso(processo);

        // then
        assertEquals("0000000-00.0000.0.00.0000", processoFormatado);
    }

    @Test
    @DisplayName("Dado um processo sem formatado, quando obter processo sem formatação então deve retornar processo sem formatação")
    void dadoUmProcessoFormatado_quandoObterProcessoSemformatacao_entaoDeveRetornarProcessoSemFormatacao() {
        // given
        String processo = "0000000-00.0000.0.00.0000";

        // when
        String processoSemFormatacao = Processo.getNumeroProcessoSemFormatacao(processo);

        // then
        assertEquals("00000000000000000000", processoSemFormatacao);
    }

    @Test
    @DisplayName("Dado um número de processo válido, quando instanciar processo pelo número então deve criar processo")
    void dadoUmNumeroDeProcessoValido_quandoInstanciarProcessoPeloNumero_entaoDeveCriarProcesso() {
        // given
        String numeroProcesso = "0002984-22.2015.4.01.3603";

        // when
        Processo processo = new Processo(numeroProcesso);

        // then
        assertNotNull(processo, "Espera-se que o processo seja criado");
    }
}