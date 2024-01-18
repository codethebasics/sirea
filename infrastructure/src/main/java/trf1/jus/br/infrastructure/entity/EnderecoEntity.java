package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class EnderecoEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "localidade")
    private String localidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "uf")
    private UnidadeFederativaEnum uf;

    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;

}
