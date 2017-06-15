package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.presenter.impl.ProdutoCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IProdutoCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProdutoCadActivity extends AppCompatActivity implements IProdutoCad {

    @BindView(R.id.etNomePro)
    EditText etNomePro;
    @BindView(R.id.etPrecoPro)
    EditText etPrecoPro;
    @BindView(R.id.spGruProCad)
    Spinner spGruProCad;
    @BindView(R.id.swtImprimepro)
    Switch swtImprimepro;
    @BindView(R.id.swtStatusPro)
    Switch swtStatusPro;
    @BindView(R.id.btCancelarProCad)
    Button btCancelarProCad;
    @BindView(R.id.btDelProCad)
    Button btDelProCad;
    @BindView(R.id.btSaveProCad)
    Button btSaveProCad;
    @BindView(R.id.btProGruIng)
    Button btProGruIng;
    @BindView(R.id.btProGruObs)
    Button btProGruObs;

    Produto produto;

    ProdutoCadPresenter produtoCadPresenter;

    GenericSpinnerAdapter adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_cad);
        ButterKnife.bind(this);

        if (getIntent().getExtras() != null) {
            long cod = getIntent().getExtras().getLong("codcli");
            produto = Produto.findById(Produto.class, cod);
        }

        produtoCadPresenter = new ProdutoCadPresenter(this);
        produtoCadPresenter.buscarGruProList();

        montaProTela();
    }

    @OnClick(R.id.btCancelarProCad)
    void clickCancel() {
        callProdutoList();
    }

    @OnClick(R.id.btDelProCad)
    void clickDel() {
        delObject();
    }

    @OnClick(R.id.btSaveProCad)
    void clickSave() {
        saveObject();
    }

    @OnClick(R.id.btProGruIng)
    void clickProGruIng() {
        if(produto != null && produto.getId() != null) {
            produtoCadPresenter.buscarGruIngList(produto.getId());
        }
    }

    @OnClick(R.id.btProGruObs)
    void clickProGruObs() {
        if(produto != null && produto.getId() != null) {
            produtoCadPresenter.buscarGruObsList(produto.getId());
        }
    }

    @Override
    public void montaProTela() {
        if (produto != null) {
            etNomePro.setText(produto.getNomepro());
            etPrecoPro.setText(produto.getPrecopro().toString());
            swtImprimepro.setChecked(produto.getImprimepro());
            swtStatusPro.setChecked(produto.getStatuspro());
            produto.save();
        } else {
            btDelProCad.setVisibility(View.GONE);
        }
    }

    @Override
    public void saveObject() {
        produto = produto == null ? new Produto() : produto;
        produto.setNomepro(etNomePro.getText().toString());
        produto.setPrecopro(Double.valueOf(etPrecoPro.getText().toString()));
        produto.setImprimepro(swtImprimepro.isChecked());
        produto.setStatuspro(swtStatusPro.isChecked());
        produto.setGrupoProdutoId((GrupoProduto) spGruProCad.getSelectedItem());
        produto.save();
        callProdutoList();
    }

    @Override
    public void delObject() {
        produto.delete();
        callProdutoList();
    }

    @Override
    public void callProdutoList() {
        Intent intent = new Intent(this, ProdutoListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void montaSpinnerGrupo(List<GrupoProduto> grupoProdutos) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(grupoProdutos);
        adapterSpinner = new GenericSpinnerAdapter(this, objectList);
        spGruProCad.setAdapter(adapterSpinner);
    }

    @Override
    public void abrirDialogIngObsPro(List<Object> objectList, List<Object> objectListProGru) {
        DialogIngObsPro dialogIngObsPro = new DialogIngObsPro(this, produto, objectList, objectListProGru);
        dialogIngObsPro.show();
    }
}
