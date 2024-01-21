package br.jus.trf1.core.exception.endereco.erros;

public enum EnderecoErroEnum {
    ENDERECO_NAO_INFORMADO("O endereço deve ser informado"),
    ENDERECO_SEM_CEP("O CEP deve ser informado"),
    ENDERECO_INVALIDO("O endereço informado é inválido"),
    ENDERECO_SEM_UF("A unidade federativa do endereço deve ser informada"),
    ENDERECO_SEM_LOGRADOURO("O logradouro do endereço deve ser informado"),
    ENDERECO_SEM_BAIRRO("O bairro do endereço deve ser informado"),
    ENDERECO_SEM_LOCALIDADE("A localidade do endereço deve ser informado");

    private final String mensagem;

    EnderecoErroEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
