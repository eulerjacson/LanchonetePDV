package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IIngCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class IngCadPresenter implements ICadsPresenter {

    private IIngCad iIngCad;

    public IngCadPresenter(IIngCad iIngCad) {
        this.iIngCad = iIngCad;
    }

    @Override
    public void buscarObjectList() {
        iIngCad.montaRecyclerIngrediente(Ingrediente.listAll(Ingrediente.class));
    }
}
