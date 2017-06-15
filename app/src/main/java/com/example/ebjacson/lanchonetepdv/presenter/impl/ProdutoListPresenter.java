package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IProdutoList;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ProdutoListPresenter implements ICadsPresenter {

    private IProdutoList iProdutoList;

    public ProdutoListPresenter(IProdutoList iProdutoList) {
        this.iProdutoList = iProdutoList;
    }

    @Override
    public void buscarObjectList() {
        iProdutoList.montaRecyclerProduto(Produto.listAll(Produto.class));
    }
}
