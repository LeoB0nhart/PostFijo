/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoIntermedio;

import java.util.ArrayList;
import static automata.NumeroTokens.*;
import lexema.Lexema;

/**
 *
 * @author bondy
 */
public class GeneraEtiquetas {
    public ArrayList<Lexema> programa;
    public ArrayList<String> codigoIntermedio = new ArrayList<>();
    GeneraListasEtiquetas generaListasEtiquetas;
    int linea=0;
    public GeneraEtiquetas(ArrayList<Lexema> programa){
        this.programa=programa;
    }
    
    public void generarEtiquetas(){
        while(linea<programa.size()){
            if (programa.get(linea).is(IF)) {
                System.out.println("Acá si está entrando -------------------------------");
                generaListasEtiquetas = new GeneraListasEtiquetas("if");
                generaListasEtiquetas.generaEtiquetas();
                System.out.println("Etiqueta Verdadera:\tEtiqueta Falsa:\tEtiqueta Siguiente:");
                System.out.println(generaListasEtiquetas.etiquetaVerdadera.get(0)+"\t\t"+
                        generaListasEtiquetas.etiquetaFalsa.get(0)+"\t\t"+
                        generaListasEtiquetas.etiquetaSiguiente.get(0));
               break;
            }else{
                linea++;
            }
        }
        
            while(!programa.get(linea).is(LLAVE_AP)){
                codigoIntermedio.add(programa.get(linea).getLexema()+" ");
                linea ++;
            }
            linea++;
            codigoIntermedio.add("goto "+ generaListasEtiquetas.etiquetaVerdadera.get(0)+"\n");
            codigoIntermedio.add("goto "+ generaListasEtiquetas.etiquetaFalsa.get(0)+"\n");
            codigoIntermedio.add(generaListasEtiquetas.etiquetaVerdadera.get(0)+":\n");
            while(!programa.get(linea).is(LLAVE_CI)){
                while(!programa.get(linea).is(PUNTO_COMA)){
                    codigoIntermedio.add(programa.get(linea).getLexema()+" ");
                    linea++;
                }
                codigoIntermedio.add("\n");
                linea ++;
            }
            linea++;
            if(programa.get(linea).is(ELSE)){
                linea++;
                codigoIntermedio.add(generaListasEtiquetas.etiquetaFalsa.get(0)+":\n");
                while(!programa.get(linea).is(LLAVE_AP)){
                codigoIntermedio.add(programa.get(linea).getLexema()+" ");
                linea ++;
                }
                linea++;
                while(!programa.get(linea).is(LLAVE_CI)){
                while(!programa.get(linea).is(PUNTO_COMA)){
                    codigoIntermedio.add(programa.get(linea).getLexema()+" ");
                    linea++;
                }
                codigoIntermedio.add("\n");
                linea ++;
            }
            }
            codigoIntermedio.add(generaListasEtiquetas.etiquetaSiguiente.get(0)+":\n");
            for (String line : codigoIntermedio) {
                System.out.print(line);
            }
    }
}
