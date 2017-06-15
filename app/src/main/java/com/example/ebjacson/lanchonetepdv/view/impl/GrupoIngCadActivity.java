package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.presenter.impl.GrupoIngCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IGrupoIngCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericCadAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GrupoIngCadActivity extends AppCompatActivity implements IGrupoIngCad {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvGenericCad)
    RecyclerView rvGrupoProCad;

    GrupoIngCadPresenter grupoIngCadPresenter;

    GenericCadAdapter genericCadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_cad);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        grupoIngCadPresenter = new GrupoIngCadPresenter(this);
        grupoIngCadPresenter.buscarObjectList();

    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        DialogGenericCad dialogGenericCad = new DialogGenericCad(this, new GrupoIng(), genericCadAdapter);
        dialogGenericCad.show();
    }

    @Override
    public void montaRecyclerGrupoIng(List<GrupoIng> grupoIngList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(grupoIngList);
        genericCadAdapter = new GenericCadAdapter(this, objectList);
        rvGrupoProCad.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvGrupoProCad.setAdapter(genericCadAdapter);
    }
}
