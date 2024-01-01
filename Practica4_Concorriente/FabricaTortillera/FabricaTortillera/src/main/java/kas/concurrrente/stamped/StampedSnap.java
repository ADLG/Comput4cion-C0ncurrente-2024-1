package kas.concurrrente.stamped;
/**
 * Clase que hace referencia al objeto StampedSnap con campos de marca, valor y el arreglo snap.
 * @author DJLP   
 * @author ADLG
 */
public class StampedSnap<T>
{
    private long stamp;
    private T value;
    private T[] snap;

    /**
     * Constructor que inicializa los valores del StampedSnap.
     * @param value el valor inicial.
     */
    public StampedSnap(T value)
    {
        this.stamp = 0;
        this.value = value;
        this.snap = null;
    }

    /**
     * Constructor que inicializa los valores stamp y value del StampedSnap.
     * @param label la marca inicial inicial.
     * @param value el valor inicial.
     * @param snap el snap inicial.
     */
    public StampedSnap(long label, T value, T[] snap)
    {
        this.stamp = label;
        this.value = value;
        this.snap = snap;
    }

    /**
     * Regresa la marca de tiempo.
     * @return la marca de tiempo.
     */
    public long getStamp()
    {
        return stamp;
    }

    /**
     * Regresa el valor.
     * @return el valor.
     */
    public T getValue()
    {
        return value;
    }

    /**
     * Regresa el snap.
     * @return el snap.
     */
    public T[] getSnap()
    {
        return snap;
    }

    /**
     * Asigna la marca de tiempo.
     * @param stamp la marca de tiempo.
     */
    public void setStamp(long stamp)
    {
        this.stamp = stamp;
    }

    /**
     * Asigna el valor.
     * @param value el valor.
     */
    public void setValue(T value)
    {
        this.value = value;
    }

    /**
     * Asigna el snap.
     * @param snap el snap.
     */
    public void setSnap(T[] snap)
    {
        this.snap = snap;
    }
}