package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.exception.contato.EmailInvalidoException;
import br.jus.trf1.core.exception.contato.TelefoneInvalidoException;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa os contatos de uma {@link Pessoa}
 *
 * @author bruno.carneiro (tr301605)
 */
public class Contato {
    private DDDEnum ddd;
    private String fixo;
    private String movel;
    private String email;

    public Contato() {

    }

    public Contato(DDDEnum ddd, String fixo, String movel, String email) {
        this.setDdd(ddd);
        this.setFixo(fixo);
        this.setMovel(movel);
        this.setEmail(email);
    }

    public DDDEnum getDdd() {
        return ddd;
    }

    public void setDdd(DDDEnum ddd) {
        this.ddd = ddd;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        if (!this.fixoIsValid.test(fixo)) {
            throw new TelefoneInvalidoException();
        }
        this.fixo = fixo;
    }

    public String getMovel() {
        return movel;
    }

    public void setMovel(String movel) {
        if (!this.movelIsValid.test(movel)) {
            throw new TelefoneInvalidoException();
        }
        this.movel = movel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!this.emailIsValid.test(email)) {
            throw new EmailInvalidoException();
        }
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return ddd == contato.ddd && Objects.equals(movel, contato.movel) && Objects.equals(email, contato.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, movel, email);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "ddd=" + ddd +
                ", fixo='" + fixo + '\'' +
                ", movel='" + movel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Predicate<String> movelIsValid = (movel) -> !Objects.isNull(movel)
        && Boolean.logicalOr(movel.length() == 8, movel.length() == 9);

    public Predicate<String> fixoIsValid = (fixo) -> !Objects.isNull(fixo)
        && fixo.length() == 8;

    public Predicate<String> emailIsValid = (email) -> {
        final String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    };

    public Predicate<Contato> isValid = contato ->
            fixoIsValid.test(contato.getFixo())
                    && movelIsValid.test(contato.getFixo())
                    && emailIsValid.test(contato.getEmail());

    public static class Builder {
        private DDDEnum ddd;
        private String fixo;
        private String movel;
        private String email;

        public Builder ddd(DDDEnum ddd) {
            this.ddd = ddd;
            return this;
        }

        public Builder fixo(String fixo) {
            this.fixo = fixo;
            return this;
        }

        public Builder movel(String movel) {
            this.movel = movel;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Contato build() {
            return new Contato(this.ddd, this.fixo, this.movel, this.email);
        }
    }
}
