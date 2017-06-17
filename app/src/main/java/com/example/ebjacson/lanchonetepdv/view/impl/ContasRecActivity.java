package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.ParcelaReceber;
import com.example.ebjacson.lanchonetepdv.presenter.impl.ContasRecPresenter;
import com.example.ebjacson.lanchonetepdv.view.IContasRecActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.ContasRecAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContasRecActivity extends AppCompatActivity implements IContasRecActivity {

    @BindView(R.id.rvContasRec)
    RecyclerView rvContasRec;

    ContasRecAdapter contasRecAdapter;

    ContasRecPresenter contasRecPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas_rec);
        ButterKnife.bind(this);

        contasRecPresenter = new ContasRecPresenter(this);
        contasRecPresenter.buscarObjectList();

    }

    @Override
    public void montaRecyclerParcelaReceber(List<ParcelaReceber> parcelaReceberList) {
        contasRecAdapter = new ContasRecAdapter(this, parcelaReceberList);
        rvContasRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvContasRec.setAdapter(contasRecAdapter);
    }
}
