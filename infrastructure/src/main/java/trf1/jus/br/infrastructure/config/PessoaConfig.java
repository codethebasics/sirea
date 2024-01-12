package trf1.jus.br.infrastructure.config;

import br.jus.trf1.actions.pessoa.CriarPessoaAction;
import br.jus.trf1.actions.processo.CriarProcessoAction;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import br.jus.trf1.usecase.processo.CriarProcessoUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import trf1.jus.br.infrastructure.service.CriarPessoaService;
import trf1.jus.br.infrastructure.service.CriarProcessoService;

@Configuration
public class PessoaConfig {

    private final CriarPessoaService criarPessoaService;
    private final CriarProcessoService criarProcessoService;

    public PessoaConfig(CriarPessoaService criarPessoaService, CriarProcessoService criarProcessoService) {
        this.criarPessoaService = criarPessoaService;
        this.criarProcessoService = criarProcessoService;
    }

    @Bean
    public CriarPessoaUC pessoa() {
        return new CriarPessoaAction(this.criarPessoaService);
    }

    public CriarProcessoUC criarProcessoUC() {
        return new CriarProcessoAction(this.criarProcessoService);
    }
}
