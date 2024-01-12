package br.jus.trf1.core.exception;

public enum CategoriaErroEnum {

    PROCESSO("PROCESSO", "Erros relacionados ao processo"),
    PESSOA("PESSOA", "Erros relacionado à pessoa"),
    DOCUMENTO_OFICIAL("DOCUMENTO_OFICIAL", "Erros relacionados ao documento oficial"),
    ENDERECO("ENDERECO", "Erros relacionados ao endereço"),
    PERMISSAO("PERMISSAO", "Erros relacionados à permissão"),
    USUARIO("USUARIO", "Erros relacionados ao usuário"),
    CONTATO("CONTATO", "Erros relacionados ao contato"),
    ;

    private final String codigo;
    private final String descricao;

    CategoriaErroEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
