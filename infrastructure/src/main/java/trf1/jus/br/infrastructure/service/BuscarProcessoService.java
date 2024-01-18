package trf1.jus.br.infrastructure.service;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;
import br.jus.trf1.gateway.processo.BuscarProcessoGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BuscarProcessoService implements BuscarProcessoGateway {

    @Override
    public Optional<Processo> buscar(Processo processo) {
        return Optional.empty();
    }

    @Override
    public Optional<Processo> buscar(String numeroProcesso) {
        return Optional.empty();
    }

    @Override
    public Set<Processo> listar() {
        return null;
    }

    @Override
    public Set<Processo> listar(OrgaoJudiciarioEnum orgaoJudiciario) {
        return null;
    }

    @Override
    public Set<Processo> listar(TribunalEnum tribunal) {
        return null;
    }

    @Override
    public Set<Processo> listar(OrigensTRF1Enum origem) {
        return null;
    }
}
