package trf1.jus.br.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="processos")
public class ProcessoEntity {
    @Id
    private Long id;
}
