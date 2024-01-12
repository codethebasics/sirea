package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.exception.contato.EmailInvalidoException;
import br.jus.trf1.core.exception.contato.TelefoneInvalidoException;

import java.util.Objects;
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
        final int FIXO_LENGTH = 8;
        if (fixo.length() != FIXO_LENGTH) {
            throw new TelefoneInvalidoException();
        }
        this.fixo = fixo;
    }

    public String getMovel() {
        return movel;
    }

    public void setMovel(String movel) {
        final int MOVEL_MIN_LENGTH = 8;
        final int MOVEL_MAX_LENGTH = 9;
        if (movel.length() != MOVEL_MIN_LENGTH && movel.length() != MOVEL_MAX_LENGTH) {
            throw new TelefoneInvalidoException();
        }
        this.movel = movel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        final String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
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
}
