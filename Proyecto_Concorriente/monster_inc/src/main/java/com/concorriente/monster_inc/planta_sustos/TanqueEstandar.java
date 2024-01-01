package com.concorriente.monster_inc.planta_sustos;

import java.util.Random;

/**
 * Clase que modelara a los tanques estandar implementando
 * la interfaz ITanques.
 * @author ADLG.
 * @author DJLP.
 */
public class TanqueEstandar implements ITanques
{
	int id;
	int capacidad;
	int energia;
	int uso;
	String tipo;
	Random random = new Random();
	int numRand;

	/**
	 * Constructor para los tanques estandar.
	 * @param id el id del tanque.
	 * @param capacidad la capacidad del tanque.
	 */
	public TanqueEstandar(int id,int capacidad)
	{
		this.id = id;
		this.capacidad = capacidad;
		this.energia = 0;
		this.uso = 0;
		this.tipo = "est";
	}

	/**
     * Establece el id al tanque.
     * @param id el id del tanque.
     */
	@Override public void setId(int id)
	{
		this.id = id;
	}
	/**
     * Establece la capacidad del tanque.
     * @param capacidad la capacidad del tanque.
     */
	@Override public void setCapacidad(int capacidad)
	{
		this.capacidad = capacidad;
	}
	/**
     * Establece el tipo del tanque.
     * @param tipo el tipo del tanque.
     */
	@Override public void setTipe(String tipo)
	{
		this.tipo = tipo;
	}
	/**
     * Regresa el id del tanque.
     * @return el id del tanque.
     */
	@Override public int getId()
	{
		return id;
	}
	/**
     * Regresa la capacidad del tanque.
     * @return la capacidad del tanque.
     */
	@Override public int getCapacidad()
	{
		return capacidad;
	}
	/**
     * Regresa el tipo del tanque.
     * @return el tipo del tanque.
     */
	@Override public String getTipe()
	{
		return tipo;
	}
	/**
     * Carga energia al tanque.
     * @param energia la cantidad de energia que se asignara.
     * @param opc el tipo de asignacion.
     */
	@Override public void cargarEnergia(int energia,int opc)
	{
		if (opc == 1)
			this.energia += energia;
		else
			this.energia = energia;
	}
	/**
     * Regresa la energia que tiene el tanque.
     * @return la energia que tiene el tanque.
     */
	@Override public int getEnergia()
	{
		return energia;
	}
	/**
     * Genera una probabilidad de que se rompa el tanque.
     */
	@Override public void setUso()
	{
		numRand = random.nextInt(10)+1;
		if (numRand < 3)
		{
			this.uso = 3;
		}
		else
		{
			this.uso = 0;
		}
	}
	/**
     * Regresa el numero de usos del tanque.
     * @return el numero de usos del tanque.
     */
	@Override public int getUso()
	{
		return uso;
	}
	/**
     * Repara el tanque, establece los usos en 0.
     */
	@Override public void reparar()
	{
		this.uso = 0;
	}
	/**
     * Nos dice si el tanque puede ser cargado por energia todavia.
     * @return true si el tanque tiene espacio para mas energia, false caso contrario.
     */
	@Override public boolean checaTanque(int energia)
	{
		if (this.energia+energia > capacidad)
			return false;			
		else 
			return true;
	}
}