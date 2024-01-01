import java.util.List;
import java.util.ArrayList;

/**
 * Clase que ejemplifica los Hilos implementando Runnable
 * @author Kassandra Mirael
 * @version 1.2
 */
public class Hilos implements Runnable
{
    public static void main(String[] args) throws InterruptedException
    {
        Hilos h = new Hilos();//Se crea una instancia de la clase

        List<Thread> list = new ArrayList<>();

        for (int i=1; i<11; i++)
        {
            Thread t = new Thread(h,"Hilo "+i);
            list.add(t);
            t.start();
        }

        for (Thread t: list)
        {t.join();}

    }

    @Override
    public void run()
    { //Sobrescribimos el metodo run
        int a = 10;
        int b = 12;
        long ID = (Thread.currentThread().getId());
        if(ID == 1)
            System.out.println("Soy el hilo 1");
        else
            System.out.println("Hola soy el: "+ Thread.currentThread().getName());//Pedimos el nombre del hilo pidiendo primero que se seleccione el Hilo
    }

}