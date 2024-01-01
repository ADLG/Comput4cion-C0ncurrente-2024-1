import java.util.Scanner;

/**
 * Clase MatrixMultiplicacionSecuencial para la multiplicación de matrices secuencial.
 * @author DJLP
 * @author ADLG
 */
public class MatrixMultiplicacionSecuencial {

    //Metodo que multiplica dos matrizes de tamaño (n x n)
    public static int[][] multiplicaMatriz(int[][] matrixA, int[][] matrixB) {
        
        int[][] resultado = new int[matrixA.length][matrixA.length];

        for(int i = 0; i < matrixA.length; i++) {
            for(int j = 0; j < matrixA.length; j++) {
                for(int k = 0; k < matrixA.length; k++) {
                    int multiplicacion = matrixA[i][k] * matrixB[k][j];
                    resultado[i][j] += multiplicacion;
                }
            }
        }
        return resultado;
    }

    //Metodo Main para probar el funcionamiento de la multiplicacion de matrices secuencial.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de las matriz A (advertencia!! la matriz B sera del mismo tamaño)");
        int tamanhio = sc.nextInt();
        int[][] matrixA = new int[tamanhio][tamanhio]; //Matriz A
        int[][] matrixB = new int[tamanhio][tamanhio]; //Matriz B

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

        //|1 2 3| |9 8 7|
        //|4 5 6| |6 5 4|
        //|7 8 9| |3 2 1|

        long iniSec = System.currentTimeMillis();
        int[][] result =  multiplicaMatriz(matrixA, matrixB);

        // Imprimir el resultado
        System.out.println("Matriz resultado");
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        long finSec = System.currentTimeMillis();
        System.out.println("Inicio a las:"+iniSec+"\tTermino a las:"+finSec+"\nResultado:"+(finSec-iniSec));
    }
}