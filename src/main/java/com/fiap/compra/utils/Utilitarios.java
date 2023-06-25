package com.fiap.compra.utils;

import java.util.Locale;

public class Utilitarios {
    public static String gerarCartao() {
        java.util.Random rand = new java.util.Random();
        return String.format((Locale)null, //don't want any thousand separators
                "52%02d-%04d-%04d-%04d",
                rand.nextInt(100),
                rand.nextInt(10000),
                rand.nextInt(10000),
                rand.nextInt(10000));

    };

    public static Integer gerarLimite() {
        return new java.util.Random().nextInt(2000 - 200) + 200;
    }


}
