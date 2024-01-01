/**
 * Clase que hace Override al metodo run para los hilos.
 * run() hace uso del lock() y unlock() de la clase Peterson.
 */
public class MyThread extends Thread
{
    private Peterson peterson;
    private int id;

    public MyThread(Peterson peterson, int id) {
        this.peterson = peterson;
        this.id = id;
    }

    @Override
    public void run() {
        // Sección crítica
        peterson.lock(id);
        // Operaciones críticas
        System.out.println("Hilo " + id + " está en la sección crítica");
        peterson.unlock(id);
        // Fin de la sección crítica
    }
}