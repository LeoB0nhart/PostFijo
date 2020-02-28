/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;
import lexema.Lexema;
import separador.Separador;

/**
 *
 * @author alan
 */
public class Automata implements NumeroTokens {

    /**
     * Automatas
     */
    private static final Object[][] AUTOMATAS = {
        {NUMERO_ENTERO, "[0-9]+"},
        {NUMERO_REAL, "[0-9]+\\.[0-9]+"},
        {VARIABLE, "[a-zA-Z]+"}
    };

    /*
    *   Tokens Fijos
     */
    private static final Object[][] TOKENS_FIJOS = {
        {TIPO_DATO, "int"},
        {TIPO_DATO, "double"},
        {TIPO_DATO, "String"},
        {TIPO_DATO, "boolean"},
        {PUNTO_COMA, ";"},
        {OPERADOR_ARITMETICO, "+"},
        {OPERADOR_ARITMETICO, "-"},
        {OPERADOR_ARITMETICO, "*"},
        {OPERADOR_ARITMETICO, "/"},
        {OPERADOR_ARITMETICO, "%"},
        {OPERADOR_LOGICO, "&&"},
        {OPERADOR_LOGICO, "||"},
        {OPERADOR_LOGICO, "!"},
        {OPERADOR_RELACIONAL, ">="},
        {OPERADOR_RELACIONAL, "<="},
        {OPERADOR_RELACIONAL, "!="},
        {OPERADOR_RELACIONAL, ">"},
        {OPERADOR_RELACIONAL, "<"},
        {OPERADOR_ASIGNACION, "="},
        {PARENTESIS_AP, "("},
        {PARENTESIS_CI, ")"},
        {CORCHETE_AP, "["},
        {CORCHETE_CI, "]"},
        {LLAVE_AP, "{"},
        {LLAVE_CI, "}"}
    };

    public static ArrayList<Lexema> generaLexemas(String ruta) {
        ArrayList<String> palabrasSeparadas = Separador.separaPalabras(ruta);
        ArrayList<Lexema> lexemas = new ArrayList<>();

        boolean isTokenFijo;
        for (String ps : palabrasSeparadas) {
            isTokenFijo = false;

            for (Object[] token : TOKENS_FIJOS) {
                if (ps.equals(token[1])) {
                    lexemas.add(new Lexema(ps, (int) token[0]));
                    isTokenFijo = true;
                    break;
                }
            }

            if (!isTokenFijo) {
                for (Object[] automata : AUTOMATAS) {
                    if (ps.matches((String) automata[1])) {
                        lexemas.add(new Lexema(ps, (int) automata[0]));
                        break;
                    }
                }
            }
        }
        return lexemas;
    }

}
