package com.concorriente.monster_inc.vestidor;

import java.util.concurrent.TimeUnit;
import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.banos.*;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase principal que modelara el comportamiento del vestidor implementando
 * Runnable y haciendo que cada hilo ejecute la tarea de algun monstruo.
 * @author ADLG.
 * @author DJLP.
 */
public class Vestidor implements Runnable
{
    static Queue<Monstruo> monstruos;
    static List<Monstruo> monstruosLista;
    Random random = new Random();
    Lock candadoL = new ReentrantLock();

    /**
     * Establece los monstruos en esta zona de la empresa.
     * @param m la lista con los monstruos ya inicializados.
     */
    public void setMonstruos(List<Monstruo> m)
    {
        this.monstruos = new LinkedList<>(m);
        this.monstruosLista = m;
    }
    
    /**
     * Regresa una lista con los monstruos ya inicializados.
     * @return la lista con los monstruos ya inicializados.
     */
    public List<Monstruo> getMonstruos()
    {
        return monstruosLista;
    }

    /* Constructor vacio para el Vestidor.*/
	public Vestidor(){}

    /**
     * El metodo run donde cada monstruo realizara sus respectivas 
     * acciones en sus respectivos casilleros.
     */
	@Override
    public void run()
    {
    	candadoL.lock();
        try
        {
            Monstruo monstruo = monstruos.poll();
            int opc = random.nextInt(3)+1;
            switch(opc)
            {
                case 1:
                	System.out.println("*ACCIONES DEL "+monstruo.getNombre()+" EN EL VESTIDOR");
                    System.out.println("El monstruo esta asignandole una contrasena a su locker...");
                    monstruo.setContrasenaCasillero();
                    System.out.println("Ahora el monstruo puede usar su Casillero :D");
                    monstruo.dejar_cosasCasillero("Casco");
                    monstruo.dejar_cosasCasillero("Desodorante");
                    monstruo.dejar_cosasCasillero("Toalla");
                    monstruo.ponerse_casco();
					monstruo.ponerse_desodorante();System.out.println();Thread.sleep(1800);
                break;
                case 2:
                	System.out.println("*ACCIONES DEL "+monstruo.getNombre()+" EN EL VESTIDOR");
                    System.out.println("El monstruo esta asignandole una contrasena a su locker...");
                    monstruo.setContrasenaCasillero();
                    System.out.println("Ahora el monstruo puede usar su Casillero :D");
                    monstruo.dejar_cosasCasillero("Casco");
                    monstruo.dejar_cosasCasillero("Desodorante");
                    monstruo.ponerse_casco();
					monstruo.ponerse_desodorante();System.out.println();Thread.sleep(1800);
                break;
                case 3:
                	System.out.println("*ACCIONES DEL "+monstruo.getNombre()+" EN EL VESTIDOR");
                    System.out.println("El monstruo esta asignandole una contrasena a su locker...");
                    monstruo.setContrasenaCasillero();
                    System.out.println("Ahora el monstruo puede usar su Casillero :D");
                    monstruo.mostrar_Casillero();
                    monstruo.dejar_cosasCasillero("Casco");
                    monstruo.ponerse_casco();System.out.println();Thread.sleep(1800);
                break;
                default:
                    System.out.println("Algo salio mal");
            }
        }catch(InterruptedException e) {e.printStackTrace();}
        candadoL.unlock();
    }

    /**
     * El main para probar los casilleros y las acciones de los monstruos en
     * el vestidor haciendo uso de hilos.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
	public static void main(String[] args) throws InterruptedException
	{
		Vestidor vestidor = new Vestidor();
        List<Thread> threads = new ArrayList<>();

        for (Monstruo i: monstruosLista)
        {
            Thread t = new Thread(vestidor,i.getNombre());
            threads.add(t);
        }

        for (Thread i: threads)
            i.start();

        for (Thread i: threads)
            i.join();
	}
}