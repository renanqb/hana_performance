package com.example.hibernate.jpa.crud.repo2.model;

import javax.persistence.*;

@Entity
@Table(name = "tabelao_pai")
public class TabelaoPai {

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

    public TabelaoPai() {

    }

    public TabelaoPai(long codigo1, long codigo2, long codigo3, long codigo4, long codigo5, String sigla) {
        this.codigo1 = codigo1;
        this.codigo2 = codigo2;
        this.codigo3 = codigo3;
        this.codigo4 = codigo4;
        this.codigo5 = codigo5;
        this.sigla = sigla;
    }

    public long getId() {
        return this.id;
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
        return  this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return String.format(
            "INSERT INTO \"SYSTEM\".\"TABELAO_PAI\" (CODIGO1, CODIGO2, CODIGO3, CODIGO4, CODIGO5, SIGLA) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');", 
            getCodigo1(), getCodigo2(), getCodigo3(), getCodigo4(), getCodigo5(), getSigla());
    }

    public String toStringWithError() {
        return String.format(
            "INSERT INTO \"SYSTEM\".\"TABELAO_PAI\" (CODIGO1, CODIGO2, CODIGO3, CODIGO4, CODIGO5, SIGLA) VALUES ('%s', '%s', '%s', '%s', '%s');", 
            getCodigo1(), getCodigo2(), getCodigo3(), getCodigo4(), getCodigo5(), getSigla());
    }

}