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
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IVendaConfirmActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.ItensConfirmAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VendaConfirmActivity extends AppCompatActivity implements IVendaConfirmActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.rvItemConfirm)
    RecyclerView rvItemConfirm;

    VendaConfirmPresenter vendaConfirmPresenter;
    ItensConfirmAdapter itensConfirmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda_confirm);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        vendaConfirmPresenter = new VendaConfirmPresenter(this);
        vendaConfirmPresenter.carregarRecyclerItens();
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        vendaConfirmPresenter.atualizarValoresVenda(Util.venda, Util.itemVendaList);
        vendaConfirmPresenter.salvarItens(Util.venda, Util.itemVendaList);
    }

    @Override
    public void montaRecyclerItens(List<ItemVenda> itemVendaList) {
        itensConfirmAdapter = new ItensConfirmAdapter(this, itemVendaList);
        rvItemConfirm.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItemConfirm.setAdapter(itensConfirmAdapter);
    }

    @Override
    public void chamaMapaMesasActivity() {
        vendaConfirmPresenter.limparVenda();
        Intent intent = new Intent(this, MapaMesasActivity.class);
        startActivity(intent);
    }
}
