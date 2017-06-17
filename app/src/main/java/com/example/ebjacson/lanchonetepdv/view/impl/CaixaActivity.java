package com.example.ebjacson.lanchonetepdv.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Caixa;
import com.example.ebjacson.lanchonetepdv.model.MovCaixa;
import com.example.ebjacson.lanchonetepdv.presenter.impl.CaixaPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.ICaixaActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.MovCaixaAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaixaActivity extends AppCompatActivity implements ICaixaActivity {

    @BindView(R.id.btAbrirFechar)
    Button btAbrirFechar;
    @BindView(R.id.tvNumCai)
    TextView tvNumCai;
    @BindView(R.id.tvDataAbCai)
    TextView tvDataAbCai;
    @BindView(R.id.tvVlrAbCai)
    TextView tvVlrAbCai;
    @BindView(R.id.tvVlrDinCai)
    TextView tvVlrDinCai;
    @BindView(R.id.tvVlrCreCai)
    TextView tvVlrCreCai;
    @BindView(R.id.tvVlrDebCai)
    TextView tvVlrDebCai;
    @BindView(R.id.tvVlrSaldoCai)
    TextView tvVlrSaldoCai;
    @BindView(R.id.rvMovCaixa)
    RecyclerView rvMovCaixa;

    MovCaixaAdapter movCaixaAdapter;

    CaixaPresenter caixaPresenter;

    Caixa caixa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa);
        ButterKnife.bind(this);

        caixaPresenter = new CaixaPresenter(this);
        if (Util.caixa != null) {
            caixa = Util.caixa;
            if(caixa.getStatuscai()) {
                btAbrirFechar.setText(getString(R.string.fechar));
                caixaPresenter.buscarMovCaixaList();
                caixaPresenter.calcularFormasRec();
            }else{
                btAbrirFechar.setText(getString(R.string.abrir));
            }
        } else {
            btAbrirFechar.setText(getString(R.string.abrir));
        }

    }

    @OnClick(R.id.btAbrirFechar)
    void clickAbrirFechar() {
        caixaPresenter.abrirFechar();
    }

    @Override
    public void montaRecyclerMovCaixa(List<MovCaixa> movCaixaList) {
        movCaixaAdapter = new MovCaixaAdapter(this, movCaixaList);
        rvMovCaixa.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMovCaixa.setAdapter(movCaixaAdapter);
    }

    @Override
    public void montaDadosCaixa(Double vlrdin, Double vlrcre, Double vlrdeb, Double vlrsaldo) {
        if(caixa != null) {
            tvNumCai.setText(getString(R.string.caixa) + " " + caixa.getId());
            tvDataAbCai.setText(Util.dataHoraParaString(caixa.getDataabcai()));
            tvVlrAbCai.setText(Util.doubleParaStringText(caixa.getVlrabcai()));
        }
        tvVlrDinCai.setText(Util.doubleParaStringText(vlrdin));
        tvVlrCreCai.setText(Util.doubleParaStringText(vlrcre));
        tvVlrDebCai.setText(Util.doubleParaStringText(vlrdeb));
        tvVlrSaldoCai.setText(Util.doubleParaStringText(vlrsaldo));
    }

    @Override
    public void mensagemMesasAbertas() {
        Util.mensagemToast(this, getString(R.string.possuimesasabertas));
    }

    @Override
    public void mensagemAbriu() {
        Util.mensagemToast(this, getString(R.string.caixaaberto));
        caixaPresenter.buscarMovCaixaList();
        caixaPresenter.calcularFormasRec();
        caixa = Util.caixa;
    }

    @Override
    public void mensagemFechou() {
        Util.mensagemToast(this, getString(R.string.caixafechado));
        caixa = Util.caixa;
    }
}
