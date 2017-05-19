package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.view.adapters.ItensConfirmAdapter;

/**
 * Created by Jacson on 12/05/2017.
 */

public interface IItensConfirmAdapter {
    String adicionaQtdItem(ItemVenda iv);
    String removeDiminuiQtdItem(ItemVenda iv);
    String recuperItemTab(ItemVenda iv);
    void setIngTextView(ItensConfirmAdapter.ViewHolder viewHolder);
    void setObsTextView(ItensConfirmAdapter.ViewHolder viewHolder);
    void trataStatusBotao(ItemVenda dao, ItensConfirmAdapter.ViewHolder viewHolder);
    void mostraValores(ItensConfirmAdapter.ViewHolder viewHolder, ItemVenda dao);
}
