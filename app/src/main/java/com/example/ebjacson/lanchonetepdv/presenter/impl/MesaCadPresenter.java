package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IMesasCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class MesaCadPresenter implements ICadsPresenter {

    private IMesasCad iMesasCad;

    public MesaCadPresenter(IMesasCad iMesasCad) {
        this.iMesasCad = iMesasCad;
    }

    @Override
    public void buscarObjectList() {
        iMesasCad.montaRecyclerMesas(Mesas.listAll(Mesas.class));
    }
}
