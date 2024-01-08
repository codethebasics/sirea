package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoOficialTest {

    /**
     * - Dado dois documentos com o mesmo número, validade, órgão emissor e tipo de documento
     * - Quando verificar se os documentos são iguais
     * - Então retorna verdadeiro
     */
    @Test
    void equalsTest() {
        // fixture
        LocalDate validade = LocalDate.now();

        // given
        DocumentoOficial rg1 = new DocumentoOficial(
                "1111111",
                validade,
                OrgaoEmissorEnum.SSP,
                TipoDocumentoOficialEnum.RG);

        DocumentoOficial rg2 = new DocumentoOficial(
                "1111111",
                validade,
                OrgaoEmissorEnum.SSP,
                TipoDocumentoOficialEnum.RG);

        // when / then
        assertEquals(rg1, rg2, "Espera-se que os documentos sejam iguais");
    }
}