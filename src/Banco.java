/**
 * La clase "BancoFinal" representa un banco que maneja la asignación de turnos
 * para atender a los clientes.
 * Permite asignar turnos normales y prioritarios, atender clientes y mostrar la
 * fila de clientes del banco.
 */
public class Banco {
    private int turno;
    private int ajuste;
    private int turnoPrioritario;
    private ColaDePrioridad filaBanco;

    /**
     * Constructor de la clase "BancoFinal" que inicializa las variables de control
     * y crea una cola de prioridad vacía para la fila del banco.
     */
    public Banco() {
        this.turno = 0;
        this.ajuste = 0;
        this.turnoPrioritario = 0;
        this.filaBanco = new ColaDePrioridad();
    }

    /**
     * Asigna un turno normal a un cliente y lo agrega a la fila del banco.
     * Incrementa el contador de turnos y ajusta el valor de ajuste si es necesario.
     */
    public void asignarTurnoNormal() {
        this.filaBanco.enqueue(this.turno);
        this.turno++;
        if (this.ajuste < 5) {
            this.ajuste++;
        }
    }

    /**
     * Asigna un turno prioritario a un cliente y lo agrega a la fila del banco.
     * El turno prioritario se calcula restando el valor de ajuste al contador de
     * turnos actual.
     * Incrementa el contador de turnos y ajusta el valor de ajuste si es necesario.
     */
    public void asignarTurnoPrioritario() {
        this.turnoPrioritario = this.turno - this.ajuste;
        this.filaBanco.enqueue(this.turnoPrioritario);
        this.turno++;
        if (this.ajuste > 0) {
            this.ajuste--;
        }
    }

    /**
     * Atiende al cliente con la menor prioridad en la fila del banco (el que tenga
     * el turno más bajo) y lo remueve de la fila.
     * 
     * @return el turno del cliente atendido.
     * @throws NoSuchElementException si la fila del banco está vacía.
     */
    public int atenderCliente() {
        return this.filaBanco.dequeue();
    }

    /**
     * Retorna el número de turno actual.
     * 
     * @return el número de turno actual.
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Retorna el valor actual del ajuste.
     * 
     * @return el valor actual del ajuste.
     */
    public int getAjuste() {
        return ajuste;
    }

    /**
     * Retorna la cola de prioridad que representa la fila del banco.
     * 
     * @return la cola de prioridad utilizada para almacenar la fila del banco.
     */
    public ColaDePrioridad getFilaBanco() {
        return filaBanco;
    }

    /**
     * Muestra los elementos de la fila del banco en el orden en que serían
     * atendidos (de menor a mayor prioridad).
     */
    public void mostrarFilaBanco() {
        System.out.println(this.filaBanco.getMonticulo());
    }
}
