package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PessoaTest {

    @Test
    void adicionarDocumentoOficial() {
        // given
        DocumentoOficial documentoOficial = new DocumentoOficial(
                "111",
                LocalDate.now(),
                OrgaoEmissorEnum.SSP,
                TipoDocumentoOficialEnum.RG);

        Pessoa pessoa = new Pessoa.Builder()
                .nome("Bruno Carneiro")
                .dataNascimento(LocalDate.of(1987, 6, 29))
                .naturalidade(UnidadeFederativaEnum.DF)
                .nacionalidade("Brasil")
                .build();

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

        Pessoa pessoa = new Pessoa.Builder()
                .nome("Bruno Carneiro")
                .dataNascimento(LocalDate.of(1987, 6, 29))
                .naturalidade(UnidadeFederativaEnum.DF)
                .nacionalidade("Brasil")
                .build();

        // when
        pessoa.adicionarDocumentoOficial(documentoOficial);
        pessoa.removerDocumentoOficial(documentoOficial);

        // then
        assertTrue(pessoa.getDocumentosOficiais().isEmpty());
    }
}