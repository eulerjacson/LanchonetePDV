package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.model.Venda;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IVendaProdutosAdapter;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacson on 05/05/2017.
 */

public class VendaProdutosAdapter extends RecyclerView.Adapter<VendaProdutosAdapter.ViewHolder> implements IVendaProdutosAdapter {
    private Context mContext;
    private List<Produto> produtoList;
    private Venda venda;
    public List<ItemVenda> itemVendaList;

    public VendaProdutosAdapter(Context mContext, List<Produto> produtoList, Venda venda) {
        this.mContext = mContext;
        this.produtoList = produtoList;
        this.venda = venda;
        itemVendaList = Util.itemVendaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produtovenda, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final Produto dao = produtoList.get(position);

        viewHolder.tvNomeProPV.setText(dao.getNomepro());

        viewHolder.btMaisPV.setText(recuperItemTab(dao));

        viewHolder.btMaisPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.btMaisPV.getText().toString().equals("+")) {
                    viewHolder.btMaisPV.setText(criaAdicionaItem(true, dao));
                } else {
                    viewHolder.btMaisPV.setText(criaAdicionaItem(false, dao));
                }
            }
        });

        viewHolder.btMenosPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!viewHolder.btMaisPV.getText().toString().equals("+")) {
                    viewHolder.btMaisPV.setText(removeDiminuiItem(dao));
                }
            }
        });

        viewHolder.tvNomeProPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!viewHolder.btMaisPV.getText().toString().equals("+")) {
                    abreDialogDetalhes(dao);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    @Override
    public String criaAdicionaItem(boolean ehPrimeiro, Produto produto) {
        ItemVenda iv = new ItemVenda();
        iv.setProdutoId(produto);
        if (ehPrimeiro) {
            iv.setDataitven(new Date());
            iv.setQtditven(1);
            //iv.setStatusitven(true);
            iv.setVlracresitven(0.0);
            iv.setVlrsubtotitven(produto.getPrecopro());
            iv.setVlrtotalitven(produto.getPrecopro());
            iv.setVlrunitven(produto.getPrecopro());
            iv.setVendaId(venda);
            itemVendaList.add(iv);
        } else {
            int pos = itemVendaList.indexOf(iv);
            iv = itemVendaList.get(pos);
            iv.setQtditven(iv.getQtditven() + 1);
            iv.setVlrsubtotitven(iv.getVlrunitven() * iv.getQtditven());
            iv.setVlrtotalitven((iv.getVlrunitven() * iv.getQtditven()) + (iv.getVlracresitven() * iv.getQtditven()));
        }
        return iv.getQtditven().toString();
    }

    @Override
    public String removeDiminuiItem(Produto produto) {
        ItemVenda iv = new ItemVenda();
        iv.setProdutoId(produto);

        int pos = itemVendaList.indexOf(iv);
        iv = itemVendaList.get(pos);

        int novaQtd = iv.getQtditven() - 1;

        if (novaQtd == 0) {
            itemVendaList.remove(pos);
            return "+";
        } else {
            iv.setQtditven(novaQtd);
            iv.setVlrsubtotitven(iv.getVlrunitven() * iv.getQtditven());
            iv.setVlrtotalitven((iv.getVlrunitven() * iv.getQtditven()) + (iv.getVlracresitven() * iv.getQtditven()));
        }

        return iv.getQtditven().toString();
    }

    @Override
    public String recuperItemTab(Produto produto) {
        ItemVenda iv = new ItemVenda();
        iv.setProdutoId(produto);
        int pos = itemVendaList.indexOf(iv);
        if (pos >= 0) {
            iv = itemVendaList.get(pos);
            return iv.getQtditven().toString();
        }
        return "+";
    }

    @Override
    public void abreDialogDetalhes(Produto produto) {
        ItemVenda iv = new ItemVenda();
        iv.setProdutoId(produto);
        int pos = itemVendaList.indexOf(iv);
        if (pos >= 0) {
            iv = itemVendaList.get(pos);
        }
        DialogDetalhes dialogDetalhes = new DialogDetalhes(mContext, iv);
        dialogDetalhes.show();
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

    public class DialogDetalhes extends AlertDialog {

        @BindView(R.id.rvIngredientes)
        RecyclerView rvIngredientes;
        @BindView(R.id.rvObservacoes)
        RecyclerView rvObservacoes;

        ItemVenda itemVenda;

        IngreVendaAdapter ingreVendaAdapter;

        protected DialogDetalhes(@NonNull Context context, ItemVenda iv) {
            super(context);
            itemVenda = iv;
            ingreVendaAdapter = new IngreVendaAdapter(mContext, Ingrediente.find(Ingrediente.class, "statusing = ?", "1"), iv);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_detalhes);
            View view = View.inflate(getContext(), R.layout.dialog_detalhes, null);
            ButterKnife.bind(this, view);
        }
    }
}