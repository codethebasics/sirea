package br.jus.trf1.command.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;

/**
 * @author bruno.carneiro (tr301605)
 */
public class BuscarUsuarioCommand implements BuscarUsuarioUC {
    @Override
    public Usuario peloId(Long id) {
        return null;
    }

    @Override
    public Usuario peloUsuario(String usuario) {
        return null;
    }

    @Override
    public Usuario peloEmail(String email) {
        return null;
    }
}
