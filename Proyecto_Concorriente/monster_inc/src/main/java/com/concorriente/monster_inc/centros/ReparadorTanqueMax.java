package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
/**
 * Clase que implementara ReparadorDecorador para 
 * decorar con el metodo para repararar Maxi tanques.
 * @author ADLG.
 * @author DJLP.
 */
public class ReparadorTanqueMax extends ReparadorDecorador
{
	/**
	 * Constructor del reparador de Maxi tanques.
	 * @param reparadorDecorado el reparador que sera decorado.
 	 */
	public ReparadorTanqueMax(IReparador reparadorDecorado)
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
		reparaTanqueMax(tanque);
	}

	/**
	 * Repara un Maxi tanque dejando sus usos en 0.
	 * @param tanque el Maxi tanque a reparar.
	 */
	public void reparaTanqueMax(ITanques tanque)
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		try{Thread.sleep(200);}
		catch (InterruptedException ie){ie.printStackTrace();}
		tanque.reparar();
		System.out.println(ANSI_GREEN+"MaxiTanque Reparado :)"+rest);
	}
}