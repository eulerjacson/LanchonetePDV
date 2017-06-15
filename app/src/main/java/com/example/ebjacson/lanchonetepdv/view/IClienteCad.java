package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.model.Estado;

import java.util.List;

/**
 * Created by Jacson on 15/06/2017.
 */

public interface IClienteCad {
    void saveObject();
    void delObject();
    void callClienteList();
    void montaCliTela();
    void montaSpinnerEstado(List<Estado> estadoList);
    void montaSpinnerCidade(List<Cidade> cidadeList);
}
