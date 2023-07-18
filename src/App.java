import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class App {


    public static void main(String[] args) throws Exception {

        //Menu inicio = new Menu();
        // Menú de opciones
        // inicio.mostrarMenu();
        //inicio.validarOpcion();

        Banco banquito = new Banco();

        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoNormal();
        banquito.asignarTurnoPrioritario();
        banquito.asignarTurnoPrioritario();



        banquito.atenderCliente();
        banquito.atenderCliente();
        banquito.atenderCliente();


        banquito.asignarTurnoNormal();
        System.out.println(banquito.getColaBanco());

        System.out.println("Los turno son: " + banquito.getTurnos());
        System.out.println("El ajuste es: " + banquito.getAjuste());

        //System.out.println(banquito.getSegundaCola());

        
    }
}
