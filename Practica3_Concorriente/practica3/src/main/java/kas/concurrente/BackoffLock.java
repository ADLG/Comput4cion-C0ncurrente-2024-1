package kas.concurrente;

import java.util.concurrent.atomic.*;
import java.util.Random;
/**
 * Clase que implementa Exponential BackoffLock.
 * @author DJLP   
 * @author ADLG
 */
public class BackoffLock implements Lock
{
    //Clase para representar la parte de Backoff.
    public class Backoff
    {
        final int minDelay, maxDelay; //Valores de delay minimo y maximo.
        int limit; //Limite de delay.
        final Random random; //Entero random.

        /**
         * Constructor para ALock.
         * @param min el delay minimo inicial.
         * @param max el delay maximo inicial.
         */
        public Backoff(int min, int max)
        {
            minDelay = min; //Delay minimo inicial.
            maxDelay = min; //Delay maximo inicial.
            limit = minDelay; //Delay limite actual.
            random = new Random(); //Objeto random.
        }

        /**
         * Realiza el backoff.
         * @throws InterruptedException en caso de que ocurra algun error con el sleep().
         */
        public void backoff() throws InterruptedException
        {
            int delay = random.nextInt(limit); //Delay aleatorio entre 0 el limite actual.
            limit = Math.min(maxDelay, 2 * limit); //Se duplica el limite para el proximo delay hasta el delay maximo.
            Thread.sleep(delay); //Se bloquea al hilo el tiempo que se genero en el delay.
        }
    }

    private AtomicBoolean state = new AtomicBoolean(false); //Valor booleano inicializado en false.
    private static final int MIN_DELAY = 1; //Delays establecidos.
    private static final int MAX_DELAY = 100; //Delays establecidos.

    /**
     * Realiza el Lock de BackoffLock.
     */
    @Override public void lock()
    {
        Backoff backoff = new Backoff(MIN_DELAY, MAX_DELAY); //Objeto Backoff con delay minimo de 1 y delay maximo de 100.
        while (true) //While para leer el lock muchas veces.
        {
            while (state.get()) {}; //while para comprobar si se puede tomar el lock.
            if (!state.getAndSet(true)) //Si esta disponible el lock, entonces se adquiere.
            {
                return; //Return para salir del ciclo.
            }
            else //Si no esta disponible el lock, se hace un retroceso con ayuda del metodo backoff().
            {
                try{backoff.backoff();} //Se hace un try (por el sleep del backoff()) para calcular el delay aleatorio, dormir al hilo y duplicar el limite del delay.
                catch (InterruptedException ie){ie.printStackTrace();} //Catch en caso de un InterruptedException.
            }
        }
    }
    
    /**
     * Realiza el Unlock de BackoffLock.
     */
    @Override public void unlock()
    {
        state.set(false); //Se establece el valor de state en false.
    }
    
}
