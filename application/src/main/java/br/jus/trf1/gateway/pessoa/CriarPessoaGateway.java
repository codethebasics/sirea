package br.jus.trf1.gateway.pessoa;

import br.jus.trf1.core.domain.Pessoa;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface CriarPessoaGateway {
    Pessoa criar(Pessoa pessoa);
}
