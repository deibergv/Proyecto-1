package Listas;

/**
 * Contructor de la clase encargada de las bases para una Lista Circular
 *
 * @author deiber
 * @param <T>
 */
public class ListaCircular<T extends Comparable<T>> {

    private Nodo<T> primero;

    public ListaCircular() {
        this.primero = null;
    }

    public boolean isEmpty() {
        return this.primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
        this.primero.setAnterior(primero);
        this.primero.setSiguiente(primero);
    }

    /**
     * Insercion basede nodo
     *
     * @param valor
     */
    public void Insertar(T valor) {
        if (this.primero == null) {
            this.primero = new Nodo<T>(valor);
            this.primero.setSiguiente(this.primero);
            this.primero.setAnterior(this.primero);
            return;
        }
        Nodo<T> actual = this.primero;
        Nodo<T> actual2 = new Nodo<>(valor);
        actual.getSiguiente().setAnterior(actual2);
        actual2.setSiguiente(actual.getSiguiente());
        actual2.setAnterior(actual);
        actual.setSiguiente(actual2);
    }

    /**
     * Impresion de lista
     */
    public void Imprimir() {
        Nodo<T> actual = this.primero;
        Boolean headFlag = false;
        while ((actual != this.primero || !headFlag) && actual != null) {
            if (!headFlag) {
                headFlag = true;
            }
            System.out.println(actual.getValor());
            actual = actual.getSiguiente();
        }
    }

    /**
     * Busqueda de un nodo
     *
     * @param buscado
     * @return
     */
    public Nodo<T> Buscar(T buscado) {
        Nodo<T> actual = this.primero;
        Boolean headFlag = false;
        while ((actual != this.primero || !headFlag) && actual != null) {
            if (!headFlag) {
                headFlag = true;
            }
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getSiguiente();
            }
        }
        return null;
    }

    /**
     * Borrado de algun valor segun su respectiva busqueda
     *
     * @param valor
     */
    public void Borrar(T valor) {
        Nodo<T> actual = this.primero;
        Nodo<T> anterior = null;
        Boolean headFlag = false;
        while ((actual != this.primero || !headFlag) && actual != null) {
            if (!headFlag) {
                headFlag = true;
            }
            if (actual.getValor().equals(valor)) {
                if (actual == this.primero) {
                    this.primero = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }
}
