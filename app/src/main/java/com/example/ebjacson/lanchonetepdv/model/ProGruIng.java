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
public class ProGruIng extends SugarRecord<ProGruIng> implements Serializable {

    private GrupoIng grupoIngId;
    private Produto produtoId;

    public ProGruIng() {
    }

    public GrupoIng getGrupoIngId() {
        return grupoIngId;
    }

    public void setGrupoIngId(GrupoIng grupoIngId) {
        this.grupoIngId = grupoIngId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProGruIng proGruIng = (ProGruIng) o;

        if (grupoIngId != null ? !grupoIngId.equals(proGruIng.grupoIngId) : proGruIng.grupoIngId != null)
            return false;
        return produtoId != null ? produtoId.equals(proGruIng.produtoId) : proGruIng.produtoId == null;

    }

    @Override
    public int hashCode() {
        int result = grupoIngId != null ? grupoIngId.hashCode() : 0;
        result = 31 * result + (produtoId != null ? produtoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProGruIng{" +
                "grupoIngId=" + grupoIngId +
                ", produtoId=" + produtoId +
                '}';
    }
}
