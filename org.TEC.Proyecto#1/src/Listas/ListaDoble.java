package Listas;

public class ListaDoble<T extends Comparable<T>> {

    private Nodo<T> primero;

    public ListaDoble() {
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
    }

    public void Insertar(T valor) {
        if (this.primero == null) {
            this.primero = new Nodo<T>(valor);
            return;
        }
        Nodo<T> actual = this.primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Nodo<T> actual2 = new Nodo<>(valor);
        actual.setSiguiente(actual2);
        actual2.setAnterior(actual);
        
    }

    public void Imprimir() {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            System.out.println(actual.getValor());
            actual = actual.getSiguiente();
        }
    }

    public Nodo<T> Buscar(T buscado) {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getSiguiente();
            }
        }
        return null;
    }

    public void Borrar(T valor) {
        Nodo<T> actual = this.primero;
        Nodo<T> anterior = null;
        while (actual != null) {
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
