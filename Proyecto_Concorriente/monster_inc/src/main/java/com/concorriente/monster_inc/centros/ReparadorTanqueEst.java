package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
/**
 * Clase que implementara ReparadorDecorador para 
 * decorar con el metodo para repararar tanques estandar.
 * @author ADLG.
 * @author DJLP.
 */
public class ReparadorTanqueEst extends ReparadorDecorador
{
	/**
	 * Constructor del reparador de tanques estandar.
	 * @param reparadorDecorado el reparador que sera decorado.
 	 */
	public ReparadorTanqueEst(IReparador reparadorDecorado)
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
		reparaTanqueEst(tanque);
	}

	/**
	 * Repara un tanque estandar dejando sus usos en 0.
	 * @param tanque el tanque estandar a reparar.
	 */
	public void reparaTanqueEst(ITanques tanque)
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		try{Thread.sleep(100);}
		catch (InterruptedException ie){ie.printStackTrace();}
		tanque.reparar();
		System.out.println(ANSI_GREEN+"Tanque estandar Reparado :)"+rest);
	}
}