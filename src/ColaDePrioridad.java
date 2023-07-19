import java.util.ArrayList;
import java.util.NoSuchElementException;

class ColaDePrioridad {
    private ArrayList<Integer> monticulo;

    public ColaDePrioridad() {
        this.monticulo = new ArrayList<Integer>();
    }

    public boolean empty() {
        return this.monticulo.isEmpty();
    }

    // ?
    public int size() {
        return this.monticulo.size();
    }

    public void enqueue(Integer elemento) {
        this.monticulo.add(elemento);
        siftUp(this.monticulo.size() - 1);
    }

    public Integer dequeue() {
        if (empty()) {
            throw new NoSuchElementException("La fila está vacía!");
        }

        Integer valorMinimo = this.monticulo.get(0);
        int ultimoIndice = this.monticulo.size() - 1;
        monticulo.set(0, monticulo.get(ultimoIndice));
        monticulo.remove(ultimoIndice);
        siftDown(0);

        return valorMinimo;
    }

    private void siftUp(int i) {
        int indicePadre = (i - 1) / 2;
        while (i > 0 && monticulo.get(i).compareTo(monticulo.get(indicePadre)) < 0) {
            swap(i, indicePadre);
            i = indicePadre;
            indicePadre = (i - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int indiceHijoIzq = 2 * index + 1;
        int indiceHijoDer = 2 * index + 2;
        int indiceHijoMenor = index;

        if (indiceHijoIzq < monticulo.size() && monticulo.get(indiceHijoIzq).compareTo(monticulo.get(indiceHijoMenor)) < 0) {
            indiceHijoMenor = indiceHijoIzq;
        }

        if (indiceHijoDer < monticulo.size() && monticulo.get(indiceHijoDer).compareTo(monticulo.get(indiceHijoMenor)) < 0) {
            indiceHijoMenor = indiceHijoDer;
        }

        if (indiceHijoMenor != index) {
            swap(index, indiceHijoMenor);
            siftDown(indiceHijoMenor);
        }
    }

    private void swap(int i, int j) {
        Integer aux = monticulo.get(i);
        monticulo.set(i, monticulo.get(j));
        monticulo.set(j, aux);
    }
}