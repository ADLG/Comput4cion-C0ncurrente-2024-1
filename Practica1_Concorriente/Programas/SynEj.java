/**
 * Clase SynEj de un ejemplo que usa synchronized.
 * @author DJLP
 * @author ADLG
 */
public class SynEj implements Runnable
{
    // Aqui se uso synchronized para imprimir correctamente "¡Hola Mundo!".
	@Override
    public void run()
    {
        synchronized (this)
        {
           System.out.println(Thread.currentThread().getName());
        }
    }

    /* Main para probar synchronized con 2 hilos. */
    public static void main(String[] args) throws InterruptedException
    {
    	SynEj se = new SynEj();
    	Thread h1e = new Thread(se,"¡Hola");
        Thread h2e = new Thread(se,"Mundo!");

        h1e.start();h2e.start();
        h1e.join();h2e.join();
    }
}
