package br.jus.trf1.actions.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.gateway.contato.BuscarContatoGateway;
import br.jus.trf1.usecase.contato.BuscarContatoUC;

import java.util.List;
import java.util.Set;

public class BuscarContatoAction implements BuscarContatoUC {

    private final BuscarContatoGateway buscarContatoGateway;

    public BuscarContatoAction(BuscarContatoGateway buscarContatoGateway) {
        this.buscarContatoGateway = buscarContatoGateway;
    }

    @Override
    public Set<Contato> listarPeloDDD(DDDEnum ddd) {
        return null;
    }

    @Override
    public Contato buscarPeloEmail(String email) {
        return this.buscarContatoGateway.buscarPeloEmail(email);
    }

    @Override
    public Set<Contato> listarPorParteDoNome(String nome) {
        return null;
    }

    @Override
    public Contato buscarPeloTelefoneFixo(String fixo) {
        return null;
    }

    @Override
    public List<Contato> listarPorParteDoTelefoneFixo(String fixo) {
        return null;
    }

    @Override
    public Contato buscarPeloTelefoneMovel(String movel) {
        return null;
    }

    @Override
    public List<Contato> listarPorParteDoTelefoneMovel(String movel) {
        return null;
    }
}
