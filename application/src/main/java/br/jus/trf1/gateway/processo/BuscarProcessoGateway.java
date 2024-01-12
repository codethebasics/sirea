package br.jus.trf1.gateway.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;

import java.util.Optional;
import java.util.Set;

public interface BuscarProcessoGateway {

    Optional<Processo> buscar(Processo processo);
    Optional<Processo> busscar(String numeroProcesso);
    Set<Processo> listar();
    Set<Processo> listar(OrgaoJudiciarioEnum orgaoJudiciario);
    Set<Processo> listar(TribunalEnum tribunal);
    Set<Processo> listar(OrigensTRF1Enum origem);
}
