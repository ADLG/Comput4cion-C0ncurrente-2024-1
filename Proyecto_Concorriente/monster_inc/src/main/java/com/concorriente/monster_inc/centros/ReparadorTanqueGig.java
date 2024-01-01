package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
/**
 * Clase que implementara ReparadorDecorador para 
 * decorar con el metodo para repararar Giga tanques.
 * @author ADLG.
 * @author DJLP.
 */
public class ReparadorTanqueGig extends ReparadorDecorador
{
	/**
	 * Constructor del reparador de Giga tanques.
	 * @param reparadorDecorado el reparador que sera decorado.
 	 */
	public ReparadorTanqueGig(IReparador reparadorDecorado)
	{
		super(reparadorDecorado);
	}

	/**
	 * Repara un tanque dejando sus usos en 0.
	 * @param tanque el tanque a reparar.
	 */
	@Override public void repara(ITanques tanque)
	{
		reparadorDecorado.repara(tanque);
		reparaTanqueGig(tanque);
	}

	/**
	 * Repara un Giga tanque dejando sus usos en 0.
	 * @param tanque el Giga tanque a reparar.
	 */
	public void reparaTanqueGig(ITanques tanque)
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		try{Thread.sleep(500);}
		catch (InterruptedException ie){ie.printStackTrace();}
		tanque.reparar();
		System.out.println(ANSI_GREEN+"GigaTanque Reparado :)"+rest);
	}
}