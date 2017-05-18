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
public class ObsItVenda extends SugarRecord<ObsItVenda> implements Serializable {

    private ItemVenda itemVendaId;
    private Observacao observacaoId;

    public ObsItVenda() {
    }

    public ItemVenda getItemVendaId() {
        return itemVendaId;
    }

    public void setItemVendaId(ItemVenda itemVendaId) {
        this.itemVendaId = itemVendaId;
    }

    public Observacao getObservacaoId() {
        return observacaoId;
    }

    public void setObservacaoId(Observacao observacaoId) {
        this.observacaoId = observacaoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObsItVenda that = (ObsItVenda) o;

        if (itemVendaId != null ? !itemVendaId.equals(that.itemVendaId) : that.itemVendaId != null)
            return false;
        return observacaoId != null ? observacaoId.equals(that.observacaoId) : that.observacaoId == null;

    }

    @Override
    public int hashCode() {
        int result = itemVendaId != null ? itemVendaId.hashCode() : 0;
        result = 31 * result + (observacaoId != null ? observacaoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ObsItVenda{" +
                "itemVendaId=" + itemVendaId +
                ", observacaoId=" + observacaoId +
                '}';
    }
}
