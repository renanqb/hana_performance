package com.example.hibernate.jpa.crud.controller;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.example.hibernate.jpa.crud.repo2.model.*;
import com.example.hibernate.jpa.crud.repo2.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PerformanceTestController {

    @Autowired
    private TabelaoInsertRepositoryDA tabelaoInsertRepositoryDA;

    @Autowired
    private TabelaoInsertRepositoryJPA tabelaoInsertRepositoryJPA;

    @GetMapping("/performancejpa/{events}")
    public String insertPerformanceNativeJPA(@PathVariable(value = "events") int events) throws SQLException {
        
        Date start = new Date();

        for (int i = 1; i <= events; i++) {
            String[] inserts = new String[2];
            long index = i;
            String texto = "texto" + index;
            int inteiro = (int)index + 1;
            double decimal = index + 0.5;
            Date data = new Date();
            
            TabelaoPai pai = new TabelaoPai(index, index, index, index, index, "DW6");
            TabelaoFilho filho = new TabelaoFilho(
                index, index, index, index, index, "DW6", 
                texto, texto, texto, texto, texto, texto, texto, texto, texto, texto,
                inteiro, inteiro, inteiro, inteiro, inteiro,
                decimal, decimal, decimal, decimal, decimal,
                data, data, data, data, data);
            
            inserts[0] = pai.toString();
            inserts[1] = filho.toString();
            
            try {
                tabelaoInsertRepositoryJPA.insertWithQuery(inserts, i);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        Date end = new Date();
        return calculateTime(start, end);
    }

    @GetMapping("/performanceda/{events}")
    public String insertPerformanceDA(@PathVariable(value = "events") int events) throws ClassNotFoundException, SQLException {
        
        Date start = new Date();
        
        for (int i = 1; i <= events; i++) {
            String[] inserts = new String[2];
            long index = i;
            String texto = "texto" + index;
            int inteiro = (int)index + 1;
            double decimal = index + 0.5;
            Date data = new Date();
            
            TabelaoPai pai = new TabelaoPai(index, index, index, index, index, "DW6");
            TabelaoFilho filho = new TabelaoFilho(
                index, index, index, index, index, "DW6", 
                texto, texto, texto, texto, texto, texto, texto, texto, texto, texto,
                inteiro, inteiro, inteiro, inteiro, inteiro,
                decimal, decimal, decimal, decimal, decimal,
                data, data, data, data, data);
            
            inserts[0] = pai.toString();
            inserts[1] = filho.toString();

            tabelaoInsertRepositoryDA.executeBatch(inserts);
        }

        Date end = new Date();
        return calculateTime(start, end);
    }

    @GetMapping("/performancedawithouttransaction")
    public String insertPerformanceDAWithoutTransaction() throws ClassNotFoundException, SQLException {
        
        Date start = new Date();
        String[] inserts = new String[2];
        Date data = new Date();
        
        // scenario 1 (OK)
        TabelaoPai pai = new TabelaoPai(1, 1, 1, 1, 1, "DW6");
        TabelaoFilho filho = new TabelaoFilho(
            1, 1, 1, 1, 1, "DW6", 
            "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toString();
        inserts[1] = filho.toString();
        tabelaoInsertRepositoryDA.executeBatch(inserts);

        // scenario 2 (Fail second insert)
        pai = new TabelaoPai(2, 2, 2, 2, 2, "DW6");
        filho = new TabelaoFilho(
            2, 2, 2, 2, 2, "DW6", 
            "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toStringWithError();
        inserts[1] = filho.toString();
        tabelaoInsertRepositoryDA.executeBatch(inserts);

        // scenario 3 (Fail third insert)
        pai = new TabelaoPai(3, 3, 3, 3, 3, "DW6");
        filho = new TabelaoFilho(
            3, 3, 3, 3, 3, "DW6", 
            "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto2", "texto2", "texto2",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toString();
        inserts[1] = filho.toStringWithError();
        tabelaoInsertRepositoryDA.executeBatch(inserts);

        // scenario 4 (OK)
        pai = new TabelaoPai(4, 4, 4, 4, 4, "DW6");
        filho = new TabelaoFilho(
            4, 4, 4, 4, 4, "DW6", 
            "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto2", "texto2", "texto2",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toString();
        inserts[1] = filho.toString();
        tabelaoInsertRepositoryDA.executeBatch(inserts);

        Date end = new Date();
        return calculateTime(start, end);
    }

    @GetMapping("/performancedawithtransaction")
    public String insertPerformanceDAWithTransaction() throws ClassNotFoundException, SQLException {
        
        Date start = new Date();
        String[] inserts = new String[2];
        Date data = new Date();
        
        // scenario 1 (OK)
        TabelaoPai pai = new TabelaoPai(1, 1, 1, 1, 1, "DW6");
        TabelaoFilho filho = new TabelaoFilho(
            1, 1, 1, 1, 1, "DW6", 
            "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1", "texto1",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toString();
        inserts[1] = filho.toString();
        tabelaoInsertRepositoryDA.executeBatchWtihTransaction(inserts);

        // scenario 2 (Fail second insert)
        pai = new TabelaoPai(2, 2, 2, 2, 2, "DW6");
        filho = new TabelaoFilho(
            2, 2, 2, 2, 2, "DW6", 
            "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2", "texto2",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toStringWithError();
        inserts[1] = filho.toString();
        tabelaoInsertRepositoryDA.executeBatchWtihTransaction(inserts);

        // scenario 3 (Fail third insert)
        pai = new TabelaoPai(3, 3, 3, 3, 3, "DW6");
        filho = new TabelaoFilho(
            3, 3, 3, 3, 3, "DW6", 
            "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto2", "texto2", "texto2",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toString();
        inserts[1] = filho.toStringWithError();
        tabelaoInsertRepositoryDA.executeBatchWtihTransaction(inserts);

        // scenario 4 (OK)
        pai = new TabelaoPai(4, 4, 4, 4, 4, "DW6");
        filho = new TabelaoFilho(
            4, 4, 4, 4, 4, "DW6", 
            "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto3", "texto2", "texto2", "texto2",
            1, 2, 3, 4, 5, 
            1.1, 1.2, 1.3, 1.4, 1.5, 
            data, data, data, data, data);

        inserts[0] = pai.toString();
        inserts[1] = filho.toString();
        tabelaoInsertRepositoryDA.executeBatchWtihTransaction(inserts);

        Date end = new Date();
        return calculateTime(start, end);
    }

    private String calculateTime(Date start, Date end) {
        long diffInMillies = Math.abs(end.getTime() - start.getTime());
        long diff = TimeUnit.MILLISECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return String.valueOf(diff) + " milisegundos(s)";
    }
}