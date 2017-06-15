package com.example.ebjacson.lanchonetepdv.view;

import com.example.ebjacson.lanchonetepdv.view.adapters.IngObsProAdapter;

/**
 * Created by Jacson on 15/06/2017.
 */

public interface IIngObsProAdapter {
    void changedCheckIngObs(boolean isChecked, Object dao);
    void montandoDados(IngObsProAdapter.ViewHolder holder, Object dao);
}
