package trf1.jus.br.infrastructure.config;

import br.jus.trf1.actions.usuario.BuscarUsuarioAction;
import br.jus.trf1.core.domain.Usuario;
import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import trf1.jus.br.infrastructure.service.BuscarUsuarioService;

@Configuration
public class UsuarioConfig {

    private final BuscarUsuarioService buscarUsuarioService;

    public UsuarioConfig(BuscarUsuarioService buscarUsuarioService) {
        this.buscarUsuarioService = buscarUsuarioService;
    }

    @Bean
    public Usuario getUsuario() {
        return new Usuario();
    }

    @Bean
    public BuscarUsuarioUC getBuscarUsuarioService() {
        return new BuscarUsuarioAction(getUsuario(), this.buscarUsuarioService);
    }
}
