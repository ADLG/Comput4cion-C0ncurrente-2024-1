package kas.concurrente;

import java.util.concurrent.atomic.*;
/**
 * Clase que implementa Test-And-Set Lock.
 * @author DJLP   
 * @author ADLG
 */
public class TASLock implements Lock
{
    AtomicBoolean state = new AtomicBoolean(false); //Valor booleano inicializado en false.
    
    /**
     * Realiza el Lock de TASLock.
     */
    @Override public void lock()
    {
        //While que aplica repetidamente testAndSet(), aqui el getAndSet(true) hasta que el bloqueo esté libre.
        while(state.getAndSet(true)) {};
    }

    /**
     * Realiza el Unlock de TASLock.
     */
    @Override public void unlock()
    {
        state.set(false); //Se establece el valor de state en false
    }
    
}