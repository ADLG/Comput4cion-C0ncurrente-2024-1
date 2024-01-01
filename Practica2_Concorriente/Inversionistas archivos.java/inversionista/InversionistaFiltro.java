package kas.concurrente.inversionista;
import kas.concurrente.tenedor.Tenedor;
import kas.concurrente.tenedor.TenedorImpl;
import kas.concurrente.candadosImpl.Filtro;
import kas.concurrente.candados.Semaphore;
import java.util.Random;

/**
 * Clase que modela al inversionista, pero esta vez
 * usando el filtro.
 * @version 1.1
 * @author Kassandra Mirael
 */
public class InversionistaFiltro extends Inversionista {
    Semaphore filtro = new Filtro(5,5-1);
    int vecesComidoInvFilt;

    /**
     * Constructor del inversionista con filtro
     */ 
    public InversionistaFiltro()
    {
        vecesComidoInvFilt=0;
    }

    @Override
    public void entraALaMesa()
    {
        while (vecesComidoInvFilt < 500)
        {
        filtro.acquire();
            tomaTenedores();
            vecesComidoInvFilt++;
            setVecesComido(vecesComidoInvFilt);
            sueltaTenedores();
        filtro.release();
        }
    }

    @Override
    public void tomaTenedores()
    {
        getTenedorIzq().tomar();
        getTenedorDer().tomar();
    }

    @Override
    public void sueltaTenedores()
    {
        getTenedorIzq().soltar();
        getTenedorDer().soltar();
    }
    
}
