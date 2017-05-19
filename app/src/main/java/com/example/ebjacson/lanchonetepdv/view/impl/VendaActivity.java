package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.presenter.impl.VendaConfirmPresenter;
import com.example.ebjacson.lanchonetepdv.presenter.impl.VendaPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IVendaActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.VendaGruposAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VendaActivity extends AppCompatActivity implements IVendaActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    private VendaGruposAdapter mVendaGruposAdapter;

    VendaPresenter vendaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        vendaPresenter = new VendaPresenter(this);
        vendaPresenter.carregarPagerTab();
        /*Util.itemVendaList = new ArrayList<>();
        Util.ingItVendaList = new ArrayList<>();
        Util.obsItVendaList = new ArrayList<>();*/

    }

    @Override
    public void montaPagerTab(List<GrupoProduto> grupoProdutoList) {
        mVendaGruposAdapter = new VendaGruposAdapter(getSupportFragmentManager(), grupoProdutoList);
        mViewPager.setAdapter(mVendaGruposAdapter);
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        callVendaConfirmActivity();
    }

    @Override
    public void callVendaConfirmActivity() {
        Intent intent = new Intent(this, VendaConfirmActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(Util.venda.getId() == null) {
            Mesas m = Util.venda.getMesasId();
            m.setStatusmesa(0);
            m.save();
        }

        new VendaConfirmPresenter().limparVenda();
    }
}
