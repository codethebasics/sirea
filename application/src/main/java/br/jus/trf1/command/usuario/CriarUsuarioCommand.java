package br.jus.trf1.command.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;
import br.jus.trf1.usecase.usuario.CriarUsuarioUC;

/**
 * @author bruno.carneiro (tr301605)
 */
public class CriarUsuarioCommand implements CriarUsuarioUC {

    private BuscarUsuarioUC buscarUsuario;

    public CriarUsuarioCommand(BuscarUsuarioUC buscarUsuario) {
        this.buscarUsuario = buscarUsuario;
    }

    @Override
    public Usuario criar(Usuario usuario) throws RuntimeException {
        return null;
    }
}
