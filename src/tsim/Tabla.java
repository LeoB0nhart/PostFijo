/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsim;

import automata.NumeroTokens;
import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Tabla implements NumeroTokens {

    private ArrayList<Variable> variables;
    private Tabla madre;
    private ArrayList<Tabla> hijas;

    private int posIni;
    private int posFin;

    public Tabla() {
    }

    public Tabla(Tabla madre) {
        this.madre = madre;
        variables = new ArrayList<>();
        hijas = new ArrayList<>();
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public Tabla getMadre() {
        return madre;
    }

    public void setMadre(Tabla madre) {
        this.madre = madre;
    }

    public ArrayList<Tabla> getHijas() {
        return hijas;
    }

    public void setHijas(ArrayList<Tabla> hijas) {
        this.hijas = hijas;
    }

    public int getPosIni() {
        return posIni;
    }

    public void setPosIni(int posIni) {
        this.posIni = posIni;
    }

    public int getPosFin() {
        return posFin;
    }

    public void setPosFin(int posFin) {
        this.posFin = posFin;
    }

    public static Tabla generaTabla(ArrayList<Lexema> fuente, int pos, Tabla madre) {

        Tabla actual = new Tabla(madre);
        actual.setPosIni(pos);

        for (int i = pos; i < fuente.size(); i++) {

            if (fuente.get(i).is(VARIABLE) && fuente.get(i - 1).is(TIPO_DATO) && fuente.get(i + 1).is(OPERADOR_ASIGNACION)) {

                Variable temp = new Variable(fuente.get(i - 1), fuente.get(i));
                ArrayList<Lexema> valor = new ArrayList<>();

                /**
                 * Posicionar i en donde empieza valor
                 */
                i += 2;

                Lexema v = fuente.get(i);
                while (!v.is(PUNTO_COMA)) {
                    valor.add(v);
                    i++;
                    v = fuente.get(i);
                }

                temp.setValor(valor);
                actual.getVariables().add(temp);

            } else if (fuente.get(i).is(LLAVE_AP)) {

                Tabla t = generaTabla(fuente, i + 1, actual);
                actual.getHijas().add(t);
                i = t.getPosFin();

            } else if (fuente.get(i).is(LLAVE_CI)) {

                actual.setPosFin(i);

                return actual;

            }

        }

        return actual;
    }

    public void imprime(int n) {

        String nTabs = "";

        for (int i = 0; i < n; i++) {
            nTabs += "\t";
        }

        System.out.println(nTabs + "------------------------------------------------------------------------------------");
        for (int i = 0; i < variables.size(); i++) {
            System.out.println(nTabs + variables.get(i));
        }
        System.out.println(nTabs + "------------------------------------------------------------------------------------");

        if (hijas.size() != 0) {
            for (int i = 0; i < hijas.size(); i++) {
                hijas.get(i).imprime(n + 1);
            }
        }

    }

}
