package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.view.ICadastroActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastrosActivity extends AppCompatActivity implements ICadastroActivity {

    @BindView(R.id.tvGrupoProCad)
    TextView tvGrupoProCad;
    @BindView(R.id.tvGrupoIngCad)
    TextView tvGrupoIngCad;
    @BindView(R.id.tvGrupoObsCad)
    TextView tvGrupoObsCad;
    @BindView(R.id.tvProCad)
    TextView tvProCad;
    @BindView(R.id.tvIngCad)
    TextView tvIngCad;
    @BindView(R.id.tvObsCad)
    TextView tvObsCad;
    @BindView(R.id.tvEstCad)
    TextView tvEstCad;
    @BindView(R.id.tvCidCad)
    TextView tvCidCad;
    @BindView(R.id.tvMesaCad)
    TextView tvMesaCad;
    @BindView(R.id.tvClienteCad)
    TextView tvClienteCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastros);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tvGrupoProCad)
    public void cadGrupoProClick() {
        chamaActivity(GrupoProCadActivity.class);
    }

    @OnClick(R.id.tvGrupoIngCad)
    public void cadGrupoIngClick() {
        chamaActivity(GrupoIngCadActivity.class);
    }

    @OnClick(R.id.tvGrupoObsCad)
    public void cadGrupoObsClick() {
        chamaActivity(GrupoObsCadActivity.class);
    }

    @OnClick(R.id.tvProCad)
    public void cadProClick() {

    }

    @OnClick(R.id.tvIngCad)
    public void cadIngClick() {
        chamaActivity(IngCadActivity.class);
    }

    @OnClick(R.id.tvObsCad)
    public void cadObsClick() {
        chamaActivity(ObsCadActivity.class);
    }

    @OnClick(R.id.tvEstCad)
    public void cadEstClick() {
        chamaActivity(EstadoCadActivity.class);
    }

    @OnClick(R.id.tvCidCad)
    public void cadCidClick() {
        chamaActivity(CidadeCadActivity.class);
    }

    @OnClick(R.id.tvMesaCad)
    public void cadMesaClick() {
        chamaActivity(MesaCadActivity.class);
    }

    @OnClick(R.id.tvClienteCad)
    public void cadClienteClick() {
        chamaActivity(ClienteListActivity.class);
    }

    @Override
    public void chamaActivity(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
    }
}
