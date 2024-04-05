/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jiro
 */
import java.util.concurrent.Semaphore;
public class despliegue extends Thread {
    Matriz A;
    Matriz B;
    Matriz C;
    Semaphore s;
    public despliegue(Matriz _a,Matriz _b,Matriz _c,Semaphore _s){
    A=_a;
    B=_b;
    C=_c;
    s=_s;
    }
    
    @Override
    public void run(){
        try {
            s.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(despliegue.class.getName()).log(Level.SEVERE, null, ex);
        }
        A.desplegar();
        B.desplegar();
        C.desplegar();
    }
}
