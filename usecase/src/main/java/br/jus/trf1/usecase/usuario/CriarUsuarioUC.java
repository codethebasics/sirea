package br.jus.trf1.usecase.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.exceptions.BuscarUsuarioException;
import br.jus.trf1.usecase.usuario.exceptions.CriarUsuarioException;

/**
 * Caso de uso Criar Usuário
 *
 * @author bruno.carneiro (tr301605)
 */
public interface CriarUsuarioUC {

    /**
     * <ul>
     *     <li>Dado um usuário</li>
     *     <li>Quando criar usuário</li>
     *     <li>Deve retornar usuário criado</li>
     * </ul>
     *
     * @param usuario usuário a ser criado
     * @return usuário criado
     * @throws CriarUsuarioException em caso de erro durante a criação do usuário
     * @throws BuscarUsuarioException em caso de erro durante a busca do usuário
     */
    Usuario criar(Usuario usuario) throws CriarUsuarioException, BuscarUsuarioException;
}
