package trf1.jus.br.infrastructure.dto.contato;

import br.jus.trf1.core.enums.DDDEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarContatoResponse {
    private final DDDEnum ddd;
    private final String fixo;
    private final String movel;
    private final String email;
}
