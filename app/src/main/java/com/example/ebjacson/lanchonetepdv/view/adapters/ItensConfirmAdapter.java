package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IItensConfirmAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/05/2017.
 */

public class ItensConfirmAdapter extends RecyclerView.Adapter<ItensConfirmAdapter.ViewHolder> implements IItensConfirmAdapter {
    private Context mContext;
    public List<ItemVenda> itemVendaList;
    private Boolean ehValores;

    public ItensConfirmAdapter(Context mContext, List<ItemVenda> itemVendaList, Boolean ehValores) {
        this.mContext = mContext;
        this.itemVendaList = itemVendaList;
        this.ehValores = ehValores;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produtovenda, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final ItemVenda dao = itemVendaList.get(position);

        viewHolder.tvNomeProPV.setText(dao.getProdutoId().getNomepro());
        viewHolder.tvIngObs.setVisibility(View.GONE);

        setIngTextView(dao, viewHolder);

        setObsTextView(dao, viewHolder);

        viewHolder.btMaisPV.setText(recuperItemTab(dao));

        trataStatusBotao(dao, viewHolder);

        viewHolder.btMaisPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.btMaisPV.setText(adicionaQtdItem(dao));
                mostraValores(viewHolder, dao);
            }
        });

        viewHolder.btMenosPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!viewHolder.btMaisPV.getText().toString().equals("+")){
                    viewHolder.btMaisPV.setText(removeDiminuiQtdItem(dao));
                }
            }
        });

        mostraValores(viewHolder, dao);
    }

    @Override
    public void mostraValores(ViewHolder viewHolder, ItemVenda dao) {
        if(ehValores){
            viewHolder.btMenosPV.setEnabled(false);
            viewHolder.btMenosPV.setText(dao.getVlrtotalitven().toString());
            viewHolder.btMenosPV.setTextSize(16);
        }
    }

    @Override
    public int getItemCount() {
        return itemVendaList.size();
    }

    @Override
    public String adicionaQtdItem(ItemVenda iv) {
        iv.setQtditven(iv.getQtditven() + 1);
        iv.setVlrsubtotitven(iv.getVlrunitven() * iv.getQtditven());
        iv.setVlrtotalitven((iv.getVlrunitven() * iv.getQtditven()) + (iv.getVlracresitven() * iv.getQtditven()));
        return iv.getQtditven().toString();
    }

    @Override
    public String removeDiminuiQtdItem(ItemVenda iv) {

        int novaQtd = iv.getQtditven() - 1;

        if(novaQtd == 0){
            itemVendaList.remove(iv);
            return "+";
        }else {
            iv.setQtditven(novaQtd);
            iv.setVlrsubtotitven(iv.getVlrunitven() * iv.getQtditven());
            iv.setVlrtotalitven((iv.getVlrunitven() * iv.getQtditven()) + (iv.getVlracresitven() * iv.getQtditven()));
        }

        return iv.getQtditven().toString();
    }

    @Override
    public String recuperItemTab(ItemVenda iv) {
        return iv.getQtditven().toString();
    }

    @Override
    public void setIngTextView(ItemVenda dao, ViewHolder viewHolder) {
        if(Util.ingItVendaList.size() > 0){
            String ing = "";
            for (IngItVenda ingItVenda : Util.ingItVendaList) {
                if(ingItVenda.getItemVendaId().equals(dao)) {
                    ing = ing.concat(ingItVenda.getIngredienteId().getDescing() + " ");
                }
            }
            viewHolder.tvIngObs.setText("(" + ing + ")");
            viewHolder.tvIngObs.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setObsTextView(ItemVenda dao, ViewHolder viewHolder) {
        if(Util.obsItVendaList.size() > 0){
            String obs = "";
            for (ObsItVenda obsItVenda : Util.obsItVendaList) {
                if(obsItVenda.getItemVendaId().equals(dao)) {
                    obs = obs.concat(obsItVenda.getObservacaoId().getDescobs() + " ");
                }
            }
            viewHolder.tvIngObs.setText(viewHolder.tvIngObs.getText().toString() + "(" + obs + ")");
            viewHolder.tvIngObs.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void trataStatusBotao(ItemVenda dao, ViewHolder viewHolder) {
        if(dao.getStatusitven() != null){
            viewHolder.btMaisPV.setEnabled(false);
            viewHolder.btMenosPV.setEnabled(false);
            viewHolder.btMaisPV.setBackground(mContext.getResources().getDrawable(R.drawable.button_click_verde));
            //viewHolder.btMenosPV.setVisibility(View.GONE);
            viewHolder.btMenosPV.setBackground(mContext.getResources().getDrawable(R.drawable.button_click_verde));
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btMaisPV)
        Button btMaisPV;
        @BindView(R.id.tvNomeProPV)
        TextView tvNomeProPV;
        @BindView(R.id.btMenosPV)
        Button btMenosPV;
        @BindView(R.id.tvIngObs)
        TextView tvIngObs;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
