package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Observacao;

/**
 * Created by Jacson on 18/05/2017.
 */

public interface IObsVendaAdapter {
    ObsItVenda montaItem(Observacao dao);
}
