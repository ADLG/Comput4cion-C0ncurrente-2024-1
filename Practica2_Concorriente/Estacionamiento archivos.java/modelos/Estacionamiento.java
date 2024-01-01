package kas.concurrente.modelos;

import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * En esta clase se simula el estacionamiento en si
 * Posee un arreglo de tipo Lugar
 * Posee un entero de lugaresDisponibles
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Estacionamiento
{
    Lugar [] lugares;
    int lugaresDisponibles;
    int capacidad;

    /**
     * Metodo constructor
     * @param capacidad La capacidad del estacionamiento
     */
    public Estacionamiento(int capacidad)
    {
        this.capacidad = capacidad;
        this.lugaresDisponibles = capacidad;

        lugares = new Lugar[capacidad];
        
        for (int i=0; i<capacidad; i++)
        {
            lugares[i] = new Lugar(i);
        }
    }

    /**
     * Regresa los lugares del estacionamiento
     * @return los lugares del estacionamiento
     */
    public Lugar[] getLugares()
    {
        return lugares;
    }

    /**
     * Asigna los lugares del estacionamiento
     * @param lugares el arreglo con los lugares del estacionamiento
     */
    public void setLugares(Lugar[] lugares)
    {
        this.lugares = lugares;
    }

    /**
     * Regresa la cantidad de lugares disponibles del estacionamiento
     * @return la cantidad de lugares disponibles del estacionamiento
     */
    public int getLugaresDisponibles()
    {
        return lugaresDisponibles;
    }

    /**
     * Asigna los lugares disponibles en el estacionamiento
     * @param lugaresDisponibles el numero de lugares disponibles del estacionamiento
     */
    public void setLugaresDisponibles(int lugaresDisponibles)
    {
        this.lugaresDisponibles = lugaresDisponibles;
    }

    /**
     * Metodo que nos indica si esta lleno el estacionamiento
     * @return true si esta lleno, false en otro caso
     */
    public boolean estaLleno()
    {
        for (Lugar l: lugares)
        {
            if (l.getDisponible() == true)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que inicaliza los lugares del arreglo
     * Este es un método optativo
     */
    public void inicializaLugares(){}

    /**
     * Metodo en el que se simula la entrada de un carro
     * Imprime un texto que dice que el carro ha entrado de color AZUL
     * @param nombre El nombre del carro
     * @throws InterruptedException Si llega a fallar
     */
    public void entraCarro(int nombre) throws InterruptedException
    {
        String rest = "\u001B[0m";
        String colorAzul = "\u001B[34m";

        System.out.println(colorAzul + "El carro "+nombre+" ha entrado para estacionarse." + rest);

        int lug = obtenLugar();
        lugares[lug].setId(nombre);
        lugares[lug].estaciona();
    }

    /**
     * Metodo que asigna el lugar, una vez asignado ESTACIONA su nave
     * @param lugar El lugar que correspone
     * @throws InterruptedException
     */
    public void asignaLugar(int lugar) throws InterruptedException
    {
        int lugardisponible = obtenLugar();
        lugares[lugardisponible].setId(lugar);
    }

    /**
     * Se obtiene un lugar de forma pseudoAleatoria
     * @return Retorna el indice del lugar
     */
    public int obtenLugar()
    {
        Random random = new Random();
        int numero;
        while (true)
        {
            numero = random.nextInt(capacidad);
            if (lugares[numero].getDisponible() == true)
            {
                return numero;
            }
        }
    }
}