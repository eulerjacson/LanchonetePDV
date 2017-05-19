package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.ItemVenda;

import java.util.List;

/**
 * Created by Jacson on 12/05/2017.
 */

public interface IVendaDetalhesActivity {
    void montaRecyclerItens(List<ItemVenda> itemVendaList, Boolean ehValores);
    void chamaRecebimentoActivity();
}
