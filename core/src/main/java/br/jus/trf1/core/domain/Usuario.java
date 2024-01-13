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

    public Usuario(String usuario, String senha) {
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setAtivo(false);
        this.adicionarPermissao(new Permissao(PermissaoEnum.CADEXT));
    }

    public Usuario(String usuario, String senha, Boolean ativo) {
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setAtivo(ativo);
        this.adicionarPermissao(new Permissao(PermissaoEnum.CADEXT));
    }

    public Usuario(String usuario, String senha, Boolean ativo, Set<Permissao> permissoes) {
        this.permissoes = permissoes;
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setAtivo(ativo);
        this.setPermissoes(permissoes);
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

    public void setUsuario(String usuario) {
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

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    private void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
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
}
