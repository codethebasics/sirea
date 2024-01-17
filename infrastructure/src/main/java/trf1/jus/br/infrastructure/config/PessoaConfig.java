package trf1.jus.br.infrastructure.config;

import br.jus.trf1.actions.pessoa.BuscarPessoaAction;
import br.jus.trf1.actions.pessoa.CriarPessoaAction;
import br.jus.trf1.actions.processo.CriarProcessoAction;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import br.jus.trf1.usecase.processo.CriarProcessoUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import trf1.jus.br.infrastructure.service.BuscarPessoaService;
import trf1.jus.br.infrastructure.service.CriarPessoaService;
import trf1.jus.br.infrastructure.service.CriarProcessoService;

@Configuration
public class PessoaConfig {

    private final CriarPessoaService criarPessoaService;
    private final CriarProcessoService criarProcessoService;
    private final BuscarPessoaService buscarPessoaService;

    public PessoaConfig(
            CriarPessoaService criarPessoaService,
            CriarProcessoService criarProcessoService,
            BuscarPessoaService buscarPessoaService) {
        this.criarPessoaService = criarPessoaService;
        this.criarProcessoService = criarProcessoService;
        this.buscarPessoaService = buscarPessoaService;
    }

    @Bean
    public CriarPessoaUC criarPessoaUC() {
        return new CriarPessoaAction(this.criarPessoaService);
    }

    @Bean
    public CriarProcessoUC criarProcessoUC() {
        return new CriarProcessoAction(this.criarProcessoService);
    }

    @Bean
    public BuscarPessoaUC buscarPessoaUC() {
        return new BuscarPessoaAction(this.buscarPessoaService);
    }
}
