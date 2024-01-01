package kas.concurrrente.snapshotImp;

import kas.concurrrente.snapshot.Snapshot;
/**
 * Clase que implementa la interfaz Snapshot para el SeqSnapshot.
 * @author DJLP   
 * @author ADLG
 */
public class SeqSnapshot<T> implements Snapshot<T>
{
    private T[] aValue;

    /**
     * Constructor que inicializa los valores del arreglo MRSW con los resgistros atomicos.
     * @param capacity la capacidad del Snapshot.
     * @param init el valor generico a insertar en el arreglo de StampedValue.
     */
    public SeqSnapshot(int capacity, T init)
    {
        aValue = (T[]) new Object[capacity];

        for(int i = 0; i < aValue.length; i++)
        {
            aValue[i] = init;
        }
    }
    
    /**
     * Escribe el valor v en el registro del proceso que realiza la llamada.
     * @param v la variable a escribir en el arreglo.
     */
    @Override public synchronized void update(T v)
    {
        int ID = Integer.parseInt(Thread.currentThread().getName());
        aValue[ID] = v;
    }

    /**
     * Construye una vista instantanea del arreglo de registros.
     * @return el arreglo de registros.
     */
    @Override public synchronized T[] scan()
    {
        T[] result = (T[]) new Object[aValue.length];
        for(int i = 0; i < aValue.length; i++){
            result[i] = aValue[i];
        }
        return result;
    }
}
