package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.presenter.impl.EstadoCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IEstadoCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericCadAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EstadoCadActivity extends AppCompatActivity implements IEstadoCad {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvGenericCad)
    RecyclerView rvGrupoProCad;

    EstadoCadPresenter estadoCadPresenter;

    GenericCadAdapter genericCadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_cad);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        estadoCadPresenter = new EstadoCadPresenter(this);
        estadoCadPresenter.buscarObjectList();

    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        DialogGenericCad dialogGenericCad = new DialogGenericCad(this, new Estado(), genericCadAdapter);
        dialogGenericCad.show();
    }

    @Override
    public void montaRecyclerEstado(List<Estado> estadoList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(estadoList);
        genericCadAdapter = new GenericCadAdapter(this, objectList);
        rvGrupoProCad.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvGrupoProCad.setAdapter(genericCadAdapter);
    }
}
