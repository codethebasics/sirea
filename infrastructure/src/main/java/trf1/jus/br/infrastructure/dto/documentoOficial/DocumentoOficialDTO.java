package trf1.jus.br.infrastructure.dto.documentoOficial;

import br.jus.trf1.core.domain.DocumentoOficial;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DocumentoOficialDTO {
    private String numero;
    private LocalDate emissao;
    private LocalDate vencimento;
    private String orgaoEmissor;
    private String tipoDocumentoOficial;

    public DocumentoOficialDTO() {

    }

    public DocumentoOficialDTO(DocumentoOficial documentoOficial) {
        this.numero = documentoOficial.getNumero();
        this.emissao = documentoOficial.getEmissao();
        this.vencimento = documentoOficial.getVencimento();
        this.orgaoEmissor = this.formatarOrgaoEmissor(documentoOficial);
        this.tipoDocumentoOficial = documentoOficial.getTipoDocumentoOficial().getDocumento();
    }

    private String formatarOrgaoEmissor(DocumentoOficial documentoOficial) {
        return documentoOficial.getOrgaoEmissor().getSigla()
                .concat(" - ")
                .concat(documentoOficial.getOrgaoEmissor().getNome());
    }
}
