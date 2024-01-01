package com.concorriente.monster_inc.almacenes;

import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.planta_sustos.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento del almacen de tanques.
 * @author ADLG.
 * @author DJLP.
 */
public class AlmacenTanques
{
	List<ITanques> tanques_estandar_uso = new ArrayList<>();
	List<ITanques> tanques_maxi_uso = new ArrayList<>();
	List<ITanques> tanques_ultra_uso = new ArrayList<>();
	List<ITanques> tanques_giga_uso = new ArrayList<>();

	List<ITanques> tanques_estandar_disponibles = new ArrayList<>();
	List<ITanques> tanques_maxi_disponibles = new ArrayList<>();
	List<ITanques> tanques_ultra_disponibles = new ArrayList<>();
	List<ITanques> tanques_giga_disponibles = new ArrayList<>();

    /**
     * Recolecta los tanques creados por la fabrica de tanques.
     * @param monstruos los monstruos que han traido los tanques de 
     * la fabrica al almacen.
     */
	public void recolectaTanques(List<Monstruo> monstruos)
	{
		for (Monstruo i: monstruos)
		{
			if (i.getTanque().equals("est"))
			{
				i.llevarTanqueAlmacen(tanques_estandar_disponibles);
				i.llevarTanqueAlmacen(tanques_estandar_uso);
			}
			else if (i.getTanque().equals("max"))
			{
				i.llevarTanqueAlmacen(tanques_maxi_disponibles);
				i.llevarTanqueAlmacen(tanques_maxi_uso);
			}
			else if (i.getTanque().equals("ult"))
			{
				i.llevarTanqueAlmacen(tanques_ultra_disponibles);
				i.llevarTanqueAlmacen(tanques_ultra_uso);
			}
			else
			{
				i.llevarTanqueAlmacen(tanques_giga_disponibles);
				i.llevarTanqueAlmacen(tanques_giga_uso);
			}
		}
	}

    /**
     * Recolecta los tanques vaciados por el recolector industrial y 
     * estos son traidos de vuelta al almacen marcados como disponibles.
     * @param tanques los tanques vacios.
     * @param opc el tipo de opcion acorde al tipo de centro de trabajo.
     */
	public void recolectorAalmacen(List<ITanques> tanques,int opc)
	{
		if (opc == 1)
			limpiaDisponiblesSustos();
		else
			limpiaDisponiblesRisas();

		for (ITanques i: tanques)
		{
			if (i.getTipe().equals("est"))
			{
				tanques_estandar_disponibles.add(i);
			}
			else if (i.getTipe().equals("max"))
			{
				tanques_maxi_disponibles.add(i);
			}
			else if (i.getTipe().equals("ult"))
			{
				tanques_ultra_disponibles.add(i);
			}	
			else
			{
				tanques_giga_disponibles.add(i);
			}
		}
	}

    /**
     * Regresa los tanques estandar disponibles.
     * @return los tanques estandar disponibles.
     */
	public List<ITanques> getTanquesEstDisponibles(){return this.tanques_estandar_disponibles;}
	/**
     * Regresa los maxi tanques disponibles.
     * @return los maxi tanques disponibles.
     */
	public List<ITanques> getTanquesMaxDisponibles(){return this.tanques_maxi_disponibles;}
	/**
     * Regresa los ultra tanques disponibles.
     * @return los ultra tanques disponibles.
     */
	public List<ITanques> getTanquesUltDisponibles(){return this.tanques_ultra_disponibles;}
	/**
     * Regresa los giga tanques disponibles.
     * @return los giga tanques disponibles.
     */
	public List<ITanques> getTanquesgigDisponibles(){return this.tanques_giga_disponibles;}

	/**
     * Limpia los tanques usados por el centro de sustos.
     */
	public void limpiaDisponiblesSustos()
	{
		tanques_estandar_disponibles.clear();
		tanques_maxi_disponibles.clear();
		tanques_estandar_uso.clear();
		tanques_maxi_uso.clear();
	}

	/**
     * Limpia los tanques usados por el centro de risas.
     */
	public void limpiaDisponiblesRisas()
	{
		tanques_maxi_disponibles.clear();
		tanques_ultra_disponibles.clear();
		tanques_giga_disponibles.clear();
		tanques_maxi_uso.clear();
		tanques_ultra_uso.clear();
		tanques_giga_uso.clear();
	}
}
