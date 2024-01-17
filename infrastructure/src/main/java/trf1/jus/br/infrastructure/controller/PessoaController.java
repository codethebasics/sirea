package trf1.jus.br.infrastructure.controller;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.usecase.pessoa.BuscarPessoaUC;
import br.jus.trf1.usecase.pessoa.CriarPessoaUC;
import br.jus.trf1.usecase.pessoa.exceptions.CriarPessoaException;
import br.jus.trf1.usecase.pessoa.exceptions.PessoaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trf1.jus.br.infrastructure.dto.pessoa.PessoaDTO;
import trf1.jus.br.infrastructure.dto.pessoa.mapper.PessoaMapper;
import trf1.jus.br.infrastructure.dto.pessoa.request.CriarPessoaRequest;
import trf1.jus.br.infrastructure.dto.pessoa.response.BuscarPessoaResponse;
import trf1.jus.br.infrastructure.dto.pessoa.response.CriarPessoaResponse;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaController {

    private final CriarPessoaUC criarPessoaUC;
    private final BuscarPessoaUC buscarPessoaUC;

    public PessoaController(CriarPessoaUC criarPessoaUC, BuscarPessoaUC buscarPessoaUC) {
        this.criarPessoaUC = criarPessoaUC;
        this.buscarPessoaUC = buscarPessoaUC;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BuscarPessoaResponse> buscarPessoa(@RequestParam("email") String email) {

        BuscarPessoaResponse response;

        try {
            // Busca pessoa pelo email
            Pessoa pessoa = this.buscarPessoaUC.peloEmail(email);

            // Verifica se pessoa foi retornada
            if (Objects.isNull(pessoa))
                throw new PessoaNaoEncontradaException("Pessoa não encontrada");

            // Converte a pessoa retornada para um DTO
            PessoaDTO pessoaDTO = PessoaMapper.toDTO(pessoa);

            // Cria o response da requisição
            response = new BuscarPessoaResponse(pessoaDTO);

            // Retorna a requisição
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        // Pessoa não encontrada
        catch (PessoaNaoEncontradaException e1) {
            return ResponseEntity.notFound().build();
        }
        // Erro desconhecido
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CriarPessoaResponse> criarPessoa(@RequestBody CriarPessoaRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CriarPessoaResponse(null, "Pessoa cadastrada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new CriarPessoaResponse(null, "Erro durante cadastro"));
        }
    }

}
