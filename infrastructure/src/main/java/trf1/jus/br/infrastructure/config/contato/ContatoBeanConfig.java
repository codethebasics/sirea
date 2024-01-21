package trf1.jus.br.infrastructure.config.contato;

import br.jus.trf1.actions.contato.BuscarContatoAction;
import br.jus.trf1.actions.contato.CriarContatoAction;
import br.jus.trf1.gateway.contato.BuscarContatoGateway;
import br.jus.trf1.gateway.contato.CriarContatoGateway;
import br.jus.trf1.usecase.contato.BuscarContatoUC;
import br.jus.trf1.usecase.contato.CriarContatoUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContatoBeanConfig {

    private final CriarContatoGateway criarContatoGateway;
    private final BuscarContatoGateway buscarContatoGateway;

    public ContatoBeanConfig(
            CriarContatoGateway criarContatoGateway,
            BuscarContatoGateway buscarContatoGateway) {
        this.criarContatoGateway = criarContatoGateway;
        this.buscarContatoGateway = buscarContatoGateway;
    }

    @Bean
    public CriarContatoUC criarContatoUCBean() {
        return new CriarContatoAction(this.criarContatoGateway, buscarContatoUCBean());
    }

    @Bean
    public BuscarContatoUC buscarContatoUCBean() {
        return new BuscarContatoAction(this.buscarContatoGateway);
    }

}
