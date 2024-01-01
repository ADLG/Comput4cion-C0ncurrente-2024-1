package com.concorriente.monster_inc.vestidor;

import java.util.Arrays;

/**
 * Clase que modelara el comportamiento de los casilleros o lockers.
 * @author ADLG.
 * @author DJLP.
 */
public class Casillero
{
	String nombre;
	int contrasena;
	String [] elementos;
	int contador_elementos;

    /**
     * Constructor para los casilleros.
     * @param nombre el nombre del casillero.
     */
	public Casillero (String nombre)
	{
		this.nombre = nombre;
		this.elementos = new String[3];
		this.contador_elementos = 0;
	}

    /**
     * Permite anadir elementos de tipo string al casillero de un monstruo.
     * @param elemento el elemento que se anadira al casillero.
     * @throws InterruptedException si ocurre algun error con el sleep().
     */
	public void anadir_Elemento(String elemento) throws InterruptedException
	{
		String rest = "\u001B[0m";
		String ANSI_YELLOW = "\u001B[33m";
		if (contador_elementos == 3)
			System.out.println("Tu casillero esta lleno, elimina elementos para agregar mas");
		else if (contador_elementos == 1)
		{
			System.out.println(ANSI_YELLOW+"+Anadiendo "+elemento+" al Casillero"+rest);
			Thread.sleep(200);
			elementos[contador_elementos] = elemento; contador_elementos++;
			System.out.print("\tPuedes anadir "+(3-contador_elementos)+" elemento mas\n");
		}
		else
		{
			System.out.println(ANSI_YELLOW+"+Anadiendo "+elemento+" al Casillero"+rest);
			Thread.sleep(200);
			elementos[contador_elementos] = elemento; contador_elementos++;
			System.out.print("\tPuedes anadir "+(3-contador_elementos)+" elementos mas\n");
		}
	}

    /**
     * Permite eliminar elementos de tipo string en un casillero de un monstruo.
     * @param elemento el elemento que sera eliminado del casillero.
     */
	public void eliminar_Elemento(String elemento)
	{
		String rest = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		if (Arrays.binarySearch(elementos, elemento) < 0 )
			System.out.println("No se encontro ningun "+elemento+" en tu casillero");
		else if (contador_elementos == 0)
			System.out.println(ANSI_RED+"Tu casillero esta vacio"+rest);
		else
		{
			System.out.println(ANSI_RED+"Eliminando "+elemento+" de tu casillero"+rest);
			elementos[Arrays.binarySearch(elementos, elemento)] = "";
			contador_elementos--;
		}
	}

    /**
     * Muestra los elementos que se encuentran en el casillero.
     */
	public void mostrar_Casillero()
	{
		String rest = "\u001B[0m";
		String ANSI_PURPLE = "\u001B[35m";
		if (contador_elementos == 0)
			System.out.println("Tu casillero esta vacio");
		else
		{
			System.out.println("Tu casillero contiene estos elementos:");
			for (int i=0; i<elementos.length; i++)
			{
				System.out.println(ANSI_PURPLE+""+elementos[i]+""+rest);
			}
		}
	}

    /**
     * Permite que un monstruo establezca una contrasena en su casillero.
     * @param contrasena la contrasena del casillero.
     */
	public void setContrasena(int contrasena)
	{
		this.contrasena = contrasena;
	}
}