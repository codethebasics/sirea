package br.jus.trf1.usecase.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.usecase.pessoa.exceptions.PessoaNaoEncontradaException;

import java.util.List;

/**
 *
 * Caso de uso Buscar Pessoa
 *
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarPessoaUC {

    /**
     * <b>Fluxo principal</b>
     * <ul>
     *      <li>Dado o ID de uma pessoa válida</li>
     *      <li>Quando solicitar a busca</li>
     *      <li>Então retorna pessoa pesquisada</li>
     * </ul>
     * <br>
     * <b>Fluxo de exeção</b>
     * <ul>
     *      <li>Dado o ID de uma pessoa não existente</li>
     *      <li>Quando solicitar a busca</li>
     *      <li>Então lança PessoaNaoEncontradaException</li>
     * </ul>
     *
     * @param id id da pessoa a ser pesquisada
     * @return pessoa
     */
    Pessoa peloId(Long id) throws PessoaNaoEncontradaException;

    /**
     * <b>Fluxo principal</b>
     * <ul>
     *      <li>Dado o nome de uma pessoa válida</li>
     *      <li>Quando solicitar a busca</li>
     *      <li>Então retorna pessoa pesquisada</li>
     * </ul>
     * <br>
     * <b>Fluxo de exeção</b>
     * <ul>
     *      <li>Dado o nome de uma pessoa não existente</li>
     *      <li>Quando solicitar a busca</li>
     *      <li>Então lança PessoaNaoEncontradaException</li>
     * </ul>
     *
     * @param nome nome da pessoa a ser pesquisada
     * @return pessoa
     */
    List<Pessoa> peloNome(String nome) throws PessoaNaoEncontradaException;

    /**
     * <b>Fluxo principal</b>
     * <ul>
     *      <li>Dado o email de uma pessoa válida</li>
     *      <li>Quando solicitar a busca</li>
     *      <li>Então retorna pessoa pesquisada</li>
     * </ul>
     * <br>
     * <b>Fluxo de exeção</b>
     * <ul>
     *      <li>Dado o email de uma pessoa não existente</li>
     *      <li>Quando solicitar a busca</li>
     *      <li>Então lança PessoaNaoEncontradaException</li>
     * </ul>
     *
     * @param email id da pessoa a ser pesquisada
     * @return pessoa
     */
    Pessoa peloEmail(String email) throws PessoaNaoEncontradaException;

}
