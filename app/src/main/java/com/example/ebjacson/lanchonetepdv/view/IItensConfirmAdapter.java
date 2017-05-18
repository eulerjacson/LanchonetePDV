package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.ItemVenda;

/**
 * Created by Jacson on 12/05/2017.
 */

public interface IItensConfirmAdapter {
    String adicionaQtdItem(ItemVenda iv);
    String removeDiminuiQtdItem(ItemVenda iv);
    String recuperItemTab(ItemVenda iv);
}
