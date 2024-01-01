package com.concorriente.monster_inc.monstruos;

import com.concorriente.monster_inc.vestidor.Casillero;
import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.centros.*;
import java.util.List;

/**
 * Clase abstracta que modelara los metodos de los 4 tipos de monstruos.
 * @author ADLG.
 * @author DJLP.
 */
public abstract class Monstruo
{
	String nombre;
	int contrasena_locker;
	String tipo_monstruo;
	Casillero casillero;
	String tipo_Mplus;
	ITanques tanque;
	Puerta puerta;

    /**
     * Regresa el tipo del monstruo.
     * @return el tipo del monstruo.
     */
	public abstract String getTipo_monstruo();
    /**
     * Regresa el nombre del monstruo.
     * @return el nombre del monstruo.
     */
	public abstract String getNombre();
    /**
     * Regresa el tipo extra del monstruo.
     * @return el tipo extra del monstruo.
     */
	public abstract String getTipo_Mplus();
    /**
     * Regresa el tipo de tanque que tiene el monstruo.
     * @return el tipo de tanque que tiene el monstruo.
     */
	public abstract String getTanque();
    /**
     * Regresa la puerta que tiene el monstruo.
     * @return la puerta que tiene el monstruo.
     */
	public abstract Puerta getPuerta();
	/**
     * El monstruo establece la contrasena de su casillero.
     */
	public abstract void setContrasenaCasillero();
	/**
     * El monstruo deja cosas en su casillero.
     * @param elemento el elemento anadido.
     */
	public abstract void dejar_cosasCasillero(String elemento) throws InterruptedException;
	/**
     * El monstruo saca cosas de su casillero.
     * @param elemento el elemento eliminado.
     */
	public abstract void sacar_cosasCasillero(String elemento);
	/**
     * Muestra los elementos que tiene el monstruo en su casillero.
     */
	public abstract void mostrar_Casillero();
	/**
     * El monstruo se pone desodorante.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
	public abstract void ponerse_desodorante() throws InterruptedException;
	/**
     * El monstruo se pone su casco.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
	public abstract void ponerse_casco() throws InterruptedException;
	/**
     * El monstruo come.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
	public abstract void comer() throws InterruptedException;
	/**
     * El monstruo recolecta un tanque.
     * @param tanque el tanque recolectado.
     */
	public abstract void recolectaTanque(ITanques tanque);
	/**
     * El monstruo recolecta una puerta.
     * @param puerta la puerta recolectada.
     */
	public abstract void recolectaPuerta(Puerta puerta);
	/**
     * El monstruo lleva el tanque al almacen.
     * @param tanques la lista donde anadira su tanque el monstruo.
     */
	public abstract void llevarTanqueAlmacen(List<ITanques> tanques);
	/**
     * El monstruo lleva la puerta al almacen.
     * @param puertas la lista donde anadira su puerta el monstruo
     */
	public abstract void llevarPuertaAlmacen(List<Puerta> puertas);
	/**
     * Verifica el estado de la puerta.
     * @param reparadores los reparadores que repararan la puerta de ser necesario.
     */
	public abstract void compruebaPuerta(CentroReparacion reparadores);
    /**
     * Verifica el estado del tanque.
     * @param tanque el tanque que sera reparado en caso de ser necesario.
     * @param reparadores los reparadores que repararan el tanque de ser necesario.
     */
    public abstract void compruebaTanque(ITanques tanque, CentroReparacion reparadores);
	/**
     * Hace que el monstruo asuste y anada la energia en tanques.
     * @param tanques los tanques donde se anadira la energia generada por el susto.
     * @param reparadores los reparadores que repararan el tanque de ser necesario.
     */
	public abstract void asustar(List<ITanques> tanques, CentroReparacion reparadores);
	/**
     * Hace que el monstruo provoque risa y anada la energia en tanques.
     * @param tanques los tanques donde se anadira la energia generada por la risa.
     * @param reparadores los reparadores que repararan el tanque de ser necesario.
     */
	public abstract void hazReir(List<ITanques> tanques, CentroReparacion reparadores);
}