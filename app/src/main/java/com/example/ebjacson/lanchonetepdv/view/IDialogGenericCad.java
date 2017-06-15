package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;

import java.util.List;

/**
 * Created by euler on 18/05/17.
 */

public interface IDialogGenericCad {
    void saveObject();
    void delObject();
    void atualizaListaAct();
    void montaSpinnerGrupoObs(List<GrupoObs> grupoObsList);
    void montaSpinnerGrupoIng(List<GrupoIng> grupoIngList);
    void montaSpinnerEstado(List<Estado> estadoList);
}
