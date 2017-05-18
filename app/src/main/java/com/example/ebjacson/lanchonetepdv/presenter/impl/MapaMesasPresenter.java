package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.view.IMapaMesasActivity;

/**
 * Created by Jacson on 05/05/2017.
 */

public class MapaMesasPresenter implements com.example.ebjacson.lanchonetepdv.presenter.IMapaMesasPresenter {

    private IMapaMesasActivity iMapaMesasActivity;

    public MapaMesasPresenter(IMapaMesasActivity iMapaMesasActivity) {
        this.iMapaMesasActivity = iMapaMesasActivity;
    }

    @Override
    public void carregarGridView() {
        iMapaMesasActivity.montaGridView(Mesas.listAll(Mesas.class));
    }
}
