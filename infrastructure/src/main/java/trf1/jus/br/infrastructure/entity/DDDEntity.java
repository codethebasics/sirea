package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.DDDEnum;
import br.jus.trf1.core.enums.RegiaoEnum;
import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ddd")
public class DDDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "ddd")
    private String ddd;

    @Enumerated(EnumType.STRING)
    @Column(name = "regiao")
    private RegiaoEnum regiao;

    @OneToMany(mappedBy = "ddd")
    private Set<ContatoEntity> contatos;
}
