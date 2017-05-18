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
public class Estado extends SugarRecord<Estado> implements Serializable {

    private String nomeest;
    private String siglaest;

    public Estado() {
    }

    public String getNomeest() {
        return nomeest;
    }

    public void setNomeest(String nomeest) {
        this.nomeest = nomeest;
    }

    public String getSiglaest() {
        return siglaest;
    }

    public void setSiglaest(String siglaest) {
        this.siglaest = siglaest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        if (nomeest != null ? !nomeest.equals(estado.nomeest) : estado.nomeest != null)
            return false;
        return siglaest != null ? siglaest.equals(estado.siglaest) : estado.siglaest == null;

    }

    @Override
    public int hashCode() {
        int result = nomeest != null ? nomeest.hashCode() : 0;
        result = 31 * result + (siglaest != null ? siglaest.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nomeest='" + nomeest + '\'' +
                ", siglaest='" + siglaest + '\'' +
                '}';
    }
}
