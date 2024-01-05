package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void adicionarDocumentoOficial() {
        // given
        DocumentoOficial documentoOficial = new DocumentoOficial(
                "111",
                LocalDate.now(),
                OrgaoEmissorEnum.SSP,
                TipoDocumentoOficialEnum.RG);

        Pessoa pessoa = new Pessoa(
                "Bruno Carneiro",
                LocalDate.of(1987, 6, 29),
                "Brasília",
                "Brasil",
                new HashSet<>(),
                null,
                null);

        // when
        pessoa.adicionarDocumentoOficial(documentoOficial);

        // then
        assertNotNull(pessoa.getDocumentosOficiais());
    }

    @Test
    void removerDocumentoOficial() {
        // given
        DocumentoOficial documentoOficial = new DocumentoOficial(
                "111",
                LocalDate.now(),
                OrgaoEmissorEnum.SSP,
                TipoDocumentoOficialEnum.RG);

        Pessoa pessoa = new Pessoa(
                "Bruno Carneiro",
                LocalDate.of(1987, 6, 29),
                "Brasília",
                "Brasil",
                new HashSet<>(),
                null,
                null);

        // when
        pessoa.adicionarDocumentoOficial(documentoOficial);
        pessoa.removerDocumentoOficial(documentoOficial);

        // then
        assertTrue(pessoa.getDocumentosOficiais().isEmpty());
    }
}