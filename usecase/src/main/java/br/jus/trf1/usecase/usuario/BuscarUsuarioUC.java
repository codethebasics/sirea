package br.jus.trf1.usecase.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.exceptions.BuscarUsuarioException;

/**
 * Caso de uso Buscar Usuário
 *
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarUsuarioUC {

    /**
     * <ul>
     *     <li>Dado um ID</li>
     *     <li>Quando buscar pelo id</li>
     *     <li>Deve retornar usuário</li>
     * </ul>
     *
     * @param id id do usuário a ser pesquisado
     * @return usuário pesquisado
     * @throws BuscarUsuarioException no caso de erro durante busca de usuário
     */
    Usuario peloId(Long id) throws BuscarUsuarioException;


    /**
     * <ul>
     *     <li>Dado um usuário</li>
     *     <li>Quando buscar usuário pelo nome de usuário</li>
     *     <li>Deve retornar usuário</li>
     * </ul>
     *
     * @param usuario usuário a ser pesquisado
     * @return usuário pesquisado
     * @throws BuscarUsuarioException em caso de erro durante busca de usuário
     */
    Usuario peloUsuario(String usuario) throws BuscarUsuarioException;

    /**
     * <ul>
     *     <li>Dado um email</li>
     *     <li>Quando pesquisar usuário pelo email</li>
     *     <li>Deve retornar usuário</li>
     * </ul>
     * @param email email do usuário a ser pesquisado
     * @return usuário pesquisado
     * @throws BuscarUsuarioException no caso de erro durante busca do usuário
     */
    Usuario peloEmail(String email) throws BuscarUsuarioException;
}
