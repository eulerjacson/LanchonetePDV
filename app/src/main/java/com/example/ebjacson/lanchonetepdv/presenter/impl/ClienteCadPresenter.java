package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.presenter.IClienteCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IClienteCad;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ClienteCadPresenter implements IClienteCadPresenter {

    private IClienteCad iClienteCad;

    public ClienteCadPresenter(IClienteCad iClienteCad) {
        this.iClienteCad = iClienteCad;
    }

    @Override
    public void buscarEstadoList() {
        iClienteCad.montaSpinnerEstado(Estado.listAll(Estado.class));
    }

    @Override
    public void buscarCidadeList(Long idEst) {
        iClienteCad.montaSpinnerCidade(Cidade.find(Cidade.class, "estado_id = ?", idEst.toString()));
    }
}
