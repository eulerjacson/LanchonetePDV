package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Cliente;
import com.example.ebjacson.lanchonetepdv.presenter.ICadsPresenter;
import com.example.ebjacson.lanchonetepdv.view.IClienteList;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ClienteListPresenter implements ICadsPresenter {

    private IClienteList iClienteList;

    public ClienteListPresenter(IClienteList iClienteList) {
        this.iClienteList = iClienteList;
    }

    @Override
    public void buscarObjectList() {
        iClienteList.montaRecyclerCliente(Cliente.listAll(Cliente.class));
    }
}
