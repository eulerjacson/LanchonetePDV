package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.Produto;

import java.util.List;

/**
 * Created by Jacson on 06/05/2017.
 */

public interface IVendaPagerFragment {
    void montaRecyclerProduto(List<Produto> produtoList);
}
