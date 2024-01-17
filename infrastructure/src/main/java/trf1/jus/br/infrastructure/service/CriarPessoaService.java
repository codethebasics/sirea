package trf1.jus.br.infrastructure.service;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.gateway.pessoa.BuscarPessoaGateway;
import br.jus.trf1.gateway.pessoa.CriarPessoaGateway;
import org.springframework.stereotype.Service;
import trf1.jus.br.infrastructure.repository.PessoaRepository;


@Service
public class CriarPessoaService implements CriarPessoaGateway {

    private final PessoaRepository repository;
    private final BuscarPessoaGateway buscarPessoaGateway;

    public CriarPessoaService(PessoaRepository repository, BuscarPessoaGateway buscarPessoaGateway) {
        this.repository = repository;
        this.buscarPessoaGateway = buscarPessoaGateway;
    }

    @Override
    public Pessoa criar(Pessoa pessoa) {
        try {
            this.buscarPessoaGateway.peloEmail(pessoa.getContato().getEmail());
            System.out.println("Infrastructure::CriarPessoaService.criar");
            System.out.println(pessoa);
            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException("Erro durante cadastro de pessoa");
        }
    }
}
