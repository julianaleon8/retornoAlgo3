
import java.io.*;

/*
 * Implementa la clase abstracta Digraph utilizando dos tablas de
 * hash, una para vertices y una para arcos.
 */

public class DigraphHash extends Digraph {

    private MyHashTable<Node> nodes;
    private MyHashTable<Edge> edges;

    /*
     * @see Constructor para Digraph.
     */
    public DigraphHash() {
        super();
        nodes = new MyHashTable<Node>(31);
        edges = new MyHashTable<Edge>(31);
    }
    public int numNodos() {
        return this.nodes.size();
    }
    /*
     * Agrega la arista dada al grafo. Si los vertices de la arista
     * no existen o el grafo tiene una arista entre dichos vertices,
     * retorna false. Si se agrega la nueva arista, retorna true.
     */
    public boolean add(Edge e) {
        if (edges.contains(e)) {
            return false;
        } else {
            edges.add(e);
            numEdges++;
            return true;
        }
    }

    /*
     * Agrega el nodo n. Si el vertice ya existe, retorna false. Si
     * se agrega el nodo, retorna true.
     */
    public boolean add(Node n) {
        if (nodes.contains(n)) {
            return false;
        } else {
            nodes.add(n);
            numVertices++;
            return true;
        }
    }

    /*
     * Elimina los nodos y aristas del grafo.
     */
    public void clear() {
        super.numEdges = 0;
        super.numVertices = 0;
        nodes = new MyHashTable<Node>(31);
        edges = new MyHashTable<Edge>(31);
    }

    @Override
    public Object clone() {
        DigraphHash grafoClon = new DigraphHash();
        grafoClon.numEdges = this.numEdges;
        grafoClon.numVertices = this.numVertices;
        grafoClon.edges = (MyHashTable) this.edges.clone();
        grafoClon.nodes = (MyHashTable) this.nodes.clone();
        return grafoClon;
    }

    /*
     * Chequea si el grafo contiene una arista del nodo src a dst
     */
    public boolean contains(String src, String dst) {
        Edge element = new Edge(src, dst);
        return edges.contains(element);
    }

    /*
     * Chequea si el grafo contiene un nodo con id nod
     */

    @Override
    public boolean contains(String nod) {
        Node element = new Node(nod);
        return nodes.contains(element);
    }

    /*
     * Retorna la arista del grafo que conecta a los vertices
     * src y dst. Si no existe dicha arista, retorna null.
     */
    public Edge get(String src, String dst) {
        if (this.contains(src, dst)) {
            return edges.get("(" + src + ", " + dst + ")");
        } else {
            return null;
        }
    }

    /*
     *Retorna todas las aristas del grafo
     */
    public List<Edge> getEdges() {
        List<Edge> lista = new MyList<Edge>();
        Object[] obj = edges.toArray();
        Edge ed;
        for (int i = 0; i < obj.length; i++) {
            ed = (Edge) obj[i];
            if (!lista.add(ed))
                return null;
        }
        return lista;
    }

    /*
     * Retorna el nodo con id nod. Si no existe dicho nodo, 
     * retorna null.
     */
    public Node get(String nod) {
        if (this.contains(nod)) {
            return nodes.get(nod);
        } else {
            return null;
        }
    }

    /* 
     * Retorna todos los nodos del grafo.
     */
    public List<Node> getNodes() {
        List<Node> lista = new MyList<Node>();
        Object[] obj = nodes.toArray();
        Node nod;
        for (int i = 0; i < obj.length; i++) {
            nod = (Node) obj[i];
            if (!(lista.add(nod))) {
                return null;
            }
        }
        return lista;
    }

    /*
     * Retorna la lista de lados que tienen al vertice dado como
     * destino. Si el vertice no existe, retorna null.
     *///
    public List<Edge> getInEdges(String node) {

        List<Edge> ListPrede = new MyList<Edge>();
        ListIterator<Edge> iteradorEdge = getEdges().iterator();

        while (iteradorEdge.hasNext()) {
            Edge edge = iteradorEdge.next();
            if (edge.getDst().equals(node)) {
                ListPrede.add(edge);
            }
        }
        return ListPrede;
    }

    /*
     * Retorna la lista de lados que tienen al vertice dado como
     * origen. Si el vertice no existe, retorna null.
     */
    public List<Edge> getOutEdges(String node) {

        List<Edge> ListSuce = new MyList<Edge>();
        ListIterator<Edge> iteradorEdge = getEdges().iterator();

        while (iteradorEdge.hasNext()) {
            Edge edge = iteradorEdge.next();
            if (edge.getSrc().equals(node)) {
                ListSuce.add(edge);
            }
        }
        return ListSuce;
    }

    /*
     * Remueve la arista del grafo que conecta a los vertices src y
     * dst. Si el grafo no cambia, retorna false. Si el grafo cambia,
     * retorna true.
     */
    public boolean remove(String src, String dst) {

        if (this.contains(src, dst)) {
            Edge eddd = this.edges.remove("(" + src + ", " + dst + ")");
            this.numEdges--;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Remueve el nodo del grafo el nodo nod y todas las aristas a las
     * que esta conectado. Si el grafo no cambia, retorna false. Si el
     * grafo cambia, retorna true.
     */
    public boolean remove(String nod) {

        if (this.contains(nod)) {
            Node noddd = this.nodes.remove(nod);
            List<Edge> mylist = getInEdges(nod);
            Edge edge;
            Edge edge2;
            ListIterator<Edge> iterador = mylist.iterator();
            while (iterador.hasNext()) {
                edge = iterador.next();
                edge2 = edges.remove(edge.toString());
            }

            mylist = getOutEdges(nod);
            iterador = mylist.iterator();
            while (iterador.hasNext()) {
                edge = iterador.next();
                edge2 = edges.remove(edge.toString());
            }
            this.numVertices--;
            return true;
            
        } else {
            return false;
        }
    }


}

// End DigraphHash.

