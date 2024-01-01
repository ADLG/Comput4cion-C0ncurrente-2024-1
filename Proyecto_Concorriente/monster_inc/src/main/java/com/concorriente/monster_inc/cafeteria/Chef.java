package com.concorriente.monster_inc.cafeteria;

import java.util.List;

/**
 * Clase que modelara el comportamiento del EX Chef de Harryhausen’s.
 * @author ADLG.
 * @author DJLP.
 */
public class Chef
{
	String nombre;

	/**
     * Constructor para el Chef.
     * @param nombre el nombre del Chef.
     */
	public Chef (String nombre)
	{
		this.nombre = nombre;
	}

	/**
     * Prepara los platillos con un inventario asignado.
     * @param platillos los platillos que preparara el Chef.
     * @param inventario el inventario con el que cuenta el Chef.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
	public List<Platillo> prepara_Platillo(List<Platillo> platillos, Inventario inventario) throws InterruptedException
	{
		String rest = "\u001B[0m";
		String GREEN = "\033[0;32m"; 
		System.out.println("\nEl chef "+nombre+" esta preparando los platillos...");
		for (int i=0; i<platillos.size(); i++)
		{
			System.out.println("Cocinando el platillo: "+platillos.get(i).getNombre());
			inventario.usar_Ingredientes();
			Thread.sleep(platillos.get(i).getTiempo_Coccion());
			System.out.println(GREEN+"\t*Platillo preparado*"+rest);
		}
		System.out.println("\nEl chef "+nombre+" ha terminado de cocinar los platillos.");
		return platillos;
	}
}