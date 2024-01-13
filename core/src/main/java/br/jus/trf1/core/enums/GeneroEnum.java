package br.jus.trf1.core.enums;

public enum GeneroEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String genero;

    GeneroEnum(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
