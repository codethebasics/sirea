package br.jus.trf1.core.exception.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.exception.contato.errors.ContatoErroEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneInvalidoExceptionTest {

    @Test
    void dadoUmTelefoneInvalido_quandoSetarTelefone_entaoLancaTelefoneInvalidoException() {
        // given / when / then
        Exception exception = assertThrows(TelefoneInvalidoException.class, () -> {
            new Contato.Builder()
                    .ddd(DDDEnum.DF_61)
                    .fixo("33471304")
                    .movel("9857704")
                    .email("bruno.ferreira@trf1.jus.br")
                    .build();
        });

        assertEquals(ContatoErroEnum.TELEFONE_INVALIDO.getMensagem(), exception.getMessage());
    }

}