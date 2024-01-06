package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;
import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import br.jus.trf1.core.exception.InvalidEmailException;
import br.jus.trf1.core.exception.InvalidPasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * @author bruno.carneiro (tr301605)
 */
class ContatoTest {

    @Test
    @DisplayName("Dado um email inválido, quando setar o email então lança exception")
    void givenInvalidEmail_whenSetEmail_thenThrowsRuntimeException() {
        // given
        String emailInvalido = "fulano@detal";
        Contato contato = new Contato();

        // when / then
        assertThrows(InvalidEmailException.class, () -> {
            contato.setEmail(emailInvalido);
        }, "Um email inválido não deveria ser cadastrado");
    }

    @Test
    @DisplayName("Dado um email válido, quando setar o email, então espera que o email seja setado")
    void givenValidEmail_whenSetEmail_thenExpectEmailToBeSet() {
        // given
        String emailValido = "fulano@trf1.jus.br";
        Contato contato = new Contato();

        // when
        contato.setEmail(emailValido);

        // then
        assertEquals("fulano@trf1.jus.br", emailValido);
    }

    @Test
    void teste() {
        Contato contato = new Contato(
                DDDEnum.DF_61,
                "33471304",
                "985770401",
                "bruno.ferreira@trf1.jus.br");

        Endereco endereco = new Endereco(
                "70765110",
                "SQN 312 Bloco K",
                "Asa Norte",
                "Brasília",
                UnidadeFederativaEnum.DF);

        DocumentoOficial documentoOficial = new DocumentoOficial(
                "111",
                LocalDate.now(),
                OrgaoEmissorEnum.SSP,
                TipoDocumentoOficialEnum.RG);

        Set<DocumentoOficial> documentos = new HashSet<>();
        documentos.add(documentoOficial);

        Pessoa pessoa = new Pessoa(
                "Bruno Carneiro",
                LocalDate.of(1987, 6, 29),
                "Brasília",
                "Brasil",
                documentos,
                contato,
                endereco);

        System.out.println(pessoa);
    }
}