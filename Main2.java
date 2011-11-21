import java.io.*;
import java.lang.Integer;


public class Main2 {

    public static void agregarDatos(DigraphHash grafo, String linea) {
        String[] line;
        line = linea.split(" ");
        Node nod = new Node(line[0]);
        Node nod2 = new Node(line[1]);
        Edge ed = new Edge(line[0],line[1]);
        int costo = Integer.parseInt(line[2]);
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
            line = linea.split(" ");
            numNodes = Integer.parseInt(line[0]);
            System.out.println(numNodes);
            estadio = Integer.parseInt(line[1]);
            System.out.println(estadio);
            manuel = Integer.parseInt(line[2]);
            System.out.println(manuel);
            antonio = Integer.parseInt(line[3]);
            System.out.println(antonio);
            numEdges = Integer.parseInt(line[4]);
            System.out.println(numEdges);
            if (numNodes == -1 ) {
                termino = true;

            } else {
               int[] datos = new int[5];
               datos[0] = numNodes;
               datos[1] = estadio;
               datos[2] = manuel;
               datos[3] = antonio;
               datos[4] = numEdges;
               lista.add(datos);

               for(int i = 0; i < numEdges; i++) {
                linea = br.readLine();
                while (linea.length() < 1) {
                linea = br.readLine();
                }
                agregarDatos(grafo2,linea);
               }
               grafo.add(grafo2);
               grafo2 = new DigraphHash();


            }
            }
            } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {

        String input = null;
        MyList<DigraphHash> listaGrafo = new MyList<DigraphHash>();
        MyList<int[]> listaDatos = new MyList<int[]>();

        if (args.length == 1) {
            input = args[0];

            lectura(input,listaGrafo,listaDatos);
        } else {
           System.out.println("Debe especificar la ruta del archivo");
           System.exit(0);
        }
        ListIterator<DigraphHash> iter = listaGrafo.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            System.out.println("\n");
        }
        
    }

}
