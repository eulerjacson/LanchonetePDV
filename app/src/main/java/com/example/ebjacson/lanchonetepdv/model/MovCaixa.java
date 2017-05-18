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
public class MovCaixa extends SugarRecord<MovCaixa> implements Serializable {

    private Date datamovcai;
    private Boolean tipomovcai;
    private Double vlrmovcai;
    private String descmovcaixa;
    private Integer tiporecmovcai;
    private Caixa caixaId;
    private Recebimento recebimentoId;

    public MovCaixa() {
    }

    public Date getDatamovcai() {
        return datamovcai;
    }

    public void setDatamovcai(Date datamovcai) {
        this.datamovcai = datamovcai;
    }

    public Boolean getTipomovcai() {
        return tipomovcai;
    }

    public void setTipomovcai(Boolean tipomovcai) {
        this.tipomovcai = tipomovcai;
    }

    public Double getVlrmovcai() {
        return vlrmovcai;
    }

    public void setVlrmovcai(Double vlrmovcai) {
        this.vlrmovcai = vlrmovcai;
    }

    public String getDescmovcaixa() {
        return descmovcaixa;
    }

    public void setDescmovcaixa(String descmovcaixa) {
        this.descmovcaixa = descmovcaixa;
    }

    public Integer getTiporecmovcai() {
        return tiporecmovcai;
    }

    public void setTiporecmovcai(Integer tiporecmovcai) {
        this.tiporecmovcai = tiporecmovcai;
    }

    public Caixa getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Caixa caixaId) {
        this.caixaId = caixaId;
    }

    public Recebimento getRecebimentoId() {
        return recebimentoId;
    }

    public void setRecebimentoId(Recebimento recebimentoId) {
        this.recebimentoId = recebimentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovCaixa movCaixa = (MovCaixa) o;

        if (datamovcai != null ? !datamovcai.equals(movCaixa.datamovcai) : movCaixa.datamovcai != null)
            return false;
        if (tipomovcai != null ? !tipomovcai.equals(movCaixa.tipomovcai) : movCaixa.tipomovcai != null)
            return false;
        if (vlrmovcai != null ? !vlrmovcai.equals(movCaixa.vlrmovcai) : movCaixa.vlrmovcai != null)
            return false;
        if (descmovcaixa != null ? !descmovcaixa.equals(movCaixa.descmovcaixa) : movCaixa.descmovcaixa != null)
            return false;
        if (tiporecmovcai != null ? !tiporecmovcai.equals(movCaixa.tiporecmovcai) : movCaixa.tiporecmovcai != null)
            return false;
        if (caixaId != null ? !caixaId.equals(movCaixa.caixaId) : movCaixa.caixaId != null)
            return false;
        return recebimentoId != null ? recebimentoId.equals(movCaixa.recebimentoId) : movCaixa.recebimentoId == null;

    }

    @Override
    public int hashCode() {
        int result = datamovcai != null ? datamovcai.hashCode() : 0;
        result = 31 * result + (tipomovcai != null ? tipomovcai.hashCode() : 0);
        result = 31 * result + (vlrmovcai != null ? vlrmovcai.hashCode() : 0);
        result = 31 * result + (descmovcaixa != null ? descmovcaixa.hashCode() : 0);
        result = 31 * result + (tiporecmovcai != null ? tiporecmovcai.hashCode() : 0);
        result = 31 * result + (caixaId != null ? caixaId.hashCode() : 0);
        result = 31 * result + (recebimentoId != null ? recebimentoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovCaixa{" +
                "datamovcai=" + datamovcai +
                ", tipomovcai=" + tipomovcai +
                ", vlrmovcai=" + vlrmovcai +
                ", descmovcaixa='" + descmovcaixa + '\'' +
                ", tiporecmovcai=" + tiporecmovcai +
                ", caixaId=" + caixaId +
                ", recebimentoId=" + recebimentoId +
                '}';
    }
}
