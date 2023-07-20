public class Controlador {
    private Menu menu;
    private BancoFinal bancolombia;


    public Controlador() {
        this.menu = new Menu();
        this.bancolombia = new BancoFinal();
    }

    public void Main() throws Exception{
        int opcionElegida = 0;

        do {

            this.menu.mostrarMenu();
            opcionElegida = this.menu.getOpcion();

            switch (opcionElegida) {
                case 1:
                    System.out.println("\nHa seleccionado: Asignar turno Normal");
                    bancolombia.asignarTurnoNormal();
                    System.out.println("Turno: " + bancolombia.getTurno());
                    System.out.println("Ajuste: " + bancolombia.getAjuste());
                    System.out.println("La fila es: " + bancolombia.getFilaBanco().getMonticulo());
                    break;
                case 2:
                    System.out.println("\nHa seleccionado: Asignar turno Prioritario");
                    bancolombia.asignarTurnoPrioritario();
                    System.out.println("Turno: " + bancolombia.getTurno());
                    System.out.println("Ajuste: " + bancolombia.getAjuste());
                    System.out.println("La fila es: " + bancolombia.getFilaBanco().getMonticulo());
                    break;
                case 3:
                    System.out.println("\nHa seleccionado: Atender cliente");
                    System.out.println("El cliente atendido fue: " + bancolombia.atenderCliente());
                    System.out.println("Turno: " + bancolombia.getTurno());
                    System.out.println("Ajuste: " + bancolombia.getAjuste());
                    System.out.println("La fila es: " + bancolombia.getFilaBanco().getMonticulo());
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, intente de nuevo.");

            }

            if (opcionElegida > 4) {
                System.out.println("\nElige una opción correcta!");
            }

        } while (opcionElegida != 4);

        System.out.println("Me salí");
    }
}
