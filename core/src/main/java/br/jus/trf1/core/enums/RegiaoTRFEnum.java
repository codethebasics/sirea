package br.jus.trf1.core.enums;

/**
 * @author bruno.carneiro (tr301605)
 */
public enum RegiaoTRFEnum {
    TRF1("TRF-1", "Tribunal Regional Federal da Primeira Região", "01"),
    TRF2("TRF-2", "Tribunal Regional Federal da Segunda Região", "02"),
    TRF3("TRF-3", "Tribunal Regional Federal da Terceira Região", "03"),
    TRF4("TRF-4", "Tribunal Regional Federal da Primeira Região", "04"),
    TRF5("TRF-5", "Tribunal Regional Federal da Quinta Região", "05"),
    TRF6("TRF-6", "Tribunal Regional Federal da Sexta Região", "06");

    private final String sigla;
    private final String nome;
    private final String codigo;

    RegiaoTRFEnum(String sigla, String nome, String codigo) {
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
