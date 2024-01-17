package trf1.jus.br.infrastructure.dto.pessoa.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trf1.jus.br.infrastructure.dto.pessoa.PessoaDTO;

/**
 * Representa um requisição de cadastro de pessoa
 *
 * @author Bruno Carneiro
 */
@Getter
@Setter
@NoArgsConstructor
public class CriarPessoaRequest  {
    private PessoaDTO pessoaDTO;

    public CriarPessoaRequest(PessoaDTO pessoaDTO) {
        this.pessoaDTO = pessoaDTO;
    }

}
