package trf1.jus.br.infrastructure.dto.pessoa.mapper;

import br.jus.trf1.core.domain.Pessoa;
import trf1.jus.br.infrastructure.dto.pessoa.PessoaDTO;

public class PessoaMapper {

    public static Pessoa fromDTO(PessoaDTO pessoaDTO) {
        return null;
    }

    public static PessoaDTO toDTO(Pessoa pessoa) {
        return new PessoaDTO(pessoa);
    }
}
