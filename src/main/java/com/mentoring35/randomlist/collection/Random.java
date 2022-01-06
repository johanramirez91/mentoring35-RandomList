package com.mentoring35.randomlist.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Random {


    @Id
    private String id;
    private Date date;
    private String originalList;
    private String randomList;
    private Parametros parametros;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalList() {
        return originalList;
    }

    public void setOriginalList(String originalList) {
        this.originalList = originalList;
    }

    public String getRandomList() {
        return randomList;
    }

    public void setRandomList(String randomList) {
        this.randomList = randomList;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }
}
