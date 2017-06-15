package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/06/2017.
 */

public class GenericSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {
    private Context mContext;
    private List<Object> objectList;

    public GenericSpinnerAdapter(Context mContext, List<Object> objectList) {
        this.mContext = mContext;
        this.objectList = objectList;
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public Object getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final Object dao = getItem(position);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_generic_sp, parent, false);

        ViewHolder holder = new ViewHolder(itemView);

        if (dao instanceof GrupoProduto) {
            holder.textViewSp.setText(((GrupoProduto) dao).getDescgrupo());
        } else if (dao instanceof GrupoIng) {
            holder.textViewSp.setText(((GrupoIng) dao).getDescgruing());
        } else if (dao instanceof GrupoObs) {
            holder.textViewSp.setText(((GrupoObs) dao).getDescgruobs());
        } else if (dao instanceof Estado) {
            holder.textViewSp.setText(((Estado) dao).getNomeest());
        } else if (dao instanceof Cidade) {
            holder.textViewSp.setText(((Cidade) dao).getNomecid());
        }

        return itemView;
    }

    static class ViewHolder {
        @BindView(R.id.textViewSp)
        TextView textViewSp;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
