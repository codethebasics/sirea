package br.jus.trf1.gateway.pessoa;

import br.jus.trf1.core.domain.Pessoa;

import java.util.List;
import java.util.Set;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarPessoaGateway {

    Pessoa peloId(Long id);

    Set<Pessoa> peloNome(String nome);

    Pessoa peloEmail(String email);
}
