package com.example.hibernate.jpa.crud.repo2.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tabelao_filho")
public class TabelaoFilho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "codigo1", nullable = false)
    private long codigo1;
    @Column(name = "codigo2", nullable = false)
    private long codigo2;
    @Column(name = "codigo3", nullable = false)
    private long codigo3;
    @Column(name = "codigo4", nullable = false)
    private long codigo4;
    @Column(name = "codigo5", nullable = false)
    private long codigo5;
    @Column(name = "sigla", nullable = false)
    private String sigla;

    @Column(name = "texto1")
    private String texto1;
    @Column(name = "texto2")
    private String texto2;
    @Column(name = "texto3")
    private String texto3;
    @Column(name = "texto4")
    private String texto4;
    @Column(name = "texto5")
    private String texto5;
    @Column(name = "texto6")
    private String texto6;
    @Column(name = "texto7")
    private String texto7;
    @Column(name = "texto8")
    private String texto8;
    @Column(name = "texto9")
    private String texto9;
    @Column(name = "texto10")
    private String texto10;

    @Column(name = "inteiro1")
    private int inteiro1;
    @Column(name = "inteiro2")
    private int inteiro2;
    @Column(name = "inteiro3")
    private int inteiro3;
    @Column(name = "inteiro4")
    private int inteiro4;
    @Column(name = "inteiro5")
    private int inteiro5;

    @Column(name = "decimal1")
    private Double decimal1;
    @Column(name = "decimal2")
    private Double decimal2;
    @Column(name = "decimal3")
    private Double decimal3;
    @Column(name = "decimal4")
    private Double decimal4;
    @Column(name = "decimal5")
    private Double decimal5;

    @Column(name = "data1")
    @Temporal(TemporalType.DATE)
    private Date data1;
    @Column(name = "data2")
    @Temporal(TemporalType.DATE)
    private Date data2;
    @Column(name = "data3")
    @Temporal(TemporalType.DATE)
    private Date data3;
    @Column(name = "data4")
    @Temporal(TemporalType.DATE)
    private Date data4;
    @Column(name = "data5")
    @Temporal(TemporalType.DATE)
    private Date data5;

    public TabelaoFilho() {
        
    }

    public TabelaoFilho(
        long codigo1, long codigo2, long codigo3, long codigo4, long codigo5, String sigla, 
        String texto1, String texto2, String texto3, String texto4, String texto5, String texto6, String texto7, String texto8, String texto9, String texto10, 
        int inteiro1, int inteiro2, int inteiro3, int inteiro4, int inteiro5, 
        Double decimal1, Double decimal2, Double decimal3, Double decimal4, Double decimal5, 
        Date data1, Date data2, Date data3, Date data4, Date data5) {
        this.codigo1 = codigo1;
        this.codigo2 = codigo2;
        this.codigo3 = codigo3;
        this.codigo4 = codigo4;
        this.codigo5 = codigo5;
        this.sigla = sigla;
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.texto4 = texto4;
        this.texto5 = texto5;
        this.texto6 = texto6;
        this.texto7 = texto7;
        this.texto8 = texto8;
        this.texto9 = texto9;
        this.texto10 = texto10;
        this.inteiro1 = inteiro1;
        this.inteiro2 = inteiro2;
        this.inteiro3 = inteiro3;
        this.inteiro4 = inteiro4;
        this.inteiro5 = inteiro5;
        this.decimal1 = decimal1;
        this.decimal2 = decimal2;
        this.decimal3 = decimal3;
        this.decimal4 = decimal4;
        this.decimal5 = decimal5;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public long getCodigo1() {
        return this.codigo1;
    }

    public void setCodigo1(long codigo1) {
        this.codigo1 = codigo1;
    }

    public long getCodigo2() {
        return this.codigo2;
    }

    public void setCodigo2(long codigo2) {
        this.codigo2 = codigo2;
    }

    public long getCodigo3() {
        return this.codigo3;
    }

    public void setCodigo3(long codigo3) {
        this.codigo3 = codigo3;
    }

    public long getCodigo4() {
        return this.codigo4;
    }

    public void setCodigo4(long codigo4) {
        this.codigo4 = codigo4;
    }

    public long getCodigo5() {
        return this.codigo5;
    }

    public void setCodigo5(long codigo5) {
        this.codigo5 = codigo5;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTexto1() {
        return this.texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return this.texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public String getTexto3() {
        return this.texto3;
    }

    public void setTexto3(String texto3) {
        this.texto3 = texto3;
    }

    public String getTexto4() {
        return this.texto4;
    }

    public void setTexto4(String texto4) {
        this.texto4 = texto4;
    }

    public String getTexto5() {
        return this.texto5;
    }

    public void setTexto5(String texto5) {
        this.texto5 = texto5;
    }

    public String getTexto6() {
        return this.texto6;
    }

    public void setTexto6(String texto6) {
        this.texto6 = texto6;
    }

    public String getTexto7() {
        return this.texto7;
    }

    public void setTexto7(String texto7) {
        this.texto7 = texto7;
    }

    public String getTexto8() {
        return this.texto8;
    }

    public void setTexto8(String texto8) {
        this.texto8 = texto8;
    }

    public String getTexto9() {
        return this.texto9;
    }

    public void setTexto9(String texto9) {
        this.texto9 = texto9;
    }

    public String getTexto10() {
        return this.texto10;
    }

    public void setTexto10(String texto10) {
        this.texto10 = texto10;
    }

    public int getInteiro1() {
        return this.inteiro1;
    }

    public void setInteiro1(int inteiro1) {
        this.inteiro1 = inteiro1;
    }

    public int getInteiro2() {
        return this.inteiro2;
    }

    public void setInteiro2(int inteiro2) {
        this.inteiro2 = inteiro2;
    }

    public int getInteiro3() {
        return this.inteiro3;
    }

    public void setInteiro3(int inteiro3) {
        this.inteiro3 = inteiro3;
    }

    public int getInteiro4() {
        return this.inteiro4;
    }

    public void setInteiro4(int inteiro4) {
        this.inteiro4 = inteiro4;
    }

    public int getInteiro5() {
        return this.inteiro5;
    }

    public void setInteiro5(int inteiro5) {
        this.inteiro5 = inteiro5;
    }

    public Double getDecimal1() {
        return this.decimal1;
    }

    public void setDecimal1(Double decimal1) {
        this.decimal1 = decimal1;
    }

    public Double getDecimal2() {
        return this.decimal2;
    }

    public void setDecimal2(Double decimal2) {
        this.decimal2 = decimal2;
    }

    public Double getDecimal3() {
        return this.decimal3;
    }

    public void setDecimal3(Double decimal3) {
        this.decimal3 = decimal3;
    }

    public Double getDecimal4() {
        return this.decimal4;
    }

    public void setDecimal4(Double decimal4) {
        this.decimal4 = decimal4;
    }

    public Double getDecimal5() {
        return this.decimal5;
    }

    public void setDecimal5(Double decimal5) {
        this.decimal5 = decimal5;
    }

    public Date getData1() {
        return this.data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2() {
        return this.data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public Date getData3() {
        return this.data3;
    }

    public void setData3(Date data3) {
        this.data3 = data3;
    }

    public Date getData4() {
        return this.data4;
    }

    public void setData4(Date data4) {
        this.data4 = data4;
    }

    public Date getData5() {
        return this.data5;
    }

    public void setData5(Date data5) {
        this.data5 = data5;
    }

    @Override
    public String toString() {
        return String.format(
            "INSERT INTO \"SYSTEM\".\"TABELAO_FILHO\" (" + 
            "CODIGO1, CODIGO2, CODIGO3, CODIGO4, CODIGO5, SIGLA, " + 
            "TEXTO1, TEXTO2,TEXTO3, TEXTO4, TEXTO5, TEXTO6, TEXTO7, TEXTO8, TEXTO9, TEXTO10, " + 
            "INTEIRO1, INTEIRO2, INTEIRO3, INTEIRO4, INTEIRO5, " +
            "DECIMAL1, DECIMAL2, DECIMAL3, DECIMAL4, DECIMAL5, " +
            "DATA1, DATA2, DATA3, DATA4, DATA5" +
            ") VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", 
            getCodigo1(), 
            getCodigo2(), 
            getCodigo3(), 
            getCodigo4(), 
            getCodigo5(), 
            getSigla(),
            getTexto1(),
            getTexto2(),
            getTexto3(),
            getTexto4(),
            getTexto5(),
            getTexto6(),
            getTexto7(),
            getTexto8(),
            getTexto9(),
            getTexto10(),
            getInteiro1(),
            getInteiro2(),
            getInteiro3(),
            getInteiro4(),
            getInteiro5(),
            getDecimal1(),
            getDecimal2(),
            getDecimal3(),
            getDecimal4(),
            getDecimal5(),
            new java.sql.Date(getData1().getTime()),
            new java.sql.Date(getData2().getTime()),
            new java.sql.Date(getData3().getTime()),
            new java.sql.Date(getData4().getTime()),
            new java.sql.Date(getData5().getTime()));
    }

    public String toStringWithError() {
        return String.format(
            "INSERT INTO \"SYSTEM\".\"TABELAO_FILHO\" (" + 
            "CODIGO1, CODIGO2, CODIGO3, CODIGO4, CODIGO5, SIGLA, " + 
            "TEXTO1, TEXTO2,TEXTO3, TEXTO4, TEXTO5, TEXTO6, TEXTO7, TEXTO8, TEXTO9, TEXTO10, " + 
            "INTEIRO1, INTEIRO2, INTEIRO3, INTEIRO4, INTEIRO5, " +
            "DECIMAL1, DECIMAL2, DECIMAL3, DECIMAL4, DECIMAL5, " +
            "DATA1, DATA2, DATA3, DATA4, DATA5" +
            ") VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", 
            getCodigo1(), 
            getCodigo2(), 
            getCodigo3(), 
            getCodigo4(), 
            getCodigo5(), 
            getSigla(),
            getTexto1(),
            getTexto2(),
            getTexto3(),
            getTexto4(),
            getTexto5(),
            getTexto6(),
            getTexto7(),
            getTexto8(),
            getTexto9(),
            getTexto10(),
            getInteiro1(),
            getInteiro2(),
            getInteiro3(),
            getInteiro4(),
            getInteiro5(),
            getDecimal1(),
            getDecimal2(),
            getDecimal3(),
            getDecimal4(),
            getDecimal5(),
            new java.sql.Date(getData1().getTime()),
            new java.sql.Date(getData2().getTime()),
            new java.sql.Date(getData3().getTime()),
            new java.sql.Date(getData4().getTime()),
            new java.sql.Date(getData5().getTime()));
    }

}