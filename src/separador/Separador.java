/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package separador;

import io.Stream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author alan
 */
public class Separador {

    private static final String SEPARADORES = "!<>&|(){}[]+-*/%=;:";

    public static ArrayList<String> separaPalabras(String archivo) {
        ArrayList<String> lineas = Stream.leer(archivo);
        lineas = identificaStrings(lineas);
        lineas = quitaEspaciosBlancos(lineas);
        lineas = separaPunto(lineas);
        ArrayList<String> pSeparadas = new ArrayList<>();

        StringTokenizer tokenizer;
        for (String linea : lineas) {
            tokenizer = new StringTokenizer(linea, SEPARADORES, true);
            while (tokenizer.hasMoreTokens()) {
                pSeparadas.add(tokenizer.nextToken());
            }
        }

        pSeparadas = corrigeOperadores(pSeparadas);
        return pSeparadas;
    }

    /**
     * ******************************
     *
     * Funciones para corregir lo que no hace StringTokenizer por defecto
     *
     */
    private static ArrayList<String> corrigeOperadores(ArrayList<String> p) {
        ArrayList<String> fixed = new ArrayList<>();

        for (int i = 0; i < p.size(); i++) {
            if ((p.get(i).equals(">") || p.get(i).equals("<")
                    || p.get(i).equals("=") || p.get(i).equals("+")
                    || p.get(i).equals("-") || p.get(i).equals("*")
                    || p.get(i).equals("/") || p.get(i).equals("!"))
                    && p.get(i + 1).equals("=")) {
                fixed.add(p.get(i) + "" + p.get(i + 1));
                i++;
            } else if (p.get(i).equals("&") && p.get(i + 1).equals("&")) {
                fixed.add(p.get(i) + "" + p.get(i + 1));
                i++;
            } else if (p.get(i).equals("|") && p.get(i + 1).equals("|")) {
                fixed.add(p.get(i) + "" + p.get(i + 1));
                i++;
            } else if (p.get(i).equals(".") && p.get(i - 1).matches("[0-9]+")
                    && p.get(i + 1).matches("[0-9]+")) {

            } else {
                fixed.add(p.get(i));
            }
        }

        return fixed;

    }

    private static ArrayList<String> quitaEspaciosBlancos(ArrayList<String> lineas) {
        ArrayList<String> lineasSinBlancos = new ArrayList<>();

        StringTokenizer tokenizer;
        for (String linea : lineas) {
            if (!linea.startsWith("\"")) {
                tokenizer = new StringTokenizer(linea);
                while (tokenizer.hasMoreTokens()) {
                    lineasSinBlancos.add(tokenizer.nextToken());
                }
            } else {
                lineasSinBlancos.add(linea);
            }
        }
        return lineasSinBlancos;
    }

    private static ArrayList<String> separaPunto(ArrayList<String> lineas) {
        ArrayList<String> l = new ArrayList<>();

        String[] stringSplit;
        for (String l0 : lineas) {
            if (!l0.startsWith("\"")) {
                stringSplit = l0.split("\\\\.");
                for (int i = 0; i < stringSplit.length; i++) {
                    l.add(stringSplit[i]);
                    if (i != stringSplit.length - 1) {
                        l.add(".");
                    }
                }
            } else {
                l.add(l0);
            }
        }
        return l;
    }

    private static ArrayList<String> identificaStrings(ArrayList<String> lineas) {
        ArrayList<String> l = new ArrayList<>();
        StringTokenizer tokenizer;

        String nextToken = "";

        for (String linea : lineas) {
            tokenizer = new StringTokenizer(linea, "\"", true);
            while (tokenizer.hasMoreTokens()) {
                nextToken = tokenizer.nextToken();

                if (nextToken.equals("\"")) {
                    nextToken = nextToken + tokenizer.nextToken() + tokenizer.nextToken();
                    l.add(nextToken);
                } else {
                    l.add(nextToken);
                }

            }
        }
        return l;
    }
}
