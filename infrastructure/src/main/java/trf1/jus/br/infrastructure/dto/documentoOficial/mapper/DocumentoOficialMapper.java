package trf1.jus.br.infrastructure.dto.documentoOficial.mapper;

import br.jus.trf1.core.domain.DocumentoOficial;
import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import trf1.jus.br.infrastructure.dto.documentoOficial.DocumentoOficialDTO;

public class DocumentoOficialMapper {

    public static DocumentoOficial fromDTO(DocumentoOficialDTO documentoOficialDTO) {

        DocumentoOficial documentoOficial = new DocumentoOficial();

        // Extraindo tipo de documento
        for (TipoDocumentoOficialEnum tipoDocumentoOficial : TipoDocumentoOficialEnum.values()) {
            if (tipoDocumentoOficial.getDocumento().equals(documentoOficialDTO.getTipoDocumentoOficial()))
                documentoOficial.setTipoDocumentoOficial(tipoDocumentoOficial);
        }

        // Extraindo órgão emissor
        for (OrgaoEmissorEnum orgaoEmissor : OrgaoEmissorEnum.values()) {
            if (orgaoEmissor.getSigla().equals(documentoOficialDTO.getOrgaoEmissor()))
                documentoOficial.setOrgaoEmissor(orgaoEmissor);
        }

        // Setando o restante dos atributos
        documentoOficial.setNumero(documentoOficialDTO.getNumero());
        documentoOficial.setEmissao(documentoOficialDTO.getEmissao());
        documentoOficial.setVencimento(documentoOficialDTO.getVencimento());

        return documentoOficial;
    }

    public static DocumentoOficialDTO toDTO(DocumentoOficial documentoOficial) {
        return new DocumentoOficialDTO(documentoOficial);
    }
}
