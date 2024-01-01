package com.concorriente.monster_inc.planta_sustos;

/**
 * Clase que modelara el patron de diseno Factory.
 * @author ADLG.
 * @author DJLP.
 */
public class CreaTanqueFabrica
{
	int idTanques = 0;

	/**
	 * Crea los tanques de acuerdo al tipo recibido como parametro.
	 * @param tipo el tipo de tanque que sera creado
	 */
	public ITanques creaTanque(String tipo)
	{
		idTanques++;
		if (tipo.equalsIgnoreCase("est"))
		{
			return new TanqueEstandar(idTanques,100);
		}
		else if (tipo.equalsIgnoreCase("max"))
		{
			return new MaxiTanque(idTanques,250);
		}
		else if (tipo.equalsIgnoreCase("ult"))
		{
			return new UltraTanque(idTanques,400);
		}
		else
		{
			return new GigaTanque(idTanques,800);
		}
	}
}