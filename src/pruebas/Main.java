/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import automata.Automata;
import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Lexema> lexemas = Automata.generaLexemas("fuentes/exp");
        lexemas = postfijoV1.Postfijo.toPostfijo(lexemas);

        for (Lexema lexema : lexemas) {
            System.out.println(lexema);
        }
    }
}
