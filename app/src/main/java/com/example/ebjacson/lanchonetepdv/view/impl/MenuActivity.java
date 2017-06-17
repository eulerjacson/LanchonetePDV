package com.example.ebjacson.lanchonetepdv.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ebjacson.lanchonetepdv.R;
import com.example.ebjacson.lanchonetepdv.model.Caixa;
import com.example.ebjacson.lanchonetepdv.model.Cliente;
import com.example.ebjacson.lanchonetepdv.model.GrupoIng;
import com.example.ebjacson.lanchonetepdv.model.GrupoObs;
import com.example.ebjacson.lanchonetepdv.model.GrupoProduto;
import com.example.ebjacson.lanchonetepdv.model.Ingrediente;
import com.example.ebjacson.lanchonetepdv.model.Mesas;
import com.example.ebjacson.lanchonetepdv.model.Observacao;
import com.example.ebjacson.lanchonetepdv.model.Produto;
import com.example.ebjacson.lanchonetepdv.util.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.btContasRecMenu)
    Button btContasRecMenu;
    @BindView(R.id.btCadMenu)
    Button btCadMenu;
    @BindView(R.id.btCaiMenu)
    Button btRelMenu;
    @BindView(R.id.btVendaMenu)
    Button btVendaMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        ////CADASTRO GENERICO
        if(Mesas.listAll(Mesas.class).size() == 0) {
            Cliente cliente = new Cliente();
            cliente.setNomecli("Consumidor Final");
            cliente.setCpfcli("00000000000");
            cliente.setEmailcli("consumidorfinal@gmail.com");
            cliente.setBairrocli("");
            cliente.setRuacli("");
            cliente.setNumerocli("");
            cliente.setStatuscli(true);
            cliente.setCidadeId(null);
            cliente.save();

            for (int x = 1; x < 15; x++) {
                Mesas m = new Mesas();
                m.setStatusmesa(0);
                m.setDescmesa("" + x);
                m.setMostrarmesa(true);
                m.save();
            }

            for (int x = 1; x < 6; x++) {
                GrupoProduto g = new GrupoProduto();
                g.setStatusgrupo(true);
                g.setDescgrupo("Grupo " + x);
                g.save();
            }

            for (GrupoProduto grupoProduto : GrupoProduto.listAll(GrupoProduto.class)) {
                Produto p = new Produto();
                p.setGrupoProdutoId(grupoProduto);
                p.setImprimepro(false);
                p.setNomepro("Produto " + grupoProduto.getId());
                p.setPrecopro(10.0);
                p.setStatuspro(true);
                p.save();
                Produto p2 = new Produto();
                p2.setGrupoProdutoId(grupoProduto);
                p2.setImprimepro(false);
                p2.setNomepro("Produto 1" + grupoProduto.getId());
                p2.setPrecopro(10.0);
                p2.setStatuspro(true);
                p2.save();
            }

            for (int x = 1; x <= 3; x++) {
                GrupoIng g = new GrupoIng();
                g.setDescgruing("GrupoIng " + x);
                g.setStatusgruing(true);
                g.save();
                Ingrediente i = new Ingrediente();
                i.setDescing("Ingrediente " + x);
                i.setValoring(2.0);
                i.setGrupoIngId(g);
                i.setStatusing(true);
                i.save();
            }

            for (int x = 1; x <= 3; x++) {
                GrupoObs g = new GrupoObs();
                g.setDescgruobs("GrupoObs " + x);
                g.setStatusgruobs(true);
                g.save();
                Observacao o = new Observacao();
                o.setDescobs("Observacao " + x);
                o.setGrupoObsId(g);
                o.setStatusobs(true);
                o.save();
            }
        }

        List<Caixa> caixaList = Caixa.listAll(Caixa.class);
        if(caixaList.size() > 0){
            Util.caixa = caixaList.get(caixaList.size() - 1);
        }
    }

    @OnClick(R.id.btVendaMenu)
    public void vendaClick(){
        if(Util.caixa != null && Util.caixa.getStatuscai()) {
            Intent intent = new Intent(this, MapaMesasActivity.class);
            startActivity(intent);
            finish();
        } else {
            Util.mensagemToast(this, getString(R.string.naopossuicaixaaberto));
        }
    }

    @OnClick(R.id.btCadMenu)
    public void cadClick(){
        Intent intent = new Intent(this, CadastroNavActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btCaiMenu)
    public void caixaClick(){
        Intent intent = new Intent(this, CaixaActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btContasRecMenu)
    public void contasRecClick(){

    }
}
