package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.view.IDialogIngObsPro;
import com.example.ebjacson.lanchonetepdv.view.adapters.IngObsProAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by euler on 18/05/17.
 */

public class DialogIngObsPro extends AlertDialog implements IDialogIngObsPro {

    @BindView(R.id.rvIngObsPro)
    RecyclerView rvIngObsPro;
    @BindView(R.id.btOkIngObsPro)
    Button btOkIngObsPro;

    Context context;

    IngObsProAdapter ingObsProAdapter;
    List<Object> objectList;
    List<Object> objectListProGru;
    Produto produto;

    public DialogIngObsPro(@NonNull Context context, Produto produto, List<Object> objectList, List<Object> objectListProGru) {
        super(context);
        this.context = context;
        this.objectList = objectList;
        this.objectListProGru = objectListProGru;
        this.produto = produto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_ingobspro);
        setCancelable(false);
        ButterKnife.bind(this);

        montaRecycler();

    }

    @OnClick(R.id.btOkIngObsPro)
    void btClickOK(){
        dismiss();
    }

    @Override
    public void montaRecycler() {
        ingObsProAdapter = new IngObsProAdapter(context, produto, objectList, objectListProGru);
        rvIngObsPro.setLayoutManager(new LinearLayoutManager(context));
        rvIngObsPro.setAdapter(ingObsProAdapter);
    }
}