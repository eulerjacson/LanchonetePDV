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
public class Recebimento extends SugarRecord<Recebimento> implements Serializable {

    private Double valorfinalrec;
    private Double jurorec;
    private Double multarec;
    private Double desconrec;
    private ContaReceber contaReceberId;
    private ParcelaReceber parcelaReceberId;

    public Recebimento() {
    }

    public Double getValorfinalrec() {
        return valorfinalrec;
    }

    public void setValorfinalrec(Double valorfinalrec) {
        this.valorfinalrec = valorfinalrec;
    }

    public Double getJurorec() {
        return jurorec;
    }

    public void setJurorec(Double jurorec) {
        this.jurorec = jurorec;
    }

    public Double getMultarec() {
        return multarec;
    }

    public void setMultarec(Double multarec) {
        this.multarec = multarec;
    }

    public Double getDesconrec() {
        return desconrec;
    }

    public void setDesconrec(Double desconrec) {
        this.desconrec = desconrec;
    }

    public ContaReceber getContaReceberId() {
        return contaReceberId;
    }

    public void setContaReceberId(ContaReceber contaReceberId) {
        this.contaReceberId = contaReceberId;
    }

    public ParcelaReceber getParcelaReceberId() {
        return parcelaReceberId;
    }

    public void setParcelaReceberId(ParcelaReceber parcelaReceberId) {
        this.parcelaReceberId = parcelaReceberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recebimento that = (Recebimento) o;

        if (valorfinalrec != null ? !valorfinalrec.equals(that.valorfinalrec) : that.valorfinalrec != null)
            return false;
        if (jurorec != null ? !jurorec.equals(that.jurorec) : that.jurorec != null) return false;
        if (multarec != null ? !multarec.equals(that.multarec) : that.multarec != null)
            return false;
        if (desconrec != null ? !desconrec.equals(that.desconrec) : that.desconrec != null)
            return false;
        if (contaReceberId != null ? !contaReceberId.equals(that.contaReceberId) : that.contaReceberId != null)
            return false;
        return parcelaReceberId != null ? parcelaReceberId.equals(that.parcelaReceberId) : that.parcelaReceberId == null;

    }

    @Override
    public int hashCode() {
        int result = valorfinalrec != null ? valorfinalrec.hashCode() : 0;
        result = 31 * result + (jurorec != null ? jurorec.hashCode() : 0);
        result = 31 * result + (multarec != null ? multarec.hashCode() : 0);
        result = 31 * result + (desconrec != null ? desconrec.hashCode() : 0);
        result = 31 * result + (contaReceberId != null ? contaReceberId.hashCode() : 0);
        result = 31 * result + (parcelaReceberId != null ? parcelaReceberId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recebimento{" +
                "valorfinalrec=" + valorfinalrec +
                ", jurorec=" + jurorec +
                ", multarec=" + multarec +
                ", desconrec=" + desconrec +
                ", contaReceberId=" + contaReceberId +
                ", parcelaReceberId=" + parcelaReceberId +
                '}';
    }
}
