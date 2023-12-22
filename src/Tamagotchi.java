public class Tamagotchi {

    private int hambre;

    public Tamagotchi() {
        this.hambre = (int) (1 + Math.random() * 2);
    }

    public int getHambre() {
        return hambre;
    }

    public void alimentar() {
        this.hambre = -1;
    }

    public void avanzarTiempo() {
        hambre++;
        if (hambre == 3) {
            System.out.println("El tamagochi se ha muerto! :(");
            System.exit(0);
        }
    }

    public void bailar() {
        String tamagotchiDibujo =
                        "  ^_^\n" +
                        " /   \\\n" +
                        "|     |\n" +
                        " \\___/";
        String tamagotchiDibujo2 =
                        "  O_O\n" +
                        " /   \\\n" +
                        "|     |\n" +
                        " \\___/";

        int contador = 4;
        while (contador > 0){
            if(contador%2 == 0){
                System.out.println(tamagotchiDibujo);
            }else{
                System.out.println(tamagotchiDibujo2);
            }

            Main.limpiarCMD();

            contador--;

            try {
                Thread.sleep(500); // Pausa de medio segundo entre cada parpadeo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
