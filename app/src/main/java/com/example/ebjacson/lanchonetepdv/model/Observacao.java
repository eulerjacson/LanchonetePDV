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
public class Observacao extends SugarRecord<Observacao> implements Serializable {

    private String descobs;
    private Boolean statusobs;
    private GrupoObs grupoObsId;

    public Observacao() {
    }

    public String getDescobs() {
        return descobs;
    }

    public void setDescobs(String descobs) {
        this.descobs = descobs;
    }

    public Boolean getStatusobs() {
        return statusobs;
    }

    public void setStatusobs(Boolean statusobs) {
        this.statusobs = statusobs;
    }

    public GrupoObs getGrupoObsId() {
        return grupoObsId;
    }

    public void setGrupoObsId(GrupoObs grupoObsId) {
        this.grupoObsId = grupoObsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Observacao that = (Observacao) o;

        if (descobs != null ? !descobs.equals(that.descobs) : that.descobs != null) return false;
        if (statusobs != null ? !statusobs.equals(that.statusobs) : that.statusobs != null)
            return false;
        return grupoObsId != null ? grupoObsId.equals(that.grupoObsId) : that.grupoObsId == null;

    }

    @Override
    public int hashCode() {
        int result = descobs != null ? descobs.hashCode() : 0;
        result = 31 * result + (statusobs != null ? statusobs.hashCode() : 0);
        result = 31 * result + (grupoObsId != null ? grupoObsId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Observacao{" +
                "descobs='" + descobs + '\'' +
                ", statusobs=" + statusobs +
                ", grupoObsId=" + grupoObsId +
                '}';
    }
}
