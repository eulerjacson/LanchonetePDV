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
public class ParcelaReceber extends SugarRecord<ParcelaReceber> implements Serializable {

    private Date dataparrec;
    private Double juroparrec;
    private Double descontoparrec;
    private Double multaparrec;
    private Double valorparrec;
    private ContaReceber contaReceberId;
    private Boolean statusparrec;

    public ParcelaReceber() {
    }

    public Date getDataparrec() {
        return dataparrec;
    }

    public void setDataparrec(Date dataparrec) {
        this.dataparrec = dataparrec;
    }

    public Double getJuroparrec() {
        return juroparrec;
    }

    public void setJuroparrec(Double juroparrec) {
        this.juroparrec = juroparrec;
    }

    public Double getDescontoparrec() {
        return descontoparrec;
    }

    public void setDescontoparrec(Double descontoparrec) {
        this.descontoparrec = descontoparrec;
    }

    public Double getMultaparrec() {
        return multaparrec;
    }

    public void setMultaparrec(Double multaparrec) {
        this.multaparrec = multaparrec;
    }

    public Double getValorparrec() {
        return valorparrec;
    }

    public void setValorparrec(Double valorparrec) {
        this.valorparrec = valorparrec;
    }

    public ContaReceber getContaReceberId() {
        return contaReceberId;
    }

    public void setContaReceberId(ContaReceber contaReceberId) {
        this.contaReceberId = contaReceberId;
    }

    public Boolean getStatusparrec() {
        return statusparrec;
    }

    public void setStatusparrec(Boolean statusparrec) {
        this.statusparrec = statusparrec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParcelaReceber that = (ParcelaReceber) o;

        if (dataparrec != null ? !dataparrec.equals(that.dataparrec) : that.dataparrec != null)
            return false;
        if (juroparrec != null ? !juroparrec.equals(that.juroparrec) : that.juroparrec != null)
            return false;
        if (descontoparrec != null ? !descontoparrec.equals(that.descontoparrec) : that.descontoparrec != null)
            return false;
        if (multaparrec != null ? !multaparrec.equals(that.multaparrec) : that.multaparrec != null)
            return false;
        if (valorparrec != null ? !valorparrec.equals(that.valorparrec) : that.valorparrec != null)
            return false;
        if (contaReceberId != null ? !contaReceberId.equals(that.contaReceberId) : that.contaReceberId != null)
            return false;
        return statusparrec != null ? statusparrec.equals(that.statusparrec) : that.statusparrec == null;

    }

    @Override
    public int hashCode() {
        int result = dataparrec != null ? dataparrec.hashCode() : 0;
        result = 31 * result + (juroparrec != null ? juroparrec.hashCode() : 0);
        result = 31 * result + (descontoparrec != null ? descontoparrec.hashCode() : 0);
        result = 31 * result + (multaparrec != null ? multaparrec.hashCode() : 0);
        result = 31 * result + (valorparrec != null ? valorparrec.hashCode() : 0);
        result = 31 * result + (contaReceberId != null ? contaReceberId.hashCode() : 0);
        result = 31 * result + (statusparrec != null ? statusparrec.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParcelaReceber{" +
                "dataparrec=" + dataparrec +
                ", juroparrec=" + juroparrec +
                ", descontoparrec=" + descontoparrec +
                ", multaparrec=" + multaparrec +
                ", valorparrec=" + valorparrec +
                ", contaReceberId=" + contaReceberId +
                ", statusparrec=" + statusparrec +
                '}';
    }
}
