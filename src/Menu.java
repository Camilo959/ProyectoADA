import java.util.Scanner;

/**
 * La clase "Menu" representa un menú de opciones para un sistema bancario.
 * Permite mostrar un conjunto de opciones al usuario,
 * leer la opción seleccionada por el usuario desde la entrada estándar y
 * proporcionar la opción seleccionada a través de un método.
 */
public class Menu {
    private int opcion;

    /**
     * Constructor de la clase "Menu".
     */
    public Menu() {

    }

    /**
     * Muestra el menú de opciones y espera a que el usuario ingrese una opción
     * desde la entrada estándar.
     * La opción seleccionada por el usuario se almacena en la variable "opcion".
     * Si ocurre una excepción durante la lectura de la opción, se asigna el valor 0
     * a "opcion".
     * 
     * @throws Exception si ocurre algún error durante la entrada de datos.
     */
    public void mostrarMenu() throws Exception {
        Scanner entrada = new Scanner(System.in);

        System.out.println("╔═════════════════════════╗");
        System.out.println("║          Banco          ║");
        System.out.println("╠═════════════════════════╣");
        System.out.println("║ 1. Asignar turno Normal ║");
        System.out.println("║ 2. Asignar turno Prior. ║");
        System.out.println("║ 3. Atender cliente      ║");
        System.out.println("║ 4. Salir                ║");
        System.out.println("╚═════════════════════════╝");
        System.out.print("Ingrese una opción: ");

        try {
            this.opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

        } catch (Exception e) {
            this.opcion = 0;
        }
    }

    /**
     * Retorna la opción seleccionada por el usuario en el menú.
     * 
     * @return la opción seleccionada por el usuario.
     */
    public int getOpcion() {
        return opcion;
    }
}