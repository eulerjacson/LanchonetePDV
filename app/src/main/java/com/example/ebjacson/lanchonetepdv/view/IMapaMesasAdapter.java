package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.Mesas;

/**
 * Created by Jacson on 05/05/2017.
 */

public interface IMapaMesasAdapter {
    void callVendaActivity(Long id);
    void criaVenda(Mesas id);
    void mudaStatusOcupadoMesa(Mesas id);
    void callVendaDetalhesActivity(Mesas id);
}
