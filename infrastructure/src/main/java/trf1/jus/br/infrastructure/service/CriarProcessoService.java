package trf1.jus.br.infrastructure.service;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.gateway.processo.CriarProcessoGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarProcessoService implements CriarProcessoGateway {

    @Override
    public Processo criar(Processo processo) {
        return null;
    }
}