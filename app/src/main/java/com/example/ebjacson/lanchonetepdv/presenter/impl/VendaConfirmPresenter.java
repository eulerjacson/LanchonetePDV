package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.presenter.IVendaConfirmPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IVendaConfirmActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.ebjacson.lanchonetepdv.util.Util.itemVendaList;

/**
 * Created by Jacson on 05/05/2017.
 */

public class VendaConfirmPresenter implements IVendaConfirmPresenter {

    private IVendaConfirmActivity iVendaConfirmActivity;

    public VendaConfirmPresenter() {
    }

    public VendaConfirmPresenter(IVendaConfirmActivity iVendaConfirmActivity) {
        this.iVendaConfirmActivity = iVendaConfirmActivity;
    }

    @Override
    public void carregarRecyclerItens() {
        iVendaConfirmActivity.montaRecyclerItens(itemVendaList, false);
    }

    @Override
    public void carregarRecyclerItensValores() {
        iVendaConfirmActivity.montaRecyclerItens(itemVendaList, true);
    }

    @Override
    public void atualizarValoresVenda(Venda venda, List<ItemVenda> itemVendaList) {
        Double acresc = 0.0, subtot = 0.0, total = 0.0;
        for (ItemVenda itemVenda : itemVendaList) {
            acresc += venda.getVlracresven() + itemVenda.getVlracresitven();
            subtot += venda.getVlrsubtotven() + itemVenda.getVlrsubtotitven();
            total += venda.getVlrtotalven() + itemVenda.getVlrtotalitven();
        }
        venda.setVlracresven(acresc);
        venda.setVlrsubtotven(subtot);
        venda.setVlrtotalven(total);
        Util.venda = venda;
    }

    @Override
    public void salvarItens(Venda venda, List<ItemVenda> itemVendaList, List<IngItVenda> ingItVendaList, List<ObsItVenda> obsItVendaList) {
        venda.save();
        for (ItemVenda itemVenda : itemVendaList) {
            itemVenda.setStatusitven(true);
            itemVenda.save();
        }
        for (IngItVenda ingItVenda : ingItVendaList) {
            ingItVenda.save();
        }
        for (ObsItVenda obsItVenda : obsItVendaList) {
            obsItVenda.save();
        }
        iVendaConfirmActivity.chamaMapaMesasActivity();
    }

    @Override
    public void limparVenda() {
        Util.venda = null;
        Util.itemVendaList = null;
        Util.ingItVendaList = null;
        Util.obsItVendaList = null;
    }

    @Override
    public void limparItens() {
        Util.itemVendaList = new ArrayList<>();
        Util.ingItVendaList = new ArrayList<>();
        Util.obsItVendaList = new ArrayList<>();
    }
}
