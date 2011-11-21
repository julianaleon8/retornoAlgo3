
/**
 * Interfaz que define el comportamiento de una lista
 * 
 * Esta es una clase parametrizada con tipo (clase) E; i.e., la
 * lista contiene elementos de tipo E.
 */
public interface List<E> {

    /**
     * Agrega un elemento a la lista.
     */
    public boolean add(E element);

     /**
     * Agrega un elemento en la posicion m de la lista.
     */
    public boolean add(int index, E element);

     /**
     * Agrega un elemento al principio de la lista.
     */
    public boolean addPrin(E element);

     /**
     * Devuelve el elemento de la lista en la posicion index
     */
    public E getElem(int pos);

    /**
     * Elimina todos los elementos de la lista. La lista queda
     * como recien creada.
     */
    public void clear();

    /**
     * Determina si el elemento dado esta en la lista.
     */
    public boolean contains(Object element);

    /**
     * Determina si la lista dada es igual a la lista.
     */
    public boolean equals(List<E> list);

    /**
     * Determina si la lista es vacia.
     */
    public boolean isEmpty();

    /**
     * Elimina el elemento dado de la lista. Si la lista cambia,
     * retorna true, sino retorna false.
     */
    public boolean remove(E element);

    /**
     * Retorna el numero de elementos en la lista
     */
    public int getSize();

  /**
     * Devuelve un arreglo que contiene todos los elementos
     * de la lista
     */
 
    public Object[] toArray();
   /**
     * Devuelve un iterador sobre la lista.
     */
    public ListIterator<E> iterator();
}

// End List.

