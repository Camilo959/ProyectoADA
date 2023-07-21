import java.util.ArrayList;

/**
 * La clase "ColaDePrioridad" representa una cola de prioridad
 * implementada mediante un montículo mínimo (min-heap).
 * Permite insertar elementos con su respectiva prioridad, extraer el elemento
 * con la menor prioridad y obtener el tamaño de la cola.
 */
class ColaDePrioridad {
    private ArrayList<Integer> monticulo;

    /**
     * Constructor de la clase "ColaDePrioridad" que inicializa la cola de prioridad
     * como un montículo vacío.
     */
    public ColaDePrioridad() {
        this.monticulo = new ArrayList<Integer>();
    }

    /**
     * Retorna el montículo utilizado para implementar la cola de prioridad.
     * 
     * @return el montículo utilizado en la cola de prioridad.
     */
    public ArrayList<Integer> getMonticulo() {
        return monticulo;
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return true si la cola de prioridad está vacía, false en caso contrario.
     */
    public boolean empty() {
        return this.monticulo.isEmpty();
    }

    /**
     * Obtiene el número de elementos en la cola de prioridad.
     * 
     * @return el tamaño de la cola de prioridad.
     */
    public int tamano() {
        return this.monticulo.size();
    }

    /**
     * Inserta un elemento en la cola de prioridad con su respectiva prioridad.
     * Después de agregar el elemento, se realiza un ajuste hacia arriba (sift-up)
     * para mantener la propiedad del montículo mínimo.
     * 
     * @param elemento el elemento a insertar en la cola de prioridad.
     */
    public void enqueue(Integer elemento) {
        this.monticulo.add(elemento);
        heapUp(this.monticulo.size() - 1);
    }

    /**
     * Elimina y retorna el elemento con la menor prioridad en la cola de prioridad
     * (raíz del montículo).
     * Después de extraer el elemento, se realiza un ajuste hacia abajo (sift-down)
     * para mantener la propiedad del montículo mínimo.
     * 
     * @return el elemento con la menor prioridad en la cola de prioridad, -1 en
     *         caso de que este vacía.
     */
    public Integer dequeue() {
        if (empty()) {
            System.out.println("La fila está vacía!");
            return -1;
        }

        Integer valorMinimo = this.monticulo.get(0);
        int ultimoIndice = this.monticulo.size() - 1;
        monticulo.set(0, monticulo.get(ultimoIndice));
        monticulo.remove(ultimoIndice);
        heapifyMin(0);

        return valorMinimo;
    }

    /**
     * Calcula el índice del nodo padre de un nodo dado en el montículo.
     * 
     * @param i Índice del nodo para el cual se quiere calcular el índice del padre.
     * @return Índice del nodo padre del nodo en la posición 'i'.
     */
    private int padre(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo dado en el montículo.
     * 
     * @param i Índice del nodo para el cual se quiere calcular el índice del hijo
     *          derecho.
     * @return Índice del hijo derecho del nodo en la posición 'i'.
     */
    private int indiceHijoDer(int i) {
        return 2 * i + 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un nodo dado en el montículo.
     * 
     * @param i Índice del nodo para el cual se quiere calcular el índice del hijo
     *          izquierdo.
     * @return Índice del hijo izquierdo del nodo en la posición 'i'.
     */
    private int indiceHijoIzq(int i) {
        return 2 * i + 1;
    }

    /**
     * Realiza un ajuste hacia arriba (sift-up) en el montículo para mantener la
     * propiedad del montículo mínimo
     * después de insertar un nuevo elemento en el montículo.
     * 
     * @param i el índice del elemento que se insertó recientemente en el montículo.
     */
    private void heapUp(int i) {
        while (i > 0 && monticulo.get(i).compareTo(monticulo.get(padre(i))) < 0) {
            intercambiar(i, padre(i));
            i = padre(i);
        }
    }

    /**
     * Realiza un ajuste hacia abajo (sift-down) en el montículo para mantener la
     * propiedad del montículo mínimo
     * después de extraer un elemento del montículo.
     * 
     * @param i el índice del elemento que se extrajo recientemente del montículo.
     */
    private void heapifyMin(int i) {
        int indiceHijoMenor = i;

        if (indiceHijoIzq(i) < monticulo.size()
                && monticulo.get(indiceHijoIzq(i)).compareTo(monticulo.get(indiceHijoMenor)) < 0) {
            indiceHijoMenor = indiceHijoIzq(i);
        }

        if (indiceHijoDer(i) < monticulo.size()
                && monticulo.get(indiceHijoDer(i)).compareTo(monticulo.get(indiceHijoMenor)) < 0) {
            indiceHijoMenor = indiceHijoDer(i);
        }

        if (indiceHijoMenor != i) {
            intercambiar(i, indiceHijoMenor);
            heapifyMin(indiceHijoMenor);
        }
    }

    /**
     * Intercambia dos elementos en el montículo dado sus índices.
     * 
     * @param i el índice del primer elemento.
     * @param j el índice del segundo elemento.
     */
    private void intercambiar(int i, int j) {
        Integer aux = monticulo.get(i);
        monticulo.set(i, monticulo.get(j));
        monticulo.set(j, aux);
    }
}