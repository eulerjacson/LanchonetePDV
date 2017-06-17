package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.MovCaixa;
import com.example.ebjacson.lanchonetepdv.util.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/06/2017.
 */

public class MovCaixaAdapter extends RecyclerView.Adapter<MovCaixaAdapter.ViewHolder> {
    private Context mContext;
    private List<MovCaixa> movCaixaList;

    public MovCaixaAdapter(Context mContext, List<MovCaixa> movCaixaList) {
        this.mContext = mContext;
        this.movCaixaList = movCaixaList;
    }

    private MovCaixa getItem(int position) {
        return movCaixaList.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movcaixa, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final MovCaixa dao = getItem(position);

        holder.tvDescMovCaiIt.setText(dao.getDescmovcaixa());
        holder.tvVlrMovCaiIt.setText(Util.doubleParaStringText(dao.getVlrmovcai()));

    }

    @Override
    public int getItemCount() {
        return movCaixaList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDescMovCaiIt)
        TextView tvDescMovCaiIt;
        @BindView(R.id.tvVlrMovCaiIt)
        TextView tvVlrMovCaiIt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
