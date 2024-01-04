package br.jus.trf1.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bruno.carneiro (tr301605)
 */
public class Pessoa {
    private Long id;
    private String nome;
    private String nomeSocial;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private String naturalidade;
    private String nacionalidade;
    private LocalDateTime criacao;
    private LocalDateTime modificacao;
    private List<DocumentoOficial> documentosOficiais;
    private Contato contato;
    private Endereco endereco;

    public Pessoa() {

    }

    public Pessoa(
            String nome,
            LocalDate dataNascimento,
            String naturalidade,
            String nacionalidade,
            List<DocumentoOficial> documentosOficiais,
            Contato contato,
            Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.documentosOficiais = documentosOficiais;
        this.contato = contato;
        this.endereco = endereco;
        this.criacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDateTime getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }

    public LocalDateTime getModificacao() {
        return modificacao;
    }

    public void setModificacao(LocalDateTime modificacao) {
        this.modificacao = modificacao;
    }

    public List<DocumentoOficial> getDocumentosOficiais() {
        return documentosOficiais;
    }

    public void setDocumentosOficiais(List<DocumentoOficial> documentosOficiais) {
        this.documentosOficiais = documentosOficiais;
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
}
