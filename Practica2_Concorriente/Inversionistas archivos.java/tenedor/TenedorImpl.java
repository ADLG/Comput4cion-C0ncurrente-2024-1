package kas.concurrente.tenedor;
import java.util.concurrent.locks.*;
import kas.concurrente.candadosImpl.PetersonLock;
/**
 * Clase que implementa el tenedor
 */
public class TenedorImpl implements Tenedor {

    private int id;
    private boolean status = false;
    private int vecesTomado;
    private PetersonLock lock = new PetersonLock();

    /**
     * Constructor del tenedor
     * @param id el id del tenedor
     */ 
    public TenedorImpl(int id)
    {
        this.id = id;
        vecesTomado = 0;
    }

    @Override
    public void tomar() {
        this.lock.lock();
        this.status = true;
        vecesTomado++;
    }

    @Override
    public void soltar() {
        this.status = false;
        this.lock.unlock();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getVecesTomado() {
        return this.vecesTomado;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setVecesTomado(int vecesTomado)
    {
        this.vecesTomado = vecesTomado;
    }
    
}
