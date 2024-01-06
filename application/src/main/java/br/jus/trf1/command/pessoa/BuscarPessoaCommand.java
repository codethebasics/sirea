package br.jus.trf1.command.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;

import java.util.List;

/**
 * @author bruno.carneiro (tr301605)
 */
public class BuscarPessoaCommand implements BuscarPessoaUC {
    @Override
    public Pessoa peloId(Long id) {
        return null;
    }

    @Override
    public List<Pessoa> peloNome(String nome) {
        return null;
    }

    @Override
    public Pessoa peloEmail(String email) {
        return null;
    }
}
