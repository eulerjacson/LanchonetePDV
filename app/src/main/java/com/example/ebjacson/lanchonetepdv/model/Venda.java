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
public class Venda extends SugarRecord<Venda> implements Serializable {

    private Date dataven;
    private Double vlrdescven;
    private Double vlracresven;
    private Double vlrsubtotven;
    private Double vlrtotalven;
    private Boolean statusven;
    private Cliente clienteId;
    private Mesas mesasId;
    private Usuario usuarioId;

    public Venda() {
    }

    public Date getDataven() {
        return dataven;
    }

    public void setDataven(Date dataven) {
        this.dataven = dataven;
    }

    public Double getVlrdescven() {
        return vlrdescven;
    }

    public void setVlrdescven(Double vlrdescven) {
        this.vlrdescven = vlrdescven;
    }

    public Double getVlracresven() {
        return vlracresven;
    }

    public void setVlracresven(Double vlracresven) {
        this.vlracresven = vlracresven;
    }

    public Double getVlrsubtotven() {
        return vlrsubtotven;
    }

    public void setVlrsubtotven(Double vlrsubtotven) {
        this.vlrsubtotven = vlrsubtotven;
    }

    public Double getVlrtotalven() {
        return vlrtotalven;
    }

    public void setVlrtotalven(Double vlrtotalven) {
        this.vlrtotalven = vlrtotalven;
    }

    public Boolean getStatusven() {
        return statusven;
    }

    public void setStatusven(Boolean statusven) {
        this.statusven = statusven;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Mesas getMesasId() {
        return mesasId;
    }

    public void setMesasId(Mesas mesasId) {
        this.mesasId = mesasId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venda venda = (Venda) o;

        if (dataven != null ? !dataven.equals(venda.dataven) : venda.dataven != null) return false;
        if (vlrdescven != null ? !vlrdescven.equals(venda.vlrdescven) : venda.vlrdescven != null)
            return false;
        if (vlracresven != null ? !vlracresven.equals(venda.vlracresven) : venda.vlracresven != null)
            return false;
        if (vlrsubtotven != null ? !vlrsubtotven.equals(venda.vlrsubtotven) : venda.vlrsubtotven != null)
            return false;
        if (vlrtotalven != null ? !vlrtotalven.equals(venda.vlrtotalven) : venda.vlrtotalven != null)
            return false;
        if (statusven != null ? !statusven.equals(venda.statusven) : venda.statusven != null)
            return false;
        if (clienteId != null ? !clienteId.equals(venda.clienteId) : venda.clienteId != null)
            return false;
        if (mesasId != null ? !mesasId.equals(venda.mesasId) : venda.mesasId != null) return false;
        return usuarioId != null ? usuarioId.equals(venda.usuarioId) : venda.usuarioId == null;

    }

    @Override
    public int hashCode() {
        int result = dataven != null ? dataven.hashCode() : 0;
        result = 31 * result + (vlrdescven != null ? vlrdescven.hashCode() : 0);
        result = 31 * result + (vlracresven != null ? vlracresven.hashCode() : 0);
        result = 31 * result + (vlrsubtotven != null ? vlrsubtotven.hashCode() : 0);
        result = 31 * result + (vlrtotalven != null ? vlrtotalven.hashCode() : 0);
        result = 31 * result + (statusven != null ? statusven.hashCode() : 0);
        result = 31 * result + (clienteId != null ? clienteId.hashCode() : 0);
        result = 31 * result + (mesasId != null ? mesasId.hashCode() : 0);
        result = 31 * result + (usuarioId != null ? usuarioId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "dataven=" + dataven +
                ", vlrdescven=" + vlrdescven +
                ", vlracresven=" + vlracresven +
                ", vlrsubtotven=" + vlrsubtotven +
                ", vlrtotalven=" + vlrtotalven +
                ", statusven=" + statusven +
                ", clienteId=" + clienteId +
                ", mesasId=" + mesasId +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
