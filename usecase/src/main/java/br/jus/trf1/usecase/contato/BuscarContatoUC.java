package br.jus.trf1.usecase.contato;

import br.jus.trf1.core.domain.Contato;

import java.util.List;

public interface BuscarContatoUC {

    List<Contato> peloDDD(String ddd);

    Contato peloFixo(String fixo);

    Contato peloMovel(String movel);

    Contato peloEmail(String email);
}
