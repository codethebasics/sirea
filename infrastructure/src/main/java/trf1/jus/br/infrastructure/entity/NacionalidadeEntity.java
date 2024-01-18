package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.PaisesEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "nacionalidades")
public class NacionalidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Short id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nacionalidade")
    private PaisesEnum nacionalidade;

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<PessoaEntity> pessoas;
}
