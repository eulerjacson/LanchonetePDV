/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ebjacson.lanchonetepdv.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jacson
 */
public class Caixa extends SugarRecord<Caixa> implements Serializable  {

    private Date dataabcai;
    private Date datafccai;
    private Double vlrabcai;
    private Double vlrfccai;
    private Boolean statuscai;

    public Caixa() {
    }

    public Date getDataabcai() {
        return dataabcai;
    }

    public void setDataabcai(Date dataabcai) {
        this.dataabcai = dataabcai;
    }

    public Date getDatafccai() {
        return datafccai;
    }

    public void setDatafccai(Date datafccai) {
        this.datafccai = datafccai;
    }

    public Double getVlrabcai() {
        return vlrabcai;
    }

    public void setVlrabcai(Double vlrabcai) {
        this.vlrabcai = vlrabcai;
    }

    public Double getVlrfccai() {
        return vlrfccai;
    }

    public void setVlrfccai(Double vlrfccai) {
        this.vlrfccai = vlrfccai;
    }

    public Boolean getStatuscai() {
        return statuscai;
    }

    public void setStatuscai(Boolean statuscai) {
        this.statuscai = statuscai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Caixa caixa = (Caixa) o;

        if (dataabcai != null ? !dataabcai.equals(caixa.dataabcai) : caixa.dataabcai != null)
            return false;
        if (datafccai != null ? !datafccai.equals(caixa.datafccai) : caixa.datafccai != null)
            return false;
        if (vlrabcai != null ? !vlrabcai.equals(caixa.vlrabcai) : caixa.vlrabcai != null)
            return false;
        if (vlrfccai != null ? !vlrfccai.equals(caixa.vlrfccai) : caixa.vlrfccai != null)
            return false;
        return statuscai != null ? statuscai.equals(caixa.statuscai) : caixa.statuscai == null;

    }

    @Override
    public int hashCode() {
        int result = dataabcai != null ? dataabcai.hashCode() : 0;
        result = 31 * result + (datafccai != null ? datafccai.hashCode() : 0);
        result = 31 * result + (vlrabcai != null ? vlrabcai.hashCode() : 0);
        result = 31 * result + (vlrfccai != null ? vlrfccai.hashCode() : 0);
        result = 31 * result + (statuscai != null ? statuscai.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Caixa{" +
                "id=" + id +
                ", dataabcai=" + dataabcai +
                ", datafccai=" + datafccai +
                ", vlrabcai=" + vlrabcai +
                ", vlrfccai=" + vlrfccai +
                ", statuscai=" + statuscai +
                '}';
    }
}
