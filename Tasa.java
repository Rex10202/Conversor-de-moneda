public class Tasa {
    private String monedaBase;
    private String monedaDestino;
    private double cantidad;
    private double montoConvertido;
    private double tasaCambio;

    public Tasa(String monedaBase, String monedaDestino, double cantidad, double montoConvertido, double tasaCambio) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.montoConvertido = montoConvertido;
        this.tasaCambio = tasaCambio;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

}
