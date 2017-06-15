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
public class Mesas extends SugarRecord<Mesas> implements Serializable {

    private String descmesa;
    private Integer statusmesa;
    private Boolean mostrarmesa;

    public Mesas() {
    }


    public String getDescmesa() {
        return descmesa;
    }

    public void setDescmesa(String descmesa) {
        this.descmesa = descmesa;
    }

    public Integer getStatusmesa() {
        return statusmesa;
    }

    public void setStatusmesa(Integer statusmesa) {
        this.statusmesa = statusmesa;
    }

    public Boolean getMostrarmesa() {
        return mostrarmesa;
    }

    public void setMostrarmesa(Boolean mostrarmesa) {
        this.mostrarmesa = mostrarmesa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesas mesas = (Mesas) o;

        if (descmesa != null ? !descmesa.equals(mesas.descmesa) : mesas.descmesa != null)
            return false;
        if (statusmesa != null ? !statusmesa.equals(mesas.statusmesa) : mesas.statusmesa != null)
            return false;
        return mostrarmesa != null ? mostrarmesa.equals(mesas.mostrarmesa) : mesas.mostrarmesa == null;

    }

    @Override
    public int hashCode() {
        int result = descmesa != null ? descmesa.hashCode() : 0;
        result = 31 * result + (statusmesa != null ? statusmesa.hashCode() : 0);
        result = 31 * result + (mostrarmesa != null ? mostrarmesa.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mesas{" +
                "descmesa='" + descmesa + '\'' +
                ", statusmesa=" + statusmesa +
                ", mostrarmesa=" + mostrarmesa +
                '}';
    }
}
