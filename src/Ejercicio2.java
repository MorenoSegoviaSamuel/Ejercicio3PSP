import java.util.Random;

class Animal extends Thread {
    private String nombre;
    private int velocidad;
    private int distanciaRecorrida = 0;
    private int retrocesoProbabilidad;

    public Animal(String nombre, int velocidad, int retrocesoProbabilidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.retrocesoProbabilidad = retrocesoProbabilidad;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(100); // Simula el tiempo que le toma a cada animal dar una pasada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (retrocede()) {
                retroceder();
            } else {
                avanzar();
            }

            if (distanciaRecorrida >= 1000) {
                System.out.println(nombre + " ha ganado la carrera!");
                break;
            }
        }
    }

    private boolean retrocede() {
        return new Random().nextInt(100) < retrocesoProbabilidad;
    }

    private void avanzar() {
        distanciaRecorrida += velocidad;
        System.out.println(nombre + " ha avanzado a " + distanciaRecorrida + " metros.");
    }

    private void retroceder() {
        distanciaRecorrida -= velocidad;
        if (distanciaRecorrida < 0) {
            distanciaRecorrida = 0;
        }
        System.out.println(nombre + " ha retrocedido a " + distanciaRecorrida + " metros.");
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Animal tortuga = new Animal("Tortuga", 10, 20);
        Animal liebre = new Animal("Liebre", 50, 10);
        Animal caballo = new Animal("Caballo", 30, 15);
        Animal perro = new Animal("Perro", 40, 5);

        tortuga.start();
        liebre.start();
        caballo.start();
        perro.start();
    }
}
