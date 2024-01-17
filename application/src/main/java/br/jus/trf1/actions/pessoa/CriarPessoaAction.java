package br.jus.trf1.actions.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.gateway.pessoa.BuscarPessoaGateway;
import br.jus.trf1.gateway.pessoa.CriarPessoaGateway;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import br.jus.trf1.usecase.pessoa.exceptions.CriarPessoaException;
import br.jus.trf1.usecase.pessoa.exceptions.PessoaNaoEncontradaException;

import java.util.Objects;

/**
 * Implementação do caso de uso CriarPessoaUC
 *
 * @author bruno.carneiro (tr301605)
 */
public class CriarPessoaAction implements CriarPessoaUC {
    private final CriarPessoaGateway criarPessoaGateway;

    public CriarPessoaAction(CriarPessoaGateway criarPessoaGateway) {
        this.criarPessoaGateway = criarPessoaGateway;
    }

    @Override
    public Pessoa criar(Pessoa pessoa) throws CriarPessoaException {
        try {
            return this.criarPessoaGateway.criar(pessoa);
        } catch (Exception e) {
            throw new CriarPessoaException("Erro durante cadastro de pessoa", e);
        }
    }
}
