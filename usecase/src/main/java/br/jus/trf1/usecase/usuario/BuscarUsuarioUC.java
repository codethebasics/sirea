package br.jus.trf1.usecase.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.exceptions.BuscarUsuarioException;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarUsuarioUC {
    Usuario peloId(Long id) throws BuscarUsuarioException;
    Usuario peloUsuario(String usuario) throws BuscarUsuarioException;
    Usuario peloEmail(String email) throws BuscarUsuarioException;
}
