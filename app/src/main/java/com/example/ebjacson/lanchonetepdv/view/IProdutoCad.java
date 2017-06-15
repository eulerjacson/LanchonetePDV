package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;

import java.util.List;

/**
 * Created by Jacson on 15/06/2017.
 */

public interface IProdutoCad {
    void saveObject();
    void delObject();
    void callProdutoList();
    void montaProTela();
    void montaSpinnerGrupo(List<GrupoProduto> grupoProdutos);
    void abrirDialogIngObsPro(List<Object> objectList, List<Object> objectListProGru);
}
