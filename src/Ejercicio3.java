public class Ejercicio3 {
    public static void main(String[] args) {
        ContadorCompartidoEjercicio3 contadorCompartido = new ContadorCompartidoEjercicio3();

        Thread hilo1 = new IncrementadorEjercicio3(contadorCompartido);
        Thread hilo2 = new IncrementadorEjercicio3(contadorCompartido);
        Thread hilo3 = new IncrementadorEjercicio3(contadorCompartido);
        Thread hilo4 = new IncrementadorEjercicio3(contadorCompartido);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El valor final del contador es: " + contadorCompartido.obtenerContador());
    }
}