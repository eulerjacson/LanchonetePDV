package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.view.ICadastroNavActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroNavActivity extends AppCompatActivity implements ICadastroNavActivity {

    @BindView(R.id.tvCad1)
    TextView tvCad1;
    @BindView(R.id.tvCad2)
    TextView tvCad2;
    @BindView(R.id.tvCad3)
    TextView tvCad3;
    @BindView(R.id.tvCad4)
    TextView tvCad4;
    @BindView(R.id.tvCad4Separator)
    TextView tvCad4Separator;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    int selecionado = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_gruposcad:
                    caseNavGruposCad();
                    selecionado = 0;
                    return true;
                case R.id.nav_cad:
                    caseNavCad();
                    selecionado = 1;
                    return true;
                case R.id.nav_confcad:
                    caseNavConfCad();
                    selecionado = 2;
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_nav);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        caseNavGruposCad();

        tvCad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecionado == 0) {
                    chamaActivity(GrupoProCadActivity.class);
                } else if(selecionado == 1) {
                    chamaActivity(ProdutoListActivity.class);
                } else if(selecionado == 2) {
                    chamaActivity(MesaCadActivity.class);
                }
            }
        });

        tvCad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecionado == 0) {
                    chamaActivity(GrupoIngCadActivity.class);
                } else if(selecionado == 1) {
                    chamaActivity(IngCadActivity.class);
                } else if(selecionado == 2) {
                    chamaActivity(ClienteListActivity.class);
                }
            }
        });

        tvCad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecionado == 0) {
                    chamaActivity(GrupoObsCadActivity.class);
                } else if(selecionado == 1) {
                    chamaActivity(ObsCadActivity.class);
                } else if(selecionado == 2) {
                    chamaActivity(EstadoCadActivity.class);
                }
            }
        });

        tvCad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecionado == 2) {
                    chamaActivity(CidadeCadActivity.class);
                }
            }
        });
    }

    @Override
    public void caseNavGruposCad() {
        tvCad1.setText(R.string.grupodepro);
        tvCad2.setText(R.string.grupodeing);
        tvCad3.setText(R.string.grupodeobs);
        tvCad4.setVisibility(View.GONE);
        tvCad4Separator.setVisibility(View.GONE);
    }

    @Override
    public void caseNavCad() {
        tvCad1.setText(R.string.produto);
        tvCad2.setText(R.string.ingrediente);
        tvCad3.setText(R.string.observacao);
        tvCad4.setVisibility(View.GONE);
        tvCad4Separator.setVisibility(View.GONE);
    }

    @Override
    public void caseNavConfCad() {
        tvCad1.setText(R.string.mesa);
        tvCad2.setText(R.string.cliente);
        tvCad3.setText(R.string.estado);
        tvCad4.setText(R.string.cidade);
        tvCad4.setVisibility(View.VISIBLE);
        tvCad4Separator.setVisibility(View.VISIBLE);
    }

    @Override
    public void chamaActivity(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
        finish();
    }

}
