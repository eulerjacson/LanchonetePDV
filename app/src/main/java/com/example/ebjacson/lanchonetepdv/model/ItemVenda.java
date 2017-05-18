/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ebjacson.lanchonetepdv.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jacson
 */
public class ItemVenda extends SugarRecord<ItemVenda> implements Serializable {

    private Date dataitven;
    private Integer qtditven;
    private Double vlrunitven;
    private Double vlracresitven;
    private Double vlrsubtotitven;
    private Double vlrtotalitven;
    private Boolean statusitven;
    private Produto produtoId;
    private Venda vendaId;

    public ItemVenda() {
    }

    public Date getDataitven() {
        return dataitven;
    }

    public void setDataitven(Date dataitven) {
        this.dataitven = dataitven;
    }

    public Integer getQtditven() {
        return qtditven;
    }

    public void setQtditven(Integer qtditven) {
        this.qtditven = qtditven;
    }

    public Double getVlrunitven() {
        return vlrunitven;
    }

    public void setVlrunitven(Double vlrunitven) {
        this.vlrunitven = vlrunitven;
    }

    public Double getVlracresitven() {
        return vlracresitven;
    }

    public void setVlracresitven(Double vlracresitven) {
        this.vlracresitven = vlracresitven;
    }

    public Double getVlrsubtotitven() {
        return vlrsubtotitven;
    }

    public void setVlrsubtotitven(Double vlrsubtotitven) {
        this.vlrsubtotitven = vlrsubtotitven;
    }

    public Double getVlrtotalitven() {
        return vlrtotalitven;
    }

    public void setVlrtotalitven(Double vlrtotalitven) {
        this.vlrtotalitven = vlrtotalitven;
    }

    public Boolean getStatusitven() {
        return statusitven;
    }

    public void setStatusitven(Boolean statusitven) {
        this.statusitven = statusitven;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemVenda itemVenda = (ItemVenda) o;

        return produtoId != null ? produtoId.equals(itemVenda.produtoId) : itemVenda.produtoId == null;

    }

    @Override
    public int hashCode() {
        return produtoId != null ? produtoId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "dataitven=" + dataitven +
                ", qtditven=" + qtditven +
                ", vlrunitven=" + vlrunitven +
                ", vlracresitven=" + vlracresitven +
                ", vlrsubtotitven=" + vlrsubtotitven +
                ", vlrtotalitven=" + vlrtotalitven +
                ", statusitven=" + statusitven +
                '}';
    }
}
