package com.example.ebjacson.lanchonetepdv.presenter.impl;

import com.example.ebjacson.lanchonetepdv.model.Caixa;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.MovCaixa;
import com.example.ebjacson.lanchonetepdv.presenter.ICaixaPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.ICaixaActivity;

import java.util.Date;
import java.util.List;

/**
 * Created by Jacson on 05/05/2017.
 */

public class CaixaPresenter implements ICaixaPresenter {

    private ICaixaActivity iCaixaActivity;

    public CaixaPresenter(ICaixaActivity iCaixaActivity) {
        this.iCaixaActivity = iCaixaActivity;
    }

    @Override
    public void buscarMovCaixaList() {
        iCaixaActivity.montaRecyclerMovCaixa(MovCaixa.find(MovCaixa.class, "caixa_id = ?", Util.caixa.getId().toString()));
    }

    @Override
    public void calcularFormasRec() {
        Double vlrdin = 0.0, vlrcre = 0.0, vlrdeb = 0.0, vlrsaldo = 0.0;

        List<MovCaixa> movCaixaList = MovCaixa.find(MovCaixa.class, "caixa_id = ?", Util.caixa.getId().toString());
        for (MovCaixa movCaixa : movCaixaList) {
            if(movCaixa.getTiporecmovcai() == 0){
                vlrdin += movCaixa.getVlrmovcai();
            } else if(movCaixa.getTiporecmovcai() == 1){
                vlrcre += movCaixa.getVlrmovcai();
            } else if(movCaixa.getTiporecmovcai() == 2){
                vlrdeb += movCaixa.getVlrmovcai();
            }
        }
        if(Util.caixa != null) {
            vlrsaldo = vlrdin + vlrcre + vlrdeb + Util.caixa.getVlrabcai();
        }else{
            vlrsaldo = vlrdin + vlrcre + vlrdeb;
        }
        iCaixaActivity.montaDadosCaixa(vlrdin, vlrcre, vlrdeb, vlrsaldo);
    }

    @Override
    public void abrirFechar() {
        if(Util.caixa != null){
            //fechar
            if(Mesas.find(Mesas.class, "statusmesa != ?" , "0").size() > 0){
                iCaixaActivity.mensagemMesasAbertas();
            }else{
                //fecha
                if(Util.caixa.getStatuscai()) {
                    Caixa caixa = Util.caixa;
                    caixa.setDatafccai(new Date());
                    caixa.setVlrfccai(0.0);
                    caixa.setStatuscai(false);
                    caixa.save();
                    iCaixaActivity.mensagemFechou();
                }else{
                    //abrir
                    abrir();
                }
            }
        }else{
            //abrir
            abrir();
        }
    }

    private void abrir() {
        Caixa caixa = new Caixa();
        caixa.setDataabcai(new Date());
        caixa.setDatafccai(new Date());
        caixa.setVlrabcai(0.0);
        caixa.setStatuscai(true);
        caixa.save();
        Util.caixa = caixa;
        iCaixaActivity.mensagemAbriu();
    }
}
