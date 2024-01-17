package trf1.jus.br.infrastructure.dto.pessoa.response;

import trf1.jus.br.infrastructure.dto.pessoa.PessoaDTO;

import java.time.LocalDateTime;


public final class CriarPessoaResponse {
    private final PessoaDTO pessoaDTO;
    private final String message;

    public CriarPessoaResponse(PessoaDTO pessoaDTO, String message) {
        this.pessoaDTO = pessoaDTO;
        this.message = message;
    }

    public PessoaDTO getPessoaDTO() {
        return pessoaDTO;
    }

    public String getMessage() {
        return this.message;
    }
}
