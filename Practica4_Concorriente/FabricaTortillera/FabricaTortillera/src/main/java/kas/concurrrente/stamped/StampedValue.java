package kas.concurrrente.stamped;
/**
 * Clase que hace referencia al objeto StampedValue con campos de marca y valor.
 * @author DJLP   
 * @author ADLG
 */
public class StampedValue<T>
{
    private long stamp;
    private T value;

    public static StampedValue MIN_VALUE = new StampedValue(null);

    /**
     * Constructor que inicializa los valores del StampedValue.
     * @param init el valor inicial.
     */
    public StampedValue(T init)
    {
        this.stamp = 0;
        this.value = init;
    }

    /**
     * Constructor que inicializa los valores stamp y value del StampedValue.
     * @param init el valor inicial.
     * @param stamp la marca inicial.
     */
    public StampedValue(long stamp, T value)
    {
        this.stamp = stamp;
        this.value = value;
    }

    /**
     * Regresa el stamp con la mayor marca de tiempo.
     * @param x el stamp x.
     * @param y el stamp y.
     * @return el stamp con la mayor marca de tiempo.
     */
    public static StampedValue max(StampedValue x, StampedValue y)
    {
        return (x.stamp > y.stamp) ? x:y;
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
    public T value()
    {
        return value;
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
}