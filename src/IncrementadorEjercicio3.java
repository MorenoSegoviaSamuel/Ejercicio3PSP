public class IncrementadorEjercicio3 extends Thread {
    private ContadorCompartidoEjercicio3 contadorCompartido;

    public IncrementadorEjercicio3(ContadorCompartidoEjercicio3 contadorCompartido) {
        this.contadorCompartido = contadorCompartido;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            contadorCompartido.incrementar();
        }
    }
}
