package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.presenter.impl.CidadeCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.ICidadeCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericCadAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CidadeCadActivity extends AppCompatActivity implements ICidadeCad {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvGenericCad)
    RecyclerView rvGrupoProCad;

    CidadeCadPresenter cidadeCadPresenter;

    GenericCadAdapter genericCadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_cad);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        cidadeCadPresenter = new CidadeCadPresenter(this);
        cidadeCadPresenter.buscarObjectList();

    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        DialogGenericCad dialogGenericCad = new DialogGenericCad(this, new Cidade(), genericCadAdapter);
        dialogGenericCad.show();
    }

    @Override
    public void montaRecyclerCidade(List<Cidade> cidadeList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(cidadeList);
        genericCadAdapter = new GenericCadAdapter(this, objectList);
        rvGrupoProCad.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvGrupoProCad.setAdapter(genericCadAdapter);

    }
}
