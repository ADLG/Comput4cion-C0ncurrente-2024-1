package kas.concurrente;

import java.util.concurrent.atomic.*;
/**
 * Clase que implementa The MCS Queue Lock.
 * @author DJLP   
 * @author ADLG
 */
public class MCSLock implements Lock
{
    //Clase que representa el QNode para subprocesos que buscan adquirir el lock.
    private class QNode
    {
        boolean locked = false; //Valor locked establecido como false.
        QNode next = null; //Valor next nulo.
    }

    AtomicReference<QNode> tail; //Lista "explicita" ligada de objetos QNode.
    ThreadLocal<QNode> myNode; //Nodo actual.

    /**
     * Constructor que inicializa los valores de las listas.
     */ 
    public MCSLock()
    {
        tail = new AtomicReference<QNode>(null); //Inicializacion de lista ligada.
        myNode = new ThreadLocal<QNode>() //Se inicializa el Nodo actual.
        {
            protected QNode initialValue()
            {
                return new QNode();
            }
        };
    }

    /**
     * Realiza el Lock de MCSLock.
     */
    @Override public void lock()
    {
        QNode qnode = myNode.get(); //Se obtiene el QNode actual.
        QNode pred = tail.getAndSet(qnode); //El hilo agrega su propio QNode al final de la lista.
        if (pred != null) //Si la cola no estaba previamente vacia, entonces.
        {
            qnode.locked = true; //Se adquiere el lock.
            pred.next = qnode; //Se establece que el siguiente campo del QNode del predecesor haga referencia a su propio QNode.
            while(qnode.locked) Thread.yield(); //Spin donde el hilo gira sobre el lock en su propio QNode esperando hasta que se libere el lock.
        }
    }

    /**
     * Realiza el Unlock de MCSLock.
     */
    @Override public void unlock()
    {
        QNode qnode = myNode.get(); //Se obtiene el QNode actual.
        if (qnode.next == null)  //Se comprueba si el siguiente campo del nodo es nulo.
        {
            if (tail.compareAndSet(qnode,null)) //Se verifica si hay algun hilo compitiendo por el lock.
            {
                return; //Return para salir del metodo unlock().
            }
            while(qnode.next == null) Thread.yield(); //Spin hasta que el predecesor del hilo complete su siguiente campo.
        }
        qnode.next.locked = false; //Se libera el lock.
        qnode.next = null; //Se asigna null al siguiente hilo para que se reutilice.
    }
}