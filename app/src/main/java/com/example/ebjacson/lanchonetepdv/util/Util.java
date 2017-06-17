package com.example.ebjacson.lanchonetepdv.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebjacson.lanchonetepdv.model.Caixa;
import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Usuario;
import com.example.ebjacson.lanchonetepdv.model.Venda;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jacson on 12/05/2017.
 */

public abstract class Util {
    public static Usuario usuario;
    public static Venda venda;
    public static Caixa caixa;
    public static List<ItemVenda> itemVendaList;
    public static List<IngItVenda> ingItVendaList;
    public static List<ObsItVenda> obsItVendaList;

    public static String doubleParaStringText(Double db){
        BigDecimal bd = new BigDecimal(db);
        if(bd.toString().equals("0")) {
            return " 0,00";
        }else{
            return bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString().replace(".", ",");
        }
    }

    public static Double removeTextMoney(TextView textView){
        if(!textView.getText().toString().equals("")){
            System.out.println("removeTM " + Double.valueOf(textView.getText().toString().replace("\\D","").replace(".","").replace(",",".")));
            return  Double.valueOf(textView.getText().toString().replace("\\D","").replace(".","").replace(",","."));
        }
        return 0.0;
    }

    public static void mensagemToast(Context context, String str){
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
