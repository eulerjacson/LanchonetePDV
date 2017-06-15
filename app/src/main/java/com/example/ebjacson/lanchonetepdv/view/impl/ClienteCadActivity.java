package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.model.Cliente;
import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.presenter.impl.ClienteCadPresenter;
import com.example.ebjacson.lanchonetepdv.view.IClienteCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by euler on 18/05/17.
 */

public class ClienteCadActivity extends AppCompatActivity implements IClienteCad {
    @BindView(R.id.etNomeCli)
    EditText etNomeCli;
    @BindView(R.id.etEmailCli)
    EditText etEmailCli;
    @BindView(R.id.etCpfCli)
    EditText etCpfCli;
    @BindView(R.id.etTelefoneCli)
    EditText etTelefoneCli;
    @BindView(R.id.etRuaCli)
    EditText etRuaCli;
    @BindView(R.id.etNumeroCli)
    EditText etNumeroCli;
    @BindView(R.id.etBairroCli)
    EditText etBairroCli;
    @BindView(R.id.spEstCliCad)
    Spinner spEstCliCad;
    @BindView(R.id.spCidCliCad)
    Spinner spCidCliCad;
    @BindView(R.id.swtStatusCli)
    Switch swtStatusCli;
    @BindView(R.id.btCancelarCliCad)
    Button btCancelarCliCad;
    @BindView(R.id.btDelCliCad)
    Button btDelCliCad;
    @BindView(R.id.btSaveCliCad)
    Button btSaveCliCad;

    Cliente cliente;

    ClienteCadPresenter clienteCadPresenter;

    GenericSpinnerAdapter adapterSpinner;
    GenericSpinnerAdapter adapterSpinnerCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_cad);
        ButterKnife.bind(this);

        if(getIntent().getExtras() != null) {
            long cod = getIntent().getExtras().getLong("codcli");
            cliente = Cliente.findById(Cliente.class, cod);
        }

        clienteCadPresenter = new ClienteCadPresenter(this);
        clienteCadPresenter.buscarEstadoList();

        montaCliTela();

        spEstCliCad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(adapterSpinner.getItem(position) instanceof Estado){
                    Estado estado = (Estado) adapterSpinner.getItem(position);
                    clienteCadPresenter.buscarCidadeList(estado.getId());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick(R.id.btCancelarCliCad)
    void clickCancel() {
        callClienteList();
    }

    @OnClick(R.id.btDelCliCad)
    void clickDel() {
        delObject();
    }

    @OnClick(R.id.btSaveCliCad)
    void clickSave() {
        saveObject();
    }

    @Override
    public void montaCliTela() {
        if(cliente != null){
            etNomeCli.setText(cliente.getNomecli());
            etEmailCli.setText(cliente.getEmailcli());
            etCpfCli.setText(cliente.getCpfcli());
            etTelefoneCli.setText(cliente.getTelefonecli());
            etRuaCli.setText(cliente.getRuacli());
            etNumeroCli.setText(cliente.getNumerocli());
            etBairroCli.setText(cliente.getBairrocli());
            swtStatusCli.setChecked(cliente.getStatuscli());
            cliente.save();
        }else{
            btDelCliCad.setVisibility(View.GONE);
        }
    }

    @Override
    public void saveObject() {
        cliente = cliente == null ? new Cliente() : cliente;
        cliente.setNomecli(etNomeCli.getText().toString());
        cliente.setEmailcli(etEmailCli.getText().toString());
        cliente.setCpfcli(etCpfCli.getText().toString());
        cliente.setTelefonecli(etTelefoneCli.getText().toString());
        cliente.setRuacli(etRuaCli.getText().toString());
        cliente.setNumerocli(etNumeroCli.getText().toString());
        cliente.setBairrocli(etBairroCli.getText().toString());
        cliente.setCidadeId((Cidade) spCidCliCad.getSelectedItem());
        cliente.setStatuscli(swtStatusCli.isChecked());
        cliente.save();
        callClienteList();
    }

    @Override
    public void delObject() {
        cliente.delete();
        callClienteList();
    }

    @Override
    public void callClienteList() {
        Intent intent = new Intent(this, ClienteListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void montaSpinnerEstado(List<Estado> estadoList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(estadoList);
        adapterSpinner = new GenericSpinnerAdapter(this, objectList);
        spEstCliCad.setAdapter(adapterSpinner);
    }

    @Override
    public void montaSpinnerCidade(List<Cidade> cidadeList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(cidadeList);
        adapterSpinnerCidade = new GenericSpinnerAdapter(this, objectList);
        spCidCliCad.setAdapter(adapterSpinnerCidade);
    }
}