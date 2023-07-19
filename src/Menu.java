import java.util.Scanner;

public class Menu {

    private int opcion;
    private String mensaje;

    public int getOpcion() {
        return opcion;
    }


    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }


    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public Menu() {
        
    }


    public void mostrarMenu() throws Exception{
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nBienvenido a tu banco preferido!");
        System.out.println("1. Turno normal \n2. Turno prioritario \n3. Atender Cliente \n4. Salir");
        
        try {
            this.opcion = entrada.nextInt();

        } catch (Exception e) {
            System.out.println("Elija una opción correcta!");
        }
        entrada.close();
    }


    public void validarOpcion() throws Exception{
        while(this.opcion > 4) {
            mostrarMenu();
        }
    }


}
