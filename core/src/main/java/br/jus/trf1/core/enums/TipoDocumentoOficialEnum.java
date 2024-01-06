package br.jus.trf1.core.enums;

/**
 * Define os tipos de documentos oficiais expedidos pelo governo brasileiro
 *
 * @author bruno.carneiro(tr301605)
 */
public enum TipoDocumentoOficialEnum {
    RG("Registro Geral"),
    RNE("Registro Nacional de Estrangeiro"),
    ARB("Autorização de Retorno ao Brasil"),
    CPF("Cadastro de Pessoa Física"),
    CNH("Carteira Nacional de Habilitação"),
    CERTIDAO_NASCIMENTO("Certidão de nascimento"),
    CERTIDAO_CASAMENTO("Certidão de casamento"),
    CERTIDAO_OBITO("Certidão de óbito"),
    CERTIDAO_NEGATIVA("Certidão negativa"),
    CARTEIRA_TRABALHO("Carteira de trabalho"),
    CARTAO_CIDADAO("Cartão do Cidadão"),
    CARTOES_BANCARIOS("Cartões bancários"),
    TITULO_ELEITOR("Título de Eleitor"),
    PASSAPORTE("Passaporte"),
    CERTIFICADO_ALISTAMENTO_MILITAR("Certificado de Alistamento Militar"),
    SUS("Carteirinha SUS"),
    TESTAMENTO("Testamento");

    private final String documento;

    TipoDocumentoOficialEnum(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }
}
