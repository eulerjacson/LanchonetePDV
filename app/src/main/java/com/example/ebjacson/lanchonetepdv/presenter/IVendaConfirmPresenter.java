package com.example.ebjacson.lanchonetepdv.presenter;

import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.Venda;

import java.util.List;

/**
 * Created by Jacson on 05/05/2017.
 */

public interface IVendaConfirmPresenter {
    void carregarRecyclerItens();
    void atualizarValoresVenda(Venda venda, List<ItemVenda> itemVendaList);
    void salvarItens(Venda venda, List<ItemVenda> itemVendaList);
    void limparVenda();
}
