package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IIngreVendaAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/05/2017.
 */

public class IngreVendaAdapter extends RecyclerView.Adapter<IngreVendaAdapter.ViewHolder> implements IIngreVendaAdapter {
    private Context mContext;
    private List<Ingrediente> ingredienteList;
    private ItemVenda itemVenda;

    public IngreVendaAdapter(Context mContext, List<Ingrediente> ingredienteList, ItemVenda itemVenda) {
        this.mContext = mContext;
        this.ingredienteList = ingredienteList;
        this.itemVenda = itemVenda;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingrevenda, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final Ingrediente dao = ingredienteList.get(position);
        final IngItVenda ingItVenda = montaItem(dao);

        viewHolder.checkBox.setText(dao.getDescing());

        if(Util.ingItVendaList.contains(ingItVenda)){
            viewHolder.checkBox.setChecked(true);
        }

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Util.ingItVendaList.add(ingItVenda);
                }else{
                    Util.ingItVendaList.remove(ingItVenda);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredienteList.size();
    }

    @Override
    public IngItVenda montaItem(Ingrediente dao) {
        IngItVenda ingItVenda = new IngItVenda();
        ingItVenda.setIngredienteId(dao);
        ingItVenda.setItemVendaId(itemVenda);
        return ingItVenda;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.checkBox)
        CheckBox checkBox;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
