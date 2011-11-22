/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juli
 */
public class HeapCola {
    
   // no es NODE es INT 
    int [] cola;
    int n;
    
    public HeapCola(int m, int max){
    n = m;
    cola = new int[max] ;
   
    }
    
    
    public static int [] descenderLlave(int [] c , int elem, int clave){
        c[elem]= clave;
        while ((elem/2)!= 0 && clave < c[(elem/2)]){
            int aux = c[elem];
            c[elem] = c[elem/2];
            c[elem/2] = c[elem];
        
        }
        return c;
    }
    public static int [] insertar(HeapCola c , int elem, int clave){
        c.n = c.n+1;
        c.cola[c.n] = clave;
        elem = c.n;
  // Mantener l condicion de heap
         //c.cola[elem]= clave;
        // hasta ahora solo funciona con dos hijos se debe cambiar la condicion 
        // de elem/ 2 para padre para tener n nodos
        while ((elem/2)!= 0 && clave < c.cola[(elem/2)]){
            
            c.cola[elem] = c.cola[elem/2];
            c.cola[elem/2] = clave;
            elem=elem/2;
        }
         System.out.println("cola" +c.cola[1]);
        
        System.out.println("cola" +c.cola[2]);
       System.out.println("cola" +c.cola[3]);
       
        return c.cola;
    
    }
    public static int incrementarMin(int [] c, int elem, int clave){
       
        
        while (elem*2 != 0 && (elem*2)+1!= 0 ){
            int hijoIz = elem*2;
            int hijoDer = (elem*2)+1;
            int hijo;
                if (c[hijoIz] > c[hijoDer]){    
                    hijo = hijoDer;
                }else{ 
                    hijo = hijoIz;
                }
               
            if (c[elem] > c[hijo]){
                int aux;
                aux = c[hijo];
                c[hijo] = c[elem];
                c[elem]= aux;
            }else {
                break;
            
                }
            }
                    
    return elem;
    
    }
    
    
    public static int extraerMin(HeapCola  c){
        int costo = c.cola[1];
        c.cola[1] = c.cola[c.n];
       
        c.n=c.n-1;
        incrementarMin(c.cola,1,c.cola[1]);
        return costo;
    
    
    }

    public static void dijkstra(DigraphHash grafo){
        int [] costos = new int[100];
        HeapCola camino = new HeapCola(0, 100);
        camino.cola = insertar(camino, 0, 0);
        for (int i =1; i< camino.n; i++){
            camino.cola = insertar(camino, i, 100000);
        }
        
        for (int k= 1; k < camino.n;k++){
            int min;
            min = extraerMin(camino);
            costos[k] = min;
            for (){}
            
        
        
        }
        

FOR k from 1 to n:
   (i, d) := ExtractMin(Q)
   D[i] := d
   FOR all edges ij:
      IF d + w(i,j) < j’s key
         DecreaseKey(Q, node j, d + w(i,j))

    
    }

    /* public static void main(String[] args) {
        int t=1;
        int [] algo= new int[5];
        HeapCola prueba = new HeapCola(3,100);
  
prueba.cola = insertar(prueba, 1, 0);

        for(int i =1; i< prueba.n-1;i++){
            insertar(prueba, i, 5000);
        
         
            for(int k=1 ; k< prueba.n;k++){
            int costo;
            costo = extraerMin(prueba);
            algo [i]= costo ;
            
               /* for(){
                    if costo + acumulado < nuevoCosto 
                   descenderMin(prueba, node j, costo + acumulado); 
                
                }*/
       /*     }
        }
  
      */  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* int costo = 3;
        int posicion =1 ;
        prueba.cola[1] = 2;
        prueba.cola[2] = 4;
        prueba.cola[3] = 5;
         prueba.cola = insertar(prueba, posicion, costo);
         prueba.cola = insertar(prueba, 2, 8);
          prueba.cola = insertar(prueba, 2, 1);
          t = extraerMin(prueba);
          
         System.out.println(prueba.cola[1]);
         System.out.println(prueba.cola[2]);
         System.out.println(prueba.cola[3]);
         System.out.println(prueba.cola[4]);
    System.out.println(prueba.cola[5]);
System.out.println("n es" + prueba.n);
System.out.println(prueba.cola[7]);
System.out.println(prueba.cola[8]);
System.out.println(prueba.cola[9]);
*/
//     }

}