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

        pessoa.adicionarDocumentoOficial(documentoOficial);
        System.out.println(pessoa);

        assertNotNull(pessoa.getDocumentosOficiais());
    }

    @Test
    void removerDocumentoOficial() {
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

        pessoa.adicionarDocumentoOficial(documentoOficial);
        pessoa.removerDocumentoOficial(documentoOficial);

        assertTrue(pessoa.getDocumentosOficiais().isEmpty());
    }
}