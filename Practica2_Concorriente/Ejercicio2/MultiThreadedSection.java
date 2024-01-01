import java.util.concurrent.locks.*;
/**
 * Clase que modela los metodos del filtro modificado.
 */ 
public class MultiThreadedSection {
    private int L; // Número máximo de hilos permitidos en la sección crítica
    private int count; // Contador de hilos en la sección crítica
    private Lock lock;
    private Condition condition;

    public MultiThreadedSection(int L) {
        this.L = L;
        this.count = 0;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (count >= L) {
                // Esperar si se alcanza el límite de hilos en la sección crítica
                condition.await();
            }
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            count--;
            if (count < L) {
                // Despierta a un hilo en espera si hay espacio en la sección crítica
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
