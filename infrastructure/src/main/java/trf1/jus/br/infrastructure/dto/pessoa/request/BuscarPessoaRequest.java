package trf1.jus.br.infrastructure.dto.pessoa.request;

import trf1.jus.br.infrastructure.dto.pessoa.PessoaDTO;

public class BuscarPessoaRequest {
    private final PessoaDTO pessoa;

    public BuscarPessoaRequest(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDTO getPessoa() {
        return pessoa;
    }

}
