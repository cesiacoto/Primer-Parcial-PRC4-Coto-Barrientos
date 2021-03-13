/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcialejercicio1;

import java.util.Scanner;


/**
 *
 * @author Norman
 *
 * realizar formula cuadratica
 */
public class ExamenParcialEjercicio1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        double a, b, c;
        double X = 0;

        System.out.print("digite valor de a: ");
        a = teclado.nextInt();
        System.out.print("digite valor de b: ");
        b = teclado.nextInt();
        System.out.print("digite valor de c: ");
        c = teclado.nextInt();

        double x = Math.pow(b, 2) - (4 * a * c);
        /*Math.pow(Numero, Exponente)*/

        double x1 = ((b * (-1)) + Math.sqrt(x)) / (2 * a);
        double x2 = ((b * (-1)) - Math.sqrt(x)) / (2 * a);
        System.out.print("x1= \n " + x1);
        System.out.print("\nx2= \n" + x2); 
        System.out.println("\nFinal de la operacion \n ");

    }

}
