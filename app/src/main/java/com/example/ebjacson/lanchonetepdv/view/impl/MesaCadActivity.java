package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.presenter.impl.MesaCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IMesasCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericCadAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MesaCadActivity extends AppCompatActivity implements IMesasCad {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvGenericCad)
    RecyclerView rvGrupoProCad;

    MesaCadPresenter mesasCadPresenter;

    GenericCadAdapter genericCadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_cad);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mesasCadPresenter = new MesaCadPresenter(this);
        mesasCadPresenter.buscarObjectList();

    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        DialogGenericCad dialogGenericCad = new DialogGenericCad(this, new Mesas(), genericCadAdapter);
        dialogGenericCad.show();
    }

    @Override
    public void montaRecyclerMesas(List<Mesas> mesasList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(mesasList);
        genericCadAdapter = new GenericCadAdapter(this, objectList);
        rvGrupoProCad.setLayoutManager(new GridLayoutManager(this, 3));
        rvGrupoProCad.setAdapter(genericCadAdapter);
    }
}
