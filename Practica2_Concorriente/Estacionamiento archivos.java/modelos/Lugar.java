package kas.concurrente.modelos;

import kas.concurrente.candado.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 * Clase que modela un Lugar
 * El lugar consta de un id
 * un booleano que nos dice si esta dispoible
 * y un objeto del tipo filtro Modificado
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Lugar {
    private int id;
    private volatile boolean disponible;
    private Semaphore filtroModificado;
    private int vecesEstacionado;

    /**
     * Metodo constructor
     * El lugar por defecto esta disponible
     * Pueden llegar un numero n de carros en el 
     * peor de los casos
     * veces estacionado sera el numero de veces que se han estacianado en el lugar
     * @param id El id del Lugar
     */
    public Lugar(int id)
    {
        this.id = id;
        disponible = true;
        filtroModificado = new Filtro(1,2);
        vecesEstacionado = 0;
    }

    /**
     * En este metodo se simula que se estaciona
     * PELIGRO: ESTAS ENTRANDO A LA SECCION CRITICA
     * Cambia el valor de disponible a false
     * Y se simula que vas por barbacoa
     * Al final, imprime un texto color ROJO diciendo que va salir
     * @throws InterruptedException Si algo falla
     */
    public void estaciona() throws InterruptedException
    {
        disponible = false;
        filtroModificado.acquire();

        vecesEstacionado++;

        vePorBarbacoa();

        String rest = "\u001B[0m";
        String colorRojo = "\u001B[31m";
        System.out.println(colorRojo + "Ya se acabo mi hora, voy de salida." + rest);

        filtroModificado.release();
        disponible = true;

    }

    /**
     * En este metodo se genera la sumulación
     * Se genera un tiempo entre 1 y 5 segundos
     * Es pseudo aleatorio
     * @throws InterruptedException En caso de que falle
     */
    public void vePorBarbacoa() throws InterruptedException
    {
        Random random = new Random();
        int numero = random.nextInt(5)+1;
        TimeUnit.MILLISECONDS.sleep(numero);
        String rest = "\u001B[0m";
        String color = "\u001B[33m";
        System.out.println(color+"Barbacoa Time ..."+rest);
    }
    
    /**
     * Regresa el id del lugar
     * @return el id del lugar
     */ 
    public int getId()
    {
        return this.id;
    }

    /**
     * Regresa la disponibilidad del lugar
     * @return true si esta disponible, false en caso contrario
     */ 
    public boolean getDisponible()
    {
        return this.disponible;
    }

    /**
     * Regresa las veces que se han estacionado en el lugar
     * @return las veces que se han estacionado en el lugar
     */ 
    public int getVecesEstacionado()
    {
        return this.vecesEstacionado;
    }

    /**
     * Regresa las veces que se han estacionado en el lugar
     * @return las veces que se han estacionado en el lugar
     */ 
    public Semaphore getFiltroModificado()
    {
        return this.filtroModificado;
    }

    /**
     * Asigna el id del lugar
     * @param id el id a asignar
     */ 
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Asigna la disponibilidad del lugar
     * @param bo el booleano que indicara si esta disponible o no el lugar
     */ 
    public void setDisponible(boolean bo)
    {
        this.disponible = bo;
    }

    /**
     * Asigna las veces que se han estacionado en el lugar
     * @param vecesEstacionado las veces que se han estacionado en el lugar
     */ 
    public void setVecesEstacionado(int vecesEstacionado)
    {
        this.vecesEstacionado+=vecesEstacionado;
    }

}