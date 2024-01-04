package br.jus.trf1.core.domain;

import java.time.LocalDate;

/**
 * @author bruno.carneiro (tr301605)
 */
public class DocumentoOficial {
    Long id;
    private String codigo;
    private String numero;
    private LocalDate emissao;
    private LocalDate vencimento;
    private OrgaoEmissor orgaoEmissor;
}
