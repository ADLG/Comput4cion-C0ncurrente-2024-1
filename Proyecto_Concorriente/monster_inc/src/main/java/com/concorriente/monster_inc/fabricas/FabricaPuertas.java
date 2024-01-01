package com.concorriente.monster_inc.fabricas;

import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.monstruos.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que modelara el comportamiento de la fabrica de puertas.
 * @author ADLG.
 * @author DJLP.
 */
public class FabricaPuertas
{
	Random random = new Random();
	int numRand;
	int idpuertas = 0;

    /**
     * Regresa una puerta con tipo y evento aleatorio.
     * @return la puerta fabricada.
     */
	public Puerta fabricarPuerta(Monstruo m)
	{
		try{Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();} 
		return new Puerta(idpuertas++,generaTipoPuerta(),generaEvento());
	}

    /**
     * Regresa un tipo de puerta aleatorio.
     * @return el tipo de puerta.
     */
	public String generaTipoPuerta()
	{
		numRand = random.nextInt(10)+1;
		String tipoPuerta;
		return tipoPuerta = (numRand<4) ? "Adultos" : "Ninos";
	}

    /**
     * Regresa un evento de puerta aleatorio.
     * @return el evento de la puerta.
     */
	public String generaEvento()
	{
		numRand = random.nextInt(10)+1;
		if (numRand < 4)
			return "Pijamada";
		else
			return "Sin evento";
	}
}
