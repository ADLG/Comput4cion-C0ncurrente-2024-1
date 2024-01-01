package kas.concurrente.candadosImpl;

import kas.concurrente.candados.Lock;

/**
 * Clase que implementa el candado usando el Legendario
 * algoritmo de PeterGod.
 * @version 1.0
 * @author Kassandra Mirael
 */
public class PetersonLock implements Lock {

    private volatile boolean[] flag = new boolean[2];
    private volatile int victim;

    @Override
    public void lock()
    {
        int i = ((int) Thread.currentThread().getId()) % 2;
        int j = 1 - i;
        flag[i] = true;
        victim = i;
        while (flag[j] && victim == i) {}; // wait
    }

    @Override
    public void unlock()
    {
        int i = ((int) Thread.currentThread().getId()) % 2;
        flag[i] = false;
    }
    
}
