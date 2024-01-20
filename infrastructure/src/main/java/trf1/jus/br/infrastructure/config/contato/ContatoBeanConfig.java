package trf1.jus.br.infrastructure.config.contato;

import br.jus.trf1.actions.contato.CriarContatoAction;
import br.jus.trf1.gateway.contato.CriarContatoGateway;
import br.jus.trf1.usecase.contato.CriarContatoUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContatoBeanConfig {

    private final CriarContatoGateway criarContatoGateway;

    public ContatoBeanConfig(CriarContatoGateway criarContatoGateway) {
        this.criarContatoGateway = criarContatoGateway;
    }

    @Bean
    public CriarContatoUC criarContatoUCBean() {
        return new CriarContatoAction(this.criarContatoGateway);
    }
}
