package com.concorriente.monster_inc.banos;

import com.concorriente.monster_inc.candado.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 * Clase que modelara el comportamiento de los cubiculos.
 * @author ADLG.
 * @author DJLP.
 */
public class Cubiculo
{
    private int id;
    private volatile boolean disponible;
    private Semaphore filtroModificado;
    private int vecesEntradoBano;

    /**
     * Constructor de los cubiculos.
     * @param id el id del Cubiculo.
     */
    public Cubiculo(int id)
    {
        this.id = id;
        disponible = true;
        filtroModificado = new Filtro(1,2);
        vecesEntradoBano = 0;
    }

    /**
     * Deja entrar a un monstruo a un cubiculo de un bano.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public void entraAlBano() throws InterruptedException
    {
        disponible = false;
        filtroModificado.acquire();

        vecesEntradoBano++;

        hazCosasDeBano();

        String rest = "\u001B[0m";
        String colorRojo = "\u001B[31m";
        System.out.println(colorRojo + "Ya termine de hacer mis cosas, voy de salida." + rest);

        filtroModificado.release();
        disponible = true;
    }

    /**
     * Deja hacer a un monstruo sus necesidades.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public void hazCosasDeBano() throws InterruptedException
    {
        Random random = new Random();
        int numero = random.nextInt(3)+1;
        // TimeUnit.MILLISECONDS.sleep(numero);
        TimeUnit.SECONDS.sleep(numero);
        String rest = "\u001B[0m";
        String color = "\u001B[33m";
        System.out.println(color+"Bano Time ..."+rest);
    }

    /**
     * Regresa el id del cubiculo.
     * @return el id del cubiculo.
     */
    public int getId(){return this.id;}
    /**
     * Nos dice si el bano esta disponible.
     * @return true si el bano esta dispobible, false en caso contrario.
     */
    public boolean getDisponible(){return this.disponible;}
    /**
     * Establece el id al cubiculo.
     * @param id el id del cubiculo.
     */
    public void setId(int id){this.id = id;}
    /**
     * Establece el estado del cubiculo en dispobible.
     * @param bo el estado del cubiculo.
     */
    public void setDisponible(boolean bo){this.disponible = bo;}
    /**
     * Establece las veces que se ha entrado al cubiculo.
     * @param vecesEntradoBano las veces que se ha entrado al cubiculo.
     */
    public void setVecesEntradoBano(int vecesEntradoBano){this.vecesEntradoBano+=vecesEntradoBano;}
}