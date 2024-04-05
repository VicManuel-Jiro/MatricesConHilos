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
import java.util.concurrent.Semaphore;
public class multi extends Thread {
    Matriz A;
    Matriz B;
    Matriz C;
    Semaphore s;
    public multi(Matriz _a,Matriz _b,Matriz _c,Semaphore _s){
    A=_a;
    B=_b;
    C=_c;
    s=_s;
    }
    @Override
    public void run(){
        C.multiplica(A, B);
        s.release(1);
    }
}
