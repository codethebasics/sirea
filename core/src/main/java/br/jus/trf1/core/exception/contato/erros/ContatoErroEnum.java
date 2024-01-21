package br.jus.trf1.core.exception.contato.erros;

public enum ContatoErroEnum {
    TELEFONE_INVALIDO("Telefone inválido"),
    DDD_INVALIDO("DDD inválido"),
    EMAIL_INVALIDO("E-mail inválido");

    private final String mensagem;

    ContatoErroEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
