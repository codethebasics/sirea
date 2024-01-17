package trf1.jus.br.infrastructure.dto.contato.mapper;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trf1.jus.br.infrastructure.dto.contato.ContatoDTO;

import static org.junit.jupiter.api.Assertions.*;

class ContatoMapperTest {

    @Test
    @DisplayName("Deve converter um ContatoDTO em um Contato")
    void dadoUmContatoDTO_quandoFromDTO_entaoDeveRetornarContato() {
        // given
        ContatoDTO contatoDTO = new ContatoDTO(
                DDDEnum.DF_61.getDdd(),
                "33471304",
                "985770401",
                "bruno.carneiro312@gmail.com");

        // when
        Contato contato = ContatoMapper.fromDTO(contatoDTO);

        // then
        assertAll("Validando contato", () -> {
            assertNotNull(contato, "O contato não deveria ser nulo");
            assertEquals(contatoDTO.getDdd(), contato.getDdd().getDdd());
            assertEquals(contatoDTO.getFixo(), contato.getFixo());
            assertEquals(contatoDTO.getMovel(), contato.getMovel());
            assertEquals(contatoDTO.getEmail(), contato.getEmail());
        });
    }

    @Test
    @DisplayName("Deve converter um Contato em um ContatoDTO")
    void dadoUmContatoDTO_quandoToDTO_entaoDeveRetornarUmContatoDTO() {
        // given
        Contato contato = new Contato();
        contato.setDdd(DDDEnum.DF_61);
        contato.setFixo("33471304");
        contato.setMovel("985770401");
        contato.setEmail("bruno.carneiro312@gmail.com");

        // when
        ContatoDTO contatoDTO = ContatoMapper.toDTO(contato);

        // then
        assertAll("Validado contatoDTO", () -> {
            assertNotNull(contatoDTO, "O contatoDTO não deveria ser nulo");
            assertEquals(contato.getDdd().getDdd(), contatoDTO.getDdd());
            assertEquals(contato.getFixo(), contatoDTO.getFixo());
            assertEquals(contato.getMovel(), contatoDTO.getMovel());
            assertEquals(contato.getEmail(), contatoDTO.getEmail());
        });
    }
}