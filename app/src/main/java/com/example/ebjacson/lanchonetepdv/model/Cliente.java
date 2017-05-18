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
public class Cliente extends SugarRecord<Cliente> implements Serializable {

    private String nomecli;
    private String emailcli;
    private String cpfcli;
    private String telefonecli;
    private String ruacli;
    private String numerocli;
    private String bairrocli;
    private Boolean statuscli;
    private Cidade cidadeId;

    public Cliente() {
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }

    public String getCpfcli() {
        return cpfcli;
    }

    public void setCpfcli(String cpfcli) {
        this.cpfcli = cpfcli;
    }

    public String getTelefonecli() {
        return telefonecli;
    }

    public void setTelefonecli(String telefonecli) {
        this.telefonecli = telefonecli;
    }

    public String getRuacli() {
        return ruacli;
    }

    public void setRuacli(String ruacli) {
        this.ruacli = ruacli;
    }

    public String getNumerocli() {
        return numerocli;
    }

    public void setNumerocli(String numerocli) {
        this.numerocli = numerocli;
    }

    public String getBairrocli() {
        return bairrocli;
    }

    public void setBairrocli(String bairrocli) {
        this.bairrocli = bairrocli;
    }

    public Boolean getStatuscli() {
        return statuscli;
    }

    public void setStatuscli(Boolean statuscli) {
        this.statuscli = statuscli;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (nomecli != null ? !nomecli.equals(cliente.nomecli) : cliente.nomecli != null)
            return false;
        if (emailcli != null ? !emailcli.equals(cliente.emailcli) : cliente.emailcli != null)
            return false;
        if (cpfcli != null ? !cpfcli.equals(cliente.cpfcli) : cliente.cpfcli != null) return false;
        if (telefonecli != null ? !telefonecli.equals(cliente.telefonecli) : cliente.telefonecli != null)
            return false;
        if (ruacli != null ? !ruacli.equals(cliente.ruacli) : cliente.ruacli != null) return false;
        if (numerocli != null ? !numerocli.equals(cliente.numerocli) : cliente.numerocli != null)
            return false;
        if (bairrocli != null ? !bairrocli.equals(cliente.bairrocli) : cliente.bairrocli != null)
            return false;
        if (statuscli != null ? !statuscli.equals(cliente.statuscli) : cliente.statuscli != null)
            return false;
        return cidadeId != null ? cidadeId.equals(cliente.cidadeId) : cliente.cidadeId == null;

    }

    @Override
    public int hashCode() {
        int result = nomecli != null ? nomecli.hashCode() : 0;
        result = 31 * result + (emailcli != null ? emailcli.hashCode() : 0);
        result = 31 * result + (cpfcli != null ? cpfcli.hashCode() : 0);
        result = 31 * result + (telefonecli != null ? telefonecli.hashCode() : 0);
        result = 31 * result + (ruacli != null ? ruacli.hashCode() : 0);
        result = 31 * result + (numerocli != null ? numerocli.hashCode() : 0);
        result = 31 * result + (bairrocli != null ? bairrocli.hashCode() : 0);
        result = 31 * result + (statuscli != null ? statuscli.hashCode() : 0);
        result = 31 * result + (cidadeId != null ? cidadeId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomecli='" + nomecli + '\'' +
                ", emailcli='" + emailcli + '\'' +
                ", cpfcli='" + cpfcli + '\'' +
                ", telefonecli='" + telefonecli + '\'' +
                ", ruacli='" + ruacli + '\'' +
                ", numerocli='" + numerocli + '\'' +
                ", bairrocli='" + bairrocli + '\'' +
                ", statuscli=" + statuscli +
                ", cidadeId=" + cidadeId +
                '}';
    }
}
