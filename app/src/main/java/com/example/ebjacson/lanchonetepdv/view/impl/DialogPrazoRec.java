package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cliente;
import com.example.ebjacson.lanchonetepdv.model.ContaReceber;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.ParcelaReceber;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IDialogPrazoRec;
import com.example.ebjacson.lanchonetepdv.view.IRecebimentoActivity;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericSpinnerAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by euler on 18/05/17.
 */

public class DialogPrazoRec extends AlertDialog implements IDialogPrazoRec {

    @BindView(R.id.spClientePrazo)
    Spinner spClientePrazo;
    @BindView(R.id.etQtdPrazo)
    EditText etQtdPrazo;
    @BindView(R.id.btCancelarDlgPrazo)
    Button btCancelarDlgPrazo;
    @BindView(R.id.btSaveDlgPrazo)
    Button btSaveDlgPrazo;

    Context context;
    IRecebimentoActivity iRecebimentoActivity;
    Venda venda;
    GenericSpinnerAdapter adapterSpinner;

    public DialogPrazoRec(@NonNull Context context, IRecebimentoActivity iRecebimentoActivity) {
        super(context);
        this.context = context;
        this.iRecebimentoActivity = iRecebimentoActivity;
        venda = Util.venda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_prazorec);
        setCancelable(false);
        ButterKnife.bind(this);

        montaSpinnerCliente(Cliente.find(Cliente.class, "statuscli = ? and id != ?", "1", "1"));
    }

    @OnClick(R.id.btCancelarDlgPrazo)
    void btClickCancelar() {
        dismiss();
    }

    @OnClick(R.id.btSaveDlgPrazo)
    void btClickSave() {
        geraRecebimentoPrazo();
    }

    @Override
    public void geraRecebimentoPrazo() {
        if(spClientePrazo.getSelectedItem() != null) {
            if (!etQtdPrazo.getText().toString().equals("")) {
                if ((Integer.valueOf(etQtdPrazo.getText().toString()) > 0)
                        && (Integer.valueOf(etQtdPrazo.getText().toString()) <= 10)) {

                    int qtd = Integer.valueOf(etQtdPrazo.getText().toString());

                    Venda venda = Util.venda;
                    venda.setClienteId((Cliente) spClientePrazo.getSelectedItem());
                    venda.setStatusven(false);

                    ContaReceber contaReceber = new ContaReceber();
                    ParcelaReceber parcelaReceber;

                    contaReceber.setVendaId(venda);
                    contaReceber.setClienteId(venda.getClienteId());
                    contaReceber.setDataconrec(new Date());
                    contaReceber.setVlrdescontoconrec(venda.getVlrdescven());
                    contaReceber.setVlrsubtotconrec(venda.getVlrsubtotven());
                    contaReceber.setVlrtotalconrec(venda.getVlrtotalven());
                    contaReceber.save();

                    for (int x = 1; x <= qtd; x++) {
                        parcelaReceber = new ParcelaReceber();
                        parcelaReceber.setContaReceberId(contaReceber);
                        parcelaReceber.setDataparrec(new Date());
                        parcelaReceber.setDescontoparrec(0.0);
                        parcelaReceber.setJuroparrec(0.0);
                        parcelaReceber.setMultaparrec(0.0);
                        parcelaReceber.setValorparrec(venda.getVlrtotalven() / qtd);
                        parcelaReceber.save();
                    }

                    Mesas mesas = venda.getMesasId();
                    mesas.setStatusmesa(0);

                    mesas.save();
                    venda.save();

                    iRecebimentoActivity.callMapaMesasActivity();
                }else{
                    Util.mensagemToast(context, context.getString(R.string.digiteumvalorvalido));
                }
            }else{
                Util.mensagemToast(context, context.getString(R.string.digiteumvalorvalido));
            }
        }else{
            Util.mensagemToast(context, context.getString(R.string.selecionecli));
        }
    }

    @Override
    public void montaSpinnerCliente(List<Cliente> clienteList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(clienteList);
        adapterSpinner = new GenericSpinnerAdapter(context, objectList);
        spClientePrazo.setAdapter(adapterSpinner);
    }
}