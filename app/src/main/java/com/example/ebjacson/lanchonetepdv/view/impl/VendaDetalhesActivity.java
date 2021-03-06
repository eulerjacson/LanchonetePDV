package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.presenter.impl.VendaConfirmPresenter;
import com.example.ebjacson.lanchonetepdv.view.IVendaConfirmActivity;
import com.example.ebjacson.lanchonetepdv.view.IVendaDetalhesActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.ItensConfirmAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VendaDetalhesActivity extends AppCompatActivity implements IVendaDetalhesActivity, IVendaConfirmActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvItemConfirm)
    RecyclerView rvItemConfirm;
    @BindView(R.id.fab2)
    FloatingActionButton fab2;

    VendaConfirmPresenter vendaConfirmPresenter;
    ItensConfirmAdapter itensConfirmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda_confirm);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        vendaConfirmPresenter = new VendaConfirmPresenter(this);
        vendaConfirmPresenter.carregarRecyclerItensValores();
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        chamaRecebimentoActivity();
    }

    @OnClick(R.id.fab2)
    public void fab2Click(View view) {
        chamaVendaActivity();
    }

    @Override
    public void montaRecyclerItens(List<ItemVenda> itemVendaList, Boolean ehValores) {
        itensConfirmAdapter = new ItensConfirmAdapter(this, itemVendaList, ehValores);
        rvItemConfirm.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItemConfirm.setAdapter(itensConfirmAdapter);
    }

    @Override
    public void chamaRecebimentoActivity() {
        //vendaConfirmPresenter.limparVenda();
        Intent intent = new Intent(this, RecebimentoActivity.class);
        startActivity(intent);
    }

    @Override
    public void chamaMapaMesasActivity() {
        ///
    }

    @Override
    public void chamaVendaActivity() {
        vendaConfirmPresenter.limparItens();
        Intent intent = new Intent(this, VendaActivity.class);
        startActivity(intent);
        finish();
    }
}