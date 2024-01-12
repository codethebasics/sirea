package br.jus.trf1.core.exception.processo.errors;

import br.jus.trf1.core.exception.CategoriaErroEnum;

public enum ProcessoErrosEnum {
    NUMERO_PROCESSO_INVALIDO("Número do processo inválido"),
    DIGITO_VERIFICADOR_INVALIDO("Dígito verificador inválido"),
    ANO_INVALIDO("Ano inválido"),
    ORGAO_NAO_EXISTE("Órgão inexistente"),
    TRIBUNAL_NAO_EXISTE("Tribunal inexistente"),
    ORIGEM_NAO_EXISTE("Origem inexistente");

    private final String mensagem;
    private final CategoriaErroEnum categoriaErro;

    ProcessoErrosEnum(String mensagem) {
        this.mensagem = mensagem;
        this.categoriaErro = CategoriaErroEnum.PROCESSO;
    }

    public String getMensagem() {
        return mensagem;
    }

    public CategoriaErroEnum getCategoriaErro() {
        return categoriaErro;
    }
}
