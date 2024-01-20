package trf1.jus.br.infrastructure.entity;

import br.jus.trf1.core.domain.Pessoa;
import br.jus.trf1.core.enums.GeneroEnum;
import br.jus.trf1.core.enums.OcupacaoProfissionalEnum;
import br.jus.trf1.core.enums.PaisesEnum;
import br.jus.trf1.core.enums.UnidadeFederativaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class PessoaEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_social")
    private String nomeSocial;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_falecimento")
    private LocalDate dataFalecimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private GeneroEnum genero;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "criacao")
    private LocalDateTime criacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modificacao")
    private LocalDateTime modificacao;

    @ManyToMany
    @JoinTable(
            name = "pessoas_ocupacoes_profissionais",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "ocupacao_profissional_id"))
    private Set<OcupacaoProfissionalEntity> ocupacoesProfissionais;

    @ManyToOne
    @JoinTable(
            name = "pessoas_naturalidades",
            joinColumns = @JoinColumn(name = "unidade_federativa_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
    private UnidadeFederativaEntity unidadeFederativa;

    @ManyToMany
    @JoinTable(
            name = "pessoas_nacionalidades",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "nacionalidade_id"))
    private Set<NacionalidadeEntity> nacionalidades;

    @ManyToMany
    @JoinTable(
            name = "pessoas_documentos_oficiais",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "documento_oficial_id"))
    private Set<DocumentoOficialEntity> documentosOficiais;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "contato_id")
    private ContatoEntity contato;

    @ManyToMany
    @JoinTable(
            name = "pessoas_enderecos",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private Set<EnderecoEntity> enderecos;

    public PessoaEntity(
            String nome,
            String nomeSocial,
            LocalDate dataNascimento,
            LocalDate dataFalecimento,
            GeneroEnum genero,
            LocalDateTime criacao,
            LocalDateTime modificacao,
            Set<OcupacaoProfissionalEntity> ocupacoesProfissionais,
            UnidadeFederativaEntity unidadeFederativa,
            Set<NacionalidadeEntity> nacionalidades,
            Set<DocumentoOficialEntity> documentosOficiais,
            ContatoEntity contato,
            Set<EnderecoEntity> enderecos) {
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.dataNascimento = dataNascimento;
        this.dataFalecimento = dataFalecimento;
        this.genero = genero;
        this.criacao = criacao;
        this.modificacao = modificacao;
        this.ocupacoesProfissionais = ocupacoesProfissionais;
        this.unidadeFederativa = unidadeFederativa;
        this.nacionalidades = nacionalidades;
        this.documentosOficiais = documentosOficiais;
        this.contato = contato;
        this.enderecos = enderecos;
    }
}
