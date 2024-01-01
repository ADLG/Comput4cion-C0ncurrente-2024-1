package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento del centro de reparacion
 * junto con los reparadores de diferentes tipos de tanques usando Decorator.
 * @author ADLG.
 * @author DJLP.
 */
public class CentroReparacion
{
	IReparador reparador1;
	IReparador reparador2;
	IReparador reparador3;
	IReparador reparador4;

	IReparador reparadorTanqueEst;
	IReparador reparadorTanqueMax;
	IReparador reparadorTanqueUlt;
	IReparador reparadorTanqueGig;
	ReparadorPuertas reparadorPuerta;

	List<String> listaReparacion;

	/**
	 * Constructor del centro de reparacion que inicializara a los 
	 * reparadores de tanques y puertas.
 	 */
	public CentroReparacion()
	{
		reparador1 = new Reparador(1);
		reparador2 = new Reparador(2);
		reparador3 = new Reparador(3);
		reparador4 = new Reparador(4);

		reparadorTanqueEst = new ReparadorTanqueEst(reparador1);
		reparadorTanqueMax = new ReparadorTanqueMax(reparador2);
		reparadorTanqueUlt = new ReparadorTanqueUlt(reparador3);
		reparadorTanqueGig = new ReparadorTanqueGig(reparador4);
		reparadorPuerta = new ReparadorPuertas();

		listaReparacion = new ArrayList<>();
	}

    /**
     * Regresa un reparador de tanques estandar.
     * @return el reparador de tanques estandar.
     */
	public IReparador getReparadorTanqueEst()
	{
		listaReparacion.add("Tanque estandar");
		return reparadorTanqueEst;
	}

    /**
     * Regresa un reparador de Maxi tanques.
     * @return el reparador de Maxi tanques.
     */
	public IReparador getReparadorTanqueMax()
	{
		listaReparacion.add("Maxi Tanque");
		return reparadorTanqueMax;
	}

    /**
     * Regresa un reparador de Ultra tanques.
     * @return el reparador de Ultra tanques.
     */
	public IReparador getReparadorTanqueUlt()
	{
		listaReparacion.add("Ultra Tanque");
		return reparadorTanqueUlt;
	}

    /**
     * Regresa un reparador de Giga tanques.
     * @return el reparador de Giga tanques.
     */
	public IReparador getReparadorTanqueGig()
	{
		listaReparacion.add("Giga Tanque");
		return reparadorTanqueGig;
	}

    /**
     * Regresa un reparador de puertas.
     * @return el reparador de puertas.
     */
	public void reparaPuerta(Puerta puerta)
	{
		listaReparacion.add("Puerta");
		reparadorPuerta.reparaPuerta(puerta);
	}

    /**
     * Muestra los elementos que han sido reparados a lo largo del dia.
     */
	public void mostrarlistaReparacion()
	{
		String GREEN_BOLD_BRIGHT = "\033[1;92m";
		String rest = "\u001B[0m";
		String GREEN_BOLD = "\033[1;32m"; 
		System.out.println(GREEN_BOLD+"CENTRO DE REPARACION"+rest);
		System.out.println("Estos son los elementos que se han reparado gracias a nuestros reparadores:");
		for (String i: listaReparacion)
		{
			System.out.println(GREEN_BOLD_BRIGHT+"-"+i+""+rest);
		}
	}
}