import java.util.concurrent.atomic.AtomicInteger;

//Si contador no se coloca como AtomicInteger el programa no compila

public class Ejercicio1 {
    public static void main(String[] args) {
        AtomicInteger contador = new AtomicInteger();

        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.getAndIncrement();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.getAndIncrement();
            }
        });

        Thread hilo3 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.getAndIncrement();
            }
        });

        Thread hilo4 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.getAndIncrement();
            }
        });

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

        System.out.println("El valor final del contador es: " + contador);
    }
}
