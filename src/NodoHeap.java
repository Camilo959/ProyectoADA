public class NodoHeap {
    int valor;
    NodoHeap izquierda;
    NodoHeap derecha;

    public NodoHeap(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}