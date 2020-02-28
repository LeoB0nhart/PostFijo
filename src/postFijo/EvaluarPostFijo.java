/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postFijo;

/**
 *
 * @author bondy
 */
import java.util.Stack;

public class EvaluarPostFijo {
    String expresion;
    public EvaluarPostFijo(String exp){
        expresion=exp;
    }
    public String obtenerResultado(){
        String[] post = expresion.split(" ");   
   
    //Declaración de las pilas
    Stack < String > E = new Stack < String > (); //Pila entrada
    Stack < String > P = new Stack < String > (); //Pila de operandos


    //Añadir post (array) a la Pila de entrada (E)
    for (int i = post.length - 1; i >= 0; i--) {
      E.push(post[i]);
    }

    //Algoritmo de Evaluación Postfija
    String operadores = "+-*/%";
    while (!E.isEmpty()) {
      if (operadores.contains("" + E.peek())) {
        P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
      }else {
        P.push(E.pop());
      }
    }
    String resultado = P.peek();
    return resultado;
    }

  private static int evaluar(String op, String n2, String n1) {
    int num1 = Integer.parseInt(n1);
    int num2 = Integer.parseInt(n2);
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    if (op.equals("%")) return (num1 % num2);
    return 0;
  }

}
