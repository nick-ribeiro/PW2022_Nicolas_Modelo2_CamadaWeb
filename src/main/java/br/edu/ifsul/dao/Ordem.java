package br.edu.ifsul.dao;

import java.io.Serializable;

public class Ordem implements Serializable{
    
    private String atributo;
    private String label;
    private String operador;

    public String getAtributo() {
        return atributo;
    }

    public Ordem(String atributo, String label, String operador) {
        this.atributo = atributo;
        this.label = label;
        this.operador = operador;
    }

    @Override
    public String toString() {
        return label;
    }
    
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
