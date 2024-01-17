package trf1.jus.br.infrastructure.dto.pessoa.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.util.MultiValueMap;
import trf1.jus.br.infrastructure.dto.pessoa.PessoaDTO;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class BuscarPessoaResponse {
    private Set<PessoaDTO> pessoas;
    private PessoaDTO pessoa;

    public BuscarPessoaResponse() {

    }

    public BuscarPessoaResponse(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public BuscarPessoaResponse(Set<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public BuscarPessoaResponse(Set<PessoaDTO> pessoas, PessoaDTO pessoa) {
        this.pessoas = pessoas;
        this.pessoa = pessoa;
    }
}
