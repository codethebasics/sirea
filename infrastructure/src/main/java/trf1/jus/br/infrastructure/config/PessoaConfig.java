package trf1.jus.br.infrastructure.config;

import br.jus.trf1.actions.pessoa.BuscarPessoaAction;
import br.jus.trf1.actions.pessoa.CriarPessoaAction;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import trf1.jus.br.infrastructure.service.BuscarPessoaService;
import trf1.jus.br.infrastructure.service.CriarPessoaService;

@Configuration
public class PessoaConfig {

    private final CriarPessoaService criarPessoaService;
    private final BuscarPessoaService buscarPessoaService;

    public PessoaConfig(
            CriarPessoaService criarPessoaService,
            BuscarPessoaService buscarPessoaService) {
        this.criarPessoaService = criarPessoaService;
        this.buscarPessoaService = buscarPessoaService;

    }

    @Bean
    public CriarPessoaUC criarPessoaUC() {
        return new CriarPessoaAction(this.criarPessoaService);
    }

    @Bean
    public BuscarPessoaUC buscarPessoaUC() {
        return new BuscarPessoaAction(this.buscarPessoaService);
    }
}
