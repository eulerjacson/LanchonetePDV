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
public class GrupoIng extends SugarRecord<GrupoIng> implements Serializable {

    private String descgruing;
    private Boolean statusgruing;

    public GrupoIng() {
    }

    public String getDescgruing() {
        return descgruing;
    }

    public void setDescgruing(String descgruing) {
        this.descgruing = descgruing;
    }

    public Boolean getStatusgruing() {
        return statusgruing;
    }

    public void setStatusgruing(Boolean statusgruing) {
        this.statusgruing = statusgruing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrupoIng grupoIng = (GrupoIng) o;

        if (descgruing != null ? !descgruing.equals(grupoIng.descgruing) : grupoIng.descgruing != null)
            return false;
        return statusgruing != null ? statusgruing.equals(grupoIng.statusgruing) : grupoIng.statusgruing == null;

    }

    @Override
    public int hashCode() {
        int result = descgruing != null ? descgruing.hashCode() : 0;
        result = 31 * result + (statusgruing != null ? statusgruing.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GrupoIng{" +
                "descgruing='" + descgruing + '\'' +
                ", statusgruing=" + statusgruing +
                '}';
    }
}
