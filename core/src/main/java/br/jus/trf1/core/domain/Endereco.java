package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import br.jus.trf1.core.exception.endereco.*;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Representa o endereço de uma {@link Pessoa}
 *
 * @author bruno.carneiro (tr301605)
 */
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private UnidadeFederativaEnum uf;

    public Endereco(String cep) {
        this.setCep(cep);
    }

    public Endereco(
            String cep,
            String logradouro,
            String bairro,
            String localidade,
            UnidadeFederativaEnum uf) {
        this.setCep(cep);
        this.setLogradouro(logradouro);
        this.setBairro(bairro);
        this.setLocalidade(localidade);
        this.setUf(uf);
    }

    public Endereco(
            String cep,
            String logradouro,
            String complemento,
            String bairro,
            String localidade,
            UnidadeFederativaEnum uf) {
        this.setCep(cep);
        this.setLogradouro(logradouro);
        this.setBairro(bairro);
        this.setLocalidade(localidade);
        this.setUf(uf);
        this.setComplemento(complemento);
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cepIsValid.negate().test(cep))
            throw new CEPInvalidoException();
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        if (logradouroIsValido.negate().test(logradouro))
            throw new LogradouroInvalidoException();
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairroIsValido.negate().test(bairro))
            throw new BairroInvalidoException();
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        if (localidadeIsValida.negate().test(localidade))
            throw new LocalidadeInvalidaException();

        this.localidade = localidade;
    }

    public UnidadeFederativaEnum getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativaEnum uf) {
        this.uf = uf;
    }

    public static Predicate<String> cepIsValid = (cep) -> Objects.nonNull(cep)
            && cep.length() == 8;

    public static Predicate<String> bairroIsValido = (bairro) -> Objects.nonNull(bairro)
            && !bairro.isBlank();

    public static Predicate<String> localidadeIsValida = (localidade) -> Objects.nonNull(localidade)
            && !localidade.isBlank();

    public static Predicate<String> logradouroIsValido = (logradouro) -> Objects.nonNull(logradouro)
            && !logradouro.isBlank();

    public static Predicate<Endereco> enderecoIsValid = (endereco) -> cepIsValid.test(endereco.getCep())
            && bairroIsValido.test(endereco.getBairro())
            && localidadeIsValida.test(endereco.getLocalidade())
            && logradouroIsValido.test(endereco.getLocalidade());

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep)
                && Objects.equals(logradouro, endereco.logradouro)
                && Objects.equals(complemento, endereco.complemento)
                && Objects.equals(bairro, endereco.bairro)
                && Objects.equals(localidade, endereco.localidade)
                && uf == endereco.uf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, complemento, bairro, localidade, uf);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf=" + uf +
                '}';
    }

    public static class Builder {
        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private UnidadeFederativaEnum uf;

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder logradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public Builder complemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder localidade(String localidade) {
            this.localidade = localidade;
            return this;
        }

        public Builder uf(UnidadeFederativaEnum uf) {
            this.uf = uf;
            return this;
        }

        public Endereco build() {

            Endereco endereco = new Endereco(
                    this.cep,
                    this.logradouro,
                    this.complemento,
                    this.localidade,
                    this.bairro,
                    this.uf);

            if (Endereco.enderecoIsValid.negate().test(endereco))
                throw new EnderecoException("O endereço informado é inválido");

            return endereco;
        }
    }
}