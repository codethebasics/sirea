package br.jus.trf1.gateway.pessoa;

import br.jus.trf1.core.domain.Pessoa;

import java.util.List;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarPessoaGateway {

    Pessoa peloId(Long id);

    List<Pessoa> peloNome(String nome);

    Pessoa peloEmail(String email);
}
