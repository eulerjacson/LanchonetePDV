/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ebjacson.lanchonetepdv.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jacson
 */
public class Cidade extends SugarRecord<Cidade> implements Serializable {

    private String nomecid;
    private Estado estadoId;

    public Cidade() {
    }

    public String getNomecid() {
        return nomecid;
    }

    public void setNomecid(String nomecid) {
        this.nomecid = nomecid;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        if (nomecid != null ? !nomecid.equals(cidade.nomecid) : cidade.nomecid != null)
            return false;
        return estadoId != null ? estadoId.equals(cidade.estadoId) : cidade.estadoId == null;

    }

    @Override
    public int hashCode() {
        int result = nomecid != null ? nomecid.hashCode() : 0;
        result = 31 * result + (estadoId != null ? estadoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nomecid='" + nomecid + '\'' +
                ", estadoId=" + estadoId +
                '}';
    }
}
