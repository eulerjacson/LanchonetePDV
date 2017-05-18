package com.example.ebjacson.lanchonetepdv.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.presenter.impl.VendaPagerPresenter;
import com.example.ebjacson.lanchonetepdv.util.Util;
import com.example.ebjacson.lanchonetepdv.view.IVendaPagerFragment;
import com.example.ebjacson.lanchonetepdv.view.adapters.VendaProdutosAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jacson on 06/05/2017.
 */

public class VendaPagerFragment extends Fragment implements IVendaPagerFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SECTION_IDGRUPO = "section_idgrupo";
    Unbinder unbinder;

    //presenter
    VendaPagerPresenter vendaPagerPresenter;

    //adapter
    VendaProdutosAdapter vendaProdutosAdapter;

    //atr
    Long idGrupo;

    @BindView(R.id.rvProdutos)
    RecyclerView rvProdutos;

    public VendaPagerFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static VendaPagerFragment newInstance(int sectionNumber, long idGrupo) {
        VendaPagerFragment fragment = new VendaPagerFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putLong(ARG_SECTION_IDGRUPO, idGrupo);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_venda, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        idGrupo = getArguments().getLong(ARG_SECTION_IDGRUPO);

        vendaPagerPresenter = new VendaPagerPresenter(this);
        vendaPagerPresenter.carregarRecyclerProduto(idGrupo);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void montaRecyclerProduto(List<Produto> produtoList) {
        vendaProdutosAdapter = new VendaProdutosAdapter(getContext(), produtoList, Util.venda);
        rvProdutos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvProdutos.setAdapter(vendaProdutosAdapter);
    }
}
