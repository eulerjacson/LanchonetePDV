package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.ParcelaReceber;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IContasRecAdapter;
import com.example.ebjacson.lanchonetepdv.view.impl.DialogRecebePrazo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ContasRecAdapter extends RecyclerView.Adapter<ContasRecAdapter.ViewHolder> implements IContasRecAdapter {
    private Context mContext;
    private List<ParcelaReceber> parcelaReceberList;
    private ContasRecAdapter contasRecAdapter = this;

    public ContasRecAdapter(Context mContext, List<ParcelaReceber> parcelaReceberList) {
        this.mContext = mContext;
        this.parcelaReceberList = parcelaReceberList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parcelarec, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final ParcelaReceber dao = parcelaReceberList.get(position);

        viewHolder.tvItParRecCli.setText(dao.getContaReceberId().getClienteId().getNomecli());
        viewHolder.tvItParRecData.setText(Util.dataHoraParaString(dao.getDataparrec()));
        viewHolder.tvItParRecValor.setText(Util.doubleParaStringText(dao.getValorparrec()));

        viewHolder.rlItParRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogRecebePrazo dialogRecebePrazo = new DialogRecebePrazo(mContext, dao, contasRecAdapter);
                dialogRecebePrazo.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return parcelaReceberList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvItParRecCli)
        TextView tvItParRecCli;
        @BindView(R.id.tvItParRecData)
        TextView tvItParRecData;
        @BindView(R.id.tvItParRecValor)
        TextView tvItParRecValor;
        @BindView(R.id.rlItParRec)
        RelativeLayout rlItParRec;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void atualizaLista(List<ParcelaReceber> novaLista){
        parcelaReceberList.clear();
        parcelaReceberList.addAll(novaLista);
        this.notifyDataSetChanged();
    }
}
