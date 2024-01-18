package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.OrgaoJudiciarioEnum;
import br.jus.trf1.core.enums.OrigensTRF1Enum;
import br.jus.trf1.core.enums.TribunalEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="processos")
public class ProcessoEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_sequencial")
    private String numeroSequencial;

    @Column(name = "digito_verificador")
    private String digitoVerificador;

    @Column(name = "ano_de_ajuizamento")
    private String anoDeAjuizamento;

    @Column(name = "orgao_do_poder_judiciario")
    @Enumerated(EnumType.STRING)
    private OrgaoJudiciarioEnum orgaoDoPoderJudiciario;

    @Column(name = "tribunal")
    @Enumerated(EnumType.STRING)
    private TribunalEnum tribunal;

    @Column(name = "origem_trf1")
    @Enumerated(EnumType.STRING)
    private OrigensTRF1Enum origensTRF1;

    @Column(name = "numero_processo")
    private String numeroProcesso;

}
