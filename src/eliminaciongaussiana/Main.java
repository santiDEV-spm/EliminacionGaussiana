
package eliminaciongaussiana;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int filas=0, columnas = 0;
        
        float AB [][];
        
        System.out.println("- - - - - - - - - - GAUSS-JORDAN - - - - - - - - - -");
        System.out.println("tiene que ingresar la matrix ampliada");
        System.out.println("Ingrese el numero de filas: ");
        filas = sc.nextInt();
        System.out.println("Ingrese el numero de columnas: ");
        columnas = sc.nextInt();
        
        AB = new float[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese AB["+(i+1)+"]["+(j+1)+"]: ");
                AB[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\n- - - - - - - - - - MATRIZ AMPLIADA - - - - - - - - - -\n");
        Gauss gs = new Gauss(AB,filas,columnas);
        gs.printMatrix();
        System.out.println("\n- - - - - - - - - - MATRIZ ESCALONADA REDUCIDA - - - - - - - - - -\n");
        gs.GAUSS_JORDAN();
    }

}
