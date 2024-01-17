package trf1.jus.br.infrastructure.dto.contato;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContatoDTO {
    private String ddd;
    private String fixo;
    private String movel;
    private String email;

    public ContatoDTO(String ddd, String fixo, String movel, String email) {
        this.ddd = ddd;
        this.fixo = fixo;
        this.movel = movel;
        this.email = email;
    }
}
