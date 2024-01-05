package br.jus.trf1.core.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bruno.carneiro (tr301605)
 */
class UsuarioTest {

    @Test
    void alterarSenha() {
        // given
        Usuario usuario = new Usuario(
                "Bruno Carneiro",
                LocalDate.of(1987, 6, 29),
                "Brasília",
                "Brasil",
                new HashSet<>(),
                null,
                null,
                "bruno.carneiro",
                "Abcd1234#!@");

        String senhaAntiga = "Abcd1234#!@";
        String senhaNova = "Abcd1234#!@&";

        // when
        usuario.alterarSenha(senhaAntiga, senhaNova);

        // then
        assertEquals(senhaNova, usuario.getSenha());
    }
}