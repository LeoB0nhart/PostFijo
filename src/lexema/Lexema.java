/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexema;

/**
 *
 * @author alan
 */
public class Lexema {

    private String lexema;
    private int token;

    public Lexema(String lexema, int token) {
        this.lexema = lexema;
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public boolean is(int that) {
        return that == token;
    }

    @Override
    public String toString() {
        return "Lexema: " + this.lexema + "\t\tToken: " + this.token;
    }

}
