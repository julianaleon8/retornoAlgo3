import java.io.*;
import java.lang.Integer;


public class main {

    public static void agregarDatos(DigraphHash grafo, String linea) {
        String[] line;
        line = linea.split("");
        Node nod = new Node(line[1]);
        Node nod2 = new Node(line[2]);
        Edge ed = new Edge(line[1],line[2]);
        int costo = Integer.parseInt(line[3]);
        ed.setCosto(costo);
        grafo.add(nod);
        grafo.add(nod2);
        grafo.add(ed);
    }
    public static void lectura(String input, MyList<DigraphHash> grafo, 
                            MyList<int[]> lista) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

         try {
            archivo = new File(input);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            DigraphHash grafo2 = new DigraphHash();
            String linea;
            String[] line;
            int numNodes;
            int estadio;
            int manuel;
            int antonio;
            int numEdges;
            boolean termino = false;
            while(!termino) {
            linea = br.readLine();
            while (linea.length() < 1) {
                linea = br.readLine();
            }
            //Agregar excepcion cuando el tamaño de la linea < 5
            line = linea.split("");
            numNodes = Integer.parseInt(line[1]);
            estadio = Integer.parseInt(line[2]);
            manuel = Integer.parseInt(line[3]);
            antonio = Integer.parseInt(line[4]);
            numEdges = Integer.parseInt(line[5]);
            if (numNodes == -1 ) {
                termino = true;

            } else {
               int[] datos = new int[5];
               datos[0] = numNodes;
               datos[1] = estadio;
               datos[2] = manuel;
               datos[3] = antonio;
               datos[4] = numEdges;

               for(int i = 0; i < numEdges; i++) {
                linea = br.readLine();
                while (linea.length() < 1) {
                linea = br.readLine();
                }
                agregarDatos(grafo2,linea);
               }
               grafo.add(grafo2);


            }
            }
            }


    }

}
