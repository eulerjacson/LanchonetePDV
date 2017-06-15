package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.ICidadeCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class CidadeCadPresenter implements ICadsPresenter {

    private ICidadeCad iCidadeCad;

    public CidadeCadPresenter(ICidadeCad iCidadeCad) {
        this.iCidadeCad = iCidadeCad;
    }

    @Override
    public void buscarObjectList() {
        iCidadeCad.montaRecyclerCidade(Cidade.listAll(Cidade.class));
    }
}
