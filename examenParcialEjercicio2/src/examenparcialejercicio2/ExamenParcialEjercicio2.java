/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcialejercicio2;

import java.util.Scanner;

/**
 *
 * @author Norman
 */
public class ExamenParcialEjercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc = 1;
        int cand1=0, cand2=0, cand3=0, cand4=0; /*se coloca 0 para inicializar
            de lo contrario da error en switch*/
        int total=0;

        Scanner teclado = new Scanner(System.in);

        System.out.println("ingrese valores de del 1 al 4. cada numero es un candidato");
        System.out.println("si ingresa datos mnor que 1 y mayor que 4 el programa se cierra");
        System.out.println("         ");
        System.out.println("digite votos: ");
        while (opc > 0 && opc < 5) {
            opc = teclado.nextInt();
             /*par ingresar valores y que sean asignados */
            switch (opc) {
                case 1:
                    cand1++;

                    break;
                case 2:
                    cand2++;

                    break;
                case 3:
                    cand3++;

                    break;
                case 4:
                    cand4++;

                    break;
            }
        }
        
        total = cand1+cand2+cand3+cand4;
        
        System.out.println("candidato 1. votos= "+cand1+ " Porcentaje "+cand1*100/total+" %");
        System.out.println("candidato 2. votos= "+cand2+ " Porcentaje "+cand2*100/total+" %");
        System.out.println("candidato 3. votos= "+cand3+ " Porcentaje "+cand3*100/total+" %");
        System.out.println("candidato 4. votos= "+cand4+ " Porcentaje "+cand4*100/total+" %");

    }
    
    

}
