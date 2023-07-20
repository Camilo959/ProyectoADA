import java.util.Scanner;

public class Menu {
    private int opcion;


    public Menu() {
        
    }


    public void mostrarMenu() throws Exception{
        Scanner entrada = new Scanner(System.in);

        System.out.println("╔═════════════════════════╗");
        System.out.println("║       Bancolombia       ║");
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
            System.out.println("\nElija una opción correcta!");
        }
        // entrada.close();
    }


    public int getOpcion() {
        return opcion;
    }
}
