package trf1.jus.br.infrastructure.service.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.gateway.contato.CriarContatoGateway;
import org.springframework.stereotype.Service;
import trf1.jus.br.infrastructure.entity.ContatoEntity;
import trf1.jus.br.infrastructure.repository.contato.ContatoRepository;

@Service
public class ContatoService implements CriarContatoGateway {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contato criar(Contato contato) {
        try {
            ContatoEntity contatoEntity = new ContatoEntity(contato);
            this.repository.save(contatoEntity);
            return contato;
        } catch (Exception e) {
            throw new RuntimeException("Erro durante a criação do contato", e);
        }
    }

}
