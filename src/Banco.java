import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Banco {

    private int turnos;
    private int ajuste;
    private int turnosprioritarios;
    private Queue<Integer> colaBanco;
    private Queue<Integer> segundaCola;

    public Queue<Integer> getSegundaCola() {
        return segundaCola;
    }

    public Banco() {
        this.turnos = 0;
        this.ajuste = 0;
        this.turnosprioritarios = 0;
        this.colaBanco = new LinkedList<Integer>();
        this.segundaCola = new LinkedList<Integer>();
    }

    public void asignarTurnoNormal() {
        this.turnos++;
        if (this.ajuste < 5) {
            this.ajuste++;
        }
        this.colaBanco.offer(this.turnos);
    }

    public void asignarTurnoPrioritario() {
        this.turnosprioritarios = this.turnos - this.ajuste;
        this.turnos++;
        if (this.ajuste > 0) {
            this.ajuste--;
        }
        this.colaBanco.offer(this.turnosprioritarios);

    }

    //
    public void atenderCliente() {

        this.segundaCola = insertionSort();
        System.out.println(this.segundaCola);
        System.out.println("Turno atendido: " + segundaCola.poll());
        this.colaBanco = this.segundaCola;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public int getAjuste() {
        return ajuste;
    }

    public void setAjuste(int ajuste) {
        this.ajuste = ajuste;
    }

    public int getTurnosprioritarios() {
        return turnosprioritarios;
    }

    public void setTurnosprioritarios(int turnosprioritarios) {
        this.turnosprioritarios = turnosprioritarios;
    }

    public Queue<Integer> getColaBanco() {
        return colaBanco;
    }

    public Integer[] queueToArray(Queue<Integer> queue) {
        Integer[] array = new Integer[queue.size()];
        queue.toArray(array);
        return array;
    }

    public Queue<Integer> insertionSort() {

        Integer[] arr = queueToArray(this.colaBanco);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        
        Queue<Integer> nueva = arrayToQueue(arr);

        return nueva;

    }

    public Queue<Integer> arrayToQueue(Integer[] array) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer element : array) {
            queue.offer(element);
        }
        return queue;
    }

}
