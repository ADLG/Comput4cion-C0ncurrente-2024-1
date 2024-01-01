package com.concorriente.monster_inc.banos;

import java.util.concurrent.TimeUnit;
import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.banos.*;
import com.concorriente.monster_inc.vestidor.*;
import com.concorriente.monster_inc.candado.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal que modelara el comportamiento de los 4 tipos de banos con ayuda de
 * Runnable y haciendo que cada hilo ejecute la tarea de algun monstruo.
 * @author ADLG.
 * @author DJLP.
 */
public class SimulacionBano implements Runnable
{
    static Bano banoescamoso;
    static Bano banomolusco;
    static Bano banopeludo;
    static Bano banopequeno;
    static Queue<Monstruo> monstruos;
    static List<Monstruo> monstruosLista;
    public static Semaphore filtroMod;

    /**
     * Establece los monstruos en esta zona de la empresa.
     * @param m la lista con los monstruos ya inicializados.
     */
    public void setMonstruos(List<Monstruo> m)
    {
        this.monstruos = new LinkedList<>(m);
        this.monstruosLista = new ArrayList<>(m);
    }

    /**
     * Constructor para inicializar cada tipo de bano de tamano 2
     * ademas del filtro que ayudara a que solo pasen de 2 en 2.
     */
    public SimulacionBano()
    {
        banoescamoso = new Bano_Escamoso(2);
        banomolusco = new Bano_Molusco(2);
        banopeludo = new Bano_Peludo(2);
        banopequeno = new Bano_Pequeno(2);

        filtroMod = new Filtro(1,2);
    }

    /**
     * El metodo run donde cada monstruo realizara sus respectivas 
     * necesidades en sus respectivos banos.
     */
    @Override
    public void run()
    {
        try
        {
            filtroMod.acquire();
            Monstruo monstruo = monstruos.poll();
            filtroMod.release();
            int idHilo = (int)(Thread.currentThread().getId());
            switch(monstruo.getTipo_monstruo())
            {
                case "Esc":
                    filtroMod.acquire();
                    banoescamoso.entraMonstruo(idHilo,monstruo); 
                    filtroMod.release();
                break;
                case "Mol":
                    filtroMod.acquire();
                    banomolusco.entraMonstruo(idHilo,monstruo); 
                    filtroMod.release();
                break;
                case "Pel":
                    filtroMod.acquire();
                    banopeludo.entraMonstruo(idHilo,monstruo); 
                    filtroMod.release();
                break;
                case "Peq":
                    filtroMod.acquire();
                    banopequeno.entraMonstruo(idHilo,monstruo); 
                    filtroMod.release();
                break;
                default:
                    System.out.println("Algo salio mal");
            }
        }catch(InterruptedException e) {e.printStackTrace();} 
    }

    /**
     * El main para probar todos los banos con hilos.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public static void main(String[] args) throws InterruptedException
    {
        SimulacionBano simluaBano = new SimulacionBano();
        List<Thread> threads = new ArrayList<>();

        for (Monstruo i: monstruosLista)
        {
            Thread t = new Thread(simluaBano,i.getNombre());
            threads.add(t);
        }

        for (Thread i: threads)
            i.start();

        for (Thread i: threads)
            i.join();
    }
}