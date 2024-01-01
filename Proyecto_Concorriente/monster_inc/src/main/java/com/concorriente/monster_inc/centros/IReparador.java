package com.concorriente.monster_inc.centros;
import com.concorriente.monster_inc.planta_sustos.*;
/**
 * Interfaz para usar el patron de diseno decorador en los Reparadores.
 * @author ADLG.
 * @author DJLP.
 */
public interface IReparador
{
	/**
	 * Repara un tanque dejando sus usos en 0.
	 * @param tanque el tanque a reparar.
	 */
	public void repara(ITanques tanque);
}