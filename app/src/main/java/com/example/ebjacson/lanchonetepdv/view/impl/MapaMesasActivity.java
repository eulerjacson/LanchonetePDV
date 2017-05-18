package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.Produto;
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

        /*for(int x = 1; x < 15;x++){
            Mesas m = new Mesas();
            m.setStatusmesa(0);
            m.setDescmesa("" + x);
            m.save();
        }

        for(int x = 1; x < 6;x++){
            GrupoProduto g = new GrupoProduto();
            g.setStatusgrupo(true);
            g.setDescgrupo("Grupo " + x);
            g.save();
        }

        for (GrupoProduto grupoProduto : GrupoProduto.listAll(GrupoProduto.class)) {
            Produto p = new Produto();
            p.setGrupoProdutoId(grupoProduto);
            p.setImprimepro(false);
            p.setNomepro("Produto " + grupoProduto.getId());
            p.setPrecopro(10.0);
            p.setStatuspro(true);
            p.save();
            Produto p2 = new Produto();
            p2.setGrupoProdutoId(grupoProduto);
            p2.setImprimepro(false);
            p2.setNomepro("Produto 1" + grupoProduto.getId());
            p2.setPrecopro(10.0);
            p2.setStatuspro(true);
            p2.save();
        }*/

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
