import java.util.Scanner;
/**
 * Clase que hace Override al run para hacer uso de los 
 * metodos acquire() y release() del filtro modificado.
 */ 
public class MyThread extends Thread {
    private MultiThreadedSection section;
    int idHilo;

    public MyThread(MultiThreadedSection section, int idHilo) {
        this.section = section;
        this.idHilo = idHilo;
    }

    @Override
    public void run() {
        try {
            section.acquire();
            // Acceso a la sección crítica
            // ... (código de la sección crítica)
            System.out.println("Hola soy el hilo " + idHilo + " Y estoy en la seccion critica...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            section.release();
            System.out.println("Notificion, ya hay espacio en la zona critica.....");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el numero de hilos que deseas crear....");
        int numHilos = sc.nextInt();
        Thread[] threads = new Thread[numHilos]; //Hilos
        int contador = 0;
        MultiThreadedSection multiHilos = new MultiThreadedSection(numHilos);

        for (int i=0; i<numHilos; i++) {
          threads[i] = new Thread(new MyThread(multiHilos,contador++));
          threads[i].start();
        }
    }
}
