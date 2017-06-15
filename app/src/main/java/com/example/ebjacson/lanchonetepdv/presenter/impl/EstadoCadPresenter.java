package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IEstadoCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class EstadoCadPresenter implements ICadsPresenter {

    private IEstadoCad iEstadoCad;

    public EstadoCadPresenter(IEstadoCad iEstadoCad) {
        this.iEstadoCad = iEstadoCad;
    }

    @Override
    public void buscarObjectList() {
        iEstadoCad.montaRecyclerEstado(Estado.listAll(Estado.class));
    }
}
