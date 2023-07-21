/**
 * La clase "Controlador" se encarga de gestionar la interacción con el usuario
 * y controlar las operaciones del banco.
 * Permite mostrar un menú al usuario, realizar acciones en base a las opciones
 * seleccionadas y gestionar la interacción con la clase "BancoFinal".
 */
public class Controlador {
    private Menu menu;
    private Banco bancolombia;

    /**
     * Constructor de la clase "Controlador" que inicializa el menú y la instancia
     * del banco.
     */
    public Controlador() {
        this.menu = new Menu();
        this.bancolombia = new Banco();
    }

    /**
     * Método principal que controla la ejecución del programa.
     * Muestra el menú al usuario, realiza acciones en base a las opciones
     * seleccionadas y muestra información relevante.
     * Se ejecuta en un bucle hasta que el usuario selecciona la opción para salir
     * del programa.
     * 
     * @throws Exception si ocurre algún error durante la entrada de datos.
     */
    public void Main() throws Exception {
        int opcionElegida = 0;

        do {
            this.menu.mostrarMenu();
            opcionElegida = this.menu.getOpcion();

            switch (opcionElegida) {
                case 1:
                    System.out.println("\nHa seleccionado: Asignar turno Normal");
                    bancolombia.asignarTurnoNormal();
                    mostrarTurnoAjuste();
                    bancolombia.mostrarFilaBanco();
                    break;
                case 2:
                    System.out.println("\nHa seleccionado: Asignar turno Prioritario");
                    bancolombia.asignarTurnoPrioritario();
                    mostrarTurnoAjuste();
                    bancolombia.mostrarFilaBanco();
                    break;
                case 3:
                    System.out.println("\nHa seleccionado: Atender cliente");
                    System.out.println("El cliente atendido fue: " + bancolombia.atenderCliente());
                    mostrarTurnoAjuste();
                    bancolombia.mostrarFilaBanco();
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, intente de nuevo.");
            }
        } while (opcionElegida != 4);

        System.out.println("Me salí");
    }

    /**
     * Muestra el turno actual y el valor de ajuste del banco en pantalla.
     */
    private void mostrarTurnoAjuste() {
        System.out.println("Turno: " + this.bancolombia.getTurno());
        System.out.println("Ajuste: " + this.bancolombia.getAjuste());
    }
}
