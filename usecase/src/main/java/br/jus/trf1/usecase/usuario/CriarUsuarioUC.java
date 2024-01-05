package br.jus.trf1.usecase.usuario;

import br.jus.trf1.core.domain.Usuario;

/**
 * Fluxo principal
 * ---------------
 * Dado um usuário válido
 * Quando solicitar o cadastramento
 * Então retorna usuário cadastrado
 *
 *
 * Fluxo de exeção
 * ---------------
 * Dado um usuário inválido
 * Quando solicitar o cadastramento
 * Então lança exception
 *
 * @author bruno.carneiro (tr301605)
 */
public interface CriarUsuarioUC {
    Usuario criar(Usuario usuario) throws RuntimeException;
}
