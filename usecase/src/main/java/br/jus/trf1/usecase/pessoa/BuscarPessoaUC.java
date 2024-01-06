package br.jus.trf1.usecase.pessoa;

import br.jus.trf1.core.domain.Pessoa;

import java.util.List;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarPessoaUC {
    Pessoa peloId(Long id);
    List<Pessoa> peloNome(String nome);
    Pessoa peloEmail(String email);

}
