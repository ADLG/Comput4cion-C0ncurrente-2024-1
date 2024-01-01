package com.concorriente.monster_inc.cafeteria;

/**
 * Clase para el inventario de ingredientes.
 * @author ADLG.
 * @author DJLP.
 */
public class Inventario
{
	private int masa_monstruosa,pescado_monstruoso,carne_monstruosa,hielo_monstruoso;

	/**
     * Constructor para el inventario.
     * @param masa_monstruosa el ingrediente de masa monstruosa.
     * @param pescado_monstruoso el ingrediente de pescado monstruoso.
     * @param carne_monstruosa el ingrediente de carne monstruosa.
     * @param hielo_monstruoso el ingrediente de hielo monstruoso.
     */
	public Inventario(int masa_monstruosa, int pescado_monstruoso, int carne_monstruosa, int hielo_monstruoso)
	{
		this.masa_monstruosa = masa_monstruosa;
		this.pescado_monstruoso = pescado_monstruoso;
		this.carne_monstruosa = carne_monstruosa;
		this.hielo_monstruoso = hielo_monstruoso;
	}

	/**
     * Llena el inventario.
     * @param i la cantidad de ingredientes que se anadira al inventario.
     */
	public void llenar_Inventario(int i)
	{
		this.masa_monstruosa += i;
		this.pescado_monstruoso += i;
		this.carne_monstruosa += i;
		this.hielo_monstruoso += i;
	}

	/**
     * Disminuira la cantidad de ingredientes en el inventario, ademas
     * si hace falta algun ingrediente se rellenara el inventario con
     * +10 ingredientes de cada elemento.
     */
	public void usar_Ingredientes()
	{
		String rest = "\u001B[0m";
		String WHITE_BOLD = "\u001B[33m";
		if (masa_monstruosa == 0 || pescado_monstruoso == 0 || carne_monstruosa == 0 || hielo_monstruoso == 0)
		{
			System.out.println(WHITE_BOLD+"\n¡¡¡Parece que faltan ingredientes para que nuestro Chef haga los platillos!!!"+rest);
			System.out.println("Surtiendo ingredientes");
			try{
        	System.out.println("...");Thread.sleep(300);System.out.println("..");Thread.sleep(300);System.out.println(".");Thread.sleep(300);
			}catch(InterruptedException e) {e.printStackTrace();} 
			llenar_Inventario(10);
			System.out.println("Inventario surtido");
			System.out.println("Ahora el Chef puede continuar con su creacion de platillos.\n");
		}
		this.masa_monstruosa -= 1;
		this.pescado_monstruoso -= 1;
		this.carne_monstruosa -= 1;
		this.hielo_monstruoso -= 1;
	}
}