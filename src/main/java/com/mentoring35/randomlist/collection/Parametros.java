package com.mentoring35.randomlist.collection;

public class Parametros {

    private Integer valorInicial;
    private Integer valorMaximo;

    public Parametros(Integer valorInicial, Integer valorMaximo) {
        this.valorInicial = valorInicial;
        this.valorMaximo = valorMaximo;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Integer valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

}
