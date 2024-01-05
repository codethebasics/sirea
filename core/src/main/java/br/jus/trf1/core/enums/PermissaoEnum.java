package br.jus.trf1.core.enums;

/**
 * @author bruno.carneiro (tr301605)
 */
public enum PermissaoEnum {
    GUEST("GUEST", "Usuário não autenticado"),
    ADVFUNC("ADVFUNC", "Funcionários de escritórios de advocacia"),
    ADMTRF1("ADMTRF1", "Administrador"),
    ADV("ADV", "Advogados"),
    MAG("MAG", "Magistrado"),
    VARDIR("VARDIR", "Diretor de Vara"),
    VARSER("VARSER", "Servidor de Vara"),
    COGER("COGER", "Corregedoria do TRF1"),
    PRE("PRE", "Preposto"),
    GPRDIR("GPRDIR", "Gestão de Precatório Diretor"),
    GPRSERV("GPRSERV", "Gestão de Precatório Servidor"),
    GPRSUP("GPRSUP", "Gestão de Precatório Supervisor"),
    SIS("SIS", "Sistema cliente"),
    CADEXT("CADEXT", "Sem perfil"),
    EXECUTADO("EXECUTADO", "Executado");

    private final String sigla;
    private final String descricao;

    PermissaoEnum(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}
