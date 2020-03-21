/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoIntermedio;

import automata.Automata;
import java.util.ArrayList;

/**
 *
 * @author bondy
 */
public class GeneraListasEtiquetas {
    ArrayList<String> etiquetaVerdadera = new ArrayList<>();
    ArrayList<String> etiquetaFalsa = new ArrayList<>();
    ArrayList<String> etiquetaSiguiente = new ArrayList<>();
    String token;
    int contador=10;
    public GeneraListasEtiquetas(String token){
        this.token=token;
    }
    public void generaEtiquetas(){
        if(token.equals("if")){
            etiquetaVerdadera.add(String.valueOf(contador));
            contador += 10;
            etiquetaFalsa.add(String.valueOf(contador));
            contador += 10;
            etiquetaSiguiente.add(String.valueOf(contador));
        }
    }
}
