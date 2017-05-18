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
public class IngItVenda extends SugarRecord<IngItVenda> implements Serializable {

    private Ingrediente ingredienteId;
    private ItemVenda itemVendaId;

    public IngItVenda() {
    }

    public Ingrediente getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Ingrediente ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public ItemVenda getItemVendaId() {
        return itemVendaId;
    }

    public void setItemVendaId(ItemVenda itemVendaId) {
        this.itemVendaId = itemVendaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngItVenda that = (IngItVenda) o;

        if (ingredienteId != null ? !ingredienteId.equals(that.ingredienteId) : that.ingredienteId != null)
            return false;
        return itemVendaId != null ? itemVendaId.equals(that.itemVendaId) : that.itemVendaId == null;

    }

    @Override
    public int hashCode() {
        int result = ingredienteId != null ? ingredienteId.hashCode() : 0;
        result = 31 * result + (itemVendaId != null ? itemVendaId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IngItVenda{" +
                "ingredienteId=" + ingredienteId +
                ", itemVendaId=" + itemVendaId +
                '}';
    }
}
