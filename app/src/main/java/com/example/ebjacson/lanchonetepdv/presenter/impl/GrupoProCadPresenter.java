package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IGrupoProCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class GrupoProCadPresenter implements ICadsPresenter {

    private IGrupoProCad iGrupoProCad;

    public GrupoProCadPresenter(IGrupoProCad iGrupoProCad) {
        this.iGrupoProCad = iGrupoProCad;
    }

    @Override
    public void buscarObjectList() {
        iGrupoProCad.montaRecyclerGrupoPro(GrupoProduto.listAll(GrupoProduto.class));
    }
}
