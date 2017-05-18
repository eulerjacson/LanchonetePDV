package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.view.IVendaActivity;

/**
 * Created by Jacson on 05/05/2017.
 */

public class VendaPresenter implements com.example.ebjacson.lanchonetepdv.presenter.IVendaPresenter {

    private IVendaActivity iVendaActivity;

    public VendaPresenter(IVendaActivity iVendaActivity) {
        this.iVendaActivity = iVendaActivity;
    }

    @Override
    public void carregarPagerTab() {
        iVendaActivity.montaPagerTab(GrupoProduto.listAll(GrupoProduto.class));
    }
}
