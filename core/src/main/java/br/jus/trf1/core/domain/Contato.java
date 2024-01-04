package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.DDDEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bruno.carneiro (tr301605)
 */
public class Contato {
    private Long id;
    private DDDEnum ddd;
    private String fixo;
    private String movel;
    private String email;

    public Contato() {

    }

    public Contato(DDDEnum ddd, String fixo, String movel, String email) {
        this.ddd = ddd;
        this.fixo = fixo;
        this.movel = movel;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (fixo.length() == 0 || fixo.length() > 8) {
            throw new RuntimeException("O número do telefone fixo deve ter 8 dígitos");
        }
        this.fixo = fixo;
    }

    public String getMovel() {
        return movel;
    }

    public void setMovel(String movel) {
        if (movel.length() == 0 || movel.length() > 9) {
            throw new RuntimeException("O número do telefone fixo deve ter 9 dígitos");
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
            throw new RuntimeException("O email informado é inválido");
        }
        this.email = email;
    }
}
