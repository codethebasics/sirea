package br.jus.trf1.gateway.processo;

import br.jus.trf1.core.domain.Processo;

public interface CriarProcessoGateway {
    Processo criar(Processo processo);
}
