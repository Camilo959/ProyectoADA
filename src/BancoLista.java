import java.util.Queue;
import java.util.PriorityQueue;

public class BancoLista {

    private int turno;
    private int ajuste;
    private int turnoPrioritario;
    private int nroFila;
    private Queue<Integer> filaBanco;

    public Queue<Integer> getFilaBanco() {
        return filaBanco;
    }

    public BancoLista() {
        this.turno = 0;
        this.ajuste = 0;
        this.turnoPrioritario = 0;
        this.nroFila = 0;
        this.filaBanco = new PriorityQueue<Integer>();
    }

    public void asignarTurnoNormal() {
        this.turno++;
        this.nroFila++;
        if (this.ajuste < 5) {
            this.ajuste++;
        }
        this.filaBanco.offer(this.nroFila); //
    }

    public void asignarTurnoPrioritario() {
        this.turnoPrioritario = this.turno - this.ajuste;
        this.turno++;
        if (this.ajuste > 0) {
            this.ajuste--;
        }
        this.filaBanco.offer(this.turnoPrioritario);
    }

    public int atenderCliente() {
        return this.filaBanco.poll();
    }

    public static void main(String[] args) {
        BancoLista bancolombia = new BancoLista();

        bancolombia.asignarTurnoNormal();
        bancolombia.asignarTurnoNormal();
        bancolombia.asignarTurnoNormal();
        bancolombia.asignarTurnoNormal();
        bancolombia.asignarTurnoNormal();
        bancolombia.asignarTurnoNormal();
        bancolombia.asignarTurnoPrioritario();

        System.out.println("Saco el: " + bancolombia.atenderCliente());
        System.out.println("Saco el: " + bancolombia.atenderCliente());

        bancolombia.asignarTurnoNormal();

        bancolombia.asignarTurnoPrioritario();

        System.out.println("Saco el: " + bancolombia.atenderCliente());
        System.out.println("Saco el: " + bancolombia.atenderCliente());
        System.out.println("Saco el: " + bancolombia.atenderCliente());
        System.out.println("Saco el: " + bancolombia.atenderCliente());
        System.out.println("Saco el: " + bancolombia.atenderCliente());

        System.out.println(bancolombia.getFilaBanco());

    }
}
