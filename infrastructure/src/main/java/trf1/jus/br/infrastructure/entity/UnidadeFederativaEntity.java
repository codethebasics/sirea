package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "unidades_federativas")
public class UnidadeFederativaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Short id;

    @Enumerated(EnumType.STRING)
    @Column(name = "unidade_federativa")
    private UnidadeFederativaEnum unidadeFederativa;

    @OneToMany(mappedBy = "unidadeFederativa")
    private Set<PessoaEntity> pessoas;

}
