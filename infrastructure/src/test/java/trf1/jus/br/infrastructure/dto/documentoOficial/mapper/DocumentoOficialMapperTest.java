package trf1.jus.br.infrastructure.dto.documentoOficial.mapper;

import br.jus.trf1.core.domain.DocumentoOficial;
import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trf1.jus.br.infrastructure.dto.documentoOficial.DocumentoOficialDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoOficialMapperTest {

    @Test
    @DisplayName("Deve converter um Documento em um Documento")
    void dadoUmDocumentoOficialDTO_quandoFromDTO_entaoDeveRetornarDocumentoOficial() {
        // given
        DocumentoOficialDTO documentoOficialDTO = new DocumentoOficialDTO();
        documentoOficialDTO.setNumero("123456");
        documentoOficialDTO.setEmissao(LocalDate.now());
        documentoOficialDTO.setVencimento(LocalDate.EPOCH.plusDays(5));
        documentoOficialDTO.setOrgaoEmissor("SSP");
        documentoOficialDTO.setTipoDocumentoOficial("Cadastro de Pessoa Física");

        // when
        DocumentoOficial documentoOficial = DocumentoOficialMapper.fromDTO(documentoOficialDTO);

        // then
        assertAll("Validando documento oficial", () -> {
            assertNotNull(documentoOficial, "O documento oficial não deveria ser nulo");
            assertEquals(documentoOficialDTO.getNumero(), documentoOficial.getNumero(), "O número do documento deveria ser o mesmo");
            assertEquals(documentoOficialDTO.getEmissao(), documentoOficial.getEmissao(), "A data de emissão do documento deveria ser a mesma");
            assertEquals(documentoOficialDTO.getVencimento(), documentoOficial.getVencimento(), "A data de vencimento do documento deveria ser a mesma");
            assertEquals(documentoOficialDTO.getOrgaoEmissor(), documentoOficial.getOrgaoEmissor().getSigla());
            assertEquals(documentoOficialDTO.getTipoDocumentoOficial(), documentoOficial.getTipoDocumentoOficial().getDocumento());
        });
    }

    @Test
    @DisplayName("Deve converter um Documento em um Documento")
    void dadoUmDocumentoOficial_quandoToDTO_entaoDeveRetornarDocumentoOficialDTO() {
        // given
        DocumentoOficial documentoOficial = new DocumentoOficial();
        documentoOficial.setNumero("123456");
        documentoOficial.setEmissao(LocalDate.now());
        documentoOficial.setVencimento(LocalDate.EPOCH.plusDays(5));
        documentoOficial.setOrgaoEmissor(OrgaoEmissorEnum.SSP);
        documentoOficial.setTipoDocumentoOficial(TipoDocumentoOficialEnum.CPF);

        // when
        DocumentoOficialDTO documentoOficialDTO = DocumentoOficialMapper.toDTO(documentoOficial);

        // then
        assertAll("Validando documento oficial", () -> {
            assertNotNull(documentoOficial, "O documento oficial não deveria ser nulo");
            assertEquals(documentoOficial.getNumero(), documentoOficialDTO.getNumero(), "O número do documento deveria ser o mesmo");
            assertEquals(documentoOficial.getEmissao(), documentoOficialDTO.getEmissao(), "A data de emissão do documento deveria ser a mesma");
            assertEquals(documentoOficial.getVencimento(), documentoOficialDTO.getVencimento(), "A data de vencimento do documento deveria ser a mesma");
            assertEquals(documentoOficial.getOrgaoEmissor().getSigla().concat(" - ").concat(documentoOficial.getOrgaoEmissor().getNome()), documentoOficialDTO.getOrgaoEmissor());
            assertEquals(documentoOficial.getTipoDocumentoOficial().getDocumento(), documentoOficialDTO.getTipoDocumentoOficial());
        });
    }
}