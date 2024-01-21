package trf1.jus.br.infrastructure.service.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.gateway.contato.BuscarContatoGateway;
import br.jus.trf1.gateway.contato.CriarContatoGateway;
import org.springframework.stereotype.Service;
import trf1.jus.br.infrastructure.entity.ContatoEntity;
import trf1.jus.br.infrastructure.repository.contato.ContatoRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class ContatoService implements CriarContatoGateway, BuscarContatoGateway {

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

    @Override
    public Set<Contato> listarPeloDDD(DDDEnum ddd) {
        return null;
    }

    @Override
    public Contato buscarPeloEmail(String email) {

        ContatoEntity contatoPesquisado = this.repository.findByEmail(email);

        if (!Objects.isNull(contatoPesquisado))
            return new Contato.Builder()
                    .ddd(DDDEnum.DF_61) // TODO: converter DDD
                    .fixo(contatoPesquisado.getFixo())
                    .movel(contatoPesquisado.getMovel())
                    .email(contatoPesquisado.getEmail())
                    .build();

        return null;
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
