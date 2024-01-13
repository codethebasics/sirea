package br.jus.trf1.actions.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;
import br.jus.trf1.core.exception.processo.ProcessoException;
import br.jus.trf1.gateway.processo.BuscarProcessoGateway;
import br.jus.trf1.usecase.processo.BuscarProcessoUC;
import jdk.internal.joptsimple.internal.Strings;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * <b>Implementação do caso de uso Buscar Processo</b>
 * <p>Favor consultar a classe {@link BuscarProcessoUC}</p>
 *
 * @author Bruno Carneiro
 */
public class BuscarProcessoAction implements BuscarProcessoUC {

    private final BuscarProcessoGateway buscarProcessoGateway;

    public BuscarProcessoAction(BuscarProcessoGateway buscarProcessoGateway) {
        this.buscarProcessoGateway = buscarProcessoGateway;
    }

    @Override
    public Optional<Processo> buscar(Processo processo) throws ProcessoException {
        if (Objects.isNull(processo))
            throw new ProcessoException("O processo deve ser informado");

        try {
            return this.buscarProcessoGateway.buscar(processo);
        } catch (RuntimeException e) {
            throw new ProcessoException("Erro durante a pesquisa do processo", e);
        }
    }

    @Override
    public Optional<Processo> buscar(String numeroProcesso) throws ProcessoException {
        if (Strings.isNullOrEmpty(numeroProcesso))
            throw new ProcessoException("O número do processo deve ser informado");

        try {
            return this.buscarProcessoGateway.buscar(numeroProcesso);
        } catch (RuntimeException e) {
            throw new ProcessoException("Erro durante a pesquisa do processo", e);
        }
    }

    @Override
    public Set<Processo> listar() throws ProcessoException {
        try {
            return this.buscarProcessoGateway.listar();
        } catch (RuntimeException e) {
            throw new ProcessoException("Erro durante a pesquisa do processo", e);
        }
    }

    @Override
    public Set<Processo> listar(OrgaoJudiciarioEnum orgaoJudiciario) throws ProcessoException {
        try {
            return this.buscarProcessoGateway.listar(orgaoJudiciario);
        } catch (RuntimeException e) {
            throw new ProcessoException("Erro durante a pesquisa do processo", e);
        }
    }

    @Override
    public Set<Processo> listar(TribunalEnum tribunal) throws ProcessoException {
        try {
            return this.buscarProcessoGateway.listar(tribunal);
        } catch (RuntimeException e) {
            throw new ProcessoException("Erro durante a pesquisa do processo", e);
        }
    }

    @Override
    public Set<Processo> listar(OrigensTRF1Enum origem) throws ProcessoException {
        try {
            return this.buscarProcessoGateway.listar();
        } catch (RuntimeException e) {
            throw new ProcessoException("Erro durante a pesquisa do processo", e);
        }
    }
}
