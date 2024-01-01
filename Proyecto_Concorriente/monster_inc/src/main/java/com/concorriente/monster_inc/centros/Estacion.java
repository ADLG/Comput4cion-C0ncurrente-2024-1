package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.planta_sustos.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento de las estaciones de 
 * trabajo donde generaran energia 2 monstruos.
 * @author ADLG.
 * @author DJLP.
 */
public class Estacion
{
	Monstruo monstruo1;
	Monstruo monstruo2;
	Puerta puerta1;
	Puerta puerta2;

	/**
	 * Constructor de las Estaciones.
	 * @param monstruo1 el monstruo 1 de la estacion.
	 * @param monstruo2 el monstruo 2 de la estacion.
	 * @param puerta1 la puerta 1 de la estacion.
	 * @param puerta2 la puerta 2 de la estacion.
 	 */
	public Estacion(Monstruo monstruo1, Monstruo monstruo2, Puerta puerta1, Puerta puerta2)
	{
		this.monstruo1 = monstruo1;
		this.monstruo2 = monstruo2;
		this.puerta1 = puerta1;
		this.puerta2 = puerta2;
	}

	/**
	 * Asigna puertas a cada monstruo de la estacion.
 	 */
	public void estableceMonstruos()
	{
		monstruo1.recolectaPuerta(puerta1);
		monstruo2.recolectaPuerta(puerta2);
	}

	/**
	 * Hace que un monstruo asuste.
	 * @param tanques los tanques donde se guardara la energia generada.
	 * @param nombreMonstruo el monstruo que asustara.
	 * @param reparadores los reparadores que repararan una puerta o tanque.
 	 */
	public void asustenMonstruos(List<ITanques> tanques,String nombreMonstruo,CentroReparacion reparadores)
	{
		if (monstruo1.getNombre().equals(nombreMonstruo))
			{
				monstruo1.compruebaPuerta(reparadores);
				monstruo1.asustar(tanques,reparadores);
			}
		else
			{
				monstruo1.compruebaPuerta(reparadores);
				monstruo2.asustar(tanques,reparadores);
			}
        try{Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();} 
	}

	/**
	 * Hace que un monstruo haga reir.
	 * @param tanques los tanques donde se guardara la energia generada.
	 * @param nombreMonstruo el monstruo que hara reir.
	 * @param reparadores los reparadores que repararan una puerta o tanque.
 	 */
	public void haganReirMonstruos(List<ITanques> tanques,String nombreMonstruo,CentroReparacion reparadores)
	{
		if (monstruo1.getNombre().equals(nombreMonstruo))
		{
			monstruo1.compruebaPuerta(reparadores);
			monstruo1.hazReir(tanques,reparadores);
		}
		else
		{
			monstruo1.compruebaPuerta(reparadores);
			monstruo2.hazReir(tanques,reparadores);
		}
	}
}