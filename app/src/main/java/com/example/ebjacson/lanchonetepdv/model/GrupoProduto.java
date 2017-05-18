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
public class GrupoProduto extends SugarRecord<GrupoProduto> implements Serializable {

    private String descgrupo;
    private Boolean statusgrupo;

    public GrupoProduto() {
    }

    public String getDescgrupo() {
        return descgrupo;
    }

    public void setDescgrupo(String descgrupo) {
        this.descgrupo = descgrupo;
    }

    public Boolean getStatusgrupo() {
        return statusgrupo;
    }

    public void setStatusgrupo(Boolean statusgrupo) {
        this.statusgrupo = statusgrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrupoProduto that = (GrupoProduto) o;

        if (descgrupo != null ? !descgrupo.equals(that.descgrupo) : that.descgrupo != null)
            return false;
        return statusgrupo != null ? statusgrupo.equals(that.statusgrupo) : that.statusgrupo == null;

    }

    @Override
    public int hashCode() {
        int result = descgrupo != null ? descgrupo.hashCode() : 0;
        result = 31 * result + (statusgrupo != null ? statusgrupo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GrupoProduto{" +
                "descgrupo='" + descgrupo + '\'' +
                ", statusgrupo=" + statusgrupo +
                '}';
    }
}
