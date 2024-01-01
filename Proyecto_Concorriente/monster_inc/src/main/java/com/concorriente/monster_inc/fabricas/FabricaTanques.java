package com.concorriente.monster_inc.fabricas;

import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.monstruos.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento de la fabrica de tanques y 
 * el patron de diseno Factory.
 * @author ADLG.
 * @author DJLP.
 */
public class FabricaTanques
{
	CreaTanqueFabrica fabrica = new CreaTanqueFabrica();

   	/**
     * Regresa/crea un tanque Estandar.
     * @param m el monstruo que ayuda a crear el tanque.
     * @return el tanque Estandar.
     */
	public ITanques creaTanqueEstandar(Monstruo m)
	{
		try{Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();} 
		return fabrica.creaTanque("est");
	}

   	/**
     * Regresa/crea un Maxi tanque.
     * @param m el monstruo que ayuda a crear el tanque.
     * @return el Maxi tanque.
     */
	public ITanques creaMaxiTanque(Monstruo m)
	{
		try{Thread.sleep(400);}catch(InterruptedException e) {e.printStackTrace();} 
		return fabrica.creaTanque("max");
	}

   	/**
     * Regresa/crea un Ultra tanque.
     * @param m el monstruo que ayuda a crear el tanque.
     * @return el Ultra tanque.
     */
	public ITanques creaUltraTanque(Monstruo m)
	{
		try{Thread.sleep(800);}catch(InterruptedException e) {e.printStackTrace();} 
		return fabrica.creaTanque("ult");
	}

   	/**
     * Regresa/crea un Giga tanque.
     * @param m el monstruo que ayuda a crear el tanque.
     * @return el Giga tanque.
     */
	public ITanques creaGigaTanque(Monstruo m)
	{
		try{Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();} 
		return fabrica.creaTanque("gig");
	}
}