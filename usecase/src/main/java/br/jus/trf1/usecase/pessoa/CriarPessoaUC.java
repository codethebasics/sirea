package br.jus.trf1.usecase.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.usecase.pessoa.exceptions.CriarPessoaException;

/**
 *
 * Caso de uso Criar Pessoa
 *
 * @author bruno.carneiro (tr301605)
 */
public interface CriarPessoaUC {

    /**
     *  <b>Fluxo principal</b>
     *  <ul>
     *       <li>Dado uma pessoa válida</li>
     *       <li>Quando solicitar a criação</li>
     *       <li>Então retorna pessoa criada</li>
     *  </ul>
     *  <br>
     *  <b>Fluxo de exeção</b>
     *  <ul>
     *       <li>Dado uma pessoa inválida</li>
     *       <li>Quando solicitar a criação</li>
     *       <li>Então lança CriarPessoaException</li>
     *  </ul>
     *
     * @param pessoa pessoa a ser criada
     * @return pessoa criada
     * @throws RuntimeException
     */
    Pessoa criar(Pessoa pessoa) throws CriarPessoaException;
}
