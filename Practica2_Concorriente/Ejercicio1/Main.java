/**
 * Main para probar el funcionamiento del algoritmo de Peterson.
 */ 
public class Main
{
    public static void main(String[] args)
    {
        Peterson peterson = new Peterson();

        Thread thread1 = new MyThread(peterson, 0);
        Thread thread2 = new MyThread(peterson, 1);

        thread1.start();
        thread2.start();
    }
}