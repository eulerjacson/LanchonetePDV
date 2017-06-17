package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Caixa;
import com.example.ebjacson.lanchonetepdv.model.ContaReceber;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.MovCaixa;
import com.example.ebjacson.lanchonetepdv.model.ParcelaReceber;
import com.example.ebjacson.lanchonetepdv.model.Recebimento;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.presenter.IRecebimentoPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IRecebimentoActivity;

import java.util.Date;

/**
 * Created by Jacson on 05/05/2017.
 */

public class RecebimentoPresenter implements IRecebimentoPresenter {

    private IRecebimentoActivity iRecebimentoActivity;

    public RecebimentoPresenter(IRecebimentoActivity iRecebimentoActivity) {
        this.iRecebimentoActivity = iRecebimentoActivity;
    }

    @Override
    public void realizaRecebimento(int tipo) {
        Venda venda = Util.venda;
        Caixa caixa = Util.caixa;

        ContaReceber contaReceber = new ContaReceber();
        ParcelaReceber parcelaReceber = new ParcelaReceber();
        Recebimento recebimento = new Recebimento();
        MovCaixa movCaixa = new MovCaixa();

        contaReceber.setVendaId(venda);
        contaReceber.setClienteId(venda.getClienteId());
        contaReceber.setDataconrec(new Date());
        contaReceber.setVlrdescontoconrec(venda.getVlrdescven());
        contaReceber.setVlrsubtotconrec(venda.getVlrsubtotven());
        contaReceber.setVlrtotalconrec(venda.getVlrtotalven());

        parcelaReceber.setContaReceberId(contaReceber);
        parcelaReceber.setDataparrec(new Date());
        parcelaReceber.setDescontoparrec(venda.getVlrdescven());
        parcelaReceber.setJuroparrec(0.0);
        parcelaReceber.setMultaparrec(0.0);
        parcelaReceber.setValorparrec(venda.getVlrtotalven());

        recebimento.setContaReceberId(contaReceber);
        recebimento.setParcelaReceberId(parcelaReceber);
        recebimento.setDesconrec(venda.getVlrdescven());
        recebimento.setJurorec(0.0);
        recebimento.setMultarec(0.0);
        recebimento.setValorfinalrec(venda.getVlrtotalven());

        movCaixa.setCaixaId(caixa);
        movCaixa.setRecebimentoId(recebimento);
        movCaixa.setDatamovcai(new Date());
        movCaixa.setDescmovcaixa("Venda: " + venda.getId());
        movCaixa.setTipomovcai(true);
        movCaixa.setTiporecmovcai(tipo);
        movCaixa.setVlrmovcai(venda.getVlrtotalven());

        Mesas mesas = venda.getMesasId();
        mesas.setStatusmesa(0);

        contaReceber.save();
        parcelaReceber.save();
        recebimento.save();
        movCaixa.save();
        mesas.save();

        iRecebimentoActivity.callMapaMesasActivity();
    }
}
