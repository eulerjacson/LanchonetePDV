package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IGrupoIngCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class GrupoIngCadPresenter implements ICadsPresenter {

    private IGrupoIngCad iGrupoIngCad;

    public GrupoIngCadPresenter(IGrupoIngCad iGrupoIngCad) {
        this.iGrupoIngCad = iGrupoIngCad;
    }

    @Override
    public void buscarObjectList() {
        iGrupoIngCad.montaRecyclerGrupoIng(GrupoIng.listAll(GrupoIng.class));
    }
}
