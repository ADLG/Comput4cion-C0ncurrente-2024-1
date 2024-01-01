/**
 * Class que modela el lock y unlock con el arreglo booleano
 * y la victima entera con volatile.
 */ 
public class Peterson
{
    private volatile boolean[] flag = new boolean[2];
    private volatile int victim = 0;

    public void lock(int threadId) {
        int j = 1 - threadId;
        flag[threadId] = true;
        victim = threadId;
        while (flag[j] && victim == threadId) {
            // Espera
        }
    }

    public void unlock(int threadId) {
        flag[threadId] = false;
    }
}