package br.jus.trf1.actions.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;
import br.jus.trf1.usecase.usuario.CriarUsuarioUC;
import br.jus.trf1.usecase.usuario.exceptions.BuscarUsuarioException;
import br.jus.trf1.usecase.usuario.exceptions.CriarUsuarioException;

import java.util.Objects;

/**
 * @author bruno.carneiro (tr301605)
 */
public class CriarUsuarioAction implements CriarUsuarioUC {

    private final BuscarUsuarioUC buscarUsuario;

    public CriarUsuarioAction(BuscarUsuarioUC buscarUsuario) {
        this.buscarUsuario = buscarUsuario;
    }

    @Override
    public Usuario criar(Usuario usuario) throws CriarUsuarioException, BuscarUsuarioException {
        return usuario;
    }
}
