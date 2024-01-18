package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.enums.OcupacaoProfissionalEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ocupacoes_profissionais")
public class OcupacaoProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Short id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ocupacao_profissional")
    private OcupacaoProfissionalEnum ocupacaoProfissional;

    @ManyToMany(mappedBy = "ocupacoesProfissionais")
    private Set<PessoaEntity> pessoas;
}
