package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.GeneroEnum;
import br.jus.trf1.core.enums.OcupacaoProfissionalEnum;
import br.jus.trf1.core.enums.UnidadeFederativaEnum;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Representa uma pessoa dentro do sistema, seja ela um {@link Usuario} ou não
 *
 * @author bruno.carneiro (tr301605)
 */
public class Pessoa {
    private String nome;
    private String nomeSocial;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private GeneroEnum genero;
    private OcupacaoProfissionalEnum ocupacaoProfissional;
    private UnidadeFederativaEnum naturalidade;
    private String nacionalidade;
    private Set<DocumentoOficial> documentosOficiais;
    private Contato contato;
    private Endereco endereco;

    public Pessoa() {
        this.setDocumentosOficiais(new HashSet<>());
    }

    private Pessoa(
            String nome,
            String nomeSocial,
            LocalDate dataNascimento,
            LocalDate dataFalecimento,
            GeneroEnum genero,
            OcupacaoProfissionalEnum ocupacaoProfissional,
            UnidadeFederativaEnum naturalidade,
            String nacionalidade,
            Set<DocumentoOficial> documentosOficiais,
            Contato contato,
            Endereco endereco) {
        this.setNome(nome);
        this.setNomeSocial(nomeSocial);
        this.setDataNascimento(dataNascimento);
        this.setDataFalecimento(dataFalecimento);
        this.setGenero(genero);
        this.setOcupacaoProfissional(ocupacaoProfissional);
        this.setNaturalidade(naturalidade);
        this.setNacionalidade(nacionalidade);
        this.setDocumentosOficiais(documentosOficiais);
        this.setContato(contato);
        this.setEndereco(endereco);
    }

    void adicionarDocumentoOficial(DocumentoOficial documentoOficial) {

        if (Objects.isNull(documentoOficial))
            throw new RuntimeException("O documento deve ser informado");

        this.documentosOficiais.add(documentoOficial);
    }

    void removerDocumentoOficial(DocumentoOficial documentoOficial) {

        if (Objects.isNull(documentoOficial))
            throw new RuntimeException("O documento deve ser informado");

        this.setDocumentosOficiais(
                this.documentosOficiais.stream()
                        .filter(d -> !d.equals(documentoOficial))
                        .collect(Collectors.toSet()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(LocalDate dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public OcupacaoProfissionalEnum getOcupacaoProfissional() {
        return ocupacaoProfissional;
    }

    public void setOcupacaoProfissional(OcupacaoProfissionalEnum ocupacaoProfissional) {
        this.ocupacaoProfissional = ocupacaoProfissional;
    }

    public UnidadeFederativaEnum getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(UnidadeFederativaEnum naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<DocumentoOficial> getDocumentosOficiais() {
        return documentosOficiais;
    }

    public void setDocumentosOficiais(Set<DocumentoOficial> documentosOficiais) {
        this.documentosOficiais =
                (Objects.isNull(documentosOficiais))
                        ? new HashSet<>()
                        :documentosOficiais;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static class Builder {
        private String nome;
        private String nomeSocial;
        private LocalDate dataNascimento;
        private LocalDate dataFalecimento;
        private GeneroEnum genero;
        private OcupacaoProfissionalEnum ocupacaoProfissional;
        private UnidadeFederativaEnum naturalidade;
        private String nacionalidade;
        private Set<DocumentoOficial> documentosOficiais;
        private Contato contato;
        private Endereco endereco;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder nomeSocial(String nomeSocial) {
            this.nomeSocial = nomeSocial;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder dataFalecimento(LocalDate dataFalecimento) {
            this.dataFalecimento = dataFalecimento;
            return this;
        }

        public Builder genero(GeneroEnum genero) {
            this.genero = genero;
            return this;
        }

        public Builder ocupacaoProfissional(OcupacaoProfissionalEnum ocupacaoProfissional) {
            this.ocupacaoProfissional = ocupacaoProfissional;
            return this;
        }

        public Builder naturalidade(UnidadeFederativaEnum naturalidade) {
            this.naturalidade = naturalidade;
            return this;
        }

        public Builder nacionalidade(String nacionalidade) {
            this.nacionalidade = nacionalidade;
            return this;
        }

        public Builder documentosOficiais(Set<DocumentoOficial> documentosOficiais) {
            this.documentosOficiais = documentosOficiais;
            return this;
        }

        public Builder contato(Contato contato) {
            this.contato = contato;
            return this;
        }

        public Builder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(
                    nome,
                    nomeSocial,
                    dataNascimento,
                    dataFalecimento,
                    genero,
                    ocupacaoProfissional,
                    naturalidade,
                    nacionalidade,
                    documentosOficiais,
                    contato,
                    endereco);
        }
    }
}
