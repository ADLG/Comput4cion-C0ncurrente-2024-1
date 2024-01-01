package kas.concurrente;

import java.util.concurrent.atomic.*;
/**
 * Clase que implementa Array-Based Locks.
 * @author DJLP   
 * @author ADLG
 */
public class ALock implements Lock
{
    ThreadLocal<Integer> mySlotIndex; //Variable local de subproceso.
    AtomicInteger tail; //Tail de valor AtomicInteger.
    boolean[] flag; //Matriz de booleanos.
    int size; //El numero de hilos.

    /**
     * Constructor para ALock.
     * @param hilos el numero de hilos.
     */
    public ALock(int hilos)
    {
        size = hilos; //Se inicializa el tamaño de los hilos.
        tail = new AtomicInteger(0); //Valor atomico inicializado en 0.
        flag = new boolean[hilos]; //Se inicializa el tamaño de la matriz.
        flag[0] = true; //Indicador 0 inicializado en true.
        mySlotIndex = new ThreadLocal<Integer>(){ //Se inicializa la variable local de subproceso.
        protected Integer initialValue()
        {return 0;}};
    }

    /**
     * Realiza el Lock de ALock.
     */
    @Override public void lock()
    {
        int slot = tail.getAndIncrement() % size; //Se genera un slot del hilo.
        mySlotIndex.set(slot); //Se establece el slot en la variable de subprocesos.
        while (!flag[slot]) Thread.yield(); //While donde un hilo gira hasta adquirir el lock.
    }

    /**
     * Realiza el Unlock de ALock.
     */
    @Override public void unlock()
    {
        int slot = mySlotIndex.get(); //Se obtiene el slot de la variable de subprocesos.
        flag[slot] = false; //Se establece en un indice de la matriz el slot en false.
        flag[(slot + 1) % size] = true; //Se establece el indice del siguiente slot en true.
    }
}