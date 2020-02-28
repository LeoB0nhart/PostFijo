/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijoV1;

import automata.NumeroTokens;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Postfijo {

    private static final HashMap<String, Integer> JERARQUIA = new HashMap<>();
    private static final Object[][] MAP_JER = {
        {"||", 1},
        {"&&", 2},
        {"!", 3},
        {"=", 4},
        {"==", 4},
        {">", 4},
        {"<", 4},
        {">=", 4},
        {"<=", 4},
        {"!=", 4},
        {"+", 5},
        {"-", 5},
        {"*", 6},
        {"/", 6},
        {"^", 7},
        {"(", 9},
        {")", 9}
    };

    public static ArrayList<Lexema> toPostfijo(ArrayList<Lexema> expresion) {

        /**
         * Asignar a un HashMap la jerarquia de cada operador
         */
        mapJerarquia();

        /**
         * Pila donde se amacenaran temporalmente los operadores y lista donde
         * se almacenara la salida
         */
        Stack<Lexema> operadores = new Stack<>();
        ArrayList<Lexema> salida = new ArrayList<>();

        /**
         * Temporal token, lexema
         */
        String lexema;
        int token;

        /**
         * Recorrer la tabla para convertir a notación postfija la expresión
         */
        for (Lexema simbolo : expresion) {

            lexema = simbolo.getLexema();
            token = simbolo.getToken();

            /**
             * Si el token es un numero o una variable lo inserta en la lista de
             * salida
             */
            if (simbolo.is(NumeroTokens.NUMERO_ENTERO) || simbolo.is(NumeroTokens.NUMERO_REAL)
                    || simbolo.is(NumeroTokens.VARIABLE)) {

                salida.add(simbolo);

                /**
                 * Si el token es un parentesis de apertura "(" lo inserta en la
                 * pila de operadores
                 */
            } else if (simbolo.is(NumeroTokens.PARENTESIS_AP)) {

                operadores.push(simbolo);

                /**
                 * Si el token es un operador, comprobar los operadores que hay
                 * en la pila e irlos sacando
                 */
            } else if (simbolo.is(NumeroTokens.OPERADOR_ARITMETICO) || simbolo.is(NumeroTokens.OPERADOR_ASIGNACION)
                    || simbolo.is(NumeroTokens.OPERADOR_LOGICO) || simbolo.is(NumeroTokens.OPERADOR_RELACIONAL)) {

                while (!operadores.isEmpty() && !operadores.peek().getLexema().equals("(")
                        && esDeMayorPre(lexema, operadores.peek().getLexema())) {
                    salida.add(operadores.pop());
                }

                operadores.add(simbolo);

                /**
                 * Si el token es un parentesis de cierre ")" sacar hasta que el
                 * primer elemento de la pila sea un parentesis de apertura o
                 * hasta que la pila este vacia
                 */
            } else if (simbolo.is(NumeroTokens.PARENTESIS_CI)) {

                while (!operadores.isEmpty() && !operadores.peek().getLexema().equals("(")) {
                    salida.add(operadores.pop());
                }

                if (!operadores.isEmpty()) {
                    if (operadores.peek().getLexema().equals("(")) {
                        operadores.pop();
                    }
                }

            }

        }

        /**
         * Mientras la pila de operadores no este vacia sacar los operadores y
         * meterlos a la lista de salida
         */
        while (!operadores.isEmpty()) {
            salida.add(operadores.pop());
        }

        return salida;
    }

    /**
     * Compara si el operador2 es de mayor precedencia que el operador1.
     *
     * @param operador1 operador 1
     * @param operador2 operador 2
     * @return true si el operador2 es de mayor o igual precedencia, false si
     * no.
     */
    private static boolean esDeMayorPre(String operador1, String operador2) {
        int precedenciaOperador1 = JERARQUIA.get(operador1);
        int precedenciaOperador2 = JERARQUIA.get(operador2);

        if (precedenciaOperador1 <= precedenciaOperador2) {
            return true;
        }
        return false;

    }

    private static void mapJerarquia() {
        for (Object[] op : MAP_JER) {
            JERARQUIA.put((String) op[0], (Integer) op[1]);
        }
    }

}
