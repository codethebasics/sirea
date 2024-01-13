package br.jus.trf1.core.domain;

import br.jus.trf1.core.enums.OrgaoEmissorEnum;
import br.jus.trf1.core.enums.TipoDocumentoOficialEnum;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa um documento oficial emitido por órgão federal
 *
 * @author bruno.carneiro (tr301605)
 */
public class DocumentoOficial {
    private String numero;
    private LocalDate emissao;
    private LocalDate vencimento;
    private OrgaoEmissorEnum orgaoEmissor;
    private TipoDocumentoOficialEnum tipoDocumentoOficial;

    public DocumentoOficial(
            String numero,
            LocalDate emissao,
            OrgaoEmissorEnum orgaoEmissor,
            TipoDocumentoOficialEnum tipoDocumentoOficial) {
        this.numero = numero;
        this.emissao = emissao;
        this.orgaoEmissor = orgaoEmissor;
        this.tipoDocumentoOficial = tipoDocumentoOficial;
    }

    public DocumentoOficial(
            String numero,
            LocalDate emissao,
            LocalDate vencimento,
            OrgaoEmissorEnum orgaoEmissor,
            TipoDocumentoOficialEnum tipoDocumentoOficial) {
        this.numero = numero;
        this.emissao = emissao;
        this.vencimento = vencimento;
        this.orgaoEmissor = orgaoEmissor;
        this.tipoDocumentoOficial = tipoDocumentoOficial;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        if (emissao.isAfter(LocalDate.now()))
            throw new RuntimeException("O documento não pode ter uma data de emissão futura");
        this.emissao = emissao;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public OrgaoEmissorEnum getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(OrgaoEmissorEnum orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public TipoDocumentoOficialEnum getTipoDocumentoOficial() {
        return tipoDocumentoOficial;
    }

    public void setTipoDocumentoOficial(TipoDocumentoOficialEnum tipoDocumentoOficial) {
        this.tipoDocumentoOficial = tipoDocumentoOficial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoOficial that = (DocumentoOficial) o;
        return Objects.equals(numero, that.numero)
                && Objects.equals(emissao, that.emissao)
                && orgaoEmissor == that.orgaoEmissor
                && tipoDocumentoOficial == that.tipoDocumentoOficial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, emissao, orgaoEmissor, tipoDocumentoOficial);
    }

    @Override
    public String toString() {
        return "DocumentoOficial{" +
                "numero='" + numero + '\'' +
                ", emissao=" + emissao +
                ", vencimento=" + vencimento +
                ", orgaoEmissor=" + orgaoEmissor +
                ", tipoDocumentoOficial=" + tipoDocumentoOficial +
                '}';
    }
}
