package com.concorriente.monster_inc.banos;

import java.util.Random;
import com.concorriente.monster_inc.monstruos.*;

/**
 * Clase que modelara el comportamiento del bano Peludo.
 * @author ADLG.
 * @author DJLP.
 */
public class Bano_Peludo extends Bano
{
    Cubiculo [] cubiculos;
    int cubiculosDisponibles;
    int capacidad;

    /**
     * Constructor del bano Peludo.
     * @param capacidad la capacidad del bano.
     */
    public Bano_Peludo(int capacidad)
    {
        this.capacidad = capacidad;
        this.cubiculosDisponibles = capacidad;

        cubiculos = new Cubiculo[capacidad];
        
        for (int i=0; i<capacidad; i++)
        {
            cubiculos[i] = new Cubiculo(i);
        }
    }

    /**
     * Nos dice si la el bano esta lleno.
     * @return true si el bano esta lleno, false en otro caso.
     */
    public boolean estaLleno()
    {
        for (Cubiculo l: cubiculos)
        {
            if (l.getDisponible() == true)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Deja entrar a un monstruo a un bano.
     * @param nombre el numero de hilo que ejecutara las acciones del monstruo.
     * @param monstruo el monstruo que usara el bano.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public void entraMonstruo(int nombre, Monstruo monstruo) throws InterruptedException
    {   
        if (monstruo.getTipo_monstruo() == "Pel" || monstruo.getTipo_Mplus() == "Pel")
        {  
            System.out.println("Monstruo "+monstruo.getNombre()+" entrando al bano");
            String rest = "\u001B[0m";
            String colorAzul = "\u001B[34m";

            System.out.println(colorAzul + "El "+monstruo.getNombre()+" ha entrado al cubiculo" + rest);

            int c = obtenCubiculo();
            cubiculos[c].setId(nombre);
            cubiculos[c].entraAlBano();
        }
        else
            System.out.println("Lo sentimos este es un bano para monstruos Peludos");
    }

    /**
     * Asigna un cubiculo a un monstruo.
     * @param cubiculo el cubiculo al cual entrara el monstruo.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public void asignaCubiculo(int cubiculo) throws InterruptedException
    {
        int cubiculo_disponible = obtenCubiculo();
        cubiculos[cubiculo_disponible].setId(cubiculo);
    }

    /**
     * Regresa el id de un cubiculo de un tipo de bano.
     * @return el id del cubiculo.
     */
    public int obtenCubiculo()
    {
        Random random = new Random();
        int numero;
        while (true)
        {
            numero = random.nextInt(capacidad);
            if (cubiculos[numero].getDisponible() == true)
            {
                return numero;
            }
        }
    }

    /**
     * Regresa los cubiculos del bano.
     * @return los cubiculos del bano.
     */
    public Cubiculo [] getCubiculos(){return cubiculos;}

    /**
     * Asigna los cubiculos en un bano.
     * @param cubiculos que seran asignados en el bano.
     */
    public void setCubiculos(Cubiculo [] cubiculos){this.cubiculos = cubiculos;}

    /**
     * Regresa el numero de cubiculos disponibles.
     * @return el numero de cubiculos disponibles.
     */
    public int getCubiculosDisponibles(){return cubiculosDisponibles;}

    /**
     * Establece el numero de cubiculos disponibles en un bano.
     * @param cubiculosDisponibles los cubiculos disponibles.
     */
    public void setcubiculosDisponibles(int cubiculosDisponibles){this.cubiculosDisponibles = cubiculosDisponibles;}

    /**
     * Establece el numero de cubiculos disponibles en un bano.
     * @param cubiculosDisponibles los cubiculos disponibles.
     */
}