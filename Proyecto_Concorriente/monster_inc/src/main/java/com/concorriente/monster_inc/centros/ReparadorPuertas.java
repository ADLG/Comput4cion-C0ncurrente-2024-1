package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
/**
 * Clase que modelara el comportamiento del reparador de puertas.
 * @author ADLG.
 * @author DJLP.
 */
public class ReparadorPuertas
{
	/* Constructor vacio del reparador de puertas. */
	public ReparadorPuertas(){}

	/**
	 * Repara una puerta dejando sus usos en 0.
	 * @param puerta la puerta a reparar.
	 */
	public void reparaPuerta(Puerta puerta)
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		try{Thread.sleep(300);}
		catch (InterruptedException ie){ie.printStackTrace();}
		puerta.reparar();
		System.out.println(ANSI_GREEN+"Puerta Reparada :)"+rest);
	}
}