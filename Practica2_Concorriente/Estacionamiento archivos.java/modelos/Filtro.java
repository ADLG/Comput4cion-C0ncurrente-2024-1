package kas.concurrente.modelos;

import kas.concurrente.candado.Semaphore;
import java.util.concurrent.locks.*;

/**
 * Clase que modela el Algoritmo del Filtro Modificado
 * @version 1.0
 * @author Kassandra Mirael
 */
public class Filtro implements Semaphore {
    private int maxHilosConcurrentes; // Número máximo de hilos permitidos en la sección crítica
    private int hilos; // Contador de hilos en la sección crítica
    private Lock lock;
    private Condition condition;

    /**
     * Constructor del Filtro
     * @param hilos El numero de Hilos Permitidos
     * @param maxHilosConcurrentes EL numero de hilos concurrentes simultaneos
     */
    public Filtro(int hilos, int maxHilosConcurrentes) {
        this.maxHilosConcurrentes = maxHilosConcurrentes;
        this.hilos = 0;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    @Override
    public int getPermitsOnCriticalSection() {
        return this.maxHilosConcurrentes;
    }

    @Override
    public void acquire()
    {
        lock.lock();
        try {
            while (hilos >= maxHilosConcurrentes) {
                // Esperar si se alcanza el límite de hilos en la sección crítica
                condition.await();
            }
            hilos++;
        } catch (Exception e) {
            
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void release()
    {
        lock.lock();
        try {
            hilos--;
            if (hilos < maxHilosConcurrentes) {
                // Despierta a un hilo en espera si hay espacio en la sección crítica
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
    
}