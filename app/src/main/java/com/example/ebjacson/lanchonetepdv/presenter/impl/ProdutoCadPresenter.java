package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.ProGruIng;
import com.example.ebjacson.lanchonetepdv.model.ProGruObs;
import com.example.ebjacson.lanchonetepdv.presenter.IProdutoCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IProdutoCad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ProdutoCadPresenter implements IProdutoCadPresenter {

    private IProdutoCad iProdutoCad;

    public ProdutoCadPresenter(IProdutoCad iProdutoCad) {
        this.iProdutoCad = iProdutoCad;
    }

    @Override
    public void buscarGruProList() {
        iProdutoCad.montaSpinnerGrupo(GrupoProduto.listAll(GrupoProduto.class));
    }

    @Override
    public void buscarGruIngList(Long idPro) {
        List<GrupoIng> grupoIngList = GrupoIng.find(GrupoIng.class, "statusgruing = ?", "1");
        List<Object> objectList = new ArrayList<>();

        List<ProGruIng> grupoIngProList = ProGruIng.find(ProGruIng.class, "produto_id = ?", idPro.toString());
        List<Object> objectListProGru = new ArrayList<>();

        objectList.addAll(grupoIngList);
        objectListProGru.addAll(grupoIngProList);

        iProdutoCad.abrirDialogIngObsPro(objectList, objectListProGru);
    }

    @Override
    public void buscarGruObsList(Long idPro) {
        List<GrupoObs> grupoObsList = GrupoObs.find(GrupoObs.class, "statusgruobs = ?", "1");
        List<Object> objectList = new ArrayList<>();

        List<ProGruObs> grupoIngProList = ProGruObs.find(ProGruObs.class, "produto_id = ?", idPro.toString());
        List<Object> objectListProGru = new ArrayList<>();

        objectList.addAll(grupoObsList);
        objectListProGru.addAll(grupoIngProList);

        iProdutoCad.abrirDialogIngObsPro(objectList, objectListProGru);
    }
}
