package br.jus.trf1.usecase.usuario;

import br.jus.trf1.core.domain.Usuario;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarUsuarioUC {
    Usuario peloId(Long id);
    Usuario peloUsuario(String usuario);
    Usuario peloEmail(String email);
}
