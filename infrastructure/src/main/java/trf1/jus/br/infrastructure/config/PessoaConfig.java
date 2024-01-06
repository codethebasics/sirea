package trf1.jus.br.infrastructure.config;

import br.jus.trf1.command.pessoa.CriarPessoaCommand;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import trf1.jus.br.infrastructure.service.CriarPessoaService;

@Configuration
public class PessoaConfig {

    private final CriarPessoaService criarPessoaService;

    public PessoaConfig(CriarPessoaService criarPessoaService) {
        this.criarPessoaService = criarPessoaService;
    }

    @Bean
    public CriarPessoaUC pessoa() {
        return new CriarPessoaCommand(this.criarPessoaService);
    }
}
