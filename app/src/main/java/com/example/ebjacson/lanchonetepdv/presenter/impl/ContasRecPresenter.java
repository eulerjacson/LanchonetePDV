package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.ParcelaReceber;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IContasRecActivity;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ContasRecPresenter implements ICadsPresenter {

    private IContasRecActivity iContasRecActivity;

    public ContasRecPresenter(IContasRecActivity iContasRecActivity) {
        this.iContasRecActivity = iContasRecActivity;
    }

    @Override
    public void buscarObjectList() {
        iContasRecActivity.montaRecyclerParcelaReceber(ParcelaReceber.find(ParcelaReceber.class, "statusparrec = ?", "0"));
    }
}
