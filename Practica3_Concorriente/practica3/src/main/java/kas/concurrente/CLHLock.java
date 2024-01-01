package kas.concurrente;

import java.util.concurrent.atomic.*;
/**
 * Clase que implementa The CLH Queue Lock.
 * @author DJLP   
 * @author ADLG
 */
public class CLHLock implements Lock
{
    //Clase que representa el QNode para el bloqueo de cola.
    private class QNode
    {
        boolean locked = false; //Valor locked establecido como false.
        QNode next = null; //Valor next nulo.
    }
    
    //Lista "virtual" ligada de objetos QNode (se inicializa).
    AtomicReference<QNode> tail = new AtomicReference<QNode>(new QNode());
    ThreadLocal<QNode> myPred; //Predecesor del hilo.
    ThreadLocal<QNode> myNode; //Nodo actual.

    /**
     * Constructor que inicializa la lista ligada.
     */
    public CLHLock()
    {
        //Se inicializa la lista virtual ligada.
        tail = new AtomicReference<QNode>(new QNode());
        myNode = new ThreadLocal<QNode>() //Se inicializa el Nodo actual.
        {
            protected QNode initialValue()
            {
                return new QNode();
            }
        };
        myPred = new ThreadLocal<QNode>() //Se inicializa el pred del hilo.
        {
            protected QNode initialValue()
            {
                return null;
            }
        };
    }

    /**
     * Realiza el Lock de CLHLock.
     */
    @Override public void lock()
    {
        QNode qnode = myNode.get(); //Se obtiene el QNode actual.
        qnode.locked = true; //Adquisicion del lock mediante el true asignado a locked.
        QNode pred = tail.getAndSet(qnode); //Se hace que el propio nodo este en el final de la cola.
        myPred.set(pred); //Se hace referencia al QNode de su pred.
        while (pred.locked) Thread.yield(); //Spin donde gira el hilo en el campo bloqueado del pred hasta que se libere el lock. 
    }

    /**
     * Realiza el Unlock de CLHLock.
     */
    @Override public void unlock()
    {
        QNode qnode = myNode.get(); //Se obtiene el QNode actual.
        qnode.locked = false; //Se libera el lock asignando false a locked.
        myNode.set(myPred.get()); //Se reutiliza el pred como nuevo nodo para futuros accesos.
    }
}
