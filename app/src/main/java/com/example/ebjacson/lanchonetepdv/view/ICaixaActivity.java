package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.MovCaixa;

import java.util.List;

/**
 * Created by euler on 18/05/17.
 */

public interface ICaixaActivity {
    void montaRecyclerMovCaixa(List<MovCaixa> movCaixaList);
    void montaDadosCaixa(Double vlrdin, Double vlrcre, Double vlrdeb, Double vlrsaldo);
    void mensagemMesasAbertas();
    void mensagemAbriu();
    void mensagemFechou();
}
