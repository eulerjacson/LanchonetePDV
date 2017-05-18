package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
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

    public ItensConfirmAdapter(Context mContext, List<ItemVenda> itemVendaList) {
        this.mContext = mContext;
        this.itemVendaList = itemVendaList;
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

        viewHolder.btMaisPV.setText(recuperItemTab(dao));

        if(dao.getStatusitven() != null){
            viewHolder.btMaisPV.setEnabled(false);
            viewHolder.btMenosPV.setEnabled(false);
            viewHolder.btMaisPV.setBackground(mContext.getResources().getDrawable(R.drawable.button_click_verde));
            viewHolder.btMenosPV.setVisibility(View.GONE);
        }

        viewHolder.btMaisPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.btMaisPV.setText(adicionaQtdItem(dao));
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

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btMaisPV)
        Button btMaisPV;
        @BindView(R.id.tvNomeProPV)
        TextView tvNomeProPV;
        @BindView(R.id.btMenosPV)
        Button btMenosPV;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
