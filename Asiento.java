public class Asiento {
    private int numero;

    public Asiento(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Asiento " + numero;
    }
}