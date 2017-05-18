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
public class GrupoObs extends SugarRecord<GrupoObs> implements Serializable {

    private String descgruobs;
    private Boolean statusgruobs;

    public GrupoObs() {
    }

    public String getDescgruobs() {
        return descgruobs;
    }

    public void setDescgruobs(String descgruobs) {
        this.descgruobs = descgruobs;
    }

    public Boolean getStatusgruobs() {
        return statusgruobs;
    }

    public void setStatusgruobs(Boolean statusgruobs) {
        this.statusgruobs = statusgruobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrupoObs grupoObs = (GrupoObs) o;

        if (descgruobs != null ? !descgruobs.equals(grupoObs.descgruobs) : grupoObs.descgruobs != null)
            return false;
        return statusgruobs != null ? statusgruobs.equals(grupoObs.statusgruobs) : grupoObs.statusgruobs == null;

    }

    @Override
    public int hashCode() {
        int result = descgruobs != null ? descgruobs.hashCode() : 0;
        result = 31 * result + (statusgruobs != null ? statusgruobs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GrupoObs{" +
                "descgruobs='" + descgruobs + '\'' +
                ", statusgruobs=" + statusgruobs +
                '}';
    }
}
