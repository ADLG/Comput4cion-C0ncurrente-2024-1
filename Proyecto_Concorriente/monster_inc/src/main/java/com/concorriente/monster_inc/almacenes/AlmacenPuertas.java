package com.concorriente.monster_inc.almacenes;

import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.monstruos.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento del almacen de puertas.
 * @author ADLG.
 * @author DJLP.
 */
public class AlmacenPuertas
{
	List<Puerta> puertas_uso = new ArrayList<>();
	List<Puerta> puertas_disponibles = new ArrayList<>();
	List<Puerta> vacia = new ArrayList<>();

    /**
     * Recolecta las puertas creadas por la fabrica de puertas.
     * @param monstruos los monstruos que han traido las puertas de 
     * la fabrica al almacen.
     */
	public void recolectaPuertas(List<Monstruo> monstruos)
	{
		for (Monstruo i: monstruos)
		{
			i.llevarPuertaAlmacen(puertas_disponibles);
		}
		puertas_uso = puertas_disponibles;
	}

   	/**
     * Deja vacia la lista con las puertas diponibles ya que
     * estan en uso.
     */
	public void limpiaDisponibles()
	{
		puertas_disponibles = vacia;
	}

   	/**
     * regresa la lista de puertas del alamcen de puertas.
     * return la lista de puertas del alamcen de puertas.
     */
	public List<Puerta> getPuertas(){return this.puertas_disponibles;}
}
