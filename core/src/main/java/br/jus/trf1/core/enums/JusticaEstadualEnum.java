package br.jus.trf1.core.enums;

/**
 * @author Bruno Carneiro
 */
public enum JusticaEstadualEnum {

    TJAC("TJAC", "Tribunal de Justiça do Acre", "01"),
    TJAL("TJAL", "Tribunal de Justiça do Alagoas", "02"),
    TJAP("TJAP", "Tribunal de Justiça do Amapá", "03"),
    TJAM("TJAM", "Tribunal de Justiça do Amazonas", "04"),
    TJBA("TJBA", "Tribunal de Justiça da Bahia", "05"),
    TJCE("TJCE", "Tribunal de Justiça do Ceará", "06"),
    TJDF("TJDF", "Tribunal de Justiça do Distrito Federal", "07"),
    TJES("TJES", "Tribunal de Justiça do Espírito Santo", "08"),
    TJGO("TJGO", "Tribunal de Justiça do Goiás", "09"),
    TJMA("TJMA", "Tribunal de Justiça do Maranhão", "10"),
    TJMT("TJMT", "Tribunal de Justiça do Mato Grosso", "11"),
    TJMS("TJMS", "Tribunal de Justiça do Mato Grosso do Sul", "12"),
    TJMG("TJMG", "Tribunal de Justiça de Minas Gerais", "13"),
    TJPA("TJPA", "Tribunal de Justiça do Pará", "14"),
    TJPB("TJPB", "Tribunal de Justiça da Paraíba", "15"),
    TJPR("TJPR", "Tribunal de Justiça do Paraná", "16"),
    TJPE("TJPE", "Tribunal de Justiça de Pernambuco", "17"),
    TJPI("TJPI", "Tribunal de Justiça do Piauí", "18"),
    TJRJ("TJRJ", "Tribunal de Justiça do Rio de Janeiro", "19"),
    TJRN("TJRN", "Tribunal de Justiça do Rio Grande do Norte", "20"),
    TJRS("TJRS", "Tribunal de Justiça do Rio Grande do Sul", "21"),
    TJRO("TJRO", "Tribunal de Justiça de Rondônia", "22"),
    TJRR("TJRR", "Tribunal de Justiça de Roraima", "23"),
    TJSC("TJSC", "Tribunal de Justiça de Santa Catarina", "24"),
    TJSE("TJSE", "Tribunal de Justiça de Sergipe", "25"),
    TJSP("TJSP", "Tribunal de Justiça de São Paulo", "26"),
    TJTO("TJTO", "Tribunal de Justiça de Tocantins", "27");

    private final String sigla;
    private final String nome;
    private final String codigo;

    JusticaEstadualEnum(String sigla, String nome, String codigo) {
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
