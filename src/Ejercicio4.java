import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio4 {
    public static void main(String[] args) {
        Buffer compartido = new Buffer();

        Thread productorThread = new Thread(new Productor(compartido));
        Thread consumidorThread = new Thread(new Consumidor(compartido));

        productorThread.start();
        consumidorThread.start();
    }
}

class Buffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacidad = 5;

    public synchronized void producir(int elemento) {
        while (buffer.size() == capacidad) {
            try {
                wait(); // Espera si el buffer está lleno
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(elemento);
        System.out.println("Producido: " + elemento);
        notify(); // Notifica al consumidor que hay elementos para consumir
    }

    public synchronized int consumir() {
        while (buffer.isEmpty()) {
            try {
                wait(); // Espera si el buffer está vacío
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int elemento = buffer.poll();
        System.out.println("Consumido: " + elemento);
        notify(); // Notifica al productor que se ha consumido un elemento
        return elemento;
    }
}

class Productor implements Runnable {
    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.producir(i);
        }
    }
}

class Consumidor implements Runnable {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int elemento = buffer.consumir();
        }
    }
}

