package com.cccpharma.util;

import com.cccpharma.models.*;
import java.util.Comparator;

public class MeuComparador implements Comparator<Produto> {
    public static final int POR_NOME = 1;
    public static final int POR_PRECO = 2;
    int tipoComparacao;
    public MeuComparador(int tipoComparacao) {
        this.tipoComparacao = tipoComparacao;
    }
    @Override
    public int compare(Produto objeto1, Produto objeto2) {
        int retorno = 0;
        switch (this.tipoComparacao) {
            case POR_NOME:
                retorno = objeto1.getNome().compareTo(objeto2.getNome());
                break;
            case POR_PRECO:
                retorno = objeto1.getPreco().compareTo(objeto2.getPreco());
                break;
            default:
                throw new RuntimeException("opcao invalida");
        }
        return retorno;
    }
};