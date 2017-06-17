package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cliente;
import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IMapaMesasAdapter;
import com.example.ebjacson.lanchonetepdv.view.impl.VendaActivity;
import com.example.ebjacson.lanchonetepdv.view.impl.VendaDetalhesActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/05/2017.
 */

public class MapaMesasAdapter extends BaseAdapter implements IMapaMesasAdapter{
    private Context mContext;
    private List<Mesas> mesasList;

    public MapaMesasAdapter(Context mContext, List<Mesas> mesasList) {
        this.mContext = mContext;
        this.mesasList = mesasList;
    }

    public int getCount() {
        return mesasList.size();
    }

    public Object getItem(int position) {
        return mesasList.get(position);
    }

    public long getItemId(int position) {
        return mesasList.get(position).getId();
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mapamesas, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        final Mesas dao = (Mesas) getItem(position);

        viewHolder.btMapaMesas.setText(dao.getDescmesa());
        if(dao.getStatusmesa() == 0) {
            viewHolder.btMapaMesas.setBackgroundColor(mContext.getResources().getColor(R.color.md_green_500));
        } else if(dao.getStatusmesa() == 1){
            viewHolder.btMapaMesas.setBackgroundColor(mContext.getResources().getColor(R.color.md_red_500));
        }

        viewHolder.btMapaMesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dao.getStatusmesa().equals(0)) {
                    criaVenda(dao);
                    mudaStatusOcupadoMesa(dao);
                    callVendaActivity(dao.getId());
                }else if (dao.getStatusmesa().equals(1)){
                    callVendaDetalhesActivity(dao);
                }
            }
        });

        return itemView;
    }

    @Override
    public void callVendaActivity(Long id) {
        Intent intent = new Intent(mContext, VendaActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void criaVenda(Mesas id) {
        Venda v = new Venda();
        v.setMesasId(id);
        v.setClienteId(Cliente.findById(Cliente.class, (long) 1));
        v.setUsuarioId(Util.usuario);
        v.setDataven(new Date());
        v.setStatusven(true);
        v.setVlracresven(0.0);
        v.setVlrdescven(0.0);
        v.setVlrsubtotven(0.0);
        v.setVlrtotalven(0.0);

        Util.venda = v;
        Util.itemVendaList = new ArrayList<>();
        Util.ingItVendaList = new ArrayList<>();
        Util.obsItVendaList = new ArrayList<>();
    }

    @Override
    public void mudaStatusOcupadoMesa(Mesas id) {
        id.setStatusmesa(1);
        id.save();
    }

    @Override
    public void callVendaDetalhesActivity(Mesas id) {
        List<Venda> vendaList = Venda.find(Venda.class, "mesas_id = ? AND statusven = ?", id.getId().toString(), "1");
        Util.venda = vendaList.size() > 0 ? vendaList.get(vendaList.size() - 1) : null;
        Util.itemVendaList = ItemVenda.find(ItemVenda.class, "venda_id = ?", Util.venda.getId().toString());
        Util.ingItVendaList = new ArrayList<>();
        Util.obsItVendaList = new ArrayList<>();

        for (ItemVenda itemVenda : Util.itemVendaList) {
            Util.ingItVendaList.addAll(IngItVenda.find(IngItVenda.class, "item_venda_id = ?", itemVenda.getId().toString()));
        }

        for (ItemVenda itemVenda : Util.itemVendaList) {
            Util.obsItVendaList.addAll(ObsItVenda.find(ObsItVenda.class, "item_venda_id = ?", itemVenda.getId().toString()));
        }

        Intent intent = new Intent(mContext, VendaDetalhesActivity.class);
        mContext.startActivity(intent);
    }

    static class ViewHolder {
        @BindView(R.id.btMapaMesas)
        Button btMapaMesas;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
