
public class BancoFinal {
    private int turno;
    private int ajuste;
    private int turnoPrioritario;
    private ColaDePrioridad filaBanco;

    public BancoFinal() {
        this.turno = 0;
        this.ajuste = 0;
        this.turnoPrioritario = 0;
        this.filaBanco = new ColaDePrioridad();
    }

    public void asignarTurnoNormal() {
        this.filaBanco.enqueue(this.turno);
        this.turno++;
        if (this.ajuste < 5) {
            this.ajuste++;
        }
    }

    public void asignarTurnoPrioritario() {
        this.turnoPrioritario = this.turno - this.ajuste;
        this.filaBanco.enqueue(this.turnoPrioritario);
        this.turno++;
        if (this.ajuste > 0) {
            this.ajuste--;
        }
    }

    public int atenderCliente() {
        return this.filaBanco.dequeue();
    }

    public int getTurno() {
        return turno;
    }

    public int getAjuste() {
        return ajuste;
    }

    public ColaDePrioridad getFilaBanco() {
        return filaBanco;
    }
}
