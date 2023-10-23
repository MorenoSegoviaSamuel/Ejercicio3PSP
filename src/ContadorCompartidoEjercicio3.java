public class ContadorCompartidoEjercicio3 {
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public int obtenerContador() {
        return contador;
    }
}
