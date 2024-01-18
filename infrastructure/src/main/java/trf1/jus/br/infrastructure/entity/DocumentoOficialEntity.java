package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "documentos_oficiais")
public class DocumentoOficialEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "emissao")
    @Temporal(TemporalType.DATE)
    private LocalDate emissao;

    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private LocalDate vencimento;

    @Column(name = "orgao_emissor")
    @Enumerated(EnumType.STRING)
    private OrgaoEmissorEnum orgaoEmissor;

    @Column(name = "tipo_documento_oficial")
    @Enumerated(EnumType.STRING)
    private TipoDocumentoOficialEnum tipoDocumentoOficial;

    @ManyToMany(mappedBy = "documentosOficiais")
    private Set<PessoaEntity> pessoa;
}
