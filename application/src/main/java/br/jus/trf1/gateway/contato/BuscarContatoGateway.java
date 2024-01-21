package br.jus.trf1.gateway.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;

import java.util.List;
import java.util.Set;

public interface BuscarContatoGateway {

    Set<Contato> listarPeloDDD(DDDEnum ddd);

    Contato buscarPeloEmail(String email);

    Set<Contato> listarPorParteDoNome(String nome);

    Contato buscarPeloTelefoneFixo(String fixo);

    List<Contato> listarPorParteDoTelefoneFixo(String fixo);

    Contato buscarPeloTelefoneMovel(String movel);

    List<Contato> listarPorParteDoTelefoneMovel(String movel);
}
