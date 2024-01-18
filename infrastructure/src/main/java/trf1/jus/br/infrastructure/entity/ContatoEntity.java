package trf1.jus.br.infrastructure.entity;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ddd")
    private DDDEntity ddd;

    @Column(name = "fixo")
    private String fixo;

    @Column(name = "movel")
    private String movel;

    @Column(name = "email")
    private String email;

}
