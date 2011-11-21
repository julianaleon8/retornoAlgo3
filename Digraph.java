
/**
 * Clase abstracta que implemena un grafo dirigido. Las aristas son
 * instancias de la clase Edge.
 */
public abstract class Digraph {

    protected int numVertices;  // numero de vertices
    protected int numEdges;     // numero de aristas

    /*
     * Construye un grafo vacio.
     */
    public Digraph() {
        numVertices = 0;
        numEdges = 0;
    }

    /*
     * Agrega la arista dada al grafo. Si los vertices de la arista
     * no existen o el grafo tiene una arista entre dichos vertices,
     * retorna false. Si se agrega la nueva arista, retorna true.
     */
    public abstract boolean add(Edge e);

    /*
     * Agrega el nodo n. Si el vertice ya existe, retorna false. Si
     * se agrega el nodo, retorna true.
     */
    public abstract boolean add(Node n);

    /*
     * Elimina los nodos y aristas del grafo.
     * 
     */
    public abstract void clear();

    /*
     * Retorna un nuevo grafo que es una copia del grafo actual.
     * 
     */
    public Object clone() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    /*
     * Chequa que el grafo contiene una arista (src, dst).
     */
    public abstract boolean contains(String src, String dst);

    /*
     * Chequa que el grafo contiene una nodo con id nod
     */
    public boolean contains(String nod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * Retorna la arista del grafo que conecta a los vertices
     * src y dst. Si no existe dicha arista, retorna null.
     */
    public abstract Edge get(String src, String dst);

    /*
     *Retorna todas las aristas del grafo
     */
    public abstract List<Edge> getEdges();

    /*
     * Retorna el nodo con id nod. Si no existe dicho nodo, 
     * retorna null.
     */
    public abstract Node get(String nod);

    /* 
     * Retorna todos los nodos del grafo.
     */
    public abstract List<Node> getNodes();

    /*
     * Retorna el numero de aristas en el grafo.
     */
    public int getNumEdges() {
        return numEdges;
    }

    /*
     * Retorna el numero de vertices en el grafo.
     */
    public int getNumVertices() {
        return numVertices;
    }

    /*
     * Retorna la lista de lados que tienen al vertice dado como
     * destino. Si el vertice no existe, retorna null.
     */
    public abstract List<Edge> getInEdges(String node);

    /*
     * Retorna los predecesores del nodo con id node
     */
    @SuppressWarnings("unchecked")
    public List<Node> getPreds(String node) {
        if (!contains(node)) {
            return null;
        }

        List<Edge> inEdges = getInEdges(node);

        if (inEdges == null) {
            return null;
        }

        ListIterator<Edge> li = inEdges.iterator();
        List<Node> preds = (List<Node>) new MyList();

        while (li.hasNext()) {
            Edge e = li.next();
            String sid = e.getSrc();

            preds.add(this.get(sid));
        }

        return preds;
    }

    /*
     * Retorna la lista de lados que tienen al vertice dado como
     * origen. Si el vertice no existe, retorna null.
     */
    public abstract List<Edge> getOutEdges(String node);

    /*
     * Retorna los sucesores del nodo con id node
     */
    @SuppressWarnings("unchecked")
    public List<Node> getSucs(String node) {
        if (!contains(node)) {
            return null;
        }

        List<Edge> outEdges = getOutEdges(node);

        if (outEdges == null) {
            return null;
        }

        ListIterator<Edge> li = outEdges.iterator();
        List<Node> sucs = new MyList();

        while (li.hasNext()) {
            Edge e = li.next();
            String sid = e.getDst();

            sucs.add(this.get(sid));
        }

        return sucs;
    }

    /*
     * Retorna el in-degree del vertice dado. Si el
     * vertice no existe, retorna -1.
     */
    public int getInDegree(String node) {
        return getInEdges(node).getSize();
    }
    /*
     * Retorna el out-degree del vertice dado. Si el
     * vertice no existe, retorna -1.
     */

    public int getOutDegree(String node) {
        return getOutEdges(node).getSize();
    }

    /*
     * Remueve la arista del grafo que conecta a los vertices src y
     * dst. Si el grafo no cambia, retorna false. Si el grafo cambia,
     * retorna true.
     */
    public abstract boolean remove(String src, String dst);

    /*
     * Remueve el nodo del grafo con id nod. Si el grafo no cambia,
     * retorna false. Si el grafo cambia, retorna true.
     */
    public abstract boolean remove(String nod);

    /*
     * Construye una representacion en String del grafo.
     */

    @Override
    public String toString() {
        String ret = numVertices + ":" + numEdges;

        ListIterator<Node> nods = getNodes().iterator();

        while (nods.hasNext()) {
            Node n = nods.next();
            ret += "\n" + n.toString();
        }

        ListIterator<Edge> edgs = getEdges().iterator();

        while (edgs.hasNext()) {
            Edge e = edgs.next();
            ret += "\n" + e.toString();
        }

        return ret;
    }
}

// End Digraph.java

