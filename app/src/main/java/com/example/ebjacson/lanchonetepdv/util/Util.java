package com.example.ebjacson.lanchonetepdv.util;

import com.example.ebjacson.lanchonetepdv.model.IngItVenda;
import com.example.ebjacson.lanchonetepdv.model.ItemVenda;
import com.example.ebjacson.lanchonetepdv.model.ObsItVenda;
import com.example.ebjacson.lanchonetepdv.model.Usuario;
import com.example.ebjacson.lanchonetepdv.model.Venda;

import java.util.List;

/**
 * Created by Jacson on 12/05/2017.
 */

public abstract class Util {
    public static Usuario usuario;
    public static Venda venda;
    public static List<ItemVenda> itemVendaList;
    public static List<IngItVenda> ingItVendaList;
    public static List<ObsItVenda> obsItVendaList;
}
