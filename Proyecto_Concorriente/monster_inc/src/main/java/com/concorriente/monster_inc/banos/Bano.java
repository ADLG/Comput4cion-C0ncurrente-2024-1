package com.concorriente.monster_inc.banos;

import java.util.Random;
import com.concorriente.monster_inc.monstruos.*;

/**
 * Clase que abstracta que modelara el comportamiento de los 4 tipos de banos.
 * @author ADLG.
 * @author DJLP.
 */
public abstract class Bano
{
    Cubiculo [] cubiculos;
    int cubiculosDisponibles;
    int capacidad;

    /**
     * Nos dice si la el bano esta lleno.
     * @return true si el bano esta lleno, false en otro caso.
     */
    public abstract boolean estaLleno();
    /**
     * Deja entrar a un monstruo a un bano.
     * @param nombre el numero de hilo que ejecutara las acciones del monstruo.
     * @param monstruo el monstruo que usara el bano.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public abstract void entraMonstruo(int nombre, Monstruo monstruo) throws InterruptedException;
    /**
     * Asigna un cubiculo a un monstruo.
     * @param cubiculo el cubiculo al cual entrara el monstruo.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
    public abstract void asignaCubiculo(int cubiculo) throws InterruptedException;
    /**
     * Regresa el id de un cubiculo de un tipo de bano.
     * @return el id del cubiculo.
     */
    public abstract int obtenCubiculo();
    /**
     * Regresa los cubiculos del bano.
     * @return los cubiculos del bano.
     */
    public abstract Cubiculo [] getCubiculos();
    /**
     * Asigna los cubiculos en un bano.
     * @param cubiculos que seran asignados en el bano.
     */
    public abstract void setCubiculos(Cubiculo [] cubiculos);
    /**
     * Regresa el numero de cubiculos disponibles.
     * @return el numero de cubiculos disponibles.
     */
    public abstract int getCubiculosDisponibles();
    /**
     * Establece el numero de cubiculos disponibles en un bano.
     * @param cubiculosDisponibles los cubiculos disponibles.
     */
    public abstract void setcubiculosDisponibles(int cubiculosDisponibles);
}