package br.jus.trf1.actions.usuario;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.core.enums.PermissaoEnum;
import br.jus.trf1.gateway.usuario.BuscarUsuarioGateway;
import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;
import br.jus.trf1.usecase.usuario.exceptions.BuscarUsuarioException;

import java.util.Optional;
import java.util.Set;

/**
 * @author bruno.carneiro (tr301605)
 */
public class BuscarUsuarioAction implements BuscarUsuarioUC {

    private final Usuario usuario;
    private final BuscarUsuarioGateway buscarUsuarioGateway;

    public BuscarUsuarioAction(Usuario usuario, BuscarUsuarioGateway buscarUsuarioGateway) {
        this.usuario = usuario;
        this.buscarUsuarioGateway = buscarUsuarioGateway;
    }

    @Override
    public Optional<Usuario> peloId(Long id) throws BuscarUsuarioException {
        try {
            return this.buscarUsuarioGateway.peloId(id);
        } catch (Exception e) {
            throw new BuscarUsuarioException("Erro durante pesquisa do usuário", e);
        }
    }

    @Override
    public Optional<Usuario> peloUsuario(String usuario) throws BuscarUsuarioException {
        try {
            return this.buscarUsuarioGateway.peloUsuario(usuario);
        } catch (Exception e) {
            throw new BuscarUsuarioException("Erro durante pesquisa do usuário", e);
        }
    }

    @Override
    public Optional<Usuario> peloEmail(String email) throws BuscarUsuarioException {
        try {
            return this.buscarUsuarioGateway.peloEmail(email);
        } catch (Exception e) {
            throw new BuscarUsuarioException("Erro durante pesquisa do usuário", e);
        }
    }

    @Override
    public Set<Usuario> listar() throws BuscarUsuarioException {
        try {
            boolean isAdmin = usuario.getPermissoes().stream()
                    .anyMatch(p -> p.getPermissao().equals(PermissaoEnum.ADMTRF1));

            if (!isAdmin)
                throw new BuscarUsuarioException("Privilégios insuficientes");

            return this.buscarUsuarioGateway.listar();
        } catch (Exception e) {
            throw new BuscarUsuarioException("Erro durante pesquisa do usuário", e);
        }
    }
}
