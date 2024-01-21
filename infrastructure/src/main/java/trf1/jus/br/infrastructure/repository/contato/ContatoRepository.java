package trf1.jus.br.infrastructure.repository.contato;

import org.springframework.data.jpa.repository.JpaRepository;
import trf1.jus.br.infrastructure.entity.ContatoEntity;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
    ContatoEntity findByEmail(String email);
}
