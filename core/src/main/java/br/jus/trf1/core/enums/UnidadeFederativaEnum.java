package br.jus.trf1.core.enums;

/**
 * Define os Estados do Brasil
 *
 * @author bruno.carneiro (tr301605)
 */
public enum UnidadeFederativaEnum {
    AC("Acre", "AC", RegiaoEnum.NORTE),
    AL("Alagoas", "AL", RegiaoEnum.NORDESTE),
    AP("Amapá", "AP", RegiaoEnum.NORTE),
    AM("Amazonas", "AM", RegiaoEnum.NORTE),
    BA("Bahia", "BA", RegiaoEnum.NORDESTE),
    CE("Ceará", "CE", RegiaoEnum.NORDESTE),
    DF("Distrito Federal", "DF", RegiaoEnum.CENTRO_OESTE),
    ES("Espírito Santo", "ES", RegiaoEnum.SUDESTE),
    GO("Goiás", "GO", RegiaoEnum.CENTRO_OESTE),
    MA("Maranhão", "MA", RegiaoEnum.NORDESTE),
    MT("Mato Grosso", "MT", RegiaoEnum.CENTRO_OESTE),
    MS("Mato Grosso do Sul", "MS", RegiaoEnum.CENTRO_OESTE),
    MG("Minas Gerais", "MG", RegiaoEnum.SUDESTE),
    PA("Pará", "PA", RegiaoEnum.NORTE),
    PB("Paraíba", "PB", RegiaoEnum.NORDESTE),
    PR("Paraná", "PR", RegiaoEnum.SUL),
    PE("Pernambuco", "PE", RegiaoEnum.NORDESTE),
    PI("Piauí", "PI", RegiaoEnum.NORDESTE),
    RJ("Rio de Janeiro", "RJ", RegiaoEnum.SUDESTE),
    RN("Rio Grande do Norte", "RN", RegiaoEnum.NORDESTE),
    RS("Rio Grande do Sul", "RS", RegiaoEnum.SUL),
    RO("Rondônia", "RO", RegiaoEnum.NORTE),
    RR("Roraima", "RR", RegiaoEnum.NORTE),
    SC("Santa Catarina", "SC", RegiaoEnum.SUL),
    SP("São Paulo", "SP", RegiaoEnum.SUDESTE),
    SE("Sergipe", "SE", RegiaoEnum.NORDESTE),
    TO("Tocantins", "TO", RegiaoEnum.NORTE);

    private final String nome;
    private final String sigla;
    private final RegiaoEnum regiao;

    UnidadeFederativaEnum(String nome, String sigla, RegiaoEnum regiao) {
        this.nome = nome;
        this.sigla = sigla;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public RegiaoEnum getRegiao() {
        return regiao;
    }
}
