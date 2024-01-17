package trf1.jus.br.infrastructure.dto.pessoa;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.core.enums.PaisesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trf1.jus.br.infrastructure.dto.contato.ContatoDTO;
import trf1.jus.br.infrastructure.dto.contato.mapper.ContatoMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private String nome;
    private String nomeSocial;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private String genero;
    private String ocupacaoProfissional;
    private String naturalidade;
    private ContatoDTO contato;
    private Set<String> nacionalidades;
    private Set<String> documentosOficiais;
    private Boolean ativo;
    private LocalDateTime criacao;
    private LocalDateTime modificacao;

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.nomeSocial = pessoa.getNomeSocial();
        this.dataNascimento = pessoa.getDataNascimento();
        this.dataFalecimento = pessoa.getDataFalecimento();
        this.genero = pessoa.getGenero().getDescricao();
        this.ocupacaoProfissional = pessoa.getOcupacaoProfissional().getDescricao();
        this.naturalidade = pessoa.getNaturalidade().getNome();
        this.nacionalidades = pessoa.getNacionalidades().stream().map(PaisesEnum::getNome).collect(Collectors.toSet());
        this.contato = ContatoMapper.toDTO(pessoa.getContato());
        this.criacao = LocalDateTime.now();
        this.modificacao = LocalDateTime.now();
    }
}
