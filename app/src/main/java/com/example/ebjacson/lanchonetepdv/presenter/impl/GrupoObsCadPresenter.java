package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IGrupoObsCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class GrupoObsCadPresenter implements ICadsPresenter {

    private IGrupoObsCad iGrupoObsCad;

    public GrupoObsCadPresenter(IGrupoObsCad iGrupoObsCad) {
        this.iGrupoObsCad = iGrupoObsCad;
    }

    @Override
    public void buscarObjectList() {
        iGrupoObsCad.montaRecyclerGrupoObs(GrupoObs.listAll(GrupoObs.class));
    }
}
