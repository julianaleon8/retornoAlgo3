
/**
 * Clase que implementa la interfaz List
 * Esta es una clase parametrizada con tipo (clase) E; i.e., la
 * lista contiene elementos de tipo E.
 */
public class MyList<E> implements List<E> {

    /*
     * Modelo de representacion: lista simplemente enlazada
     * con un centinela.
     * La primera "caja" esta vacia.
     *
     * http://es.wikipedia.org/wiki/Lista_(inform�tica)#Nodos_Centinelas
     */
    public E[] actual;
    public MyList<E> prox;
    public int tam;

    /*
     * Constructor
     */
    public MyList() {

        this.actual = (E[]) new Object[1];
        this.prox = null;
        this.tam = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     */
    public boolean add(E element) {
        MyList<E> aux = new MyList<E>();
        if (this.tam == 0) {
            this.prox = aux;
        }
        aux = this;
        for (int i = 0; i < tam && aux.prox != null; i++) {
            aux = aux.prox;
        }
        MyList<E> next = aux.prox;
        aux.prox = new MyList<E>();
        aux.prox.actual[0] = element;
        this.tam++;
        return true;
    }
     /**
     * Agrega un elemento en la posicion m de la lista.
     */
    public boolean add(int m, E element) {

        if (element == null || m < 0) {
            return false;
        }
        //Nos despalazamos hasta la caja anterior a la que se quiere
        //eliminar, luego se acomodan los pointeres
        MyList<E> pointer = this;

        for (int i = 0; i < m && pointer.prox != null; i++) {
            pointer = pointer.prox;
        }
        
        MyList<E> next = pointer.prox;
        pointer.prox = new MyList<E>();
        pointer.prox.prox = next;
        pointer.prox.actual[0] = element;
        this.tam++;
        return true;
    }
     /**
     * Agrega un elemento al principio de la lista.
     */
    public boolean addPrin(E element) {
        MyList<E> aux = new MyList<E>();
        if (this.tam == 0) {
            this.prox = aux;
        }
        aux.prox = new MyList<E>();

        aux.prox = this.prox;
        aux.actual[0] = element;
        this.prox = aux;
        this.tam++;
        return true;

    }
     /**
     * Devuelve el elemento de la lista en la posicion index
     */

    public E getElem(int index) {
        if (index < 0 || index >= this.tam) {
            return null;
        } else {
            MyList<E> elem = this.prox;
            for (int i = 0; i < index; i++) {
                elem = elem.prox;
            }
            return elem.actual[0];
        }
    }

    /**
     * Elimina todos los elementos de la lista. La lista queda
     * como recien creada.
     */
    public void clear() {
        this.actual[0] = null;
        this.prox = null;
        this.tam = 0;
    }

    /**
     * Determina si el elemento dado esta en la lista.
     */
    public boolean contains(Object element) {
        ListIterator<E> iter = iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determina si la lista dada es igual a la lista.
     */
    public boolean equals(List<E> list) {
        if (this == null && list == null) {
            return true;
        }
        if (this != null && list == null) {
            return false;
        }
        if (this == null && list != null) {
            return false;
        }
        if (this.tam != list.getSize()) {
            return false;
        } else {
            boolean esIgual = true;
            ListIterator<E> iter1 = this.iterator();
            ListIterator<E> iter2 = list.iterator();

            while (iter1.hasNext()) {
                esIgual = iter1.next().equals(iter2.next());
            }
            return esIgual;
        }
    }

    /**
     * Determina si la lista es vacia.
     */
    public boolean isEmpty() {
        return (this.tam == 0);
    }

    /**
     * Elimina el elemento dado de la lista. Si la lista cambia,
     * retorna true, sino retorna false.
     */
    public boolean remove(E element) {
        if (element == null) {
            return false;
        } else {
            MyList<E> lista = this;
            int i = 0;
            while (i < this.tam && this.getElem(i) != element) {
                lista = lista.prox;
                i++;
            }
            if (i == this.tam) {
                return false;
            } else {
                lista.prox = lista.prox.prox;
            }
            this.tam--;
            return true;
        }
    }

    /**
     * Retorna el numero de elementos en la lista
     */
    public int getSize() {
        return this.tam;
    }

    /**
     * Devuelve un arreglo que contiene todos los elementos
     * de la lista
     */
    public Object[] toArray() {
        Object arreglo[] = new Object[this.tam];
        MyList<E> act = this.prox;
        for (int i = 0; i < this.tam; i++) {
            arreglo[i] = act.actual[0];
            act = act.prox;
        }
        return arreglo;
    }

    /**
     * Devuelve un iterador sobre la lista.
     */
    public ListIterator<E> iterator() {
        return new MyListIterator(this);
    }
}
// End List.

