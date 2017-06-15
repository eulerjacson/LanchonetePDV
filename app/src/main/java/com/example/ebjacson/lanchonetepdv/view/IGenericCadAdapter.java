package com.example.ebjacson.lanchonetepdv.view;

import java.util.List;

/**
 * Created by Jacson on 18/05/2017.
 */

public interface IGenericCadAdapter {
    void abrirDialog(Object object);
    void atualizaLista(List<Object> novaLista);
    void callClienteCad(Long codCli);
}
