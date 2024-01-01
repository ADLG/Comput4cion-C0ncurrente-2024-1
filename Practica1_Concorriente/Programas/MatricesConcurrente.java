import java.io.File;
import java.util.Scanner;
import java.util.Date;
/**
 * Clase MatricesConcurrente para la multiplicación de matrices concurrente
 * implementando Runnable.
 * @author DJLP   
 * @author ADLG
 */
public class MatricesConcurrente implements Runnable {

    int[][] matrixA;
    int[][] matrixB;
    int[][] resultado;
    int procesoId;

    /**
     * Constructor para crear la matriz concurrente.
     * @param procesoId el id del hilo.
     * @param matrixA la matriz A.
     * @param matrixB la matriz B.
     * @param resultado la matriz resultado.
     */
    public MatricesConcurrente (int procesoId, int[][] matrixA, int[][] matrixB, int[][] resultado) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.resultado = resultado;
        this.procesoId = procesoId;
    }

    /**
     * Obtiene la matriz A.
     * @return la matriz A.
     */
    public int[][] getMatrixA() {
        return this.matrixA;
    }

    /**
     * Obtiene la matriz B.
     * @return la matriz B.
     */
    public int[][] getMatrixB() {
        return this.matrixB;
    }

    /**
     * Obtiene la matriz resultado.
     * @return la matriz resultado.
     */
    public int[][] getResultado() {
        return this.resultado;
    }

    /**
     * Obtiene el id del proceso.
     * @return el id del proceso.
     */
    public int getProcesoId() {
        return this.procesoId;
    }

    //Metodo que multiplica dos matrices de tamaño (n x n)
    @Override
    public void run() {

        int[][] matrixA = getMatrixA();
        int[][] matrixB = getMatrixB();
        int[][] resultado = getResultado();
        int hilo = getProcesoId();

            for(int j = 0; j < matrixA.length; j++) {
                for(int k = 0; k < matrixA.length; k++) {
                    int multiplicacion = matrixA[j][k] * matrixB[k][hilo];
                    resultado[j][hilo] += multiplicacion;
                }
            }
    }

    /* Main para probar el funcionamiento de la multiplicacion de matrices */
    public static void main(String[] args) throws Exception {
    Date date = new Date();
    Scanner sc = new Scanner(System.in);
    int [][] matrizFile;
    while (true)
    {
    System.out.println("\n**MULTIPLICACION DE MATRICES CON HILOS**\n\t\tMENU\n1.Ingresar matrices de forma manual.\n2.Multiplicar matrices del archivo [Mat10.txt]\n3.Multiplicar matrices del archivo [Mat100.txt]\n4.Multiplicar matrices del archivo [Mat1000.txt]\n5.Salir.");
    int opc = sc.nextInt();
    switch (opc)
    {
    case 1:
        System.out.println("Ingresa el tamaño de las matriz A (advertencia!! la matriz B debe ser del mismo tamaño)");
        int tamanhio = sc.nextInt();
        int[][] matrixA = new int[tamanhio][tamanhio]; //Matriz A
        int[][] matrixB = new int[tamanhio][tamanhio]; //Matriz B
        int[][] resultado = new int[tamanhio][tamanhio]; //Matriz resultante
        Thread[] threads = new Thread[tamanhio]; //Hilos
		int cont = 0;//Contador de hilos

        //Llenamos la matriz A
        System.out.println("Datos de matriz A");
        for(int i = 0; i < tamanhio; i++ ) {
            System.out.println("Datos de la fila " + (i+1));
            for(int j = 0; j < tamanhio; j++ ) {
                System.out.println("Ingresa el dato " + (j+1));
                int dato = sc.nextInt();
                matrixA[i][j] = dato;
            }
        }


        //Llenamos la matriz B
        System.out.println("Datos de matriz B");
        for(int i = 0; i < tamanhio; i++ ) {
            System.out.println("Datos de la fila " + (i+1));
            for(int j = 0; j < tamanhio; j++ ) {
                System.out.println("Ingresa el dato " + (j+1));
                int dato = sc.nextInt();
                matrixB[i][j] = dato;
            }
        }

        long iniCustm = System.currentTimeMillis();

        //Creamos los n hilos que vienen siendo lo mismo que tamanhio
        for (int i=0; i<tamanhio; i++) {
			threads[i] = new Thread(new MatricesConcurrente(cont++, matrixA, matrixB, resultado));
			threads[i].start();
		}

        for (int i=0; i<tamanhio; i++) {
			try {
				threads[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

        // Imprimir el resultado
        System.out.println("\n*Matriz resultado*");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado.length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
        long finCustm = System.currentTimeMillis();
        System.out.println("Inicio a las:"+iniCustm+"\tTermino a las:"+finCustm+"\nResultado:"+(finCustm-iniCustm));
    break;

    case 2:
        long inix10 = System.currentTimeMillis();
        int[][] matrix10 = new int[10][10];
        int[][] resultadox10 = new int[10][10];
        Thread[] threadsx10 = new Thread[10];
        int cont10 = 0;
        matrix10 = leeArchivoMatriz("mat10.txt",10,10);
        for (int i=0; i<10; i++)
        {
            threadsx10[i] = new Thread(new MatricesConcurrente(cont10++, matrix10, matrix10, resultadox10));
            threadsx10[i].start();
        }

        for (int i=0; i<10; i++)
        {
            try {
                threadsx10[i].join();
            } catch(InterruptedException e) {e.printStackTrace();}
        }
        long finx10 = System.currentTimeMillis();
        System.out.println("Inicio a las:"+inix10+"\tTermino a las:"+finx10+"\nResultado:"+(finx10-inix10));
        imprimeMatrizFile(resultadox10,1);
    break;

    case 3: 
        long inix100 = System.currentTimeMillis();
        int[][] matrix100 = new int[100][100];
        int[][] resultadox100 = new int[100][100];
        Thread[] threadsx100 = new Thread[100];
        int cont100 = 0;
        matrix100 = leeArchivoMatriz("mat100.txt",100,100);
        for (int i=0; i<100; i++)
        {
            threadsx100[i] = new Thread(new MatricesConcurrente(cont100++, matrix100, matrix100, resultadox100));
            threadsx100[i].start();
        }

        for (int i=0; i<100; i++)
        {
            try {
                threadsx100[i].join();
            } catch(InterruptedException e) {e.printStackTrace();}
        }
        long finx100 = System.currentTimeMillis();
        System.out.println("Inicio a las:"+inix100+"\tTermino a las:"+finx100+"\nResultado:"+(finx100-inix100));
        imprimeMatrizFile(resultadox100,2);
    break;

    case 4:
        long inix1000 = System.currentTimeMillis();
        int[][] matrix1000 = new int[1000][1000];
        int[][] resultadox1000 = new int[1000][1000];
        Thread[] threadsx1000 = new Thread[1000];
        int cont1000 = 0;
        matrix1000 = leeArchivoMatriz("mat1000.txt",1000,1000);
        for (int i=0; i<1000; i++)
        {
            threadsx1000[i] = new Thread(new MatricesConcurrente(cont1000++, matrix1000, matrix1000, resultadox1000));
            threadsx1000[i].start();
        }

        for (int i=0; i<1000; i++)
        {
            try {
                threadsx1000[i].join();
            } catch(InterruptedException e) {e.printStackTrace();}
        }
        long finx1000 = System.currentTimeMillis();
        System.out.println("Inicio a las:"+inix1000+"\tTermino a las:"+finx1000+"\nResultado:"+(finx1000-inix1000));
        imprimeMatrizFile(resultadox1000,3);
    break;

    case 5: System.exit(1);
    break;

    default:System.out.println("Ingrese una opcion valida del MENU");
    break;
    }}}

    /**
     * Lee las matrices de los archivos mat10.txt, mat100.txt, mat1000.txt.
     * @param archivoName el nombre del txt con la matriz.
     * @param filas el numero de filas de la matriz del txt.
     * @param colum el numero de columnas de la matriz del txt
     * @return la matriz de un archivo txt en especifico de los 3 que hay en la carpeta.
     */
    public static int[][] leeArchivoMatriz(String archivoName, int filas, int colum) throws Exception
    {
       int[][] arrtxt = new int[filas][colum];
       try (Scanner sc = new Scanner(new File(archivoName)))
       {
          for (int i = 0; i < filas; i++)
             for (int j = 0; j < colum; j++)
                arrtxt[i][j] = sc.nextInt();
       }
               for (int i = 0; i < arrtxt.length; i++) {
             for (int j = 0; j < arrtxt.length; j++) {
                 System.out.print(arrtxt[i][j] + " ");
             }
             System.out.println();
         }
       return arrtxt;
    }

    /**
     * Imprime el resultado de las matrices de tamaño 10, 100 y 1000 correctamente.
     * @param matriz la matriz resultado.
     * @param size la opcion para imprimir una matriz de un tamaño en especifico.
     */
    public static void imprimeMatrizFile(int [][] matriz, int size)
    {
     System.out.println("\n*Matriz resultado*");
     if (size == 1)
     {
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz.length; j++) {
                 System.out.print(matriz[i][j] + " ");
             }
             System.out.println();
         }
     }
     if (size == 2)
     {        
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz.length; j++) {
                 System.out.print(matriz[i][j] + " ");
             }
             System.out.println();
         }
     }
     if (size == 3)
     {
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz.length; j++) {
                 System.out.print(matriz[i][j] + " ");
             }
             System.out.println();
         }
     }
    }
}