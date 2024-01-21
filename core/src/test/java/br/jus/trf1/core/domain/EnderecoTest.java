package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import br.jus.trf1.core.exception.endereco.BairroInvalidoException;
import br.jus.trf1.core.exception.endereco.CEPInvalidoException;
import br.jus.trf1.core.exception.endereco.LocalidadeInvalidaException;
import br.jus.trf1.core.exception.endereco.LogradouroInvalidoException;
import br.jus.trf1.core.exception.endereco.erros.EnderecoErroEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    @Test
    @DisplayName("Dado um CEP inválido, quando setar o CEP então deve lançar CEPInvalidoException")
    void dadoUmCepInvalido_quandoSetCEP_deveLancarCEPInvalidoException() {
        // given
        String cep = "000000000";

        // when / then
        Exception exception = assertThrows(CEPInvalidoException.class, () -> new Endereco(cep));
        assertEquals(EnderecoErroEnum.ENDERECO_SEM_CEP.getMensagem(), exception.getMessage(), "A mensagem de erro não coincide");
    }

    @Test
    @DisplayName("Dado um logradouro inválido, quando setar logradouro então deve lançar LogradouroException")
    void dadoUmLogradouroInvalido_quandoSetLogradouro_entaoDeveLancarLogradouroException() {
        // given / when / then
        Exception exception = assertThrows(LogradouroInvalidoException.class, () -> {
            Endereco endereco = new Endereco("00000000");
            endereco.setLocalidade("Brasilia");
            endereco.setBairro("Asa Norte");
            endereco.setUf(UnidadeFederativaEnum.DF);
            endereco.setLogradouro(null);
        });
        assertEquals(EnderecoErroEnum.ENDERECO_SEM_LOGRADOURO.getMensagem(), exception.getMessage(), "A mensagem de erro não coincide");
    }

    @Test
    @DisplayName("Dado uma localidade inválida, quando setar localidade então deve lançar LocalidadeInvalidaException")
    void dadoUmaLocalidadeInvalida_quandoSetLocalidade_entaoDeveLancarLocalidadeInvalidaException() {
        // given / when / then
        Exception exception = assertThrows(LocalidadeInvalidaException.class, () -> {
            Endereco endereco = new Endereco("00000000");
            endereco.setLocalidade("");
            endereco.setBairro("Asa Norte");
            endereco.setUf(UnidadeFederativaEnum.DF);
            endereco.setLogradouro("SQN 312 Bl K");
        });
        assertEquals(EnderecoErroEnum.ENDERECO_SEM_LOCALIDADE.getMensagem(), exception.getMessage(), "A mensagem de erro não coincide");
    }

    @Test
    @DisplayName("Dado um bairro inválido, quando setBairro então deve lançar BairroException")
    void dadoUmBairroInvalido_quandoSetBairro_entaoDeveLancarBairroException() {
        // given / when / then
        Exception exception = assertThrows(BairroInvalidoException.class, () -> {
            Endereco endereco = new Endereco("00000000");
            endereco.setLocalidade("Brasilia");
            endereco.setBairro("");
            endereco.setUf(UnidadeFederativaEnum.DF);
            endereco.setLogradouro("SQN 312 BL K");
        });
        assertEquals(EnderecoErroEnum.ENDERECO_SEM_BAIRRO.getMensagem(), exception.getMessage(), "A mensagem de erro não coincide");
    }

}