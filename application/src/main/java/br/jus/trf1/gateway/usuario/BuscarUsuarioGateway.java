package br.jus.trf1.gateway.usuario;

import br.jus.trf1.core.domain.Usuario;

import java.util.Optional;
import java.util.Set;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface BuscarUsuarioGateway {
    Optional<Usuario> peloId(Long id);
    Optional<Usuario> peloUsuario(String usuario);
    Optional<Usuario> peloEmail(String email);
    Set<Usuario> listar();
}
