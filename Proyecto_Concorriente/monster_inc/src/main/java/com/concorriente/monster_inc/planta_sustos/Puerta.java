package com.concorriente.monster_inc.planta_sustos;

import java.util.Random;
/**
 * Clase que modelara el comportamiento de las Puertas.
 * @author ADLG.
 * @author DJLP.
 */
public class Puerta
{
	int id;
	int uso;
	String tipo;
	String evento;
	Random random = new Random();
	int numRand;

    /**
     * Constructor para las puertas las cuales tendran una probabilidad
     * de generarse con un algun defecto para que estas sean reparadas.
     * @param id el id de la puerta.
     * @param tipo el tipo de puerta.
     * @param evento el evento que tiene la puerta.
     */
	public Puerta(int id, String tipo,String evento)
	{
		this.id = id;
		this.tipo = tipo;
		this.evento = evento;

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
     * Anade +1 al uso de la puerta.
     */
	public void usar(){this.uso++;}
	/**
     * Repara la puerta, deja su uso en 0.
     */
	public void reparar(){this.uso = 0;}
	/**
     * Regresa el numero de usos de la puerta.
     * @return el numero de usos de la puerta.
     */
	public int getUso(){return this.uso;}
	/**
     * Regresa el tipo de la puerta.
     * @return el tipo de la puerta.
     */
	public String getTipo(){return this.tipo;}
	/**
     * Regresa el evento de la puerta.
     * @return el evento de la puerta.
     */
	public String getEvento(){return this.evento;}
	/**
     * Regresa el id de la puerta.
     * @return el id de la puerta.
     */
	public int getId(){return this.id;}
	/**
     * Imprime las caracteristicas de la puerta
     */
	public void getInfo()
	{
		System.out.println("Puerta "+id);
		System.out.println("Tipo de puerta:"+tipo);
		System.out.println("Evento:"+evento);
	}

	/**
     * Nos dice si la puerta aun puede usarse o debe de repararse.
     * @return true si aun se puede usar la puerta, false en caso contrario.
     */
	public boolean usoPuerta()
	{
		if (uso+1 > 2)
			return false;
		else
			return true;
	}
}