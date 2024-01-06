package br.jus.trf1.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Long id;
    private String nome;
    private String nomeSocial;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private String naturalidade;
    private String nacionalidade;
    private LocalDateTime criacao;
    private LocalDateTime modificacao;
    private Set<DocumentoOficial> documentosOficiais;
    private Contato contato;
    private Endereco endereco;

    public Pessoa(
            String nome,
            LocalDate dataNascimento,
            String naturalidade,
            String nacionalidade,
            Set<DocumentoOficial> documentosOficiais,
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
        this.contato = contato;
        this.endereco = endereco;
        this.documentosOficiais = !Objects.isNull(documentosOficiais)
                ? documentosOficiais
                : new HashSet<>();
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

    public Set<DocumentoOficial> getDocumentosOficiais() {
        return documentosOficiais;
    }

    private void setDocumentosOficiais(Set<DocumentoOficial> documentosOficiais) {
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

    public void adicionarDocumentoOficial(DocumentoOficial documentoOficial) {
        this.documentosOficiais.add(documentoOficial);
    }

    public void removerDocumentoOficial(DocumentoOficial documentoOficial) {
        this.setDocumentosOficiais(this.documentosOficiais.stream()
                .filter(d -> !Objects.equals(d.getId(), documentoOficial.getId()))
                .collect(Collectors.toSet()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(nomeSocial, pessoa.nomeSocial) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(dataFalecimento, pessoa.dataFalecimento) && Objects.equals(naturalidade, pessoa.naturalidade) && Objects.equals(nacionalidade, pessoa.nacionalidade) && Objects.equals(criacao, pessoa.criacao) && Objects.equals(modificacao, pessoa.modificacao) && Objects.equals(documentosOficiais, pessoa.documentosOficiais) && Objects.equals(contato, pessoa.contato) && Objects.equals(endereco, pessoa.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nomeSocial, dataNascimento, dataFalecimento, naturalidade, nacionalidade, criacao, modificacao, documentosOficiais, contato, endereco);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataFalecimento=" + dataFalecimento +
                ", naturalidade='" + naturalidade + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", criacao=" + criacao +
                ", modificacao=" + modificacao +
                ", documentosOficiais=" + documentosOficiais +
                ", contato=" + contato +
                ", endereco=" + endereco +
                '}';
    }
}
