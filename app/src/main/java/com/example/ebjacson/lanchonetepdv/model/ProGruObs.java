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
public class ProGruObs extends SugarRecord<ProGruObs> implements Serializable {

    private GrupoObs grupoObsId;
    private Produto produtoId;

    public ProGruObs() {
    }

    public GrupoObs getGrupoObsId() {
        return grupoObsId;
    }

    public void setGrupoObsId(GrupoObs grupoObsId) {
        this.grupoObsId = grupoObsId;
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

        ProGruObs proGruObs = (ProGruObs) o;

        if (grupoObsId != null ? !grupoObsId.equals(proGruObs.grupoObsId) : proGruObs.grupoObsId != null)
            return false;
        return produtoId != null ? produtoId.equals(proGruObs.produtoId) : proGruObs.produtoId == null;

    }

    @Override
    public int hashCode() {
        int result = grupoObsId != null ? grupoObsId.hashCode() : 0;
        result = 31 * result + (produtoId != null ? produtoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProGruObs{" +
                "grupoObsId=" + grupoObsId +
                ", produtoId=" + produtoId +
                '}';
    }
}
