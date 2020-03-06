/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaSimbolos;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author bondy
 */
public class GeneraTablaSimbolos {

    ArrayList<Lexema> programa;
    public int apuntadorLexema = 0;
    ArrayList<String> tablas = new ArrayList<String>();

    public GeneraTablaSimbolos(ArrayList<Lexema> programa) {
        this.programa = programa;
    }

    public ArrayList<String> generaTabla() {
        for (Lexema lexema : programa) {
            apuntadorLexema++;
            if (lexema.getToken() == 15) {
                System.out.println("entró la generación de tablas");
                for(String linea : identificaSimbolos(apuntadorLexema)){
                  tablas.add(linea);
                }
                tablas.add("-------------------------------------");
            }
        }
        return tablas;
    }
    public void tablaRecursiva(){
        
    }
    public ArrayList<String> identificaSimbolos(int posicion) {
        ArrayList<String> listaSimbolos = new ArrayList<>();
        int recorrido = posicion;
        while (programa.get(recorrido).getToken() != 16) {
            if (programa.get(recorrido).getToken() == 1
                    && programa.get(recorrido + 1).getToken() == 7
                    && programa.get(recorrido + 2).getToken() == 2) {
                listaSimbolos.add("Símbolo: " + programa.get(recorrido + 1).getLexema() + " Tipo de dato: "
                        + programa.get(recorrido).getLexema() + " Valor = 0");
            } else if (programa.get(recorrido).getToken() == 1
                    && programa.get(recorrido + 1).getToken() == 7
                    && programa.get(recorrido + 2).getToken() == 6
                    && (programa.get(recorrido + 3).getToken() == 9
                    || programa.get(recorrido + 3).getToken() == 10
                    || programa.get(recorrido + 3).getToken() == 8)
                    && programa.get(recorrido + 4).getToken() == 2) {
                listaSimbolos.add("Símbolo: " + programa.get(recorrido + 1).getLexema() + " Tipo de dato: "
                        + programa.get(recorrido).getLexema() + " Valor = "
                        + programa.get(recorrido + 3).getLexema());
            }
            recorrido++;
        }   
            System.out.println("Acá terminó la primera tabla. En el lexema: "+programa.get(recorrido).getLexema());
            return listaSimbolos;
    }
}
