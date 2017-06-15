package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.model.ProGruIng;
import com.example.ebjacson.lanchonetepdv.model.ProGruObs;
import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.view.IIngObsProAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/06/2017.
 */

public class IngObsProAdapter extends RecyclerView.Adapter<IngObsProAdapter.ViewHolder> implements IIngObsProAdapter {
    private Context mContext;
    private List<Object> objectList;
    private List<Object> objectListProGru;

    private Produto produto;

    public IngObsProAdapter(Context mContext, Produto produto, List<Object> objectList, List<Object> objectListProGru) {
        this.mContext = mContext;
        this.objectList = objectList;
        this.objectListProGru = objectListProGru;
        this.produto = produto;
    }

    private Object getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingobspro, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Object dao = getItem(position);

        montandoDados(holder, dao);

        holder.swtIngObsPro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changedCheckIngObs(isChecked, dao);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.swtIngObsPro)
        Switch swtIngObsPro;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void changedCheckIngObs(boolean isChecked, Object dao) {
        if(objectList.get(0) instanceof GrupoIng){
            ProGruIng pgi = new ProGruIng();
            pgi.setGrupoIngId((GrupoIng) dao);
            pgi.setProdutoId(produto);
            if(isChecked)
                pgi.save();
            else
                pgi.delete();
        } else if(objectList.get(0) instanceof GrupoObs){
            ProGruObs pgo = new ProGruObs();
            pgo.setGrupoObsId((GrupoObs) dao);
            pgo.setProdutoId(produto);
            if(isChecked)
                pgo.save();
            else
                pgo.delete();
        }
    }

    @Override
    public void montandoDados(ViewHolder holder, Object dao) {
        if(dao instanceof GrupoIng){
            holder.swtIngObsPro.setText(((GrupoIng) dao).getDescgruing());
            for (Object obj : objectListProGru){
                if(obj instanceof ProGruIng){
                    holder.swtIngObsPro.setChecked(((ProGruIng) obj)
                            .getGrupoIngId().equals(dao));
                }
            }
        } else if(dao instanceof GrupoObs){
            holder.swtIngObsPro.setText(((GrupoObs) dao).getDescgruobs());
            for (Object obj : objectListProGru){
                if(obj instanceof ProGruObs){
                    holder.swtIngObsPro.setChecked(((ProGruObs) obj)
                            .getGrupoObsId().equals(dao));
                }
            }
        }
    }
}
