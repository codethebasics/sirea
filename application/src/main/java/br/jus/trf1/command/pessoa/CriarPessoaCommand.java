package br.jus.trf1.command.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.gateway.pessoa.CriarPessoaGateway;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;

/**
 * Implementação do caso de uso CriarPessoaUC
 *
 * @author bruno.carneiro (tr301605)
 */
public class CriarPessoaCommand implements CriarPessoaUC {

    private final CriarPessoaGateway criarPessoaGateway;

    public CriarPessoaCommand(CriarPessoaGateway criarPessoaGateway) {
        this.criarPessoaGateway = criarPessoaGateway;
    }

    @Override
    public Pessoa criar(Pessoa pessoa) throws RuntimeException {
        System.out.println("Application::CriarPessoaCommand.criar");
        System.out.println(pessoa);
        Pessoa pessoaCriada = this.criarPessoaGateway.criar(pessoa);
        return pessoa;
    }
}
