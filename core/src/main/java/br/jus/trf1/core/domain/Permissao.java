package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.PermissaoEnum;

/**
 * @author bruno.carneiro (tr301605)
 */
public class Permissao {
    private Integer id;
    private PermissaoEnum permissao;

    public Permissao(PermissaoEnum permissao) {
        this.permissao = permissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PermissaoEnum getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoEnum permissao) {
        this.permissao = permissao;
    }
}
