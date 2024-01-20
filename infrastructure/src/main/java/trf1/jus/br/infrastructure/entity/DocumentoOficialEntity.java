package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.domain.DocumentoOficial;
import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "documentos_oficiais")
public class DocumentoOficialEntity extends DocumentoOficial {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PessoaEntity> getPessoa() {
        return pessoa;
    }
}
