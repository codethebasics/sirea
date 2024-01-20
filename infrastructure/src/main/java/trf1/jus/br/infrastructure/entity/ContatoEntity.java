package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.enums.DDDEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contatos")
public class ContatoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ddd")
    private DDDEntity ddd;

    @Column(name = "fixo")
    private String fixo;

    @Column(name = "movel")
    private String movel;

    @Column(name = "email")
    private String email;

    public ContatoEntity() {

    }

    public ContatoEntity(Contato contato) {
        this.setFixo(contato.getFixo());
        this.setMovel(contato.getMovel());
        this.setEmail(contato.getEmail());
        this.setDDD(contato.getDdd());
    }

    public ContatoEntity(DDDEntity ddd, String fixo, String movel, String email) {
        this.ddd = ddd;
        this.fixo = fixo;
        this.movel = movel;
        this.email = email;
    }

    public ContatoEntity(DDDEnum ddd, String fixo, String movel, String email) {
        this.fixo = fixo;
        this.movel = movel;
        this.email = email;
        this.setDDD(ddd);
    }

    private void setDDD(DDDEnum ddd) {
        for (DDDEnum dddEnum : DDDEnum.values()) {
            if (ddd.getDdd().equals(dddEnum.getDdd())) {
                this.ddd = new DDDEntity();
                this.ddd.setDdd(dddEnum.getDdd());
                this.ddd.setRegiao(dddEnum.getUnidadeFederativaEnum().getRegiao());
            }
        }
    }
}
