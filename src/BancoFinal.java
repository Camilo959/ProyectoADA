
public class BancoFinal {

    private int turno;
    private int ajuste;
    private int nroFila;
    private int turnoPrioritario;
    private ColaDePrioridad filaBanco;

    public BancoFinal() {
        this.turno = 0;
        this.ajuste = 0;
        this.nroFila = 0;
        this.turnoPrioritario = 0;
        this.filaBanco = new ColaDePrioridad();
    }

    public void asignarTurnoNormal() {
        this.turno++;
        this.nroFila++;
        if (this.ajuste < 5) {
            this.ajuste++;
        }
        this.filaBanco.enqueue(this.nroFila); //
    }

    public void asignarTurnoPrioritario() {
        this.turnoPrioritario = this.turno - this.ajuste;
        this.turno++;
        if (this.ajuste > 0) {
            this.ajuste--;
        }
        this.filaBanco.enqueue(this.turnoPrioritario);
    }

    public int atenderCliente() {
        this.ajuste--;
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

    public static void main(String[] args) {
        BancoFinal davivienda = new BancoFinal();

        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoPrioritario();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoNormal();
        davivienda.asignarTurnoPrioritario();

        System.out.println("El cliente atendido fue: " + davivienda.atenderCliente());
        System.out.println("El cliente atendido fue: " + davivienda.atenderCliente());
        System.out.println("El cliente atendido fue: " + davivienda.atenderCliente());
        System.out.println("El cliente atendido fue: " + davivienda.atenderCliente());
        System.out.println("El cliente atendido fue: " + davivienda.atenderCliente());
    }

}
