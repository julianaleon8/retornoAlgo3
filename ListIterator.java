/*
 * Interface que describe un iterador sobre listas.
 * Es una interface parametrizada con tipo (clase) E.
 * 
 * Tip: 
 * Ud debe generar una clase que implemente esta interfaz
 * 
 */
public interface ListIterator<E> {

    /*
     * Comprueba que exista un proximo elemento.
     */
    public boolean hasNext();

    /*
     * Devuelve el elemento asociado y avanza el iterador.
     */
    public E next();

    /*
     * Remueve de la lista el ultimo elemento retornado por next()
     */
    public void unlink();
}

// End ListIterator.
