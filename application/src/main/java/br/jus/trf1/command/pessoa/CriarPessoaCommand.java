package br.jus.trf1.command.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.gateway.pessoa.CriarPessoaGateway;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;

/**
 * @author bruno.carneiro (tr301605)
 */
public class CriarPessoaCommand implements CriarPessoaUC {

    private final BuscarPessoaUC buscarPessoa;
    private final CriarPessoaGateway criarPessoaGateway;

    public CriarPessoaCommand(BuscarPessoaUC buscarPessoa, CriarPessoaGateway criarPessoaGateway) {
        this.buscarPessoa = buscarPessoa;
        this.criarPessoaGateway = criarPessoaGateway;
    }

    @Override
    public Pessoa criar(Pessoa pessoa) throws RuntimeException {
        return this.criarPessoaGateway.criar(pessoa);
    }
}
