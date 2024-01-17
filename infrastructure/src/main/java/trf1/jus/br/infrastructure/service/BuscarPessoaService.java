package trf1.jus.br.infrastructure.service;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.core.domain.Endereco;
import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.core.enums.GeneroEnum;
import br.jus.trf1.core.enums.OcupacaoProfissionalEnum;
import br.jus.trf1.core.enums.PaisesEnum;
import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import br.jus.trf1.gateway.pessoa.BuscarPessoaGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BuscarPessoaService implements BuscarPessoaGateway {

    @Override
    public Pessoa peloId(Long id) {
        return null;
    }

    @Override
    public List<Pessoa> peloNome(String nome) {
        return null;
    }

    @Override
    public Pessoa peloEmail(String email) {
        Set<PaisesEnum> nacionalidades = new HashSet<>();
        nacionalidades.add(PaisesEnum.BRASIL);
        nacionalidades.add(PaisesEnum.ISRAEL);

        return new Pessoa.Builder()
                .nome("Bruno Carneiro")
                .dataNascimento(LocalDate.of(1987, Month.JULY, 29))
                .nacionalidades(nacionalidades)
                .naturalidade(UnidadeFederativaEnum.DF)
                .genero(GeneroEnum.MASCULINO)
                .ocupacaoProfissional(OcupacaoProfissionalEnum.SERVIDOR_CARREIRAS_PODER_JUDICIARIO)
                .contato(new Contato.Builder()
                        .fixo("33471304")
                        .movel("985770401")
                        .email("bruno.carneiro312@gmail.com")
                        .build())
                .endereco(new Endereco(
                        "70765110",
                        "SQN 312 BL K",
                        "ASA NORTE",
                        "BRASÍLIA",
                        UnidadeFederativaEnum.DF))
                .build();
    }
}
