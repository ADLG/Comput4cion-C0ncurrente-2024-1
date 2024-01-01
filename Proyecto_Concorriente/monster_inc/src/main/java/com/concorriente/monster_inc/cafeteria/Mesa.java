package com.concorriente.monster_inc.cafeteria;

import com.concorriente.monster_inc.monstruos.Monstruo;
import java.util.List;

/**
 * Clase que modelara el comportamiento de las mesas.
 * @author ADLG.
 * @author DJLP.
 */
public class Mesa
{
	int numero_Mesa;
	int capacidad;
	Monstruo [] monstruos;
	String [] cubiertos;
	String t="Tenedor",c="Cuchara",k="Cuchillo";
	Platillo [] platillos;

	/**
     * Constructor para las mesas donde se pondran cubiertos en forma de String.
     * @param numero_Mesa el id de la mesa.
     * @param capacidad la capacidad de la mesa.
     */
	public Mesa (int numero_Mesa, int capacidad)
	{
		this.numero_Mesa = numero_Mesa;
		this.capacidad = capacidad;
		monstruos = new Monstruo[capacidad];
		cubiertos = new String[capacidad];
		platillos = new Platillo[capacidad];
		for (int i=0; i<capacidad; i++)
			cubiertos[i] = t;
	}

    /**
     * Regresa la capacidad de la mesa.
     * @return la capacidad de la mesa.
     */
	public int getCapacidad(){return capacidad;}

	/**
     * Regresa el numero de la mesa.
     * @return el numero de la mesa.
     */
	public int getNumero_Mesa(){return numero_Mesa;}

	/**
     * Asigna a un monstruo a una mesas disponible.
     * @param monstruo el que sera asignado a una mesa.
     * @param indice el indice del monstruo que sera asignado.
     */
	public void asignaLugares(Monstruo monstruo, int indice){monstruos[indice]=monstruo;}

	/**
     * Regresa el arreglo de monstruos de la mesa.
     * @return el arreglo de monstruos de la mesa.
     */
	public Monstruo [] regresa(){return monstruos;}

	/**
     * Regresa los platillos de la mesa.
     * @return los platillos de la mesa.
     */
	public Platillo [] getPlatillos(){return platillos;}


	/**
	 * Nos dice si la mesa esta llena.
     * @return true si la mesa esta llena, false en caso contrario.
     */
	public boolean mesa_Llena()
	{
		for (Monstruo i: monstruos)
		{
			if (i == null)
				return false;
		}
		return true;
	}
		

}