package com.example.ebjacson.lanchonetepdv.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.view.fragment.VendaPagerFragment;

import java.util.List;

/**
 * Created by Jacson on 06/05/2017.
 */

public class VendaGruposAdapter extends FragmentPagerAdapter {

    List<GrupoProduto> grupoProdutoList;

    public VendaGruposAdapter(FragmentManager fm, List<GrupoProduto> grupoProdutoList) {
        super(fm);
        this.grupoProdutoList = grupoProdutoList;
    }

    @Override
    public Fragment getItem(int position) {
        return VendaPagerFragment.newInstance(position + 1, grupoProdutoList.get(position).getId());
    }

    @Override
    public int getCount() {
        return grupoProdutoList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return grupoProdutoList.get(position).getDescgrupo();
    }
}