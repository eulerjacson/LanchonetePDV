package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IObsCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ObsCadPresenter implements ICadsPresenter {

    private IObsCad iObsCad;

    public ObsCadPresenter(IObsCad iObsCad) {
        this.iObsCad = iObsCad;
    }

    @Override
    public void buscarObjectList() {
        iObsCad.montaRecyclerObs(Observacao.listAll(Observacao.class));
    }
}
