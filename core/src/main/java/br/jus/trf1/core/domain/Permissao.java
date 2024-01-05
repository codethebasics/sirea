package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.PermissaoEnum;

import java.util.Objects;

/**
 * Representa a permissão de um {@link Usuario} do sistema
 *
 * @author bruno.carneiro (tr301605)
 */
public class Permissao {
    private Integer id;
    private PermissaoEnum permissao;

    public Permissao(PermissaoEnum permissao) {
        this.permissao = permissao;
    }

    public Permissao(Integer id, PermissaoEnum permissao) {
        this.id = id;
        this.permissao = permissao;
    }

    public Integer getId() {
        return id;
    }

    public PermissaoEnum getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoEnum permissao) {
        this.permissao = permissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permissao permissao1 = (Permissao) o;
        return Objects.equals(id, permissao1.id) && permissao == permissao1.permissao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, permissao);
    }

    @Override
    public String toString() {
        return "Permissao{" +
                "id=" + id +
                ", permissao=" + permissao +
                '}';
    }
}
