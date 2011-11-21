
/**
 * Clase que almacena la informacion de las aristas en el grafo.
 */
public class Node {

    // id es unico
    private String id = null;

    public Node(String i) {
        id = new String(i);
    }

    /**
     * Retorna una nueva arista que es copia de this.
     */
    @Override
    protected Object clone() {
        return new Node(id);
    }

    /**
     * Indica si la arista de entrada es igual a this.
     */
    public boolean equals(Object o) {
        Node d = (Node) o;
        return (o instanceof Node) && d.id.equalsIgnoreCase(id);
    }

    /**
     * Retorna la representacion en String de la arista.
     */
    @Override
    public String toString() {
        return new String(id);
    }
}

// End Edge.java

