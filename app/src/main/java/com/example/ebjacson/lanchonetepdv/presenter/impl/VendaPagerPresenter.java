package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.view.IVendaPagerFragment;

/**
 * Created by Jacson on 05/05/2017.
 */

public class VendaPagerPresenter implements com.example.ebjacson.lanchonetepdv.presenter.IVendaPagerPresenter {

    private IVendaPagerFragment iVendaPagerFragment;

    public VendaPagerPresenter(IVendaPagerFragment iVendaPagerFragment) {
        this.iVendaPagerFragment = iVendaPagerFragment;
    }

    @Override
    public void carregarRecyclerProduto(Long idGrupo) {
        iVendaPagerFragment.montaRecyclerProduto(Produto.find(Produto.class, "grupo_produto_id = ?", String.valueOf(idGrupo)));
    }
}
