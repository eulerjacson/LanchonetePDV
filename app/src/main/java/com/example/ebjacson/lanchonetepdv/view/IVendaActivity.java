package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;

import java.util.List;

/**
 * Created by Jacson on 06/05/2017.
 */

public interface IVendaActivity {
    void montaPagerTab(List<GrupoProduto> grupoProdutoList);
    void callVendaConfirmActivity();
}
