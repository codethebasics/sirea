package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.PermissaoEnum;
import br.jus.trf1.core.exception.InvalidPasswordException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa um usuário de sistema.
 *
 * @author bruno.carneiro (tr301605)
 */
public class Usuario extends Pessoa {
    private String usuario;
    private String senha;
    private Boolean ativo;
    private Set<Permissao> permissoes;

    private Usuario(Builder builder) {
        this.setUsuario(builder.usuario);
        this.setSenha(builder.senha);
        this.setAtivo(builder.ativo);
        this.setPermissoes(builder.permissoes);
    }

    public void alterarSenha(String senhaAntiga, String senhaNova) {
        if (!this.getSenha().equals(senhaAntiga)) {
            throw new RuntimeException("A senha atual informada é inválida");
        }
        this.setSenha(senhaNova);
    }

    private void validarSenha(String senha) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        if (!matcher.matches()) {
            throw new InvalidPasswordException("A senha informada não atende aos parâmetros de segurança");
        }
    }

    private void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new InvalidPasswordException("A senha do usuário deve ser informada");
        }
        this.validarSenha(senha);
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    private void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void ativar() {
        this.setAtivo(Boolean.TRUE);
    }

    public void desativar() {
        this.setAtivo(Boolean.FALSE);
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    private void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;

        // Caso nenhuma permissão tenha sido informada, adiciona permissão padrão
        if (Objects.isNull(this.permissoes) || this.permissoes.isEmpty()) {
            this.adicionarPermissao(new Permissao(PermissaoEnum.CADEXT));
        }
    }

    public void adicionarPermissao(Permissao permissao) {
        if (Objects.isNull(permissao))
            throw new RuntimeException("A permissão não pode ser nula");

        if (Objects.isNull(this.permissoes)) {
            this.setPermissoes(new HashSet<>());
            this.adicionarPermissao(permissao);
        }

        this.permissoes.add(permissao);
    }

    public void removerPermissao(Permissao permissao) {
        if (Objects.isNull(permissao))
            throw new RuntimeException("A permissão não pode ser nula");
        this.permissoes.remove(permissao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(usuario, usuario1.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), usuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", permissoes=" + permissoes +
                '}';
    }

    public static class Builder {
        private String usuario;
        private String senha;
        private Boolean ativo;
        private Set<Permissao> permissoes;

        public Builder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder ativo(Boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public Builder inativo() {
            this.ativo = Boolean.FALSE;
            return this;
        }

        public Builder ativo() {
            this.ativo = Boolean.TRUE;
            return this;
        }

        public Builder permissoes(Set<Permissao> permissoes) {
            this.permissoes = permissoes;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}
