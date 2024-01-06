package trf1.jus.br.infrastructure.repository;

import br.jus.trf1.core.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import trf1.jus.br.infrastructure.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

}
