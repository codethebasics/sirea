package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.RegiaoTRFEnum;

import java.math.BigInteger;

/**
 * <b>Representa um processo</b>
 * <p>
 *     Esta classe busca implementar a representação de um processo conforme
 *     a <a href="https://atos.cnj.jus.br/atos/detalhar/119">Resolução Nº 65 de 16/12/2008 do CNJ</a>
 * </p>
 * <br>
 * <p>O número do processo do TRF é composto por:</p>
 * <ul>
 *     <li>10 dígitos se anterior ao ano de 1997</li>
 *     <li>15 dígitos se protocolado entre os anos de 1997 e 2009</li>
 *     <li>20 dígitos para os processos a partir de janeiro de 2010</li>
 * </ul>
 * <p>Exemplos:</p>
 * <ul>
 *     <li>AA.TR.NNNNN-D (anterior a 1997)</li>
 *     <li>AAAA.RE.OR.NNNNN-D (entre 1997 e 2009)</li>
 *     <li>NNNNNNN-DD.AAAA.J.TR.OOOO (A partir de 2009)</li>
 * </ul>
 *
 * @author bruno.carneiro (tr301605)
 * @since 2024
 */
public class Processo {
    private String numeroSequencial;
    private String digitoVerificador;
    private String anoDeAjuizamento;
    private OrgaoJudiciarioEnum orgaoDoPoderJudiciario;
    private RegiaoTRFEnum regiao;
    private String origemNoPrimeiroGrau;
    private String numeroProcesso;

    /**
     * Art. 1º Fica instituída a numeração única de processos no âmbito do Poder Judiciário,
     * observada a estrutura NNNNNNN-DD.AAAA.J.TR.OOOO, composta de 6 (seis) campos obrigatórios [...]
     *
     * @param numeroSequencial NNNNNNN
     * @param digitoVerificador DD
     * @param anoDeAjuizamento AAAA
     * @param orgaoDoPoderJudiciario J
     * @param regiao TR
     * @param origemNoPrimeiroGrau OOOO
     */
    public Processo(
            String numeroSequencial,
            String digitoVerificador,
            String anoDeAjuizamento,
            OrgaoJudiciarioEnum orgaoDoPoderJudiciario,
            RegiaoTRFEnum regiao,
            String origemNoPrimeiroGrau) {
        this.setNumeroSequencial(numeroSequencial);
        this.setDigitoVerificador(digitoVerificador);
        this.setAnoDeAjuizamento(anoDeAjuizamento);
        this.setOrgaoDoPoderJudiciario(orgaoDoPoderJudiciario);
        this.setRegiao(regiao);
        this.setOrigemNoPrimeiroGrau(origemNoPrimeiroGrau);
        this.setNumeroProcesso();
    }

    public String getNumeroSequencial() {
        return numeroSequencial;
    }

    /**
     * §1º O campo (NNNNNNN), com 7 (sete) dígitos, identifica o número seqüencial
     * do processo por unidade de origem (OOOO), a ser reiniciado a cada ano,
     * facultada a utilização de funcionalidade que oculte a visibilidade dos zeros
     * à esquerda e/ou torne desnecessário o seu preenchimento para a localização do processo.
     *
     * @param numeroSequencial NNNNNNN
     */
    private void setNumeroSequencial(String numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    /**
     * § 2º O campo (DD), com 2 (dois) dígitos, identifica o dígito verificador,
     * cujo cálculo de verificação deve ser efetuado pela aplicação
     * do algoritmo Módulo 97 Base 10, conforme Norma ISO 7064:2003,
     * nos termos das instruções constantes do Anexo VIII desta Resolução.
     *
     * @param digitoVerificador DD
     */
    private void setDigitoVerificador(String digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public String getAnoDeAjuizamento() {
        return anoDeAjuizamento;
    }

    /**
     * § 3º O campo (AAAA), com 4 (quatro) dígitos, identifica o ano do ajuizamento do processo.
     *
     * @param anoDeAjuizamento AAAA
     */
    private void setAnoDeAjuizamento(String anoDeAjuizamento) {
        this.anoDeAjuizamento = anoDeAjuizamento;
    }

    public OrgaoJudiciarioEnum getOrgaoDoPoderJudiciario() {
        return orgaoDoPoderJudiciario;
    }

    /**
     * § 4º O campo (J), com 1 (um) dígito, identifica o órgão ou segmento do Poder Judiciário, observada a seguinte correspondência:
     *
     * <ul>
     *     <li>I – Supremo Tribunal Federal: 1 (um)</li>
     *     <li>II – Conselho Nacional de Justiça: 2 (dois)</li>
     *     <li>III – Superior Tribunal de Justiça: 3 (três)</li>
     *     <li>IV - Justiça Federal: 4 (quatro)</li>
     *     <li>V - Justiça do Trabalho: 5 (cinco)</li>
     *     <li>VI - Justiça Eleitoral: 6 (seis)</li>
     *     <li>VII - Justiça Militar da União: 7 (sete)</li>
     *     <li>VIII - Justiça dos Estados e do Distrito Federal e Territórios: 8 (oito)</li>
     *     <li>IX - Justiça Militar Estadual: 9 (nove)</li>
     * </ul>
     *
     * @param orgaoDoPoderJudiciario J
     */
    private void setOrgaoDoPoderJudiciario(OrgaoJudiciarioEnum orgaoDoPoderJudiciario) {
        this.orgaoDoPoderJudiciario = orgaoDoPoderJudiciario;
    }

    public RegiaoTRFEnum getRegiao() {
        return regiao;
    }

    /**
     * § 5º O campo (TR), com 2 (dois) dígitos, identifica o tribunal do respectivo segmento do Poder Judiciário e, na Justiça Militar da União, a Circunscrição Judiciária, observando-se
     *
     * <ul>
     *      <li>I – nos processos originários do Supremo Tribunal Federal, do Conselho Nacional de Justiça, do Superior Tribunal de Justiça, do Tribunal Superior do Trabalho, do Tribunal Superior Eleitoral e do Superior Tribunal Militar, o campo (TR) deve ser preenchido com zero;</li>
     *      <li>II – nos processos originários do Conselho da Justiça Federal e do Conselho Superior da Justiça do Trabalho, o campo (TR) deve ser preenchido com o número 90 (noventa);</li>
     *      <li>III – nos processos da Justiça Federal, os Tribunais Regionais Federais devem ser identificados no campo (TR) pelos números de 01 a 06, observadas as respectivas regiões; (R</li>
     *      <li>IV – nos processos da Justiça do Trabalho, os Tribunais Regionais do Trabalho devem ser identificados no campo (TR) pelos números 01 a 24, observadas as respectivas regiões;</li>
     *      <li>V – nos processos da Justiça Eleitoral, os Tribunais Regionais Eleitorais devem ser identificados no campo (TR) pelos números 01 a 27, observados os Estados da Federação, em ordem</li>
     *      <li>VI – nos processos da Justiça Militar da União, as Circunscrições Judiciárias Militares devem ser identificadas no campo (TR) pelos números 01 a 12, observada a subdivisão vigente;</li>
     *      <li>VII – nos processos da Justiça dos Estados e do Distrito Federal e Territórios, os Tribunais de Justiça devem ser identificados no campo (TR) pelos números 01 a 27, observados os Estados da Federação e o Distrito Federal, em ordem alfabética;</li>
     *      <li>VIII – nos processos da Justiça Militar Estadual, os Tribunais Militares dos Estados de Minas Gerais, Rio Grande do Sul e São Paulo devem ser identificados no campo (TR) pelos números 13, 21 e 26, respectivamente, cumprida a ordem alfabética de que tratam os incisos V e VII;</li>
     * </ul>
     *
     * @param regiao TR
     */
    private void setRegiao(RegiaoTRFEnum regiao) {

        this.regiao = regiao;
    }

    public String getOrigemNoPrimeiroGrau() {
        return origemNoPrimeiroGrau;
    }

    private void setOrigemNoPrimeiroGrau(String origemNoPrimeiroGrau) {
        this.origemNoPrimeiroGrau = origemNoPrimeiroGrau;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public String getNumeroProcessoFormatado() {
        return numeroProcesso;
    }

    public void setNumeroProcesso() {
        this.numeroProcesso = this.numeroSequencial +
                this.digitoVerificador +
                this.anoDeAjuizamento +
                this.orgaoDoPoderJudiciario.getCodigo() +
                this.regiao.getCodigo() +
                this.origemNoPrimeiroGrau;

        if (!isNumeroProcessoValid())
            throw new RuntimeException("Número de processo inválido");
    }

    public boolean isNumeroProcessoValid() {
        String numeroProcessoPreparado = Modulo97Base10.preparacao(this.numeroProcesso);
        return Modulo97Base10.calculo(numeroProcessoPreparado, this.digitoVerificador);
    }

    /**
     * § 2º O campo (DD), com 2 (dois) dígitos, identifica o dígito verificador,
     * cujo cálculo de verificação deve ser efetuado pela aplicação
     * do algoritmo Módulo 97 Base 10, conforme Norma ISO 7064:2003,
     * nos termos das instruções constantes do Anexo VIII desta Resolução.
     */
    public static class Modulo97Base10 {

        public static String preparacao(String numeroProcessoUnico) {
            // Remover formatação
            numeroProcessoUnico = numeroProcessoUnico
                    .replaceAll("\\.", "")
                    .replaceAll("-", "");

            // Verifica se o processo contém 20 dígitos
            if (numeroProcessoUnico.length() != 20)
                throw new RuntimeException("O número do processo deve ter 20 dígitos");

            // Remove o dígito verificador do número do processo e o armazena
            String numeroProcessoSemDigitoVerificador =
                    numeroProcessoUnico.substring(0, 7)
                    .concat(numeroProcessoUnico.substring(9));

            // Repete os últimos dois dígitos, concatenando-os do número do processo
            String numeroProcessoPreparado = numeroProcessoSemDigitoVerificador
                    .concat(numeroProcessoUnico.substring(7, 9));

            return numeroProcessoPreparado;
        }

        public static boolean calculo(String numeroProcessoPreparado, String digitoVerificador) {
            if (numeroProcessoPreparado.isBlank())
                throw new RuntimeException("O número do processo deve ser informado");

            if (digitoVerificador.isBlank())
                throw new RuntimeException("O digito verificador deve ser informado");

            if (numeroProcessoPreparado.length() != 20)
                throw new RuntimeException("O número do processo deve ser formado por 20 dígitos");

            if (digitoVerificador.length() != 2)
                throw new RuntimeException("O dígito verificador deve ser composto por 2 dígitos");

            BigInteger numeroProcesso = new BigInteger(numeroProcessoPreparado);
            BigInteger result = BigInteger.valueOf(98L).min(calcularMod97(numeroProcesso));

            return result.equals(BigInteger.ONE) ;
        }

        public static BigInteger calcularMod97(BigInteger numero) {
            return numero.mod(BigInteger.valueOf(97L));
        }
    }

}
