package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Cidade;
import com.example.ebjacson.lanchonetepdv.model.Estado;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.view.IDialogGenericCad;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericCadAdapter;
import com.example.ebjacson.lanchonetepdv.view.adapters.GenericSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by euler on 18/05/17.
 */

public class DialogGenericCad extends AlertDialog implements IDialogGenericCad {

    Context context;
    Object object;
    @BindView(R.id.etDlgGenCad)
    EditText etDlgGenCad;
    @BindView(R.id.btCancelarDlgCad)
    Button btCancelarDlgCad;
    @BindView(R.id.btDelDlgCad)
    Button btDelDlgCad;
    @BindView(R.id.btSaveDlgCad)
    Button btSaveDlgCad;
    @BindView(R.id.swtDlgGenCad)
    Switch swtDlgGenCad;
    @BindView(R.id.spDlgGenCad)
    Spinner spDlgGenCad;
    @BindView(R.id.etDlgGenCad2)
    EditText etDlgGenCad2;

    GenericCadAdapter adapter;
    GenericSpinnerAdapter adapterSpinner;

    public DialogGenericCad(@NonNull Context context, Object object, GenericCadAdapter adapter) {
        super(context);
        this.context = context;
        this.object = object;
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_generic_cad);
        setCancelable(false);
        //setTitle(context.getString(R.string.cadastrode) + " " + context.getString(R.string.grupodepro));
        ButterKnife.bind(this);

        if (object instanceof GrupoProduto) {
            spDlgGenCad.setVisibility(View.GONE);
            etDlgGenCad2.setVisibility(View.GONE);
            GrupoProduto gp = ((GrupoProduto) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getDescgrupo());
                swtDlgGenCad.setChecked(gp.getStatusgrupo());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
        } else if (object instanceof GrupoIng) {
            spDlgGenCad.setVisibility(View.GONE);
            etDlgGenCad2.setVisibility(View.GONE);
            GrupoIng gp = ((GrupoIng) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getDescgruing());
                swtDlgGenCad.setChecked(gp.getStatusgruing());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
        } else if (object instanceof GrupoObs) {
            spDlgGenCad.setVisibility(View.GONE);
            etDlgGenCad2.setVisibility(View.GONE);
            GrupoObs gp = ((GrupoObs) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getDescgruobs());
                swtDlgGenCad.setChecked(gp.getStatusgruobs());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
        } else if (object instanceof Ingrediente) {
            etDlgGenCad2.setHint(R.string.valor);
            Ingrediente gp = ((Ingrediente) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getDescing());
                etDlgGenCad2.setText(gp.getValoring().toString());
                swtDlgGenCad.setChecked(gp.getStatusing());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
            montaSpinnerGrupoIng(GrupoIng.listAll(GrupoIng.class));
        } else if (object instanceof Observacao) {
            etDlgGenCad2.setVisibility(View.GONE);
            Observacao gp = ((Observacao) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getDescobs());
                swtDlgGenCad.setChecked(gp.getStatusobs());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
            montaSpinnerGrupoObs(GrupoObs.listAll(GrupoObs.class));
        } else if (object instanceof Estado) {
            spDlgGenCad.setVisibility(View.GONE);
            swtDlgGenCad.setVisibility(View.GONE);
            etDlgGenCad2.setHint(context.getString(R.string.sigla));
            Estado gp = ((Estado) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getNomeest());
                etDlgGenCad2.setText(gp.getSiglaest());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
        } else if (object instanceof Cidade) {
            etDlgGenCad2.setVisibility(View.GONE);
            swtDlgGenCad.setVisibility(View.GONE);
            Cidade gp = ((Cidade) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getNomecid());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
            montaSpinnerEstado(Estado.listAll(Estado.class));
        } else if (object instanceof Mesas) {
            etDlgGenCad2.setVisibility(View.GONE);
            spDlgGenCad.setVisibility(View.GONE);
            Mesas gp = ((Mesas) object);
            if (gp.getId() != null) {
                etDlgGenCad.setText(gp.getDescmesa());
                swtDlgGenCad.setChecked(gp.getMostrarmesa());
            } else {
                btDelDlgCad.setVisibility(View.GONE);
            }
        } else {
            btDelDlgCad.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btCancelarDlgCad)
    void clickCancel() {
        dismiss();
    }

    @OnClick(R.id.btDelDlgCad)
    void clickDel() {
        delObject();
        dismiss();
    }

    @OnClick(R.id.btSaveDlgCad)
    void clickSave() {
        saveObject();
        dismiss();
    }

    @Override
    public void saveObject() {
        if (object instanceof GrupoProduto) {
            GrupoProduto gp = ((GrupoProduto) object);
            gp.setDescgrupo(etDlgGenCad.getText().toString());
            gp.setStatusgrupo(swtDlgGenCad.isChecked());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof GrupoIng) {
            GrupoIng gp = ((GrupoIng) object);
            gp.setDescgruing(etDlgGenCad.getText().toString());
            gp.setStatusgruing(swtDlgGenCad.isChecked());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof GrupoObs) {
            GrupoObs gp = ((GrupoObs) object);
            gp.setDescgruobs(etDlgGenCad.getText().toString());
            gp.setStatusgruobs(swtDlgGenCad.isChecked());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof Ingrediente) {
            Ingrediente gp = ((Ingrediente) object);
            gp.setDescing(etDlgGenCad.getText().toString());
            gp.setValoring(Double.valueOf(etDlgGenCad2.getText().toString()));
            gp.setStatusing(swtDlgGenCad.isChecked());
            gp.setGrupoIngId((GrupoIng) spDlgGenCad.getSelectedItem());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof Observacao) {
            Observacao gp = ((Observacao) object);
            gp.setDescobs(etDlgGenCad.getText().toString());
            gp.setStatusobs(swtDlgGenCad.isChecked());
            gp.setGrupoObsId((GrupoObs) spDlgGenCad.getSelectedItem());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof Estado) {
            Estado gp = ((Estado) object);
            gp.setNomeest(etDlgGenCad.getText().toString());
            gp.setSiglaest(etDlgGenCad2.getText().toString());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof Cidade) {
            Cidade gp = ((Cidade) object);
            gp.setNomecid(etDlgGenCad.getText().toString());
            gp.setEstadoId((Estado) spDlgGenCad.getSelectedItem());
            gp.save();
            atualizaListaAct();
        } else if (object instanceof Mesas) {
            Mesas gp = ((Mesas) object);
            gp.setDescmesa(etDlgGenCad.getText().toString());
            gp.setMostrarmesa(swtDlgGenCad.isChecked());
            gp.setStatusmesa(gp.getStatusmesa() != null ? gp.getStatusmesa() : 0);
            gp.save();
            atualizaListaAct();
        }
    }

    @Override
    public void delObject() {
        if (object instanceof GrupoProduto) {
            ((GrupoProduto) object).delete();
            atualizaListaAct();
        } else if (object instanceof GrupoIng) {
            ((GrupoIng) object).delete();
            atualizaListaAct();
        } else if (object instanceof GrupoObs) {
            ((GrupoObs) object).delete();
            atualizaListaAct();
        } else if (object instanceof Ingrediente) {
            ((Ingrediente) object).delete();
            atualizaListaAct();
        } else if (object instanceof Observacao) {
            ((Observacao) object).delete();
            atualizaListaAct();
        } else if (object instanceof Estado) {
            ((Estado) object).delete();
            atualizaListaAct();
        } else if (object instanceof Cidade) {
            ((Cidade) object).delete();
            atualizaListaAct();
        } else if (object instanceof Mesas) {
            ((Mesas) object).delete();
            atualizaListaAct();
        }
    }

    @Override
    public void atualizaListaAct() {
        List<Object> objectList = new ArrayList<>();
        if (object instanceof GrupoProduto) {
            objectList.addAll(GrupoProduto.listAll(GrupoProduto.class));
        } else if (object instanceof GrupoIng) {
            objectList.addAll(GrupoIng.listAll(GrupoIng.class));
        } else if (object instanceof GrupoObs) {
            objectList.addAll(GrupoObs.listAll(GrupoObs.class));
        } else if (object instanceof Ingrediente) {
            objectList.addAll(Ingrediente.listAll(Ingrediente.class));
        } else if (object instanceof Observacao) {
            objectList.addAll(Observacao.listAll(Observacao.class));
        } else if (object instanceof Estado) {
            objectList.addAll(Estado.listAll(Estado.class));
        } else if (object instanceof Cidade) {
            objectList.addAll(Cidade.listAll(Cidade.class));
        } else if (object instanceof Mesas) {
            objectList.addAll(Mesas.listAll(Mesas.class));
        }
        adapter.atualizaLista(objectList);
    }

    @Override
    public void montaSpinnerGrupoObs(List<GrupoObs> grupoObsList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(grupoObsList);
        adapterSpinner = new GenericSpinnerAdapter(context, objectList);
        spDlgGenCad.setAdapter(adapterSpinner);
    }

    @Override
    public void montaSpinnerGrupoIng(List<GrupoIng> grupoIngList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(grupoIngList);
        adapterSpinner = new GenericSpinnerAdapter(context, objectList);
        spDlgGenCad.setAdapter(adapterSpinner);
    }

    @Override
    public void montaSpinnerEstado(List<Estado> estadoList) {
        List<Object> objectList = new ArrayList<>();
        objectList.addAll(estadoList);
        adapterSpinner = new GenericSpinnerAdapter(context, objectList);
        spDlgGenCad.setAdapter(adapterSpinner);
    }
}