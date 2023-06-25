package com.fiap.compra.entity.model;

public enum StatusCompra {
    APROVADO,CANCELADO,AGUARDANDO;

    public static boolean contains(String test) {

        for (StatusCompra c : StatusCompra.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}