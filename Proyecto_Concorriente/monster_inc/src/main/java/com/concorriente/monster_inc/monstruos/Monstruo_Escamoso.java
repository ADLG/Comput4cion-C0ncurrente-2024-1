package com.concorriente.monster_inc.monstruos;

import com.concorriente.monster_inc.vestidor.Casillero;
import com.concorriente.monster_inc.centros.*;
import com.concorriente.monster_inc.planta_sustos.*;
import java.util.List;

/**
 * Clase que modelara a los monstruos Escamosos.
 * @author ADLG.
 * @author DJLP.
 */
public class Monstruo_Escamoso extends Monstruo
{
	String nombre;
	int contrasena_locker;
	String tipo_monstruo;
	Casillero casillero;
	String tipo_Mplus;
	ITanques tanque;
	Puerta puerta;

	/**
	 * Constructor para monstruos Escamosos.
	 * @param nombre el nombre del monstruo.
	 * @param contrasena_locker la contrasena del casillero del monstruo.
	 * @param tipo_monstruo el tipo del monstruo.
	 * @param casillero el casillero del monstruo.
	 */
	public Monstruo_Escamoso (String nombre, int contrasena_locker, String tipo_monstruo, Casillero casillero)
	{
		this.nombre = nombre;
		this.contrasena_locker = contrasena_locker;
		this.tipo_monstruo = tipo_monstruo;
		this.casillero = casillero;
	}
	
	/**
	 * Constructor para monstruos Escamosos con un tipo extra.
	 * @param nombre el nombre del monstruo.
	 * @param contrasena_locker la contrasena del casillero del monstruo.
	 * @param tipo_monstruo el tipo del monstruo.
	 * @param tipo_Mplus el tipo extra del monstruo.
	 * @param casillero el casillero del monstruo.
	 */
	public Monstruo_Escamoso (String nombre, int contrasena_locker, String tipo_monstruo, String tipo_Mplus, Casillero casillero)
	{
		this.nombre = nombre;
		this.contrasena_locker = contrasena_locker;
		this.tipo_monstruo = tipo_monstruo;
		this.casillero = casillero;
		this.tipo_Mplus = tipo_Mplus;
	}

	/**
     * Regresa el nombre del monstruo.
     * @return el nombre del monstruo.
     */
	public String getNombre(){return nombre;}

    /**
     * Regresa el tipo del monstruo.
     * @return el tipo del monstruo.
     */
	public String getTipo_monstruo(){return tipo_monstruo;}

    /**
     * Regresa el tipo extra del monstruo.
     * @return el tipo extra del monstruo.
     */
	public String getTipo_Mplus(){return tipo_Mplus;}

    /**
     * El monstruo establece la contrasena de su casillero.
     */
	public void setContrasenaCasillero(){casillero.setContrasena(contrasena_locker);}

    /**
     * El monstruo deja cosas en su casillero.
     * @param elemento el elemento anadido.
     */
	public void dejar_cosasCasillero(String elemento) throws InterruptedException {casillero.anadir_Elemento(elemento);}

    /**
     * El monstruo saca cosas de su casillero.
     * @param elemento el elemento eliminado.
     */
	public void sacar_cosasCasillero(String elemento){casillero.eliminar_Elemento(elemento);}

    /**
     * Muestra los elementos que tiene el monstruo en su casillero.
     */
	public void mostrar_Casillero(){casillero.mostrar_Casillero();}

	/**
     * El monstruo se pone desodorante.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
	public void ponerse_desodorante() throws InterruptedException
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		System.out.println(ANSI_GREEN+""+nombre+" se pone desodorante..."); Thread.sleep(700); System.out.println("Desodorante puesto"+rest);
	}

	/**
     * El monstruo se pone su casco.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
	public void ponerse_casco() throws InterruptedException
	{
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		System.out.println(ANSI_GREEN+""+nombre+" se pone casco..."); Thread.sleep(600); System.out.println("Casco puesto"+rest);
	}

	/**
     * El monstruo come.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
	public void comer() throws InterruptedException
	{
		String rest = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		String ANSI_GREEN = "\u001B[32m";
		System.out.println(ANSI_RED+""+nombre+" comiendo..."+rest);
		Thread.sleep(400);
		System.out.println(ANSI_GREEN+""+nombre+" Termino de comer"+rest);
	}

	/**
     * El monstruo recolecta un tanque.
     * @param tanque el tanque recolectado.
     */
	public void recolectaTanque(ITanques tanque){this.tanque = tanque;}

    /**
     * Regresa el tipo de tanque que tiene el monstruo.
     * @return el tipo de tanque que tiene el monstruo.
     */
	public String getTanque(){return tanque.getTipe();}

	/**
     * El monstruo lleva el tanque al almacen.
     * @param tanques la lista donde anadira su tanque el monstruo.
     */
	public void llevarTanqueAlmacen(List<ITanques> tanques){tanques.add(tanque);}

	/**
     * El monstruo recolecta una puerta.
     * @param puerta la puerta recolectada.
     */
	public void recolectaPuerta(Puerta puerta){this.puerta = puerta;}

    /**
     * Regresa la puerta que tiene el monstruo.
     * @return la puerta que tiene el monstruo.
     */
	public Puerta getPuerta(){return puerta;}

	/**
     * El monstruo lleva la puerta al almacen.
     * @param puertas la lista donde anadira su puerta el monstruo
     */
	public void llevarPuertaAlmacen(List<Puerta> puertas){puertas.add(puerta);}

	/**
     * Verifica el estado de la puerta.
     * @param reparadores los reparadores que repararan la puerta de ser necesario.
     */
	public void compruebaPuerta(CentroReparacion reparadores)
	{
		String ANSI_RED = "\u001B[31m";
		String ANSI_YELLOW = "\u001B[33m";
		String rest = "\u001B[0m";
		if (puerta.usoPuerta())
		{
			System.out.println(ANSI_YELLOW+"¡La puerta"+puerta.getId()+" soporta unos usos mas.!\n"+rest);
		}
		else
		{
			System.out.println(ANSI_RED+"La puerta "+puerta.getId()+" ha tenido suficientes usos, es hora de repararla...\n"+rest);
			reparadores.reparaPuerta(puerta);
		}
	}

    /**
     * Verifica el estado del tanque.
     * @param reparadores los reparadores que repararan el tanque de ser necesario.
     * @param tanque el tanque que sera reparado de ser necesario.
     */
	public void compruebaTanque(ITanques tanque, CentroReparacion reparadores)
	{
		String ANSI_RED = "\u001B[31m";
		String ANSI_YELLOW = "\u001B[33m";
		String rest = "\u001B[0m";
		if (tanque.getUso() < 2)
		{
			System.out.println(ANSI_YELLOW+"¡El tanque "+tanque.getId()+" soporta unos usos mas.!\n"+rest);
		}
		else
		{
			System.out.println(ANSI_RED+"El tanque "+tanque.getId()+" ha tenido suficientes usos, es hora de repararlo..."+rest);
			if (tanque.getTipe() == "est")
				reparadores.getReparadorTanqueEst().repara(tanque);
			else if (tanque.getTipe() == "max")
				reparadores.getReparadorTanqueMax().repara(tanque);
			else if (tanque.getTipe() == "ult")
				reparadores.getReparadorTanqueUlt().repara(tanque);
			else
				reparadores.getReparadorTanqueGig().repara(tanque);
		}
	}

	/**
     * Hace que el monstruo asuste y anada la energia en tanques.
     * @param tanques los tanques donde se anadira la energia generada por el susto.
     * @param reparadores los reparadores que repararan el tanque de ser necesario.
     */
	public void asustar(List<ITanques> tanques, CentroReparacion reparadores)
	{
		String ANSI_YELLOW = "\u001B[33m";
		String ANSI_PURPLE = "\u001B[35m";
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		puerta.usar();
		if (puerta.getTipo().equals("Ninos"))
		{
			for (ITanques i: tanques)
			{
				if (i.checaTanque(30))
				{
					i.setUso();
					compruebaTanque(i,reparadores);
					System.out.println(ANSI_PURPLE+""+nombre+" Asustando en una puerta con "+puerta.getTipo()+rest);
					i.cargarEnergia(30,1);
					System.out.println(ANSI_GREEN+"Se ha generado 30 de Energia\n"+rest);
					break;
				}
				else
				{
					System.out.println(ANSI_YELLOW+"*El tanque "+i.getId()+" esta lleno, se anadira la energia en otro tanque*\n"+rest);
				}
			}
		}
		else
		{
			for (ITanques i: tanques)
			{
				if (i.checaTanque(60))
				{
					i.setUso();
					compruebaTanque(i,reparadores);
					System.out.println(ANSI_PURPLE+""+nombre+" Asustando en una puerta con "+puerta.getTipo());
					i.cargarEnergia(60,1);
					System.out.println(ANSI_GREEN+"Se ha generado 60 de Energia\n"+rest);
					break;
				}
				else
				{
					System.out.println(ANSI_YELLOW+"*El tanque "+i.getId()+" esta lleno, se anadira la energia en otro tanque*\n"+rest);
				}
			}
		}
	}
	
	/**
     * Hace que el monstruo provoque risa y anada la energia en tanques.
     * @param tanques los tanques donde se anadira la energia generada por la risa.
     * @param reparadores los reparadores que repararan el tanque de ser necesario.
     */
	public void hazReir(List<ITanques> tanques, CentroReparacion reparadores)
	{
		String ANSI_YELLOW = "\u001B[33m";
		String ANSI_CYAN = "\u001B[36m";
		String ANSI_GREEN = "\u001B[32m";
		String rest = "\u001B[0m";
		puerta.usar();
		if (puerta.getTipo().equals("Ninos"))
		{
			for (ITanques i: tanques)
			{
				if (i.checaTanque(90))
				{
					i.setUso();
					compruebaTanque(i,reparadores);
					System.out.println(ANSI_CYAN+""+nombre+" Haciendo reir en una puerta con "+puerta.getTipo()+rest);
					i.cargarEnergia(90,1);
					System.out.println(ANSI_GREEN+"Se ha generado 90 de Energia\n"+rest);					
					break;
				}
				else
				{
					System.out.println(ANSI_YELLOW+"*El tanque "+i.getId()+" esta lleno, se anadira la energia en otro tanque*\n"+rest);
				}
			}
		}
		else
		{
			for (ITanques i: tanques)
			{
				if (i.checaTanque(120))
				{
					i.setUso();
					compruebaTanque(i,reparadores);
					System.out.println(ANSI_CYAN+""+nombre+" Haciendo reir en una puerta con "+puerta.getTipo()+rest);
					i.cargarEnergia(120,1);
					System.out.println(ANSI_GREEN+"Se ha generado 120 de Energia\n"+rest);					
					break;
				}
				else
				{
					System.out.println(ANSI_YELLOW+"*El tanque "+i.getId()+" esta lleno, se anadira la energia en otro tanque*\n"+rest);
				}
			}
		}	
	}
}