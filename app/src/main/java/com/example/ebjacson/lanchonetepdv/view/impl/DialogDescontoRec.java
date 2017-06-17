package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IDialogDescontoRec;
import com.example.ebjacson.lanchonetepdv.view.IRecebimentoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by euler on 18/05/17.
 */

public class DialogDescontoRec extends AlertDialog implements IDialogDescontoRec {

    @BindView(R.id.etValorDesconto)
    EditText etValorDesconto;
    @BindView(R.id.btCancelarDlgDesc)
    Button btCancelarDlgDesc;
    @BindView(R.id.btSaveDlgDesc)
    Button btSaveDlgDesc;

    Context context;
    Venda venda;
    IRecebimentoActivity iRecebimentoActivity;

    public DialogDescontoRec(@NonNull Context context, IRecebimentoActivity iRecebimentoActivity) {
        super(context);
        this.context = context;
        this.iRecebimentoActivity = iRecebimentoActivity;
        venda = Util.venda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_descontorec);
        setCancelable(false);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btCancelarDlgDesc)
    void btClickCancelar() {
        dismiss();
    }

    @OnClick(R.id.btSaveDlgDesc)
    void btClickSave() {
        atribuiDesconto();
    }

    @Override
    public void atribuiDesconto() {
        Double desc = Util.removeTextMoney(etValorDesconto);
        venda.setVlrdescven(desc);
        venda.setVlrtotalven(venda.getVlrsubtotven() - desc);
        Util.venda = venda;

        dismiss();
        iRecebimentoActivity.atualizaCalculo();
        iRecebimentoActivity.atualizaTotalTV();
    }
}