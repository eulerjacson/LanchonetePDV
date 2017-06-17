package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.Cliente;

import java.util.List;

/**
 * Created by euler on 18/05/17.
 */

public interface IDialogPrazoRec {
    void geraRecebimentoPrazo();
    void montaSpinnerCliente(List<Cliente> clienteList);
}
