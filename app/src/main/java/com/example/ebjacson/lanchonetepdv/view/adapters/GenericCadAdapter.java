package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.model.Cliente;
import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.view.IGenericCadAdapter;
import com.example.ebjacson.lanchonetepdv.view.impl.ClienteCadActivity;
import com.example.ebjacson.lanchonetepdv.view.impl.DialogGenericCad;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/06/2017.
 */

public class GenericCadAdapter extends RecyclerView.Adapter<GenericCadAdapter.ViewHolder> implements IGenericCadAdapter {
    private Context mContext;
    private List<Object> objectList;

    public GenericCadAdapter(Context mContext, List<Object> objectList) {
        this.mContext = mContext;
        this.objectList = objectList;
    }

    private Object getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_generic_cad, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Object dao = getItem(position);

        if(dao instanceof GrupoProduto){
            holder.textView.setText(((GrupoProduto) dao).getDescgrupo());
        } else if(dao instanceof GrupoIng){
            holder.textView.setText(((GrupoIng) dao).getDescgruing());
        } else if(dao instanceof GrupoObs){
            holder.textView.setText(((GrupoObs) dao).getDescgruobs());
        } else if(dao instanceof Ingrediente){
            holder.textView.setText(((Ingrediente) dao).getDescing());
        } else if(dao instanceof Observacao){
            holder.textView.setText(((Observacao) dao).getDescobs());
        } else if(dao instanceof Estado){
            holder.textView.setText(((Estado) dao).getNomeest());
        } else if(dao instanceof Cidade){
            holder.textView.setText(((Cidade) dao).getNomecid());
        } else if(dao instanceof Mesas){
            holder.textView.setText(((Mesas) dao).getDescmesa());
        } else if(dao instanceof Cliente){
            holder.textView.setText(((Cliente) dao).getNomecli());
        }

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dao instanceof Cliente){
                    callClienteCad(((Cliente) dao).getId());
                }else {
                    abrirDialog(dao);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void abrirDialog(Object object) {
        DialogGenericCad dialogGenericCad = new DialogGenericCad(mContext, object, this);
        dialogGenericCad.show();
    }

    @Override
    public void atualizaLista(List<Object> novaLista){
        objectList.clear();
        objectList.addAll(novaLista);
        this.notifyDataSetChanged();
    }

    @Override
    public void callClienteCad(Long codCli) {
        Intent intent = new Intent(mContext, ClienteCadActivity.class);
        intent.putExtra("codcli", codCli);
        mContext.startActivity(intent);
    }
}
