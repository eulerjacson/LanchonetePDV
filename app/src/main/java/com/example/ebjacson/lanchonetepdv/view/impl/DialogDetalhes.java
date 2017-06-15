package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.model.ProGruIng;
import com.example.ebjacson.lanchonetepdv.model.ProGruObs;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IDialogDetalhes;
import com.example.ebjacson.lanchonetepdv.view.adapters.IngreVendaAdapter;
import com.example.ebjacson.lanchonetepdv.view.adapters.ObsVendaAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.orm.SugarRecord.find;

/**
 * Created by euler on 18/05/17.
 */

public class DialogDetalhes extends AlertDialog implements IDialogDetalhes {

    @BindView(R.id.rvIngredientes)
    RecyclerView rvIngredientes;
    @BindView(R.id.rvObservacoes)
    RecyclerView rvObservacoes;
    @BindView(R.id.btCancelarDetalhes)
    Button btCancelarDetalhes;
    @BindView(R.id.btOkDetalhes)
    Button btOkDetalhes;

    Context context;

    ItemVenda itemVenda;

    IngreVendaAdapter ingreVendaAdapter;
    ObsVendaAdapter obsVendaAdapter;

    public DialogDetalhes(@NonNull Context context, ItemVenda itemVenda) {
        super(context);
        this.context = context;
        this.itemVenda = itemVenda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_detalhes);
        setCancelable(false);
        ButterKnife.bind(this);

        montaRecyclerIng();
        montaRecyclerObs();
    }

    @Override
    public void montaRecyclerIng() {
        List<Ingrediente> ingredienteList = new ArrayList<>();
        List<ProGruIng> proGruIngList = find(ProGruIng.class, "produto_id = ? ", itemVenda.getProdutoId().getId().toString());
        for (ProGruIng proGruIng : proGruIngList) {
            ingredienteList.addAll(Ingrediente.find(Ingrediente.class, "grupo_ing_id = ? and statusing = 1 ", proGruIng.getGrupoIngId().getId().toString()));
        }

        ingreVendaAdapter = new IngreVendaAdapter(context, ingredienteList, itemVenda);
        rvIngredientes.setLayoutManager(new GridLayoutManager(context, 2));
        rvIngredientes.setAdapter(ingreVendaAdapter);
    }

    @Override
    public void montaRecyclerObs() {
        List<Observacao> observacaoList = new ArrayList<>();
        List<ProGruObs> proGruIngList = find(ProGruObs.class, "produto_id = ? ", itemVenda.getProdutoId().getId().toString());
        for (ProGruObs proGruObs : proGruIngList) {
            observacaoList.addAll(Observacao.find(Observacao.class, "grupo_obs_id = ? and statusobs = 1 ", proGruObs.getGrupoObsId().getId().toString()));
        }

        obsVendaAdapter = new ObsVendaAdapter(context, observacaoList, itemVenda);
        rvObservacoes.setLayoutManager(new GridLayoutManager(context, 2));
        rvObservacoes.setAdapter(obsVendaAdapter);
    }

    @OnClick(R.id.btOkDetalhes)
    public void clickOk(){
        dismiss();
    }

    @OnClick(R.id.btCancelarDetalhes)
    public void clickCancelar(){
        List<IngItVenda> removerIngs = new ArrayList<>();
        for (IngItVenda ingItVenda : Util.ingItVendaList) {
            if(ingItVenda.getItemVendaId().equals(itemVenda)){
                removerIngs.add(ingItVenda);
            }
        }
        Util.ingItVendaList.removeAll(removerIngs);

        List<ObsItVenda> removerObs = new ArrayList<>();
        for (ObsItVenda obsItVenda : Util.obsItVendaList) {
            if(obsItVenda.getItemVendaId().equals(itemVenda)){
                removerObs.add(obsItVenda);
            }
        }
        Util.obsItVendaList.removeAll(removerObs);

        dismiss();
    }
}