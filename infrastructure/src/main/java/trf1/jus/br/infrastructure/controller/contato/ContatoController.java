package trf1.jus.br.infrastructure.controller.contato;

import br.jus.trf1.core.domain.Contato;
import br.jus.trf1.usecase.contato.CriarContatoUC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trf1.jus.br.infrastructure.controller.BaseResponse;
import trf1.jus.br.infrastructure.dto.contato.CriarContatoRequest;
import trf1.jus.br.infrastructure.dto.contato.CriarContatoResponse;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/contatos")
public class ContatoController {

    private final CriarContatoUC criarContatoUC;

    public ContatoController(CriarContatoUC criarContatoUC) {
        this.criarContatoUC = criarContatoUC;
    }

    @PostMapping
    public BaseResponse<CriarContatoResponse> criar(@RequestBody CriarContatoRequest request) {
        try {

            Contato contato = new Contato.Builder()
                    .ddd(request.getDdd())
                    .fixo(request.getFixo())
                    .movel(request.getMovel())
                    .email(request.getEmail())
                    .build();

            Contato contatoCriado = this.criarContatoUC.criar(contato);

            if (Objects.isNull(contatoCriado))
                throw new RuntimeException("Não foi possível criar o contato");

            CriarContatoResponse response = CriarContatoResponse.builder()
                    .ddd(contatoCriado.getDdd())
                    .fixo(contatoCriado.getFixo())
                    .movel(contatoCriado.getMovel())
                    .email(contatoCriado.getEmail())
                    .build();

            return BaseResponse.<CriarContatoResponse>builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Contato criado com sucesso")
                    .responseEntity(ResponseEntity.ok(response))
                    .at(LocalDateTime.now()).build();

        } catch (Exception e) {
            return BaseResponse.<CriarContatoResponse>builder()
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("Erro durante a criação do contato: " + e.getMessage())
                    .at(LocalDateTime.now())
                    .build();
        }
    }

}
