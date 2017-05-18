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
public class ContaReceber extends SugarRecord<ContaReceber> implements Serializable {

    private Date dataconrec;
    private Double vlrsubtotconrec;
    private Double vlrdescontoconrec;
    private Double vlrtotalconrec;
    private Cliente clienteId;
    private Usuario usuarioId;
    private Venda vendaId;

    public ContaReceber() {
    }

    public Date getDataconrec() {
        return dataconrec;
    }

    public void setDataconrec(Date dataconrec) {
        this.dataconrec = dataconrec;
    }

    public Double getVlrsubtotconrec() {
        return vlrsubtotconrec;
    }

    public void setVlrsubtotconrec(Double vlrsubtotconrec) {
        this.vlrsubtotconrec = vlrsubtotconrec;
    }

    public Double getVlrdescontoconrec() {
        return vlrdescontoconrec;
    }

    public void setVlrdescontoconrec(Double vlrdescontoconrec) {
        this.vlrdescontoconrec = vlrdescontoconrec;
    }

    public Double getVlrtotalconrec() {
        return vlrtotalconrec;
    }

    public void setVlrtotalconrec(Double vlrtotalconrec) {
        this.vlrtotalconrec = vlrtotalconrec;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContaReceber that = (ContaReceber) o;

        if (dataconrec != null ? !dataconrec.equals(that.dataconrec) : that.dataconrec != null)
            return false;
        if (vlrsubtotconrec != null ? !vlrsubtotconrec.equals(that.vlrsubtotconrec) : that.vlrsubtotconrec != null)
            return false;
        if (vlrdescontoconrec != null ? !vlrdescontoconrec.equals(that.vlrdescontoconrec) : that.vlrdescontoconrec != null)
            return false;
        if (vlrtotalconrec != null ? !vlrtotalconrec.equals(that.vlrtotalconrec) : that.vlrtotalconrec != null)
            return false;
        if (clienteId != null ? !clienteId.equals(that.clienteId) : that.clienteId != null)
            return false;
        if (usuarioId != null ? !usuarioId.equals(that.usuarioId) : that.usuarioId != null)
            return false;
        return vendaId != null ? vendaId.equals(that.vendaId) : that.vendaId == null;

    }

    @Override
    public int hashCode() {
        int result = dataconrec != null ? dataconrec.hashCode() : 0;
        result = 31 * result + (vlrsubtotconrec != null ? vlrsubtotconrec.hashCode() : 0);
        result = 31 * result + (vlrdescontoconrec != null ? vlrdescontoconrec.hashCode() : 0);
        result = 31 * result + (vlrtotalconrec != null ? vlrtotalconrec.hashCode() : 0);
        result = 31 * result + (clienteId != null ? clienteId.hashCode() : 0);
        result = 31 * result + (usuarioId != null ? usuarioId.hashCode() : 0);
        result = 31 * result + (vendaId != null ? vendaId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContaReceber{" +
                "dataconrec=" + dataconrec +
                ", vlrsubtotconrec=" + vlrsubtotconrec +
                ", vlrdescontoconrec=" + vlrdescontoconrec +
                ", vlrtotalconrec=" + vlrtotalconrec +
                ", clienteId=" + clienteId +
                ", usuarioId=" + usuarioId +
                ", vendaId=" + vendaId +
                '}';
    }
}
