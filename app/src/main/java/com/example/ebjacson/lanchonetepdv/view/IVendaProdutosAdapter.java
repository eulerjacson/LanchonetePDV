package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.Produto;

/**
 * Created by Jacson on 12/05/2017.
 */

public interface IVendaProdutosAdapter {
    String criaAdicionaItem(boolean ehPrimeiro, Produto produto);
    String removeDiminuiItem(Produto produto);
    String recuperItemTab(Produto produto);
    void abreDialogDetalhes(Produto produto);
}
