package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.PermissaoEnum;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author bruno.carneiro (tr301605)
 */
public class Usuario extends Pessoa {
    private Long id;
    private String usuario;
    private String senha;
    private Boolean ativo;
    private Set<Permissao> permissoes;

    public Usuario(
            String nome,
            LocalDate dataNascimento,
            String naturalidade,
            String nacionalidade,
            Set<DocumentoOficial> documentosOficiais,
            Contato contato,
            Endereco endereco) {
        super(
                nome,
                dataNascimento,
                naturalidade,
                nacionalidade,
                documentosOficiais,
                contato,
                endereco);

        this.permissoes = new HashSet<>();
        this.ativo = false;
        this.permissoes.add(new Permissao(PermissaoEnum.GUEST));
    }

    public Usuario(String nome,
                   LocalDate dataNascimento,
                   String naturalidade,
                   String nacionalidade,
                   Set<DocumentoOficial> documentosOficiais,
                   Contato contato,
                   Endereco endereco,
                   String usuario,
                   String senha) {
        super(
                nome,
                dataNascimento,
                naturalidade,
                nacionalidade,
                documentosOficiais,
                contato,
                endereco);
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = false;
        this.permissoes = new HashSet<>();
        this.permissoes.add(new Permissao(PermissaoEnum.GUEST));
    }

    public Usuario(
            String nome,
            LocalDate dataNascimento,
            String naturalidade,
            String nacionalidade,
            Set<DocumentoOficial> documentosOficiais,
            Contato contato,
            Endereco endereco,
            String usuario,
            String senha,
            Boolean ativo,
            Set<Permissao> permissoes) {
        super(
                nome,
                dataNascimento,
                naturalidade,
                nacionalidade,
                documentosOficiais,
                contato,
                endereco);
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

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(id, usuario1.id) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(senha, usuario1.senha) && Objects.equals(ativo, usuario1.ativo) && Objects.equals(permissoes, usuario1.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, usuario, senha, ativo, permissoes);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", permissoes=" + permissoes +
                '}';
    }
}
