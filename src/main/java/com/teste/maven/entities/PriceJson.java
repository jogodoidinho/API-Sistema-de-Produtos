package com.teste.maven.entities;

public class PriceJson {
    private Double price;

    public PriceJson(){
    }

    public PriceJson(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
