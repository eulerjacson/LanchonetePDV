package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.presenter.impl.MapaMesasPresenter;
import com.example.ebjacson.lanchonetepdv.view.IMapaMesasActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.MapaMesasAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapaMesasActivity extends AppCompatActivity implements IMapaMesasActivity {

    //adapters
    MapaMesasAdapter mapaMesasAdapter;

    //presenter
    MapaMesasPresenter mapaMesasPresenter;

    //view
    @BindView(R.id.gvMapaMesas)
    GridView gvMapaMesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mapaMesasPresenter = new MapaMesasPresenter(this);
        mapaMesasPresenter.carregarGridView();

    }

    @Override
    public void montaGridView(List<Mesas> mesasList) {
        System.out.println(mesasList.toString());
        mapaMesasAdapter = new MapaMesasAdapter(this, mesasList);
        gvMapaMesas.setAdapter(mapaMesasAdapter);
    }
}
