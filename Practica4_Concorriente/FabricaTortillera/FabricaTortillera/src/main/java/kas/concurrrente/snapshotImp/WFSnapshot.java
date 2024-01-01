package kas.concurrrente.snapshotImp;

import kas.concurrrente.snapshot.Snapshot;
import kas.concurrrente.stamped.StampedSnap;
/**
 * Clase que implementa la interfaz Snapshot para el Snapshot WF.
 * @author DJLP   
 * @author ADLG
 */
public class WFSnapshot<T> implements Snapshot<T>{
    private StampedSnap<T>[] aTable;

    /**
     * Constructor que inicializa los valores del arreglo MRSW con los resgistros atomicos.
     * @param capacity la capacidad del Snapshot.
     * @param init el valor generico a insertar en el arreglo de StampedValue.
     */
    public WFSnapshot(int capacity, T init)
    {
        aTable = (StampedSnap<T>[]) new StampedSnap[capacity];
        for (int i=0; i<aTable.length; i++)
        {
            aTable[i] = new StampedSnap<T>(init); 
        }
    }

    /**
     * Escribe el valor v en el registro del proceso que realiza la llamada.
     * @param value la variable a escribir en el arreglo.
     */
    @Override public void update(T value)
    {
        int id = Integer.parseInt(Thread.currentThread().getName());
        T[] snap = scan();
        StampedSnap<T> oldValue = aTable[id];
        StampedSnap<T> newValue = new StampedSnap<T>(oldValue.getStamp()+1,value,snap);
        aTable[id] = newValue;
    }

    /**
     * Construye una vista instantanea del arreglo de registros.
     * @return el arreglo de registros.
     */
    @Override public T[] scan()
    {
        StampedSnap<T>[] oldCopy, newCopy;
        boolean[] moved = new boolean[aTable.length];
        oldCopy = collect();
        collect : while(true)
        {
            newCopy = collect();
            for (int i=0; i<aTable.length; i++)
            {
                if (oldCopy[i].getStamp() != newCopy[i].getStamp())
                {
                    if (moved[i])
                    {
                        return oldCopy[i].getSnap();   
                    }
                    else
                    {
                        moved[i] = true;
                        oldCopy = newCopy;
                        continue collect;
                    }
                }
            }
        T[] result = (T[]) new Object[aTable.length];
        for (int i=0; i<aTable.length; i++)
        {
            result[i] = newCopy[i].getValue();
        }
        return result;
        }
    }
    
    /**
     * Regresa una copia de los valores del arreglo.
     * @return la copia de los valores del arreglo.
     */
    private StampedSnap<T>[] collect()
    {
        StampedSnap<T>[] copy = (StampedSnap<T>[]) new StampedSnap[aTable.length];
        for (int i=0; i<aTable.length; i++)
        {
            copy[i] = aTable[i];
        }
        return copy;
    }

    /**
     * Regresa el arreglo con los registros atomicos.
     * @return el arreglo con los registros atomicos.
     */
    public StampedSnap<T>[] getATable()
    {
        return aTable;
    }

    /**
     * Regresa el valor en la posicion del arreglo con los registros.
     * @param pos la posicion del arreglo.
     * @return el valor en la posicion dada.
     */
    public T getStampedSnap(int pos)
    {
        return (T) aTable[pos].getValue();
    }
}
