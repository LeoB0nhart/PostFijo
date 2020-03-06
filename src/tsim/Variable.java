/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsim;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Variable {

    private Lexema tipoDato;
    private Lexema nombre;
    private ArrayList<Lexema> valor;

    public Variable(Lexema tipoDato, Lexema nombre) {
        this.tipoDato = tipoDato;
        this.nombre = nombre;
    }

    public Lexema getNombre() {
        return nombre;
    }

    public void setNombre(Lexema nombre) {
        this.nombre = nombre;
    }

    public Lexema getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Lexema tipoDato) {
        this.tipoDato = tipoDato;
    }

    public ArrayList<Lexema> getValor() {
        return valor;
    }

    public void setValor(ArrayList<Lexema> valor) {
        this.valor = valor;
    }

    public String getValorResumido() {
        String vr = "";

        for (int i = 0; i < valor.size(); i++) {
            vr += valor.get(i).getLexema();
        }

        return vr;
    }

    @Override
    public String toString() {
        return "| Nombre: " + this.nombre.getLexema() + "\t | Tipo de dato: " + tipoDato.getLexema() + "\t | Valor: " + getValorResumido();
    }

}
