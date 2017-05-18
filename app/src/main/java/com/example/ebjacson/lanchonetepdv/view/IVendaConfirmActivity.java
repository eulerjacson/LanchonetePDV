package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.ItemVenda;

import java.util.List;

/**
 * Created by Jacson on 12/05/2017.
 */

public interface IVendaConfirmActivity {
    void montaRecyclerItens(List<ItemVenda> itemVendaList);
    void chamaMapaMesasActivity();
}
