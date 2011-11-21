//archivo Main.java
/**
 *
 * @author Juliana Leon 08-10608
 *         Susana Charara 08-10223
 */

import java.io.*;

public class Main {

    /**
     * Determina si una palabra del diccionario esta en el camino de un nodo dado
     *
     * @pre Grafo no vacio y Nodo Del grafo
     *
     * @param grafo El grafo a buscar el camino , no Nodo raiz de la busqueda ,
     * palabra La palabra a buscar del diccionario dado
     * @throws IllegalArgumentException Si palabra es null, está vacío o
     * contiene solo espacios.
     */
    public static boolean DFS(DigraphHash grafo, Node no, String palabra) {

        boolean existe = false;
        MyList<Node> pila = new MyList();
        List<Node> suce = new MyList();
        String[] letras;
        letras = palabra.split("");
        int tam = palabra.length();
        String[] camino = new String[tam];
        int encon = 1;

        // Nodo de entrada es igual a la
        // primera letra de la palabra a buscar


        if (no.toString().equals(letras[1])) {
            camino[encon - 1] = letras[encon];
            encon++;
            suce = grafo.getSucs(no.toString());
            ListIterator<Node> ite = suce.iterator();
            int NumSuce;
            NumSuce = suce.getSize();

            while (ite.hasNext()) {
                pila.addPrin(ite.next());
            }
            int i = 0;
            int j = 0;
            // Itera en la Lista hasta que se agoten los sucesores
            // o encunetre la palabra dada

            while (j < NumSuce && encon < tam + 1) {
                Node aux = new Node("");
                aux = pila.getElem(j);

                // El nodo actual es igual la letra de la palabra dada

                if (aux.toString().equals(letras[encon])) {
                    i++;
                    suce = grafo.getSucs(aux.toString());
                    NumSuce = suce.getSize();
                    ite = suce.iterator();

                    while (ite.hasNext()) {
                        pila.addPrin(ite.next());
                    }

                    camino[encon - 1] = letras[encon];
                    encon++;
                    j = 0;

                } else {
                    j++;
                }
            }
        }

        if (encon == tam + 1) {
            existe = true;
            return existe;
        } else {
            return existe;
        }
    }


    /**
     * Agrega nodos y arcos al grafo correspondiente al tablero
     *
     * @pre Grafo no vacio
     *
     * @param linea: Una hilera del tablero
     * actual: Hilera anterior del tablero
     * grafo:El grafo al que se le va a agregar la informacion,
     *
     * @return Arreglo de string asociado a linea
     */
    private static String[] agregarDatos(String linea, String[] actual,
                            DigraphHash grafo) {

        int numCaracteres = linea.length();
        String caracteres[] = new String[numCaracteres];
        String[] line;

        // Se agregan nodos asociados a cada elemento de la hilera dada
        for (int v = 1; v < numCaracteres + 1; v++) {
            line = linea.split("");
            caracteres[v - 1] = line[v];
            Node nodo = new Node(caracteres[v - 1]);
            grafo.add(nodo);

            if (actual != null) {

                //Se agregan arcos de elementos adyacentes verticalmente
                Edge arc = new Edge(caracteres[v - 1], actual[v - 1]);
                Edge arc2 = new Edge(actual[v - 1], caracteres[v - 1]);
                grafo.add(arc);
                grafo.add(arc2);

                //Se agregan arcos de elementos adyacentes diagonalmente
                if (v < numCaracteres) {

                    arc = new Edge(caracteres[v - 1], actual[v]);
                    arc2 = new Edge(actual[v], caracteres[v - 1]);
                    grafo.add(arc);
                    grafo.add(arc2);
                }
                if (v != 1) {
                    arc = new Edge(caracteres[v - 1], actual[v - 2]);
                    arc2 = new Edge(actual[v - 2], caracteres[v - 1]);
                    grafo.add(arc);
                    grafo.add(arc2);
                }
            }
            //Se agregan arcos de elementos adyacentes horizontalmente
            if (v - 1 != 0) {
                Edge arco = new Edge(caracteres[v - 2], caracteres[v - 1]);
                Edge arco2 = new Edge(caracteres[v - 1], caracteres[v - 2]);
                grafo.add(arco);
                grafo.add(arco2);
            }
        }
        return caracteres;
    }

    /**
     * Verifica si una palabra del diccionario es valida
     *
     * @pre true
     *
     * @param palabra: La palabra a procesar
     *
     * @return si una palabra es valida o no
     */
    public static boolean esValida(String palabra) {

        boolean val = true;
        int i = 1;
        int j;
        String[] caracteres = palabra.split("");

        // Se verifica que en una misma palabra no hayan caracteres repetidos
        while (i < caracteres.length && val) {
            j = i + 1;
            while (j < caracteres.length && val) {
                if (caracteres[i].equals(caracteres[j])) {
                    val = false;
                }
                j++;
            }
            i++;
        }
        return val;
    }

    /**
     * Retorna una lista de palabras validas almacenadas en otra lista
     *
     * @pre lista no vacia
     *
     * @param lista: La lista a procesar
     *
     * @return lista de palabras validas
     */
    public static MyList<String> validas(MyList<String> lista) {

        MyList<String> listaValidas = new MyList<String>();
        String palabra;
        ListIterator<String> iter = lista.iterator();

        while (iter.hasNext()) {
            palabra = iter.next();
            if (esValida(palabra)) {
                listaValidas.add(palabra);
            }
        }
        return listaValidas;
    }

    /**
     * Escribe en un archivo las palabras del tablero que estan en el diccionario
     *
     * @pre listaPalabras no vacia
     *
     * @param output: Archivo donde se guardara la informacion
     * listaPalabras: Una lista de las palabras encontradas en el tablero
     */

    public static void escritura(String output, MyList<String> listaPalabras) {
        BufferedReader in =
        new BufferedReader(new InputStreamReader(System.in));
        File archivo = new File(output);

        // Se obtiene un arreglo de los elementos de la lista pasada
        Object[] arreglo = listaPalabras.toArray();
        int n = arreglo.length;
        String[] arreglo2 = new String[n];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo2[i] = (String) arreglo[i];
        }

        // Se ordena lexicograficamente el arreglo asociado a la lista dada
        String[] ordenado = quicksort2.quicksortt2(arreglo2, 0, arreglo2.length);

            try {

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter
                                (new FileOutputStream(archivo, true), "UTF8"));
                for (int i = 0; i < ordenado.length; i++) {
                    out.write(ordenado[i] + "\n");
                }
                out.write("\n");
                out.close();
            } catch (UnsupportedEncodingException ue) {

                System.out.println("Not supported : ");

            } catch (IOException e) {

                System.out.println(e.getMessage());

            }

    }
/**
     * Lee la informacion dada en un archivo
     *
     * @pre grafo y diccionario no vacios
     *
     * @param input: Archivo del cual se leera la informacion
     * grafo: Lista de grafos asociados a cada tablero leido
     * diccionario: Lista de diccionarios asociados a cada juego
     *
     */
    public static void lectura(String input, MyList<DigraphHash> grafo,
                                MyList<MyList<String>> diccionario) {

        File archivo = new File(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] matriz;

        try {
            BufferedReader ib = new BufferedReader(new InputStreamReader
                                (new FileInputStream(archivo), "UTF8"));
            DigraphHash grafo2 = new DigraphHash();
            String linea;
            String[] line;
            linea = ib.readLine();

            while (linea.length() < 1) {
                linea = ib.readLine();
            }

            //Se obtiene el numero de juegos que estan en el archivo
            int numJuegos = Integer.parseInt(linea);
            int i = 0;
            int numCaracteres;
            String[] actual = null;
            String[] actual2;
            boolean termino = false;
            int j = 0;

            // Sobre cada juego
            while (i < numJuegos) {
                linea = ib.readLine();
                if (linea.length() < 1) {
                    continue;
                }

                // Se obtiene el numero de caracteres de una hilera del tablero
                // Esto es, el tamaño de la matriz asociada
                numCaracteres = linea.length();

                // Se agrega la primera linea, luego se itera hasta el final
                // de la matriz asociada para agregar el resto

                actual = agregarDatos(linea, actual, grafo2);

                for (int m = 0; m < numCaracteres - 1; m++) {
                    linea = ib.readLine();
                    for (int l = 0; l < numCaracteres - 1; l++) {
                        actual = agregarDatos(linea, actual, grafo2);
                    }
                }

                linea = ib.readLine();

                while (linea.length() < 1) {
                    linea = ib.readLine();
                }

                // Se obtiene el numero de palabras del diccionario asociado
                int numPalabras = Integer.parseInt(linea);
                int m = 0;
                MyList<String> palabras = new MyList<String>();

                while (m < numPalabras) {
                    linea = ib.readLine();
                    if (linea.length() < 1) {
                        continue;
                    }
                    palabras.add(linea);
                    m++;
                }

                i++;
                actual = null;

                // Se agrega la informacion sobre el tablero y diccionario leido
                grafo.add(grafo2);
                diccionario.add(palabras);

                // Se reinicializan para obtener los
                //demas tableros y diccionarios del archivo

                palabras = new MyList<String>();
                grafo2 = new DigraphHash();
            }

        } catch (UnsupportedEncodingException ue) {
            System.out.println("Not supported : ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Busca si una palabra dada esta en el grafo
     * @pre Grafo no vacio
     *
     * @param grafo: Grafo sobre el cual se va a buscar la palabra
     * palabra: La palabra a buscar
     *
     * @return si la palabra dada esta en el grafo o no
     */
    public static boolean buscarPalabra(DigraphHash grafo, String palabra) {

        List<Node> nodosGrafo = new MyList<Node>();
        ListIterator<Node> iter;
        Node nodo;
        boolean esta = false;

        // Se obtiene una lista de todos los nodos del grafo
        nodosGrafo = grafo.getNodes();
        iter = nodosGrafo.iterator();

        // Mientras no se encuentre la palabra, se aplica DFS sobre cada uno
        // de los nodos del grafo
        while (iter.hasNext() && !esta) {
            nodo = iter.next();
            esta = DFS(grafo, nodo, palabra);
        }
        return esta;
    }

    public static void main(String[] args) {

        String input = null;
        String output = null;
        MyList<DigraphHash> listaGrafo = new MyList<DigraphHash>();
        MyList<MyList<String>> diccionario = new MyList<MyList<String>>();

        if (args.length == 2) {
            input = args[0];
            output = args[1];
            lectura(input, listaGrafo, diccionario);
        }
        else {
           System.out.println("Debe especificar ambos archivos");
           System.exit(0);
        }

        ListIterator<DigraphHash> iter = listaGrafo.iterator();
        MyList<String> lista = new MyList<String>();
        MyList<String> listaVal = new MyList<String>();
        MyList<String> listaPalabras = new MyList<String>();
        ListIterator<MyList<String>> iter2 = diccionario.iterator();
        DigraphHash grafo = new DigraphHash();
        String palabra;
        boolean esta;
        int i = 0;

        // Se obtiene la lista de grafos asociados a cada tablero,
        // asi como la lista de diccionarios asociada
        while (iter.hasNext() && iter2.hasNext()) {
            grafo = iter.next(); // obtengo grafo
            lista = iter2.next();
            listaVal = validas(lista);

            // Se itera sobre cada diccionario de la lista
            ListIterator<String> iter3 = listaVal.iterator();

            // Se obtiene cada una de las palabras del diccionario sobre el
            // que se esta iterando
            while (iter3.hasNext()) {
                palabra = iter3.next();

                esta = buscarPalabra(grafo, palabra);
                if (esta) {
                    listaPalabras.add(palabra);
                }
                i++;
            }
            escritura(output, listaPalabras);
            listaPalabras = new MyList<String>();
        }
    }
}
