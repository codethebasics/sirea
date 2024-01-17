package trf1.jus.br.infrastructure.dto.contato.mapper;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import trf1.jus.br.infrastructure.dto.contato.ContatoDTO;

public class ContatoMapper {

    public static Contato fromDTO(ContatoDTO contatoDTO) {

        Contato contato = new Contato();

        // Obtendo DDDs
        DDDEnum[] ddds = DDDEnum.values();

        // Extraindo DDD do contato
        for (DDDEnum ddd : ddds) {
            if (ddd.getDdd().equals(contatoDTO.getDdd()))
                contato.setDdd(ddd);
        }

        // Setando o restante dos atributos
        contato.setFixo(contatoDTO.getFixo());
        contato.setMovel(contatoDTO.getMovel());
        contato.setEmail(contatoDTO.getEmail());

        return contato;
    }

    public static ContatoDTO toDTO(Contato contato) {
        return new ContatoDTO(
                contato.getDdd().getDdd(),
                contato.getFixo(),
                contato.getMovel(),
                contato.getEmail());
    }
}
