package trf1.jus.br.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trf1.jus.br.infrastructure.entity.ProcessoEntity;

public interface ProcessoRepository extends JpaRepository<ProcessoEntity, Long> {

}
