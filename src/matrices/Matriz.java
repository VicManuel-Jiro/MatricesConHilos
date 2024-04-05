/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author Jiro
 */
public class Matriz {

    private int[][] A;
    private String nombre;
    public Matriz(String _n,int _f, int _c) {
        nombre=_n;
        A = new int[_f][_c];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = (int) (Math.random() * (5));
            }
        }
    }
    public synchronized void desplegar() {
        System.out.println("\nmatriz " +nombre+":");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] < 10) {
                    System.out.print("0" + A[i][j] + " ");
                } else {
                    System.out.print(A[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
    public synchronized void multiplica(Matriz _a,Matriz _b){
        Matriz a=_a;
        Matriz b=_b;
        int p;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    p = 0;
                    for (int k = 0; k < a.getnumcolumnas(i); k++) {
                        p = p + (a.getElemento(i, k) * b.getElemento(k, j));
                    }
                    A[i][j] = p;
                }
            }
    }
    
    public synchronized int getnumfilas(){
    return A.length;
    }
    public synchronized int getnumcolumnas(int i){
    return A[i].length;
    }
    public synchronized void setElemento(int _e,int _f,int _c){
        A[_f][_c]=_e;
    }
    public synchronized int getElemento(int _f,int _c){
        return A[_f][_c];
    }
}
