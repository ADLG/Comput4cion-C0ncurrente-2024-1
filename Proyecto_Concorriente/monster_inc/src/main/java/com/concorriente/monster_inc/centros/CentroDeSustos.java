package com.concorriente.monster_inc.centros;

import com.concorriente.monster_inc.almacenes.*;
import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.fabricas.*;
import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.vestidor.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal que modelara el comportamiento del centro de sustos implementando
 * Runnable y haciendo que cada hilo ejecute la tarea de algun monstruo.
 * @author ADLG.
 * @author DJLP.
 */
public class CentroDeSustos implements Runnable
{
    String rest = "\u001B[0m";
    String YELLOW = "\033[0;33m";
    String GREEN_BOLD = "\033[1;32m";
    String GREEN_BRIGHT = "\033[0;92m";
    String CYAN_UNDERLINED = "\u001B[36m";
    static int cont = 0;
    static List<Monstruo> monstruosLista;
    static List<ITanques> tanques = new ArrayList<>();
    static List<Puerta> puertas = new ArrayList<>();

    static FabricaPuertas fabricaPuertas = new FabricaPuertas();
    static FabricaTanques fabricaTanques = new FabricaTanques();

    static AlmacenPuertas almacenPuertas = new AlmacenPuertas();
    static AlmacenTanques almacenTanques = new AlmacenTanques();

    static CentroReparacion centroR = new CentroReparacion();
    static RecolectorIndustrial recolectorI = new RecolectorIndustrial();

    static List<Estacion> estaciones = new ArrayList<>();

    /**
     * Constructor vacio del Centro de Sustos.
     */
    public CentroDeSustos(){}

    /**
     * Establece los monstruos en esta zona de la empresa.
     * @param m la lista con los monstruos ya inicializados.
     */
    public void setMonstruos(List<Monstruo> m)
    {
        this.monstruosLista = m;
    }

    /**
     * Genera las puertas acorde al numero de monstruos, haciendo que los
     * monstruos ayuden a fabricarlas para que posteriormente sean llevadas
     * al almacen de puertas y dejandolas en estado disponible.
     */
    public void inicializaPuertas()
    {
        System.out.println(CYAN_UNDERLINED+"CREACION DE PUERTAS"+rest);
        try{Thread.sleep(500);}catch(InterruptedException e) {e.printStackTrace();} 
        for (Monstruo i: monstruosLista)
        {
            Puerta puerta = fabricaPuertas.fabricarPuerta(i);
            puerta.getInfo();System.out.println();
            i.recolectaPuerta(puerta);
        }
        System.out.println(YELLOW+"\nMonstruos llevando puertas al almacen de puertas..."+rest);
        try{Thread.sleep(400);}catch(InterruptedException e) {e.printStackTrace();} 
        almacenPuertas.recolectaPuertas(monstruosLista);
        System.out.println("\nEstableciendo puertas en el CENTRO DE SUSTOS 0_0...");
        try{Thread.sleep(400);}catch(InterruptedException e) {e.printStackTrace();} 
        puertas = almacenPuertas.getPuertas();
        almacenPuertas.limpiaDisponibles();
        System.out.println(GREEN_BRIGHT+"\nCREACION DE PUERTAS EXITOSA\n"+rest);
    }

    /**
     * Genera los tanques acorde al numero de monstruos, haciendo que los
     * monstruos ayuden a fabricarlos para que posteriormente sean llevados
     * al almacen de tanques y dejandolos en estado disponible.
     */
    public void inicializaTanques()
    {
        System.out.println(CYAN_UNDERLINED+"\nCREACION DE TANQUES"+rest);
        int contanq = 0;
        for (Puerta i: puertas)
        {
            if (i.getEvento().equals("Pijamada") || i.getTipo().equals("Adultos"))
            {
                ITanques tanque = fabricaTanques.creaTanqueEstandar(monstruosLista.get(contanq));
                System.out.println("+Se ha creado un Tanque Estandar");
                monstruosLista.get(contanq).recolectaTanque(tanque);
            }
            else
            {
                ITanques tanque = fabricaTanques.creaMaxiTanque(monstruosLista.get(contanq));
                System.out.println("+Se ha creado un Maxi Tanque");
                monstruosLista.get(contanq).recolectaTanque(tanque);
            }
            contanq++;
        }
        System.out.println(YELLOW+"\nMonstruos llevando tanques al almacen de tanques..."+rest);
        try{Thread.sleep(400);}catch(InterruptedException e) {e.printStackTrace();} 
        almacenTanques.recolectaTanques(monstruosLista);
        System.out.println("\nEstableciendo tanques en el CENTRO DE SUSTOS 0_0...");
        try{Thread.sleep(400);}catch(InterruptedException e) {e.printStackTrace();} 
        setTanquesCentroSustos();
        System.out.println(GREEN_BRIGHT+"\nCREACION DE TANQUES ESTANDAR Y MAXI TANQUES EXITOSA\n"+rest);
    }

    /**
     * Se asignan los tanques dispobibles del almacen de tanques 
     * que se usaran en esta zona.
     */
    public void setTanquesCentroSustos()
    {
        List<ITanques> vacia = new ArrayList<>();
        tanques = vacia;
        for (ITanques i: almacenTanques.getTanquesEstDisponibles())
        {
            tanques.add(i);
        }
        for (ITanques i: almacenTanques.getTanquesMaxDisponibles())
        {
            tanques.add(i);
        }
    }

    /**
     * Se crean estaciones para que los monstruos puedan 
     * empezar a trabajar.
     */
    public void inicializaEstaciones()
    {
        System.out.println(CYAN_UNDERLINED+"\nCREACION DE ESTACIONES DE TRABAJO"+rest);
        for (int i=0; i<monstruosLista.size(); i+=2)
        {
            Estacion estacion = new Estacion(monstruosLista.get(i),monstruosLista.get(i+1),puertas.get(i),puertas.get(i+1));
            estaciones.add(estacion);
        }
        try{Thread.sleep(400);}catch(InterruptedException e) {e.printStackTrace();} 
        System.out.println(GREEN_BRIGHT+"\nCREACION DE ESTACIONES DE TRABAJO EXITOSA\n"+rest);
    }

    /**
     * El metodo run donde cada elemento del centro de sustos
     * realizara sus respectivas actividades.
     */ 
    @Override public void run()
    {
        cont++;
        if (cont > 3 && (cont % 4) == 0)
        {
            recolectorI.vaciarTanques(tanques,almacenTanques,1);
            setTanquesCentroSustos();
        }
        String hilo_nombre = Thread.currentThread().getName();
        switch(hilo_nombre)
        {
            case "iniciaPuertas":
                inicializaPuertas();
            break;
            case "iniciaTanques":
                inicializaTanques();
            break;
            case "iniciaEstaciones":
                inicializaEstaciones();
            break;
            case "MonstruoEscamoso1":estaciones.get(0).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoEscamoso2":estaciones.get(0).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoEscamoso3":estaciones.get(1).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoMolusco4":estaciones.get(1).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoMolusco5":estaciones.get(2).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoMolusco6":estaciones.get(2).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPequeno7":estaciones.get(3).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPequeno8":estaciones.get(3).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPequeno9":estaciones.get(4).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPeludo10":estaciones.get(4).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPeludo11":estaciones.get(5).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPeludo12":estaciones.get(5).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoEscamoso13":estaciones.get(6).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoEscamoso14":estaciones.get(6).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoEscamoso15":estaciones.get(7).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoMolusco16":estaciones.get(7).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoMolusco17":estaciones.get(8).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoMolusco18":estaciones.get(8).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPequeno19":estaciones.get(9).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPequeno20":estaciones.get(9).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPequeno21":estaciones.get(10).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPeludo22":estaciones.get(10).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPeludo23":estaciones.get(11).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "MonstruoPeludo24":estaciones.get(11).asustenMonstruos(tanques,hilo_nombre,centroR);break;
            case "RecolectorFinal":
                centroR.mostrarlistaReparacion();
                recolectorI.getInfo();
                System.out.println(CYAN_UNDERLINED+"\nAsi termina la jornada laboral del dia de hoy en EL CENTRO DE SUSTOS"+rest);
                try{Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();} 
                break;
            default:
                System.out.println("Algo salio mal");
        }
    }

    /**
     * El main para probar el centro de sustos con hilos.
     * @throws InterruptedException si ocurre un error con los hilos.
     */
    public static void main(String[] args) throws InterruptedException
    {
        CentroDeSustos centroSustos = new CentroDeSustos();
        List<Thread> threads = new ArrayList<>();
        Thread tip = new Thread(centroSustos,"iniciaPuertas");
        Thread tit = new Thread(centroSustos,"iniciaTanques");
        Thread tie = new Thread(centroSustos,"iniciaEstaciones");
        Thread tre = new Thread(centroSustos,"RecolectorFinal");

        tip.start();tip.join();
        tit.start();tit.join();
        tie.start();tie.join();

        for (Monstruo i: monstruosLista)
        {
            Thread t = new Thread(centroSustos,i.getNombre());
            threads.add(t);
        }

        for (Thread i: threads)
        {
            i.start();
            i.join();
        }

        tre.start();tre.join();
	}
}
