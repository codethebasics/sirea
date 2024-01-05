package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.UnidadeFederativaEnum;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author bruno.carneiro (tr301605)
 */
public class Endereco {
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private UnidadeFederativaEnum uf;

    public Endereco(String cep) {
        this.cep = cep;
    }

    public Endereco(
            String cep,
            String logradouro,
            String bairro,
            String localidade,
            UnidadeFederativaEnum uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Endereco(
            String cep,
            String logradouro,
            String complemento,
            String bairro,
            String localidade,
            UnidadeFederativaEnum uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(complemento, endereco.complemento) && Objects.equals(bairro, endereco.bairro) && Objects.equals(localidade, endereco.localidade) && uf == endereco.uf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, logradouro, complemento, bairro, localidade, uf);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf=" + uf +
                '}';
    }
}