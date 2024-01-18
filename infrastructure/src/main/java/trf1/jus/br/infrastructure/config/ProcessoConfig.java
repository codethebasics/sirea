package trf1.jus.br.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import trf1.jus.br.infrastructure.service.BuscarProcessoService;
import trf1.jus.br.infrastructure.service.CriarProcessoService;

@Configuration
public class ProcessoConfig {

    private final BuscarProcessoService buscarProcessoService;
    private final CriarProcessoService criarProcessoService;

    public ProcessoConfig(BuscarProcessoService buscarProcessoService, CriarProcessoService criarProcessoService) {
        this.buscarProcessoService = buscarProcessoService;
        this.criarProcessoService = criarProcessoService;
    }
}
