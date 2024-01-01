package com.concorriente.monster_inc.cafeteria;

import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.vestidor.*;
import com.concorriente.monster_inc.candado.*;
import com.concorriente.monster_inc.banos.Filtro;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal que modelara el comportamiento de la Cafeteria implementando
 * Runnable y haciendo que cada hilo ejecute la tarea de algun monstruo.
 * @author ADLG.
 * @author DJLP.
 */
public class Cafeteria implements Runnable
{
	List<Mesa> mesas;
	List<Platillo> platillos;
    List<Monstruo> monstruos;
	Recepcionista recepcionista;
	Camarero camarero;
	Chef chef;
	Inventario inventario;
	int capacidad;
    Semaphore filtroMod;

    /**
     * Nos regresa la lista con monstruos ya inicializados.
     * @return La lista con los monstruos ya con valores establecidos.
     */   
    public List<Monstruo> getMonstruos()
    {
        return monstruos;
    }

    /**
     * Constructor para la cafeteria.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
	public Cafeteria() throws InterruptedException
	{
		iniciarCafeteria();
	}

    /**
     * Inicializa todos los objetos a usar en la cafeteria, es decir,
     * monstruos, casilleros, platillos, mesas, recepcionista, camarero,
     * inventario y chef, ademas de las listas donde se guardaran estos.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
	public void iniciarCafeteria() throws InterruptedException
	{
        mesas = new ArrayList<>();
        platillos = new ArrayList<>();
        monstruos = new ArrayList<>();
        capacidad = 10;

		Mesa mesa1 = new Mesa(1,2);
        Mesa mesa2 = new Mesa(2,4);
        Mesa mesa3 = new Mesa(3,6);
        Mesa mesa4 = new Mesa(4,2);
        Mesa mesa5 = new Mesa(5,4);
        Mesa mesa6 = new Mesa(6,6);
        Mesa mesa7 = new Mesa(7,2);
        Mesa mesa8 = new Mesa(8,4);
        Mesa mesa9 = new Mesa(9,6);
        Mesa mesa10 = new Mesa(10,2);

        chef = new Chef("EX Chef de Harryhausen’s");
        camarero = new Camarero("Camarero");
        recepcionista = new Recepcionista("Recepcionista");

        inventario = new Inventario(5,5,5,5);

        Platillo platilo1 = new Platillo("Platillo Monstruoso 1",300);
        Platillo platilo2 = new Platillo("Platillo Monstruoso 2",500);
        Platillo platilo3 = new Platillo("Platillo Monstruoso 3",200);
        Platillo platilo4 = new Platillo("Platillo Monstruoso 4",400);
        Platillo platilo5 = new Platillo("Platillo Monstruoso 5",300);
        Platillo platilo6 = new Platillo("Platillo Monstruoso 6",500);
        Platillo platilo7 = new Platillo("Platillo Monstruoso 7",200);
        Platillo platilo8 = new Platillo("Platillo Monstruoso 8",400);
        Platillo platilo9 = new Platillo("Platillo Monstruoso 9",300);
        Platillo platilo10 = new Platillo("Platillo Monstruoso 10",500);
        Platillo platilo11 = new Platillo("Platillo Monstruoso 11",200);
        Platillo platilo12 = new Platillo("Platillo Monstruoso 12",400);
        Platillo platilo13 = new Platillo("Platillo Monstruoso 13",300);
        Platillo platilo14 = new Platillo("Platillo Monstruoso 14",500);
        Platillo platilo15 = new Platillo("Platillo Monstruoso 15",200);
        Platillo platilo16 = new Platillo("Platillo Monstruoso 16",400);
        Platillo platilo17 = new Platillo("Platillo Monstruoso 17",300);
        Platillo platilo18 = new Platillo("Platillo Monstruoso 18",500);
        Platillo platilo19 = new Platillo("Platillo Monstruoso 19",200);
        Platillo platilo20 = new Platillo("Platillo Monstruoso 20",400);
        Platillo platilo21 = new Platillo("Platillo Monstruoso 21",300);
        Platillo platilo22 = new Platillo("Platillo Monstruoso 22",500);
        Platillo platilo23 = new Platillo("Platillo Monstruoso 23",200);
        Platillo platilo24 = new Platillo("Platillo Monstruoso 24",400);

        mesas.add(mesa1);mesas.add(mesa2);mesas.add(mesa3);mesas.add(mesa4);mesas.add(mesa5);
        mesas.add(mesa6);mesas.add(mesa7);mesas.add(mesa8);mesas.add(mesa9);mesas.add(mesa10);

		platillos.add(platilo1);platillos.add(platilo2);platillos.add(platilo3);platillos.add(platilo4);
        platillos.add(platilo5);platillos.add(platilo6);platillos.add(platilo7);platillos.add(platilo8);
        platillos.add(platilo9);platillos.add(platilo10);platillos.add(platilo11);platillos.add(platilo12);
        platillos.add(platilo13);platillos.add(platilo14);platillos.add(platilo15);platillos.add(platilo16);
        platillos.add(platilo17);platillos.add(platilo18);platillos.add(platilo19);platillos.add(platilo20);
        platillos.add(platilo21);platillos.add(platilo22);platillos.add(platilo23);platillos.add(platilo24);

        Casillero c1 = new Casillero("casileros1"); Casillero c13 = new Casillero("casileros13");
        Casillero c2 = new Casillero("casileros2"); Casillero c14 = new Casillero("casileros14");
        Casillero c3 = new Casillero("casileros3"); Casillero c15 = new Casillero("casileros15");
        Casillero c4 = new Casillero("casileros4"); Casillero c16 = new Casillero("casileros16");
        Casillero c5 = new Casillero("casileros5"); Casillero c17 = new Casillero("casileros17");
        Casillero c6 = new Casillero("casileros6"); Casillero c18 = new Casillero("casileros18");
        Casillero c7 = new Casillero("casileros7"); Casillero c19 = new Casillero("casileros19");
        Casillero c8 = new Casillero("casileros8"); Casillero c20 = new Casillero("casileros20");
        Casillero c9 = new Casillero("casileros9"); Casillero c21 = new Casillero("casileros21");
        Casillero c10 = new Casillero("casileros10"); Casillero c22 = new Casillero("casileros22");
        Casillero c11 = new Casillero("casileros11"); Casillero c23 = new Casillero("casileros23");
        Casillero c12 = new Casillero("casileros12"); Casillero c24 = new Casillero("casileros24");

        Monstruo monstruo1 = new Monstruo_Escamoso("MonstruoEscamoso1",001,"Esc","Mol",c1);
        Monstruo monstruo2 = new Monstruo_Escamoso("MonstruoEscamoso2",002,"Esc",c2);
        Monstruo monstruo3 = new Monstruo_Escamoso("MonstruoEscamoso3",003,"Esc",c3);
        Monstruo monstruo4 = new Monstruo_Molusco("MonstruoMolusco4",004,"Mol","Pel",c4);
        Monstruo monstruo5 = new Monstruo_Molusco("MonstruoMolusco5",005,"Mol",c5);
        Monstruo monstruo6 = new Monstruo_Molusco("MonstruoMolusco6",006,"Mol",c6);
        Monstruo monstruo7 = new Monstruo_Pequeno("MonstruoPequeno7",007,"Peq","Esc",c7);
        Monstruo monstruo8 = new Monstruo_Pequeno("MonstruoPequeno8",108,"Peq",c8);
        Monstruo monstruo9 = new Monstruo_Pequeno("MonstruoPequeno9",109,"Peq",c9);
        Monstruo monstruo10 = new Monstruo_Peludo("MonstruoPeludo10",010,"Pel","Peq",c10);
        Monstruo monstruo11 = new Monstruo_Peludo("MonstruoPeludo11",011,"Pel",c11);
        Monstruo monstruo12 = new Monstruo_Peludo("MonstruoPeludo12",012,"Pel",c12);
        Monstruo monstruo13 = new Monstruo_Escamoso("MonstruoEscamoso13",013,"Esc","Mol",c13);
        Monstruo monstruo14 = new Monstruo_Escamoso("MonstruoEscamoso14",014,"Esc",c14);
        Monstruo monstruo15 = new Monstruo_Escamoso("MonstruoEscamoso15",015,"Esc",c15);
        Monstruo monstruo16 = new Monstruo_Molusco("MonstruoMolusco16",016,"Mol","Pel",c16);
        Monstruo monstruo17 = new Monstruo_Molusco("MonstruoMolusco17",017,"Mol",c17);
        Monstruo monstruo18 = new Monstruo_Molusco("MonstruoMolusco18",118,"Mol",c18);
        Monstruo monstruo19 = new Monstruo_Pequeno("MonstruoPequeno19",119,"Peq","Esc",c19);
        Monstruo monstruo20 = new Monstruo_Pequeno("MonstruoPequeno20",020,"Peq",c20);
        Monstruo monstruo21 = new Monstruo_Pequeno("MonstruoPequeno21",021,"Peq",c21);
        Monstruo monstruo22 = new Monstruo_Peludo("MonstruoPeludo22",022,"Pel","Peq",c22);
        Monstruo monstruo23 = new Monstruo_Peludo("MonstruoPeludo23",023,"Pel",c23);
        Monstruo monstruo24 = new Monstruo_Peludo("MonstruoPeludo24",024,"Pel",c24);

        monstruos.add(monstruo1);
        monstruos.add(monstruo2);
        monstruos.add(monstruo3);
        monstruos.add(monstruo4);
        monstruos.add(monstruo5);
        monstruos.add(monstruo6);
        monstruos.add(monstruo7);
        monstruos.add(monstruo8);
        monstruos.add(monstruo9);
        monstruos.add(monstruo10);
        monstruos.add(monstruo11);
        monstruos.add(monstruo12);
        monstruos.add(monstruo13);
        monstruos.add(monstruo14);
        monstruos.add(monstruo15);
        monstruos.add(monstruo16);
        monstruos.add(monstruo17);
        monstruos.add(monstruo18);
        monstruos.add(monstruo19);
        monstruos.add(monstruo20);
        monstruos.add(monstruo21);
        monstruos.add(monstruo22);
        monstruos.add(monstruo23);
        monstruos.add(monstruo24);
        
        filtroMod = new Filtro(1,capacidad);
	}

    /**
     * Muestra lo que tiene la cafeteria en una ejecucion del Main.
     * @throws InterruptedException si ocurre un error con el sleep().
     */
    public void presentaCafeteria() throws InterruptedException
    {
        System.out.println("Preparando todos los elementos, objetos, monstruos y personal");
        System.out.println("...");Thread.sleep(400);System.out.println("..");Thread.sleep(400);System.out.println(".");Thread.sleep(400);
        System.out.println("LISTO");
        System.out.println("\nTenemos una cafeteria con:\n+Un Recepcionista\n+Un Camarero\n+Un Ex Chef de Harryhausen’s");
        System.out.println("+"+mesas.size()+" Mesas disponibles\nCapacidad para "+capacidad+" clientes.");
    }

    /**
     * Las acciones del Recepcionista de la cafeteria.
     */
	public void accionRecepcionista()
	{
        String rest = "\u001B[0m";
        String WHITE_BOLD = "\033[97m";
		System.out.println(WHITE_BOLD+"\n\nCOMENCEMOS"+rest+"\n\nRecepcionista recibiendo Monstruos y Asignandoles un lugar...");
        recepcionista.asigna_Lugares(mesas,monstruos);
	}

    /**
     * Las acciones del Camarero de la cafeteria.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
	public void accionCamarero() throws InterruptedException
	{
        camarero.tomar_Platillos(chef.prepara_Platillo(platillos,inventario));
        camarero.llevar_Comida(mesas);
		System.out.println("\nCamarero tomando y llevando platillos a las mesas...\n");
        Thread.sleep(1000);
	}

    /**
     * Las acciones para poder comer de los monstruos en la cafeteria.
     * @param hilo el nombre del monstruo que procedera a comer.
     * @throws InterruptedException si ocurre un error usando sleep().
     */   
	public void accionMonstruo(String hilo) throws InterruptedException
	{
        for (Monstruo i: monstruos)
        	if (i.getNombre().equals(hilo))
        		i.comer();	
	}

    /**
     * El metodo run donde cada elemento de la cafeteria realizara
     * sus respectivas acciones.
     */ 
    @Override
	public void run()
	{
		try
        {
            String hilo = Thread.currentThread().getName();
            if (hilo.equals("camarero"))
                accionCamarero();
            else if (hilo.equals("recepcionista"))
                accionRecepcionista();
            else
            {
                filtroMod.acquire();
                accionMonstruo(hilo);
                filtroMod.release();
            }
        }catch(InterruptedException e) {e.printStackTrace();} 
	}

    /**
     * El main para probar la Cafeteria con hilos.
     * @throws InterruptedException si ocurre un error usando sleep().
     */
	public static void main(String[] args) throws InterruptedException
	{
        Cafeteria cafeteria = new Cafeteria();
        List<Thread> threads = new ArrayList<>();

        Thread trec = new Thread(cafeteria,"recepcionista");
        Thread tcam = new Thread(cafeteria,"camarero");
        Thread t1 = new Thread(cafeteria,"MonstruoEscamoso1");threads.add(t1);
        Thread t2 = new Thread(cafeteria,"MonstruoEscamoso2");threads.add(t2);
        Thread t3 = new Thread(cafeteria,"MonstruoEscamoso3");threads.add(t3);
        Thread t4 = new Thread(cafeteria,"MonstruoMolusco4");threads.add(t4);
        Thread t5 = new Thread(cafeteria,"MonstruoMolusco5");threads.add(t5);
        Thread t6 = new Thread(cafeteria,"MonstruoMolusco6");threads.add(t6);
        Thread t7 = new Thread(cafeteria,"MonstruoPequeno7");threads.add(t7);
        Thread t8 = new Thread(cafeteria,"MonstruoPequeno8");threads.add(t8);
        Thread t9 = new Thread(cafeteria,"MonstruoPequeno9");threads.add(t9);
        Thread t10 = new Thread(cafeteria,"MonstruoPeludo10");threads.add(t10);
        Thread t11 = new Thread(cafeteria,"MonstruoPeludo11");threads.add(t11);
        Thread t12 = new Thread(cafeteria,"MonstruoPeludo12");threads.add(t12);
        Thread t13 = new Thread(cafeteria,"MonstruoEscamoso13");threads.add(t13);
        Thread t14 = new Thread(cafeteria,"MonstruoEscamoso14");threads.add(t14);
        Thread t15 = new Thread(cafeteria,"MonstruoEscamoso15");threads.add(t15);
        Thread t16 = new Thread(cafeteria,"MonstruoMolusco16");threads.add(t16);
        Thread t17 = new Thread(cafeteria,"MonstruoMolusco17");threads.add(t17);
        Thread t18 = new Thread(cafeteria,"MonstruoMolusco18");threads.add(t18);
        Thread t19 = new Thread(cafeteria,"MonstruoPequeno19");threads.add(t19);
        Thread t20 = new Thread(cafeteria,"MonstruoPequeno20");threads.add(t20);
        Thread t21 = new Thread(cafeteria,"MonstruoPequeno21");threads.add(t21);
        Thread t22 = new Thread(cafeteria,"MonstruoPeludo22");threads.add(t22);
        Thread t23 = new Thread(cafeteria,"MonstruoPeludo23");threads.add(t23);
        Thread t24 = new Thread(cafeteria,"MonstruoPeludo24");threads.add(t24);

        trec.start();trec.join();
        tcam.start();tcam.join();
        System.out.println();

        for (Thread i: threads)
        {
            i.start();
        }
        for (Thread i: threads)
        {
            i.join();
        }
	}
}