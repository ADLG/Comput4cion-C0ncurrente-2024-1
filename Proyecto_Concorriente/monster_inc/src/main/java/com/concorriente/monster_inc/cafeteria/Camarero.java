package com.concorriente.monster_inc.cafeteria;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento del Camarero.
 * @author ADLG.
 * @author DJLP.
 */
public class Camarero
{
	String nombre;
	List<Platillo> platillos;

	/**
     * Constructor para el Camarero.
     * @param nombre el nombre del Camarero.
     */
	public Camarero (String nombre)
	{
		this.nombre = nombre;
		platillos = new ArrayList<>();
	}

	/**
     * Toma los platillos.
     * @param nombre la lista con los platillos.
     */
	public void tomar_Platillos(List<Platillo> platillos)
	{
		this.platillos = platillos;
	}

	/**
     * Lleva los platillos a las mesas.
     * @param mesas las mesas donde llevara los platillos.
     */
	public void llevar_Comida(List<Mesa> mesas)
	{
		int capacidadM=0,b=0;
		for (Mesa m: mesas)
		{
			capacidadM = m.getCapacidad();
			for (int i=0; i<capacidadM; i++)
			{
				if (b == platillos.size())
					break;
				m.getPlatillos()[i] = platillos.get(b);
				b++;
			}
		}
		System.out.println("\nEl Camarero ha llevado los platillos a todos los monstruos clientes");
	}
}
