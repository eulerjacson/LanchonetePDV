package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.presenter.impl.ObsCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IObsCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericCadAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObsCadActivity extends AppCompatActivity implements IObsCad {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvGenericCad)
    RecyclerView rvGrupoProCad;

    ObsCadPresenter ObsCadPresenter;

    GenericCadAdapter genericCadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_cad);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ObsCadPresenter = new ObsCadPresenter(this);
        ObsCadPresenter.buscarObjectList();

    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        DialogGenericCad dialogGenericCad = new DialogGenericCad(this, new Observacao(), genericCadAdapter);
        dialogGenericCad.show();
    }

    @Override
    public void montaRecyclerObs(List<Observacao> obsList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(obsList);
        genericCadAdapter = new GenericCadAdapter(this, objectList);
        rvGrupoProCad.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvGrupoProCad.setAdapter(genericCadAdapter);

    }
}
