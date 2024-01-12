package br.jus.trf1.actions.processo;

import br.jus.trf1.core.domain.Processo;
import br.jus.trf1.gateway.processo.CriarProcessoGateway;
import br.jus.trf1.usecase.processo.CriarProcessoUC;
import br.jus.trf1.usecase.processo.exceptions.CriarProcessoException;

import java.util.Objects;

/**
 * Implementação do caso de uso Criar Processo
 *
 * @author Bruno Carneiro
 */
public class CriarProcessoAction implements CriarProcessoUC {

    private final CriarProcessoGateway criarProcessoGateway;

    public CriarProcessoAction(CriarProcessoGateway criarProcessoGateway) {
        this.criarProcessoGateway = criarProcessoGateway;
    }

    @Override
    public Processo criar(Processo processo) throws CriarProcessoException {
        try {
            if (Objects.isNull(processo))
                throw new CriarProcessoException("O processo deve ser informado");
            return criarProcessoGateway.criar(processo);
        } catch (CriarProcessoException criarProcessoException) {
            throw new CriarProcessoException("Erro durante a criação do processo", criarProcessoException);
        }
    }
}
