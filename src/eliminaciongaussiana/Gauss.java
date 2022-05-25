package eliminaciongaussiana;

public class Gauss {

    float matriz[][];
    int filas;
    int columnas;
    String green="\033[32m"; 
    String reset="\u001B[0m";
    
    public Gauss(float matriz[][],int numFIlas, int numColumnas){
        this.matriz = matriz;
        filas =  numFIlas;
        columnas = numColumnas; 
    }
    
    
    public void GAUSS_JORDAN(){
        int piv;
        
        for(int i = 0; i < filas; i++){
            
            piv = i;
            
            if(matriz[piv][piv] == 0){
                int idxFila = 0;
                
                while(idxFila < filas && matriz[idxFila][piv] == 0 ){
                    idxFila++;
                }
                cambiarFila(piv, idxFila);
            }
            
            if(matriz[piv][piv] != 1 && matriz[piv][piv] != 0){
                filaPorK(piv, 1/matriz[piv][piv]);
            }
           
            for(int j = 0; j < columnas-1; j++){
                if(piv != j && matriz[j][piv] != 0){
                    sumaDeFilas(j, piv, -1*matriz[j][piv]);
                }
            }
        }
        printMatrix();
    }
    
    public void sumaDeFilas(int filaX,int filaY,float K){
        filaPorK(filaY, K);
        for(int j = 0; j < columnas; j++){
            matriz[filaX][j] += matriz[filaY][j]; 
        }
        filaPorK(filaY, 1/K);
    }
    
    public void filaPorK(int fila, float K){
        for (int j = 0; j < columnas; j++) {
            matriz[fila][j] *= K; 
        }
    }
    
    public void cambiarFila(int filaX,int filaY){
        float auxY [] = new float [columnas];
        
        //copea la filaY
        for (int i = 0; i < auxY.length; i++) {
            auxY[i] = matriz[filaY][i];
        }
        //haces el cambio 
        for (int k = 0; k < columnas; k++) {
            matriz[filaY][k] = matriz[filaX][k];
            matriz[filaX][k] = auxY[k];
        }
    }
       
    public void printMatrix(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                
                if(i==j){
                    if(matriz[i][j] > 0){
                        System.out.printf(" "+green+(Math.round(matriz[i][j] * 100.0)/100.0)+"\t"+reset);
                    }else if(matriz[i][j] < 0){
                        System.out.printf(green+(Math.round(matriz[i][j] * 100.0)/100.0)+"\t"+reset);
                    }else{
                        System.out.printf(green+" "+(Math.round(matriz[i][j] * 100.0)/100.0)+"\t"+reset);
                    }                
                }else{
                
                    if(matriz[i][j] > 0){
                        System.out.printf(" "+(Math.round(matriz[i][j] * 100.0)/100.0)+"\t");
                    }else if(matriz[i][j] < 0){
                        System.out.printf((Math.round(matriz[i][j] * 100.0)/100.0)+"\t");
                    }else{
                        System.out.printf(" "+(Math.round(matriz[i][j] * 100.0)/100.0)+"\t");
                    }            
                }
                
            }
            System.out.println();
        }
        
        ;
    }
    
}
