package br.jus.trf1.core.enums;

/**
 * @author bruno.carneiro (tr301605)
 */
public enum DDDEnum {
    DF_61("61", UnidadeFederativaEnum.DF),
    GO_62("62", UnidadeFederativaEnum.GO),
    GO_64("64", UnidadeFederativaEnum.GO),
    MT_65("65", UnidadeFederativaEnum.MT),
    MT_66("66", UnidadeFederativaEnum.MT),
    MS_67("67", UnidadeFederativaEnum.MS),
    AL_82("82", UnidadeFederativaEnum.AL),
    BA_71("71", UnidadeFederativaEnum.BA),
    BA_73("73", UnidadeFederativaEnum.BA),
    BA_74("74", UnidadeFederativaEnum.BA),
    BA_75("75", UnidadeFederativaEnum.BA),
    BA_77("77", UnidadeFederativaEnum.BA),
    CE_85("85", UnidadeFederativaEnum.CE),
    CE_88("88", UnidadeFederativaEnum.CE),
    MA_98("98", UnidadeFederativaEnum.MA),
    MA_99("99", UnidadeFederativaEnum.MA),
    PB_83("83", UnidadeFederativaEnum.PB),
    PE_81("81", UnidadeFederativaEnum.PE),
    PE_87("87", UnidadeFederativaEnum.PE),
    PI_86("86", UnidadeFederativaEnum.PI),
    PI_89("89", UnidadeFederativaEnum.PI),
    RN_84("84", UnidadeFederativaEnum.RN),
    SE_79("79", UnidadeFederativaEnum.SE),
    AC_68("68", UnidadeFederativaEnum.AC),
    AP_96("96", UnidadeFederativaEnum.AP),
    AM_96("92", UnidadeFederativaEnum.AM),
    AM_97("97", UnidadeFederativaEnum.AM),
    PA_91("91", UnidadeFederativaEnum.PA),
    PA_93("93", UnidadeFederativaEnum.PA),
    PA_94("94", UnidadeFederativaEnum.PA),
    RO_69("69", UnidadeFederativaEnum.RO),
    RR_65("69", UnidadeFederativaEnum.RR),
    TO_63("63", UnidadeFederativaEnum.TO),
    ES_27("27", UnidadeFederativaEnum.ES),
    ES_28("28", UnidadeFederativaEnum.ES),
    MG_31("31", UnidadeFederativaEnum.MG),
    MG_32("32", UnidadeFederativaEnum.MG),
    MG_33("33", UnidadeFederativaEnum.MG),
    MG_34("34", UnidadeFederativaEnum.MG),
    MG_35("35", UnidadeFederativaEnum.MG),
    MG_37("37", UnidadeFederativaEnum.MG),
    MG_38("38", UnidadeFederativaEnum.MG),
    RJ_21("21", UnidadeFederativaEnum.RJ),
    RJ_22("22", UnidadeFederativaEnum.RJ),
    RJ_24("24", UnidadeFederativaEnum.RJ),
    SP_11("11", UnidadeFederativaEnum.SP),
    SP_12("12", UnidadeFederativaEnum.SP),
    SP_13("13", UnidadeFederativaEnum.SP),
    SP_14("14", UnidadeFederativaEnum.SP),
    SP_15("15", UnidadeFederativaEnum.SP),
    SP_16("16", UnidadeFederativaEnum.SP),
    SP_17("17", UnidadeFederativaEnum.SP),
    SP_18("18", UnidadeFederativaEnum.SP),
    SP_19("19", UnidadeFederativaEnum.SP),
    PR_41("41", UnidadeFederativaEnum.PR),
    PR_42("42", UnidadeFederativaEnum.PR),
    PR_43("43", UnidadeFederativaEnum.PR),
    PR_44("44", UnidadeFederativaEnum.PR),
    PR_45("45", UnidadeFederativaEnum.PR),
    PR_46("46", UnidadeFederativaEnum.PR),
    RS_51("51", UnidadeFederativaEnum.RS),
    RS_53("53", UnidadeFederativaEnum.RS),
    RS_54("54", UnidadeFederativaEnum.RS),
    RS_55("55", UnidadeFederativaEnum.RS),
    SC_47("47", UnidadeFederativaEnum.SC),
    SC_48("48", UnidadeFederativaEnum.SC),
    SC_49("48", UnidadeFederativaEnum.SC);

    private final String ddd;
    private final UnidadeFederativaEnum unidadeFederativaEnum;

    DDDEnum(String ddd, UnidadeFederativaEnum unidadeFederativaEnum) {
        this.ddd = ddd;
        this.unidadeFederativaEnum = unidadeFederativaEnum;
    }

    public String getDdd() {
        return ddd;
    }

    public UnidadeFederativaEnum getUnidadeFederativaEnum() {
        return unidadeFederativaEnum;
    }
}
