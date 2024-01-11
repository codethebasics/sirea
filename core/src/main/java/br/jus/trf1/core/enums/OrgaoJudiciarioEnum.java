package br.jus.trf1.core.enums;

/**
 * @author bruno.carneiro (tr301605)
 */
public enum OrgaoJudiciarioEnum {
    STF("STF", "Supremo Tribunal Federal", "1"),
    CNJ("CNJ", "Conselho Nacional de Justiça", "2"),
    STJ("STJ", "Superior Tribunal de Justiça", "3"),
    JF("JF", "Justiça Federal", "4"),
    JT("JT", "Justiça do Trabalho", "5"),
    JE("JE", "Justiça Eleitoral", "6"),
    JMU("JMU", "Justiça Militar da União", "7"),
    DFT("DFT", "Justiça dos Estados e do Distrito Federal e Territórios", "8"),
    JM("E", "Justiça Militar Estadual", "9");

    private String sigla;
    private String nome;
    private String codigo;

    OrgaoJudiciarioEnum(String sigla, String nome, String codigo) {
        this.sigla = sigla;
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
