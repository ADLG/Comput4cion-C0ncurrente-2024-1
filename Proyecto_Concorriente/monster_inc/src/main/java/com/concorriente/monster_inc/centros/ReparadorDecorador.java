package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;

/**
 * Clase abstracta que implementara IReparador para 
 * decorar con el metodo repara a un reparador de tipo IReparador.
 * @author ADLG.
 * @author DJLP.
 */
public abstract class ReparadorDecorador implements IReparador
{
	protected IReparador reparadorDecorado;

	/**
	 * Constructor del reparador decorador.
	 * @param reparadorDecorado el reparador que sera decorado.
 	 */
	public ReparadorDecorador(IReparador reparadorDecorado)
	{
		this.reparadorDecorado = reparadorDecorado;
	}

	/**
	 * Repara un tanque dejando sus usos en 0.
	 * @param tanque el tanque a reparar.
	 */
	@Override public void repara(ITanques tanque)
	{
		reparadorDecorado.repara(tanque);
	}
}