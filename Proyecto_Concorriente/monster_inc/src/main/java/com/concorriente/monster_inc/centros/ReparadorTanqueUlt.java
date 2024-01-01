package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
/**
 * Clase que implementara ReparadorDecorador para 
 * decorar con el metodo para repararar Ultra tanques.
 * @author ADLG.
 * @author DJLP.
 */
public class ReparadorTanqueUlt extends ReparadorDecorador
{
	/**
	 * Constructor del reparador de Ultra tanques.
	 * @param reparadorDecorado el reparador que sera decorado.
 	 */
	public ReparadorTanqueUlt(IReparador reparadorDecorado)
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
		reparaTanqueUlt(tanque);
	}

	/**
	 * Repara un Ultra tanque dejando sus usos en 0.
	 * @param tanque el Ultra tanque a reparar.
	 */
	public void reparaTanqueUlt(ITanques tanque)
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		try{Thread.sleep(300);}
		catch (InterruptedException ie){ie.printStackTrace();}
		tanque.reparar();
		System.out.println(ANSI_GREEN+"UltraTanque Reparado :)"+rest);
	}
}