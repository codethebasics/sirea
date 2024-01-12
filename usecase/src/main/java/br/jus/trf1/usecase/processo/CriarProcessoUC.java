package br.jus.trf1.usecase.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.usecase.processo.exceptions.CriarProcessoException;

/**
 * Caso de uso Criar Processo
 *
 * @author Bruno Carneiro
 */
public interface CriarProcessoUC {

    /**
     * <b>Deve criar um processo</b>
     * <ul>
     *     <li>Dado um processo</li>
     *     <li>Quando criar</li>
     *     <li>Então deve retornar processo criado</li>
     * </ul>
     *
     * @param processo processo a ser criado
     * @return processo criado
     * @throws CriarProcessoException em caso de erro durante criação do processo
     */
    Processo criar(Processo processo) throws CriarProcessoException;
}
