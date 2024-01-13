package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.PermissaoEnum;
import org.junit.jupiter.api.DisplayName;
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
        Usuario usuario = new Usuario("bruno.carneiro", "Abcd1234#!@");

        String senhaAntiga = "Abcd1234#!@";
        String senhaNova = "Abcd1234#!@&";

        // when
        usuario.alterarSenha(senhaAntiga, senhaNova);

        // then
        assertEquals(senhaNova, usuario.getSenha());
    }

    @Test
    @DisplayName("Dado um usuário e uma permissão, quando adicionar permissão ao usuário então espera que a permissão seja adicionada")
    public void deveAdicionarPermissao() {
        // given
        Usuario usuario = new Usuario("bruno.carneiro", "Abcd123!@#");

        Permissao cadext = new Permissao(PermissaoEnum.CADEXT);
        Permissao adm = new Permissao(PermissaoEnum.ADMTRF1);

        // when
        usuario.adicionarPermissao(cadext);
        usuario.adicionarPermissao(adm);

        // then
        assertAll("Verificando permissões adicionadas", () -> {
            assertTrue(usuario.getPermissoes().stream().anyMatch(p -> p.getPermissao().equals(PermissaoEnum.CADEXT)));
            assertTrue(usuario.getPermissoes().stream().anyMatch(p -> p.getPermissao().equals(PermissaoEnum.ADMTRF1)));
        });
    }

    @Test
    @DisplayName("Dado um usuário e uma permissão, quando remover permissão do usuário então espera que a permissão seja removida")
    public void deveRemoverPermissao() {
        // given
        Usuario usuario = new Usuario("bruno.carneiro", "Abcd123!@#");

        Permissao cadext = new Permissao(PermissaoEnum.CADEXT);
        Permissao adm = new Permissao(PermissaoEnum.ADMTRF1);

        // when / then
        assertAll("Verificando permissões adicionadas", () -> {
            usuario.adicionarPermissao(cadext);
            usuario.adicionarPermissao(adm);

            assertTrue(usuario.getPermissoes().stream().anyMatch(p -> p.getPermissao().equals(PermissaoEnum.CADEXT)));
            assertTrue(usuario.getPermissoes().stream().anyMatch(p -> p.getPermissao().equals(PermissaoEnum.ADMTRF1)));

            usuario.removerPermissao(cadext);
            usuario.removerPermissao(adm);

            assertTrue(usuario.getPermissoes().isEmpty(), "Espera-se que a lista esteja vazia");
        });
    }

    @Test
    void deveCriarUsuarioComPermissaoPadrao() {
        // given
        Usuario usuario = new Usuario("bruno.carneiro", "Abcd123!@#", true);

        // when / then
        assertAll("Verificando permissões adicionadas", () -> {
            assertTrue(usuario.getPermissoes().stream().anyMatch(p -> p.getPermissao().equals(PermissaoEnum.CADEXT)));
        });
    }
}