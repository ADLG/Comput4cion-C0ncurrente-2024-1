package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.almacenes.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que modelara el comportamiento del recolector industrial.
 * @author ADLG.
 * @author DJLP.
 */
public class RecolectorIndustrial
{
 	int energiaRecolectada = 0;

	/**
	 * Vacia los tanques y acumula la energia vaciada.
	 * @param tanques los tanques con energia.
	 * @param almacen el almacen a donde se enviaran los tanques vacios.
	 * @param opc el tipo de carga de energia.
 	 */
	public void vaciarTanques(List<ITanques> tanques, AlmacenTanques almacen,int opc)
	{
		String ANSI_CYAN = "\u001B[36m";
		String rest = "\u001B[0m";
		String ANSI_GREEN = "\u001B[32m";
		System.out.println(ANSI_CYAN+"\n\t***RECOLECTOR INDUSTRIAL VACIANDO TANQUES...\n"+rest);
 		try{Thread.sleep(1500);}catch(InterruptedException e) {e.printStackTrace();} 
		for (ITanques i: tanques)
		{
			energiaRecolectada += i.getEnergia();
			// System.out.println(i.getEnergia());
			i.cargarEnergia(0,2);
		}
		almacen.recolectorAalmacen(tanques,opc);
		System.out.println("\t\t\tRECOLECTOR INDUSTRIAL:\n\t\t\t"+ANSI_GREEN+"+Se han anadido "+energiaRecolectada+" unidades de Energia\n\n"+rest);
 		try{Thread.sleep(1500);}catch(InterruptedException e) {e.printStackTrace();} 		
	}

	/**
	 * Muestra la energia acumulada de un centro en espeficido (centro de risas o sustos).
 	 */
	public void getInfo()
	{
		String ANSI_CYAN = "\u001B[36m";
		String rest = "\u001B[0m";
		System.out.println(ANSI_CYAN+"RECOLECTOR INDUSTRIAL:\nEnergia:"+energiaRecolectada+""+rest);
	}
}