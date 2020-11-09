package com.example.AluguelEvento.model;

import java.util.ArrayList;

public class contratoControle {
    ArrayList<Contrato> contrato = new ArrayList<>();

    public void listarContratos(){}
    public void gerarMulta(){}
    public void criarContrato(Contrato c){
        contrato.add(c);
    }
}
