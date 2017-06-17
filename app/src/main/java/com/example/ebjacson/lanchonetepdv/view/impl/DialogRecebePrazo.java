package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.MovCaixa;
import com.example.ebjacson.lanchonetepdv.model.ParcelaReceber;
import com.example.ebjacson.lanchonetepdv.model.Recebimento;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IContasRecAdapter;
import com.example.ebjacson.lanchonetepdv.view.IDialogRecebePrazo;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.ebjacson.lanchonetepdv.util.Util.caixa;

/**
 * Created by euler on 18/05/17.
 */

public class DialogRecebePrazo extends AlertDialog implements IDialogRecebePrazo {
    @BindView(R.id.rbtDinheiroRecPrazo)
    RadioButton rbtDinheiroRecPrazo;
    @BindView(R.id.rbtCreditoRecPrazo)
    RadioButton rbtCreditoRecPrazo;
    @BindView(R.id.rbtDebitoRecPrazo)
    RadioButton rbtDebitoRecPrazo;
    @BindView(R.id.rgpRecPrazo)
    RadioGroup rgpRecPrazo;
    @BindView(R.id.btCancelarDlgRecPrazo)
    Button btCancelarDlgRecPrazo;
    @BindView(R.id.btSaveDlgRecPrazo)
    Button btSaveDlgRecPrazo;
    @BindView(R.id.linearLayout14)
    LinearLayout linearLayout14;
    ParcelaReceber parcelaReceber;
    @BindView(R.id.tvCliRecebePrazo)
    TextView tvCliRecebePrazo;
    @BindView(R.id.tvDataRecebePrazo)
    TextView tvDataRecebePrazo;
    @BindView(R.id.tvTotalRecebePrazo)
    TextView tvTotalRecebePrazo;
    @BindView(R.id.tvVendaRecebePrazo)
    TextView tvVendaRecebePrazo;

    Context context;
    IContasRecAdapter iContasRecAdapter;

    public DialogRecebePrazo(@NonNull Context context, ParcelaReceber parcelaReceber, IContasRecAdapter iContasRecAdapter) {
        super(context);
        this.context = context;
        this.parcelaReceber = parcelaReceber;
        this.iContasRecAdapter = iContasRecAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_recebeprazo);
        setCancelable(false);
        ButterKnife.bind(this);

        montaDados();
    }

    @OnClick(R.id.btCancelarDlgRecPrazo)
    void btClickCancelar() {
        dismiss();
    }

    @OnClick(R.id.btSaveDlgRecPrazo)
    void btClickSave() {
        recebePrazo();
    }

    @Override
    public void recebePrazo() {
        Recebimento recebimento = new Recebimento();
        MovCaixa movCaixa = new MovCaixa();

        parcelaReceber.setStatusparrec(true);

        recebimento.setContaReceberId(parcelaReceber.getContaReceberId());
        recebimento.setParcelaReceberId(parcelaReceber);
        recebimento.setDesconrec(0.0);
        recebimento.setJurorec(0.0);
        recebimento.setMultarec(0.0);
        recebimento.setValorfinalrec(parcelaReceber.getValorparrec());

        movCaixa.setCaixaId(caixa);
        movCaixa.setRecebimentoId(recebimento);
        movCaixa.setDatamovcai(new Date());
        movCaixa.setDescmovcaixa("Parc. Rec: " + parcelaReceber.getId());
        movCaixa.setTipomovcai(true);
        movCaixa.setTiporecmovcai(verificaTipoRec());
        movCaixa.setVlrmovcai(parcelaReceber.getValorparrec());

        parcelaReceber.save();
        recebimento.save();
        movCaixa.save();
        dismiss();
        iContasRecAdapter.atualizaLista(ParcelaReceber.find(ParcelaReceber.class, "statusparrec = ?", "0"));
    }

    @Override
    public void montaDados() {
        tvCliRecebePrazo.setText(parcelaReceber.getContaReceberId().getClienteId().getNomecli());
        tvDataRecebePrazo.setText(Util.dataHoraParaString(parcelaReceber.getDataparrec()));
        tvVendaRecebePrazo.setText(parcelaReceber.getContaReceberId().getVendaId().getId().toString());
        tvTotalRecebePrazo.setText(Util.doubleParaStringText(parcelaReceber.getValorparrec()));
    }

    @Override
    public int verificaTipoRec() {
        switch (rgpRecPrazo.getCheckedRadioButtonId()) {
            case R.id.rbtDinheiroRecPrazo:
                return 0;
            case R.id.rbtCreditoRecPrazo:
                return 1;
            case R.id.rbtDebitoRecPrazo:
                return 2;
            default:
                return 0;
        }
    }
}