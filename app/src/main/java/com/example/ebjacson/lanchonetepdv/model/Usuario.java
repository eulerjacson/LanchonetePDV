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
public class Usuario extends SugarRecord<Usuario> implements Serializable {

    private String usuario;
    private String senha;

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario1 = (Usuario) o;

        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null)
            return false;
        return senha != null ? senha.equals(usuario1.senha) : usuario1.senha == null;

    }

    @Override
    public int hashCode() {
        int result = usuario != null ? usuario.hashCode() : 0;
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
