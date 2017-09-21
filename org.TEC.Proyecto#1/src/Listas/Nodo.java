package Listas;

/**
 * Creacion del Nodo para su respectivo uso y caracteristicas del mismo
 *
 * @author deiber
 * @param <T>
 */
public class Nodo<T extends Comparable<T>> {

    private Nodo<T> siguiente;
    private Nodo<T> anterior;
    private T valor;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo(T valor, Nodo<T> siguiente) {
        this(valor);
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
