package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IDialogDetalhes;
import com.example.ebjacson.lanchonetepdv.view.adapters.IngreVendaAdapter;
import com.example.ebjacson.lanchonetepdv.view.adapters.MapaMesasAdapter;
import com.example.ebjacson.lanchonetepdv.view.adapters.ObsVendaAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by euler on 18/05/17.
 */

public class DialogDetalhes extends AlertDialog implements IDialogDetalhes {

    @BindView(R.id.rvIngredientes)
    RecyclerView rvIngredientes;
    @BindView(R.id.rvObservacoes)
    RecyclerView rvObservacoes;

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
        ButterKnife.bind(this);

        montaRecyclerIng();
        montaRecyclerObs();
    }

    @Override
    public void montaRecyclerIng() {
        ingreVendaAdapter = new IngreVendaAdapter(context, Ingrediente.find(Ingrediente.class, "statusing = ?", "1"), itemVenda);
        rvIngredientes.setLayoutManager(new GridLayoutManager(context, 2));
        rvIngredientes.setAdapter(ingreVendaAdapter);
    }

    @Override
    public void montaRecyclerObs() {
        obsVendaAdapter = new ObsVendaAdapter(context, Observacao.find(Observacao.class, "statusobs = ?", "1"), itemVenda);
        rvObservacoes.setLayoutManager(new GridLayoutManager(context, 2));
        rvObservacoes.setAdapter(obsVendaAdapter);
    }
}