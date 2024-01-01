package com.concorriente.monster_inc.cafeteria;

/**
 * Clase que modelara el comportamiento de los platillos.
 * @author ADLG.
 * @author DJLP.
 */
public class Platillo
{
	private String nombre;
	private int tiempo_Coccion;

	/**
     * Constructor para los platillos.
     * @param nombre el nombre del platillo.
     * @param tiempo_Coccion el timepo de coccion del platillo.
     */
	public Platillo(String nombre, int tiempo_Coccion)
	{
		this.nombre = nombre;
		this.tiempo_Coccion = tiempo_Coccion;
	}

	/**
     * Regresa el nombre del platillo.
     * @return el nombre del platillo.
     */
	public String getNombre(){return nombre;}

	/**
     * Regresa el tiempo de coccion del platillo.
     * @return el tiempo de coccion del platillo.
     */
	public int getTiempo_Coccion(){return tiempo_Coccion;}
}