/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author alan
 */
public interface NumeroTokens {

    public static final int TIPO_DATO = 1;
    public static final int PUNTO_COMA = 2;
    public static final int OPERADOR_ARITMETICO = 3;
    public static final int OPERADOR_LOGICO = 4;
    public static final int OPERADOR_RELACIONAL = 5;
    public static final int OPERADOR_ASIGNACION = 6;
    public static final int VARIABLE = 7;
    public static final int NUMERO_REAL = 8;
    public static final int NUMERO_ENTERO = 9;
    public static final int STRING = 10;

    /**
     *
     */
    public static final int PARENTESIS_AP = 11;
    public static final int PARENTESIS_CI = 12;

    public static final int CORCHETE_AP = 13;
    public static final int CORCHETE_CI = 14;

    public static final int LLAVE_AP = 15;
    public static final int LLAVE_CI = 16;

    public static final int TRUE = 17;
    public static final int FALSE = 18;

    /**
     *
     */
    public static final int IF = 19;
    public static final int ELSE = 20;
    public static final int WHILE = 21;
    public static final int DO = 22;
    public static final int FOR = 23;
    public static final int SWITCH = 24;
    public static final int CASE = 25;
    public static final int FUNCTION = 26;

    public static final int COMILLAS = 27;

    public static final int PRINT = 28;
    public static final int WRITE = 29;

}
