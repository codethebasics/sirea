package br.jus.trf1.usecase.pessoa;

import br.jus.trf1.core.domain.Pessoa;

/**
 * Fluxo principal
 * ---------------
 * Dado uma pessoa válida
 * Quando solicitar a criação
 * Então retorna pessoa cadastrada
 *
 *
 * Fluxo de exeção
 * ---------------
 * Dado uma pessoa inválida
 * Quando solicitar a criação
 * Então lança exception
 *
 * @author bruno.carneiro (tr301605)
 */
public interface CriarPessoaUC {
    Pessoa criar(Pessoa pessoa) throws RuntimeException;
}
