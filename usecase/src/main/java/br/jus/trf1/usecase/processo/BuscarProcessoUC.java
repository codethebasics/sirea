package br.jus.trf1.usecase.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;
import br.jus.trf1.core.exception.processo.ProcessoException;

import java.util.Optional;
import java.util.Set;

/**
 * Caso de uso Buscar Processo
 *
 * @author Bruno Carneiro
 */
public interface BuscarProcessoUC {

    /**
     * <ul>
     *     <li>Dado um processo</li>
     *     <li>Quando buscar</li>
     *     <li>Deve retornar processo</li>
     * </ul>
     *
     * @param processo processo a ser pesquisado
     * @return processo
     * @throws ProcessoException em caso de erro ao buscar processo
     */
    Optional<Processo> buscar(Processo processo) throws ProcessoException;

    /**
     * <ul>
     *     <li>Dado um número de processo</li>
     *     <li>Quando buscar processo</li>
     *     <li>Deve retornar processo</li>
     * </ul>
     *
     * @param numeroProcesso número do processo a ser pesquisado
     * @return processo pesquisado
     * @throws ProcessoException em caso de erro durante a pesquisa do processo
     */
    Optional<Processo> buscar(String numeroProcesso) throws ProcessoException;

    /**
     * <ul>
     *     <li>Quando listar</li>
     *     <li>Deve retornar lista de processos</li>
     * </ul>
     *
     * @return lista de processos
     * @throws ProcessoException em caso de erro durante a listagem de processos
     */
    Set<Processo> listar() throws ProcessoException;

    /**
     * <ul>
     *     <li>Dado um órgão judiciário</li>
     *     <li>Quando listar por órgão judiciário</li>
     *     <li>Deve listar processos por órgão judiciário</li>
     * </ul>
     *
     * @param orgaoJudiciario órgão judiciário
     * @return lista de processos do órgão judiciário
     * @throws ProcessoException em caso de erro durante listagem de processos por órgão judiciário
     */
    Set<Processo> listar(OrgaoJudiciarioEnum orgaoJudiciario) throws ProcessoException;

    /**
     * <ul>
     *     <li>Dado um tribunal</li>
     *     <li>Quando listar por tribunal</li>
     *     <li>Deve retornar lista de processos por tribunal</li>
     * </ul>
     *
     * @param tribunal tribunal
     * @return lista de processos do tribunal
     * @throws ProcessoException em caso de erro durante a listagem por tribunal
     */
    Set<Processo> listar(TribunalEnum tribunal) throws ProcessoException;

    /**
     * <ul>
     *     <li>Dado uma origem</li>
     *     <li>Quando listar por origem</li>
     *     <li>Deve retornar lista de processos por origem</li>
     * </ul>
     *
     * @param origem origem
     * @return lista de processos por origem
     * @throws ProcessoException em caso de erro durante listagem por origem
     */
    Set<Processo> listar(OrigensTRF1Enum origem) throws ProcessoException;
}
