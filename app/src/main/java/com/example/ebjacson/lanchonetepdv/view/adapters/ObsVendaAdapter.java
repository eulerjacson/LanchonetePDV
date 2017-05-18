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
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IIngreVendaAdapter;
import com.example.ebjacson.lanchonetepdv.view.IObsVendaAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ObsVendaAdapter extends RecyclerView.Adapter<ObsVendaAdapter.ViewHolder> implements IObsVendaAdapter {
    private Context mContext;
    private List<Observacao> observacaoList;
    private ItemVenda itemVenda;

    public ObsVendaAdapter(Context mContext, List<Observacao> observacaoList, ItemVenda itemVenda) {
        this.mContext = mContext;
        this.observacaoList = observacaoList;
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

        final Observacao dao = observacaoList.get(position);
        final ObsItVenda obsItVenda = montaItem(dao);

        if(Util.obsItVendaList.contains(obsItVenda)){
            viewHolder.checkBox.setChecked(true);
        }

        viewHolder.checkBox.setText(dao.getDescobs());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Util.obsItVendaList.add(obsItVenda);
                }else{
                    Util.obsItVendaList.remove(obsItVenda);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return observacaoList.size();
    }

    @Override
    public ObsItVenda montaItem(Observacao dao) {
        ObsItVenda obsItVenda = new ObsItVenda();
        obsItVenda.setObservacaoId(dao);
        obsItVenda.setItemVendaId(itemVenda);
        return obsItVenda;
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
