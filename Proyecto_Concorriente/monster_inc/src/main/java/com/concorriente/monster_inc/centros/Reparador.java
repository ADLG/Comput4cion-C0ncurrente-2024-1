package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;

/**
 * Clase que modelara el comportamiento de los reparadores de tanques
 * implementando la interfaz IReparador usando Decorator.
 * @author ADLG.
 * @author DJLP.
 */
public class Reparador implements IReparador
{
	int id;

	/**
	 * Constructor de los reparadores de tanques.
	 * @param id el id del reparador.
 	 */
	public Reparador(int id)
	{
		this.id = id;
	}

	/**
	 * Repara un tanque dejando sus usos en 0.
	 * @param tanque el tanque a reparar.
	 */
	@Override public void repara(ITanques tanque)
	{
		System.out.println("Reparador "+id+" preparandose para reparar");
	}
}