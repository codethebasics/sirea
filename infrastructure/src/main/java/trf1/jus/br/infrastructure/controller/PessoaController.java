package trf1.jus.br.infrastructure.controller;

import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaController {

    private final CriarPessoaUC criarPessoaUC;

    public PessoaController(CriarPessoaUC criarPessoaUC) {
        this.criarPessoaUC = criarPessoaUC;
    }

    public ResponseEntity<String> criarPessoa(@RequestBody String pessoa) {
        this.criarPessoaUC.criar(null);
        return ResponseEntity.ok("Pessoa criada com sucesso");
    }
}
