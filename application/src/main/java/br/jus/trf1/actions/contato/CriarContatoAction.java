package br.jus.trf1.actions.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.exception.contato.EmailInvalidoException;
import br.jus.trf1.core.exception.contato.TelefoneInvalidoException;
import br.jus.trf1.gateway.contato.CriarContatoGateway;
import br.jus.trf1.usecase.contato.BuscarContatoUC;
import br.jus.trf1.usecase.contato.CriarContatoUC;

import java.util.Objects;

/**
 * <b>Caso de uso Criar Contat</b>
 * <ul>
 *     <li>Dado um contato válido</li>
 *     <li>Quando criar contato</li>
 *     <li>Então deve retornar contato criado</li>
 * </ul>
 *
 * @author Bruno Carneiro
 */
public class CriarContatoAction implements CriarContatoUC {

    private final CriarContatoGateway criarContatoGateway;
    private final BuscarContatoUC buscarContatoUC;

    public CriarContatoAction(CriarContatoGateway criarContatoGateway, BuscarContatoUC buscarContatoUC) {
        this.criarContatoGateway = criarContatoGateway;
        this.buscarContatoUC = buscarContatoUC;
    }

    @Override
    public Contato criar(Contato contato) {
        try {

            if (Objects.isNull(contato))
                throw new RuntimeException("O contato deve ser informado");

            if (Objects.isNull(contato.getDdd()))
                throw new RuntimeException("O DDD deve ser informado");

            if (Objects.isNull(contato.getEmail()))
                throw new RuntimeException("O Email deve ser informado");

            if (!Objects.isNull(this.buscarContatoUC.buscarPeloEmail(contato.getEmail())))
                throw new RuntimeException("O contato informado já existe");

            return criarContatoGateway.criar(contato);

        }
        catch (EmailInvalidoException emailInvalidoException) {
            throw new RuntimeException("O e-mail informado é inválido", emailInvalidoException);
        }
        catch (TelefoneInvalidoException telefoneInvalidoException) {
            throw new RuntimeException("O telefone informado é inválido", telefoneInvalidoException);
        }
    }
}
