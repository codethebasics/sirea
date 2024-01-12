package br.jus.trf1.actions.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;
import br.jus.trf1.core.exception.processo.ProcessoException;
import br.jus.trf1.usecase.processo.BuscarProcessoUC;

import java.util.Optional;
import java.util.Set;

public class BuscarProcessoAction implements BuscarProcessoUC {

    @Override
    public Optional<Processo> buscar(Processo processo) throws ProcessoException {
        return Optional.empty();
    }

    @Override
    public Optional<Processo> buscar(String numeroProcesso) throws ProcessoException {
        return Optional.empty();
    }

    @Override
    public Set<Processo> listar() throws ProcessoException {
        return null;
    }

    @Override
    public Set<Processo> listar(OrgaoJudiciarioEnum orgaoJudiciario) throws ProcessoException {
        return null;
    }

    @Override
    public Set<Processo> listar(TribunalEnum tribunal) throws ProcessoException {
        return null;
    }

    @Override
    public Set<Processo> listar(OrigensTRF1Enum origem) throws ProcessoException {
        return null;
    }
}
