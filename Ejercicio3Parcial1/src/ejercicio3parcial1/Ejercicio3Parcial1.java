/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3parcial1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesia Coto
 */
public class Ejercicio3Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Invocamos un objeto Scanner para ingresar datos desde el teclado
        Scanner objeto = new Scanner(System.in);
        //declaramos las variables nombre de tipo String y edad de tipo int
        boolean bono;
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        Empleado empleado3 = new Empleado();

        ingresardatos(empleado1);
        ingresardatos(empleado2);
        ingresardatos(empleado3);

        calculardatos(empleado1);
        calculardatos(empleado2);
        calculardatos(empleado3);

        bono = validarbonos(empleado1, empleado2, empleado3);
        if (bono == false) {
            empleado1.sueldototal = empleado1.sueldoliquido;
            empleado2.sueldototal = empleado2.sueldoliquido;
            empleado3.sueldototal = empleado3.sueldoliquido;
        }

        imprimirdatos(empleado1, bono);
        imprimirdatos(empleado2, bono);
        imprimirdatos(empleado3, bono);

        comparacionsueldo(empleado1, empleado2, empleado3);
    }

    static void calculardatos(Empleado emp) {
        boolean cargoEncontrado = false;
        if (emp.horas <= 0) {
            System.out.println("Error, las horas ingresadas no pueden ser menor o igual que 0");
        } else {
            if (emp.horas <= 160) {
                emp.sueldo = emp.horas * 9.75;
            } else {
                emp.horasextra = emp.horas - 160;
                emp.sueldo = ((emp.horasextra * 11.50) + (160 * 9.75));
            }
            emp.descISSS = emp.sueldo * 0.0525;
            emp.descAFP = emp.sueldo * 0.0688;
            emp.descRENTA = emp.sueldo * 0.1;
            emp.sueldoliquido = emp.sueldo - emp.descISSS - emp.descAFP - emp.descRENTA;

            if (emp.cargo == "Gerente") {
                emp.bono = emp.sueldoliquido * 0.1;
                cargoEncontrado = true;
            }
            if (emp.cargo == "Asistente") {
                emp.bono = emp.sueldoliquido * 0.05;
                cargoEncontrado = true;
            }
            if (emp.cargo == "Secretaria") {
                emp.bono = emp.sueldoliquido * 0.03;
                cargoEncontrado = true;
            }
            if (cargoEncontrado == false) {
                emp.bono = emp.sueldoliquido * 0.02;
            }
            emp.sueldototal = emp.sueldoliquido + emp.bono;
        }
    }

    static void imprimirdatos(Empleado emp, boolean bono) {
        System.out.println("Nombre del Empleado: " + emp.nombre + " " + emp.apellido);
        System.out.println("Descuento ISSS: " + emp.descISSS);
        System.out.println("Descuento AFP: " + emp.descAFP);
        System.out.println("Descuento RENTA: " + emp.descRENTA);
        System.out.println("Sueldo Liquido a pagar: " + emp.sueldoliquido);

        if (bono == true) {
            System.out.println("Bono a pagar: " + emp.bono);
        } else {
            System.out.println("NO HAY BONO ");
        }
    }

    static void ingresardatos(Empleado emp) {
        Scanner objeto = new Scanner(System.in);

        System.out.println("Ingresar Nombres");
        emp.nombre = objeto.nextLine();
        System.out.println("Ingresar Apellidos: ");
        emp.apellido = objeto.nextLine();
        System.out.println("Ingresar Cargo: ");
        emp.cargo = objeto.nextLine();
        do {
            System.out.println("Ingresar El total de horas trabajadas durante el mes: ");
            emp.horas = objeto.nextInt();
            if (emp.horas <= 0) {
                System.out.println("Error, las horas debe de ser mayor a 0\n");
            }
        } while (emp.horas <= 0);
    }

    static boolean validarbonos(Empleado emp1, Empleado emp2, Empleado emp3) {
        boolean resultado = true;
        if (emp1.cargo.equals("Gerente") && emp2.cargo.equals("Asistente") && emp3.cargo.equals("Secretaria")) {
            resultado = false;
        }
        return resultado;
    }

    static void comparacionsueldo(Empleado emp1, Empleado emp2, Empleado emp3) {

        int contador = 0;
        //Se calcula el salario mayor
        if (emp1.sueldototal > emp2.sueldototal && emp1.sueldototal > emp3.sueldototal) {
            System.out.println("Empleado con Mayor Salario: " + emp1.nombre);
        } else {
            if (emp2.sueldototal > emp1.sueldototal && emp2.sueldototal > emp3.sueldototal) {
                System.out.println("Empleado con Mayor Salario: " + emp2.nombre);
            } else {
                if (emp3.sueldototal > emp1.sueldototal && emp3.sueldototal > emp2.sueldototal) {
                    System.out.println("Empleado con Mayor Salario: " + emp3.nombre);
                } else {
                    System.out.println("Se repiten el salario maximo");
                }
            }
        }
        //Se calcula el salario menor
        if (emp1.sueldototal < emp2.sueldototal && emp1.sueldototal < emp3.sueldototal) {
            System.out.println("Empleado con Menor Salario: " + emp1.nombre);
        } else {
            if (emp2.sueldototal < emp1.sueldototal && emp2.sueldototal < emp3.sueldototal) {
                System.out.println("Empleado con Menor Salario: " + emp2.nombre);
            } else {
                if (emp3.sueldototal < emp1.sueldototal && emp3.sueldototal < emp2.sueldototal) {
                    System.out.println("Empleado con Menor Salario: " + emp3.nombre);
                } else {
                    System.out.println("Se repiten el salario Minimo");
                }
            }
        }
        if (emp1.sueldototal > 300) {
            contador++;
        }
        if (emp2.sueldototal > 300) {
            contador++;
        }
        if (emp3.sueldototal > 300) {
            contador++;
        }
        System.out.println("Numero de empleados que ganan mas de $300: " + contador);
    }
}
