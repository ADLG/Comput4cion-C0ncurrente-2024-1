package kas.concurrente.inversionista;

import kas.concurrente.tenedor.*;
import kas.concurrente.candados.Lock;
import kas.concurrente.candadosImpl.PetersonLock;
import java.util.Random;

/**
 * Clase abstracta que modela al inversionista.
 * El inversionista tiene 2 tenedores a sus lados.
 * El inversionista posee un ID para que se pueda identificar.
 * El inversionista tiene una variable que indica el numero de veces que ha comido.
 * @version 1.0
 * @author Kassandra Mirael
 */
public abstract class Inversionista implements Runnable
{
    Lock lock = new PetersonLock();
    Tenedor t1;
    Tenedor t2;
    int id;
    int vecesComido;

    /**
     * Constructor de Inversionista.
     */
    public Inversionista(){}

    @Override
    public void run()
    {
        /**
         * El inversionista debe pensar y entrar a la mesa un periodo de veces
         * puesto en el test, agrega el valor aqui.
         */
        try
        {
            while (vecesComido < 500)
            {
                entraALaMesa();
            }
        } catch (InterruptedException ie) {ie.printStackTrace();}
    }

    /**
     * Metodo que nos permite entrar a la mesa.
     * El inversionista por fin dejo de pensar y de escribir en su
     * servilleta y se digna en entrar.
     * PRIMERO toma los tenedores.
     * DESPUES come.
     * FINALMENTE los suelta para que los demas los puedan usar.
     * @throws InterruptedException <Escribe porque se lanzaria esta exception>
     *      La excepcion se podria lanzar talvez en el caso que algun hilo
     *      tome un tenedor que se esta usando o quiera ejecutar el mismo metodo
     *      sin que el hilo anterior haya terminado.
     */
    public void entraALaMesa() throws InterruptedException
    {
        t1.tomar();
        t2.tomar();

        come();

        t1.soltar();
        t2.soltar();
    }

    /**
     * Una vez que termino de pensar sobre finanzas el inversionista
     * se prepara para comer.
     * El inversionista le toma un par de milisegundos comer.
     * ESTA ES LA SECCION CRITICA, SIGNIFICA PELIGRO
     * Incrementa el numero de veces que ha comido.
     * @throws InterruptedException <Escribe porque se lanzaria esta exception>
     *      La excepcion se podria lanzar por cuestiones relacionadas con el sleep del hilo.
     */
    public void come() throws InterruptedException
    {
        lock.lock();
        try
        {
            piensa();
        }
        catch (InterruptedException ex) {}
        lock.unlock();
        vecesComido++;
    }

    /**
     * Metodo que hace que el inversionista piense.
     * El inversionista pensara por una par de milisegundos.
     * Esto pasa antes de que tome sus tenedores.
     * @throws InterruptedException <Escribe porque se lanzaria esta exception>
     *      La excepcion se lanzaria de nuevo por el sleep que se le hace al hilo.
     */
    public void piensa() throws InterruptedException
    {
        Thread.sleep(generaTiempoDeEspera());
    }

    /**
     * Metodo que nos permite tomar los tenedores.
     * Los toma uno por uno.
     */
    public abstract void tomaTenedores();

    /**
     * Metodo que hace que el inversionista suelte ambos tenedores una vez
     * que terminara de comer. 
     * De esta manera otro los puede usar.
     * Suelta los tenedores uno por uno.
     */
    public abstract void sueltaTenedores();
    
    /**
     * Metodo que genera un numero pseudoaleatorio entre 1 y 10
     * @return El tiempo de espera
     */
    private long generaTiempoDeEspera(){
        double i=Math.random()*10.0;
        return (long)i ;
    }

    /**
     * Regresa el id del inversionista
     * @return el id del inversionista
     */
    public int getId(){
        return this.id;
    }

    /**
     * Asigna el id al inversionista
     * @param id el id del inversionista
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Regresa el tenedor izquierdo del inversionista
     * @return el tenedor izquierdo del inversionista
     */
    public Tenedor getTenedorIzq(){
        return t1;
    }

    /**
     * Asigna el tenedor izquierdo al inversionista
     * @param t el tenedor izquierdo del inversionista
     */
    public void setTenedorIzq(Tenedor t)
    {
        this.t1 = t; 
    }

    /**
     * Regresa el tenedor derecho del inversionista
     * @return el tenedor derecho del inversionista
     */
    public Tenedor getTenedorDer(){
        return t2;
    }

    /**
     * Asigna el tenedor derecho al inversionista
     * @param t el tenedor derecho del inversionista
     */
    public void setTenedorDer(Tenedor t)
    {
        this.t2 = t;
    }

    /**
     * Regresa las veces que ha comido el inversionista
     * @return el id del inversionista
     */
    public int getVecesComido(){
        return this.vecesComido;
    }

    /**
     * Asigna las veces que ha comido el inversionista
     * @param vecesComido el numero de veces que ha comido el inversionista
     */
    public void setVecesComido(int vecesComido){
        this.vecesComido = vecesComido;
    }
}
