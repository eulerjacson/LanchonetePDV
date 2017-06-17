package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.presenter.impl.RecebimentoPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IRecebimentoActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecebimentoActivity extends AppCompatActivity implements IRecebimentoActivity {

    @BindView(R.id.tvRecSubTotal)
    TextView tvRecSubTotal;
    @BindView(R.id.tvRecDesc)
    TextView tvRecDesc;
    @BindView(R.id.tvRecTotal)
    TextView tvRecTotal;
    @BindView(R.id.tvRecReceber)
    TextView tvRecReceber;
    @BindView(R.id.tvRecTroco)
    TextView tvRecTroco;

    @BindView(R.id.rbtDinheiroRec)
    RadioButton rbtDinheiroRec;
    @BindView(R.id.rbtCreditoRec)
    RadioButton rbtCreditoRec;
    @BindView(R.id.rbtDebitoRec)
    RadioButton rbtDebitoRec;
    @BindView(R.id.rgpRec)
    RadioGroup rgpRec;

    @BindView(R.id.btRecSete)
    Button btRecSete;
    @BindView(R.id.btRecOito)
    Button btRecOito;
    @BindView(R.id.btRecNove)
    Button btRecNove;
    @BindView(R.id.btRecLimpar)
    Button btRecLimpar;
    @BindView(R.id.btRecQuatro)
    Button btRecQuatro;
    @BindView(R.id.btRecCinco)
    Button btRecCinco;
    @BindView(R.id.btRecSeis)
    Button btRecSeis;
    @BindView(R.id.btRecExato)
    Button btRecExato;
    @BindView(R.id.btRecUm)
    Button btRecUm;
    @BindView(R.id.btRecDois)
    Button btRecDois;
    @BindView(R.id.btRecTres)
    Button btRecTres;
    @BindView(R.id.btRecZero)
    Button btRecZero;
    @BindView(R.id.btRecDoisZero)
    Button btRecDoisZero;
    @BindView(R.id.imbRecApagar)
    ImageButton imbRecApagar;
    @BindView(R.id.btRecReceber)
    Button btRecReceber;
    @BindView(R.id.btRecDesc)
    Button btRecDesc;

    Venda venda = Util.venda;

    RecebimentoPresenter recebimentoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebimento);
        ButterKnife.bind(this);

        tvRecSubTotal.setText(Util.doubleParaStringText(venda.getVlrsubtotven()));
        tvRecDesc.setText(Util.doubleParaStringText(venda.getVlrdescven()));
        tvRecTotal.setText(Util.doubleParaStringText(venda.getVlrtotalven()));

        tvRecReceber.setTextColor(Color.RED);

        recebimentoPresenter = new RecebimentoPresenter(this);

        tvRecReceber.addTextChangedListener(new TextWatcher() {
            boolean mEditing = false;

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if (!mEditing) {
                    mEditing = true;
                    String digits = s.toString().replaceAll("\\D", "");
                    NumberFormat nf = new DecimalFormat("#,##0.00");

                    try {
                        String formatted = nf.format(Double.parseDouble(digits) / 100);
                        s.replace(0, s.length(), formatted);
                    } catch (NumberFormatException nfe) {
                        s.clear();
                    }
                    mEditing = false;
                }

            }
        });
    }

    @OnClick(R.id.btRecZero)
    void clickRecZero() {
        tvRecReceber.append("0");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecDoisZero)
    void clickRecDoisZero() {
        tvRecReceber.append("00");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecUm)
    void clickRecUm() {
        tvRecReceber.append("1");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecDois)
    void clickRecDois() {
        tvRecReceber.append("2");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecTres)
    void clickRecTres() {
        tvRecReceber.append("3");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecQuatro)
    void clickRecQuatro() {
        tvRecReceber.append("4");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecCinco)
    void clickRecCinco() {
        tvRecReceber.append("5");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecSeis)
    void clickRecSeis() {
        tvRecReceber.append("6");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecSete)
    void clickRecSete() {
        tvRecReceber.append("7");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecOito)
    void clickRecOito() {
        tvRecReceber.append("8");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecNove)
    void clickRecNove() {
        tvRecReceber.append("9");
        atualizaCalculo();
    }

    ///////

    @OnClick(R.id.btRecLimpar)
    void clickRecLimpar() {
        tvRecReceber.setText("0,00");
        atualizaCalculo();
    }

    @OnClick(R.id.btRecExato)
    void clickRecExato() {
        tvRecReceber.setText(Util.doubleParaStringText(venda.getVlrtotalven()));
        atualizaCalculo();
    }

    @OnClick(R.id.btRecDesc)
    void clickRecDesc() {
        DialogDescontoRec dialogDescontoRec = new DialogDescontoRec(this, this);
        dialogDescontoRec.show();
        atualizaCalculo();
    }

    @OnClick(R.id.btRecReceber)
    void clickRecReceber() {

        Double totalPed = Util.removeTextMoney(tvRecTotal);
        Double valorPag = Util.removeTextMoney(tvRecReceber);
        int i = valorPag.compareTo(totalPed - venda.getVlrdescven());

        if (i >= 0) {
            recebimentoPresenter.realizaRecebimento(verificaTipoRec());
        } else {
            Util.mensagemToast(this, getString(R.string.valorinsuficiente));
        }

    }

    @OnClick(R.id.imbRecApagar)
    void clickRecApagar() {
        String texto = tvRecReceber.getText().toString();
        if (texto.length() > 0) {
            String resultado = texto.substring(0, texto.length() - 1);
            tvRecReceber.setText(resultado);
        }
        atualizaCalculo();
    }

    @Override
    public void atualizaCalculo() {
        if (Util.removeTextMoney(tvRecReceber) >= venda.getVlrtotalven()) {
            tvRecReceber.setTextColor(Color.GREEN);
        } else {
            tvRecReceber.setTextColor(Color.RED);
        }
        Double troco = Util.removeTextMoney(tvRecReceber) - venda.getVlrtotalven();
        if (troco >= 0) {
            tvRecTroco.setText(Util.doubleParaStringText(troco));
        } else {
            tvRecTroco.setText("0,00");
        }
        tvRecDesc.setText(Util.doubleParaStringText(venda.getVlrdescven()));
    }

    @Override
    public void atualizaTotalTV() {
        tvRecTotal.setText(Util.doubleParaStringText(venda.getVlrtotalven()));
    }

    @Override
    public void callMapaMesasActivity() {
        Intent intent = new Intent(this, MapaMesasActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public int verificaTipoRec() {
        switch (rgpRec.getCheckedRadioButtonId()) {
            case R.id.rbtDinheiroRec:
                return 0;
            case R.id.rbtCreditoRec:
                return 1;
            case R.id.rbtDebitoRec:
                return 2;
            default:
                return 0;
        }
    }


}
