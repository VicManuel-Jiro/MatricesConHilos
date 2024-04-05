/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jiro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static Scanner entradaEscaner = new Scanner(System.in);
    static String entradaTeclado = "";
    static long inicio;
    static long fin;
   
    static Matriz A;
    static Matriz B;
    static Matriz C;
    public static void main(String[] args) {
        do{
        System.out.print("Ingrese el numero de hilos a usar (1 o 2 hilos): ");
        entradaTeclado = entradaEscaner.nextLine (); 
        }while(!entradaTeclado.equals("1")&&!entradaTeclado.equals("2"));
        int cantidadHilos = Integer.parseInt(entradaTeclado);
        System.out.print("Ingrese el numero de filas de la matriz A ");
        entradaTeclado = entradaEscaner.nextLine (); 
        int fA = Integer.parseInt(entradaTeclado);
        System.out.print("Ingrese el numero de columnas de la matriz A ");
        entradaTeclado = entradaEscaner.nextLine (); 
        int cA = Integer.parseInt(entradaTeclado);
        System.out.print("Ingrese el numero de filas de la matriz B ");
        entradaTeclado = entradaEscaner.nextLine (); 
        int fB = Integer.parseInt(entradaTeclado);
        System.out.print("Ingrese el numero de columnas de la matriz B ");
        entradaTeclado = entradaEscaner.nextLine (); 
        int cB = Integer.parseInt(entradaTeclado);
        if (cA != fB) {
            System.out.print("error, las matrices no se pueden multiplicar");
        } else if (cantidadHilos < 1||cantidadHilos>2) {
            System.out.print("error, ingrese una cantidad de hilos valida");
        } else if (cantidadHilos == 1) {
                inicio = System.nanoTime();
                A = new Matriz("A", fA, cA);
                B = new Matriz("B", fB, cB);
                C = new Matriz("C", fA, cB);
                A.desplegar();
                B.desplegar();
                C.multiplica(A, B);
                C.desplegar();
                fin = System.nanoTime();
            } else if(cantidadHilos>1){
                inicio = System.nanoTime();
                Semaphore s = new Semaphore(0,true);
                A = new Matriz("A", fA, cA);
                B = new Matriz("B", fB, cB);
                C = new Matriz("C", fA, cB);
                multi h2=new multi(A,B,C,s);
                despliegue h2_1=new despliegue(A,B,C,s);
                h2.start();
                h2_1.start();
                fin = System.nanoTime();
            }
            if(cantidadHilos== 1 ||cantidadHilos== 2){
            System.out.println("\nT(" + cantidadHilos + "): " + ((fin - inicio) * 1.0e-9) + " segundos");
            System.out.println("S(" + cantidadHilos + "): " + 0.022997800000000002 / ((fin - inicio) * 1.0e-9));
            System.out.println("E(" + cantidadHilos + "): " + (0.0229978000000000021 / ((fin - inicio) * 1.0e-9))/ cantidadHilos);}
        }
    }
