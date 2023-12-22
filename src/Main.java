import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static Tamagotchi tamagotchi;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        tamagotchi = new Tamagotchi();
        AtomicBoolean salir = new AtomicBoolean(false);
        String accion = null;
        var acciones = crearAccionesMenu();

        do {
            mostrarMenu();
            System.out.println("Hambre: " + tamagotchi.getHambre());
            System.out.print("Introduce una opcion:");

            accion = sc.next();

            if (acciones.containsKey(accion)) {
                acciones.get(accion).run();
            } else {
                System.out.println("Opcion Incorrecta");
            }
            tamagotchi.avanzarTiempo();
            limpiarCMD();
        } while (!accion.equals("0"));
    }

    private static Map<String, Runnable> crearAccionesMenu(){
        var acciones = new HashMap<String, Runnable>();
        acciones.put("0", () -> System.out.println("Saliendo..."));
        acciones.put("1", tamagotchi::alimentar);
        acciones.put("2", tamagotchi::bailar);
        return acciones;
    }

    public static void limpiarCMD(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J"); // Alternativa para algunos sistemas UNIX
            System.out.flush();
        }
    }

    private static void mostrarMenu(){
        System.out.println("1. Alimentar");
        System.out.println("2. Bailar");
        System.out.println("0. Salir");
    }
}