package kas.concurrrente;

import java.util.Scanner;

import kas.concurrrente.snapshot.Snapshot;
import kas.concurrrente.snapshotImp.WFSnapshot;
import kas.concurrrente.candadosImpl.PetersonLock;
import kas.concurrrente.lock.Lock;
/**
 * Clase Main para simular la fabrica de tortillas con WFSnapshot.
 * @author DJLP   
 * @author ADLG
 */
public class Main implements Runnable
{
    private Snapshot<Integer> almacen;
    private int [] carga;
    private Lock lock = new PetersonLock();
    private static int contadorCons;
    
    /**
     * Constructor para inicializa la capacidad, carga y contador para la fabrica.
     * @param capacidad la capacidad de la fabrica.
     */
    public Main(int capacidad)
    {
        this.almacen = new WFSnapshot<Integer>(capacidad, 0);
        carga = new int[10];
        contadorCons = 0;
    }

    /**
     * Run sobreescrito de Runnable para el funcionamiento de los hilos.
     */
    @Override public void run()
    {
        if (Thread.currentThread().getName().equals("Consumidor"))
        {
            for (int i=0; i<10; i++)
            {   
                System.out.println("Consumidor acomodando tortillas...");
                lock.lock();
                contadorCons++;
                lock.unlock();
            }
        }
        else
        {
                lock.lock();
            System.out.println("Productor: "+Thread.currentThread().getName());
            almacen.update(1);
            int id = Integer.parseInt(Thread.currentThread().getName());
            carga[id] = 1;
                lock.unlock();
        }
    }

    /* Main para probar el funcionamiento de la fabrica. */
    public static void main(String[] args) throws InterruptedException
    {
        Main tortiMain = new Main(10);
        Thread[] productores = new Thread[10];
        Thread consumidor = new Thread(tortiMain,"Consumidor");

        System.out.println("\n\t\t**Fabrica de Tortillas**\n");

        for (int i=0; i<productores.length; i++)
        {
            productores[i] = new Thread(tortiMain,""+i);
        }
        System.out.println("Productores comenzando a trabajar...");
        for (int i=0; i<productores.length; i++)
        {
            productores[i].start();
        }
        consumidor.start();

        for (int i=0; i<productores.length; i++)
        {
            productores[i].join();
        }
        consumidor.join();

        System.out.println("\n**Tortillas producidas por los Productores:");
        imprime(tortiMain.getAlmacen().scan());

        System.out.println("\n**El consumidor carga con el peso de "+contadorCons+" tortillas.\n");
    }

    /**
     * Regresa el almacen en forma de Snapshot.
     * @return el almacen en forma de Snapshot.
     */ 
    public Snapshot<Integer> getAlmacen()
    {
        return almacen;
    }

    /**
     * Imprime el almacen.
     * @param almacen el almacen a imprimir.
     */ 
    public static void imprime(Object[] almacen)
    {
        for (int i = 0; i < almacen.length; i++)
        {
            System.out.println("Lugar: " + i + " con almacenamiento de " + almacen[i]+" tortilla.");
        }
    }
}