import java.io.*;
import java.lang.Integer;


public class Main2 {

    public static void agregarDatos(DigraphHash grafo, String linea) {
        String[] line;
        line = linea.split(" ");
        Node nod = new Node(line[0]);
        Node nod2 = new Node(line[1]);
        Edge ed = new Edge(line[0],line[1]);
        Edge ed2 = new Edge(line[1],line[0]);
        int costo = Integer.parseInt(line[2]);
        ed.setCosto(costo);
        ed2.setCosto(costo);
        grafo.add(nod);
        grafo.add(nod2);
        grafo.add(ed);
        grafo.add(ed2);
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
           // System.out.println(numNodes);
            estadio = Integer.parseInt(line[1]);
           // System.out.println(estadio);
            manuel = Integer.parseInt(line[2]);
           // System.out.println(manuel);
            antonio = Integer.parseInt(line[3]);
           // System.out.println(antonio);
            numEdges = Integer.parseInt(line[4]);
           // System.out.println(numEdges);
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
    	public static MyList<Integer> dijkstra(int ini, int fin, DigraphHash grafo) {
		MyList<Integer> vertices = new MyList<Integer>();
                int len = grafo.getNumVertices();
		boolean[] visitado = new boolean[len];
		int[] costos = new int[len];
                int[] pred = new int[len];
                MyList<Integer> camino = new MyList<Integer>();
                MyList<Integer> camino2 = new MyList<Integer>();


		for(int i = 0 ;  i < grafo.getNumVertices() ; i++)
                    costos[i] = Integer.MAX_VALUE;

		vertices.add(ini);
		costos[ini-1] = 0;

		while (!vertices.isEmpty()) {
                    
				int v = vertices.getElem(0);
                                
                                vertices.remove(v);
                              

				if(visitado[v-1]) continue;

				if(v == fin) break;

				visitado[v-1] = true;
                                String m = (Integer.toString(v));
				List<Node> S = grafo.getSucs(m);

				while (!S.isEmpty()) {
                                        Node n = S.getElem(0);
					S.remove(n);
                                        String f = n.toString();
                                        int l = Integer.parseInt(f);
                                        int w = l;
					if (!visitado[w-1]) {
						vertices.add(w);
                                                  
                                                String v1 = Integer.toString(v);
                                                String w1 = Integer.toString(w);
						int costo = costos[v-1] + grafo.get(v1,w1).getCosto();
						if (costo < costos[w-1]) {
							costos[w-1] = costo;
                                                        pred[w-1] = v;
                                                        //camino.add(w);
                                                }
                                                //else
                                                //    camino.remove(w-1);

					}
				}
		}
           
          camino.add(fin);
             int j = fin;
                while(pred[j - 1] != ini) {
                    camino.addPrin(pred[j - 1]);
                    j = pred[j - 1];
                }
             camino.addPrin(ini);


                camino.add(costos[fin-1]);
		return camino;
	}

           
    public static void main(String[] args) {

        String input = null;
        MyList<DigraphHash> listaGrafo = new MyList<DigraphHash>();
        MyList<int[]> listaDatos = new MyList<int[]>();
        DigraphHash grafo = new DigraphHash();
        MyList<MyList<Integer>> list = new MyList<MyList<Integer>>();

        if (args.length == 1) {
            input = args[0];

            lectura(input,listaGrafo,listaDatos);
        } else {
           System.out.println("Debe especificar la ruta del archivo");
           System.exit(0);
        }
        /*ListIterator<DigraphHash> iter = listaGrafo.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            System.out.println("\n");
        }*/
        ListIterator<DigraphHash> iter = listaGrafo.iterator();
        ListIterator<int[]> iter2 = listaDatos.iterator();
        while(iter.hasNext() && iter2.hasNext()) {
            int[] data = new int[5];
            data = iter2.next();
            int ini = data[2];
            int fin = data[1];
            grafo = iter.next();
            MyList<Integer> hola = dijkstra(ini,fin,grafo);
            list.add(hola);
        }
        for(int i = 0; i<list.getSize(); i++) {
            MyList<Integer> lista = list.getElem(i);
            for(int j = 0; j<lista.getSize(); j++) {
                System.out.println(lista.getElem(j));
            }
            //System.out.println("Costo " + lista.getElem(lista.getSize()-1));
            System.out.println("\n");
        }

        
    }

}
