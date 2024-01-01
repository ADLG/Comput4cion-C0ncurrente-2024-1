package kas.concurrrente;

import java.util.Scanner;

import kas.concurrrente.snapshot.Snapshot;
import kas.concurrrente.snapshotImp.WFSnapshot;
import java.time.LocalTime;
import java.util.Arrays;
/**
 * Clase Main que muestra el funcionamiento de la fila de una tortilleria.
 * @author DJLP   
 * @author ADLG
 */
public class Main implements Runnable
{
    static LocalTime horahora;
    static LocalTime [] tiempos;

    /**
     * Run sobreescrito del Runnable.
     */ 
    @Override public void run()
    {
        horahora = LocalTime.now();
        // System.out.println("Cliente: "+Thread.currentThread().getName()+"  Marca de tiempo: "+horahora);
        tiempos[Integer.parseInt(Thread.currentThread().getName())] = horahora;
    }

    /* Main para probar el funcionamiento de la fila de la tortilleria. */
    public static void main(String[] args) throws InterruptedException
    {
        Main tortiMain = new Main();
        Thread[] productores = new Thread[10];
        tiempos = new LocalTime[10];

        System.out.println("\n\t\t**Tortilleria**\n");

        for (int i=0; i<productores.length; i++)
        {
            productores[i] = new Thread(tortiMain,""+i);
        }
        System.out.println("Clientes formandose...");
        System.out.println("Clientes formandose..");
        for (int i=0; i<productores.length; i++)
        {
            productores[i].start();
            productores[i].join();
        }
        System.out.println("Clientes formandose.");

        System.out.println("\nOrdenamiento de tiempos de menor a mayor ...\nOrden de Fila:");
        Arrays.sort(tiempos);
        int c=0;
        for (LocalTime i: tiempos)
        {
            System.out.println("Cliente "+c+": "+i); 
            c++;   
        }
        System.out.println();
    }
}