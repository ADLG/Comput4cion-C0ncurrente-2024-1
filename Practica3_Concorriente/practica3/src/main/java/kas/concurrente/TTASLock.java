package kas.concurrente;

import java.util.concurrent.atomic.*;
/**
 * Clase que implementa Test-and-Test-and-Set.
 * @author DJLP   
 * @author ADLG
 */
public class TTASLock implements Lock
{
    AtomicBoolean state = new AtomicBoolean(false); //Valor booleano inicializado en false.

    /**
     * Realiza el Lock de TTASLock.
     */
    @Override public void lock()
    {
        while(true) //While para leer el lock muchas veces.
        {
            while(state.get()) {}; //while para comprobar si se puede tomar el lock.
            if (!state.getAndSet(true)) //Si esta disponible el lock, entonces se adquiere.
            {
                return; //Return para salir del ciclo.
            }
        }
    }

    /**
     * Realiza el Unlock de TTASLock.
     */
    @Override public void unlock()
    {
        state.set(false); //Se establece el valor de state en false.
    }
}
