package br.jus.trf1.actions.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.gateway.pessoa.BuscarPessoaGateway;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;
import br.jus.trf1.usecase.pessoa.exceptions.PessoaNaoEncontradaException;

import java.util.List;
import java.util.Objects;

/**
 * @author bruno.carneiro (tr301605)
 */
public class BuscarPessoaAction implements BuscarPessoaUC {

    private final BuscarPessoaGateway buscarPessoaGateway;

    public BuscarPessoaAction(BuscarPessoaGateway buscarPessoaGateway) {
        this.buscarPessoaGateway = buscarPessoaGateway;
    }

    @Override
    public Pessoa peloId(Long id) throws PessoaNaoEncontradaException {
        try {
            Pessoa pessoa = this.buscarPessoaGateway.peloId(id);

            if (Objects.isNull(pessoa))
                throw new PessoaNaoEncontradaException("Pessoa não encontrada");

            return pessoa;
        } catch (Exception e) {
            throw new PessoaNaoEncontradaException("Erro durante consulta por ID", e);
        }
    }

    @Override
    public List<Pessoa> peloNome(String nome) throws PessoaNaoEncontradaException {
        try {
            return this.buscarPessoaGateway.peloNome(nome);
        } catch (Exception e) {
            throw new RuntimeException("Erro durante busca pelo nome", e);
        }
    }

    @Override
    public Pessoa peloEmail(String email) throws PessoaNaoEncontradaException {
        try {
            Pessoa pessoa = this.buscarPessoaGateway.peloEmail(email);

            if (Objects.isNull(pessoa))
                throw new PessoaNaoEncontradaException("Pessoa não encontrada");

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException("Erro durante busca pelo email", e);
        }
    }
}
