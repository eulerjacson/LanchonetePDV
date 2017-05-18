/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ebjacson.lanchonetepdv.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 *
 * @author Jacson
 */
public class Produto extends SugarRecord<Produto> implements Serializable {

    private String nomepro;
    private Double precopro;
    private Boolean imprimepro;
    private Boolean statuspro;
    private GrupoProduto grupoProdutoId;

    public Produto() {
    }

    public String getNomepro() {
        return nomepro;
    }

    public void setNomepro(String nomepro) {
        this.nomepro = nomepro;
    }

    public Double getPrecopro() {
        return precopro;
    }

    public void setPrecopro(Double precopro) {
        this.precopro = precopro;
    }

    public Boolean getImprimepro() {
        return imprimepro;
    }

    public void setImprimepro(Boolean imprimepro) {
        this.imprimepro = imprimepro;
    }

    public Boolean getStatuspro() {
        return statuspro;
    }

    public void setStatuspro(Boolean statuspro) {
        this.statuspro = statuspro;
    }

    public GrupoProduto getGrupoProdutoId() {
        return grupoProdutoId;
    }

    public void setGrupoProdutoId(GrupoProduto grupoProdutoId) {
        this.grupoProdutoId = grupoProdutoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (nomepro != null ? !nomepro.equals(produto.nomepro) : produto.nomepro != null)
            return false;
        if (precopro != null ? !precopro.equals(produto.precopro) : produto.precopro != null)
            return false;
        if (imprimepro != null ? !imprimepro.equals(produto.imprimepro) : produto.imprimepro != null)
            return false;
        if (statuspro != null ? !statuspro.equals(produto.statuspro) : produto.statuspro != null)
            return false;
        return grupoProdutoId != null ? grupoProdutoId.equals(produto.grupoProdutoId) : produto.grupoProdutoId == null;

    }

    @Override
    public int hashCode() {
        int result = nomepro != null ? nomepro.hashCode() : 0;
        result = 31 * result + (precopro != null ? precopro.hashCode() : 0);
        result = 31 * result + (imprimepro != null ? imprimepro.hashCode() : 0);
        result = 31 * result + (statuspro != null ? statuspro.hashCode() : 0);
        result = 31 * result + (grupoProdutoId != null ? grupoProdutoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nomepro='" + nomepro + '\'' +
                ", precopro=" + precopro +
                ", imprimepro=" + imprimepro +
                ", statuspro=" + statuspro +
                ", grupoProdutoId=" + grupoProdutoId +
                '}';
    }
}
