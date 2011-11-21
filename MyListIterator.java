
/**
 * Clase que implementa la interfaz ListIterator
 */

public class MyListIterator<E> implements ListIterator<E> {

    private MyList<E> miLista;
    private MyList<E> miLista2;
    private int posicion;

    public MyListIterator(MyList<E> lista) {

        miLista = lista;
        posicion = 0;
        miLista2 = lista;
        lista = miLista;
    }

    public boolean hasNext() {
        return posicion < miLista.tam;
    }

    public E next() {

        E nodo = miLista.getElem(posicion);
        posicion++;
        return nodo;
    }

    public void unlink() {
        int j = 0;
        while (j < posicion - 1) {
            miLista2 = miLista2.prox;
            j++;
        }
        (miLista2.prox) = (miLista2.prox.prox);
        posicion--;
        miLista.tam--;
    }
}
	

