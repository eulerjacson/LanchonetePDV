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
public class Ingrediente extends SugarRecord<Ingrediente> implements Serializable {

    private String descing;
    private Boolean statusing;
    private GrupoIng grupoIngId;

    public Ingrediente() {
    }

    public String getDescing() {
        return descing;
    }

    public void setDescing(String descing) {
        this.descing = descing;
    }

    public Boolean getStatusing() {
        return statusing;
    }

    public void setStatusing(Boolean statusing) {
        this.statusing = statusing;
    }

    public GrupoIng getGrupoIngId() {
        return grupoIngId;
    }

    public void setGrupoIngId(GrupoIng grupoIngId) {
        this.grupoIngId = grupoIngId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingrediente that = (Ingrediente) o;

        if (descing != null ? !descing.equals(that.descing) : that.descing != null) return false;
        if (statusing != null ? !statusing.equals(that.statusing) : that.statusing != null)
            return false;
        return grupoIngId != null ? grupoIngId.equals(that.grupoIngId) : that.grupoIngId == null;

    }

    @Override
    public int hashCode() {
        int result = descing != null ? descing.hashCode() : 0;
        result = 31 * result + (statusing != null ? statusing.hashCode() : 0);
        result = 31 * result + (grupoIngId != null ? grupoIngId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "descing='" + descing + '\'' +
                ", statusing=" + statusing +
                ", grupoIngId=" + grupoIngId +
                '}';
    }
}
