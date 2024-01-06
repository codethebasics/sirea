package br.jus.trf1.command.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;
import br.jus.trf1.usecase.usuario.CriarUsuarioUC;
import br.jus.trf1.usecase.usuario.exceptions.BuscarUsuarioException;
import br.jus.trf1.usecase.usuario.exceptions.CriarUsuarioException;

import java.util.Objects;

/**
 * @author bruno.carneiro (tr301605)
 */
public class CriarUsuarioCommand implements CriarUsuarioUC {

    private final BuscarUsuarioUC buscarUsuario;

    public CriarUsuarioCommand(BuscarUsuarioUC buscarUsuario) {
        this.buscarUsuario = buscarUsuario;
    }

    @Override
    public Usuario criar(Usuario usuario) throws CriarUsuarioException, BuscarUsuarioException {
        System.out.println("Application::CriarUsuarioCommand.criar");
        System.out.println(usuario);
        Usuario usuarioDB = this.buscarUsuario.peloUsuario(usuario.getUsuario());
        if (Objects.nonNull(usuarioDB))
            throw new CriarUsuarioException("O usuário informado já está cadastrado");
        return usuario;
    }
}
