package br.jus.trf1.core.domain;

import java.util.List;

/**
 * @author bruno.carneiro (tr301605)
 */
public class Usuario extends Pessoa {
    private Long id;
    private String usuario;
    private String senha;
    private Boolean ativo;
    private List<Permissao> permissoes;

    public Usuario() {
        this.ativo = false;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = false;
    }

    public Usuario(String usuario, String senha, Boolean ativo) {
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuario(String usuario, String senha, Boolean ativo, List<Permissao> permissoes) {
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = ativo;
        this.permissoes = permissoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new RuntimeException("A senha do usuário deve ser informada");
        }
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
