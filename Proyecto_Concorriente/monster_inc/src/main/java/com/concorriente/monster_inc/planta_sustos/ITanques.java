package com.concorriente.monster_inc.planta_sustos;
/**
 * Interfaz para usar el patron de diseno fabrica en los tanques.
 * @author ADLG.
 * @author DJLP.
 */
public interface ITanques
{
	/**
     * Establece el id al tanque.
     * @param id el id del tanque.
     */
	public void setId(int id);
	/**
     * Establece la capacidad del tanque.
     * @param capacidad la capacidad del tanque.
     */
	public void setCapacidad(int capacidad);
	/**
     * Establece el tipo del tanque.
     * @param tipo el tipo del tanque.
     */
	public void setTipe(String tipo);
	/**
     * Regresa el id del tanque.
     * @return el id del tanque.
     */
	public int getId();
	/**
     * Regresa la capacidad del tanque.
     * @return la capacidad del tanque.
     */
	public int getCapacidad();
	/**
     * Regresa el tipo del tanque.
     * @return el tipo del tanque.
     */
	public String getTipe();
	/**
     * Carga energia al tanque.
     * @param energia la cantidad de energia que se asignara.
     * @param opc el tipo de asignacion.
     */
	public void cargarEnergia(int energia, int opc);
	/**
     * Regresa la energia que tiene el tanque.
     * @return la energia que tiene el tanque.
     */
	public int getEnergia();
	/**
     * Genera una probabilidad de que se rompa el tanque.
     */
	public void setUso();
	/**
     * Regresa el numero de usos del tanque.
     * @return el numero de usos del tanque.
     */
	public int getUso();
	/**
     * Repara el tanque, establece los usos en 0.
     */
	public void reparar();
	/**
     * Nos dice si el tanque puede ser cargado por energia todavia.
     * @return true si el tanque tiene espacio para mas energia, false caso contrario.
     */
	public boolean checaTanque(int energia);
}
