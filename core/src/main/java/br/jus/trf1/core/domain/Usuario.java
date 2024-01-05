package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.PermissaoEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Long id;
    private String usuario;
    private String senha;
    private Boolean ativo;
    private Set<Permissao> permissoes;

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
        this.setSenha(senha);
        this.ativo = false;
        this.permissoes = new HashSet<>();
        this.permissoes.add(new Permissao(PermissaoEnum.CADEXT));
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
        this.permissoes = Objects.nonNull(permissoes)
            ? permissoes
            : new HashSet<>();
    }

    public void alterarSenha(String senhaAntiga, String senhaNova) {
        if (!this.getSenha().equals(senhaAntiga)) {
            throw new RuntimeException("A senha atual informada é inválida");
        }
        this.setSenha(senhaNova);
        this.setModificacao(LocalDateTime.now());
    }

    private boolean validarSenha(String senha) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new RuntimeException("A senha do usuário deve ser informada");
        }
        if (!this.validarSenha(senha)) {
            throw new RuntimeException("A senha informada não atende aos parâmetros de segurança");
        }
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
        this.setModificacao(LocalDateTime.now());
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
        this.setModificacao(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(id, usuario1.id)
                && Objects.equals(usuario, usuario1.usuario)
                && Objects.equals(senha, usuario1.senha)
                && Objects.equals(ativo, usuario1.ativo)
                && Objects.equals(permissoes, usuario1.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                id,
                usuario,
                senha,
                ativo,
                permissoes);
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
