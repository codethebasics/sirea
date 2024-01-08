package trf1.jus.br.infrastructure.service;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.gateway.pessoa.CriarPessoaGateway;
import org.springframework.stereotype.Service;
import trf1.jus.br.infrastructure.repository.PessoaRepository;


@Service
public class CriarPessoaService implements CriarPessoaGateway {

    private final PessoaRepository repository;

    public CriarPessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa criar(Pessoa pessoa) {
        try {
            System.out.println("Infrastructure::CriarPessoaService.criar");
            System.out.println(pessoa);
        } catch (Exception e) {
            System.out.println("Erro durante criação de pessoa");
            e.printStackTrace();
        }

        return null;
    }
}
