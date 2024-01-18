package trf1.jus.br.infrastructure.service;

import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.gateway.usuario.BuscarUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BuscarUsuarioService implements BuscarUsuarioGateway {

    @Override
    public Optional<Usuario> peloId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> peloUsuario(String usuario) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> peloEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Set<Usuario> listar() {
        return null;
    }
}

