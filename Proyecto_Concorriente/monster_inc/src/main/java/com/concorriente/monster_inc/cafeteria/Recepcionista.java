package com.concorriente.monster_inc.cafeteria;

import com.concorriente.monster_inc.monstruos.Monstruo;
import java.util.List;

/**
 * Clase que modelara el comportamiento del Recepcionista.
 * @author ADLG.
 * @author DJLP.
 */
public class Recepcionista
{
	String nombre;

	/**
     * Constructor para el Recepcionista.
     * @param nombre el nombre del recepcionista
     */
	public Recepcionista (String nombre)
	{
		this.nombre = nombre;
	}

	/**
     * Asigna a los monstruos a sus mesas dada una lista de mesas y monstruos.
     * @param mesas el id de la mesa.
     * @param monstruos la capacidad de la mesa.
     */
	public void asigna_Lugares(List<Mesa> mesas, List<Monstruo> monstruos)
	{
		int capacidadMesa=0,a=0,b=0;
		int numMesas = mesas.size();
		int numMonstruos = monstruos.size();
		for (int i=0; b<numMonstruos; i++)
		{
			while(!mesas.get(i).mesa_Llena())
			{
				mesas.get(i).asignaLugares(monstruos.get(b),a);
				a++;
				b++;
				if (b == numMonstruos)
				{
					System.out.println("\nSe han asignado todos los lugares :)");
					break;
				}
			}
			a=0;
		}
	}
}
