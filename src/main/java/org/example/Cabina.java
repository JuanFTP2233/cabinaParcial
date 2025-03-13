package org.example;

public class Cabina {
    private Double llamadaLocal = 50.0;
    private Double llamadaLargaDistancia = 350.0;
    private Double llamadaCelu = 150.0;
    private int minutos;
    private String numeroCabina;
    private int llamadasLocales;
    private int llamadasLargaDistancia;
    private int llamadasCelu;

    public Cabina() {}

    public Cabina(String numeroCabina) {
        this.numeroCabina = numeroCabina;
    }

    public Double getLlamadaLocal() {
        return llamadaLocal;
    }

    public void setLlamadaLocal(Double llamadaLocal) {
        this.llamadaLocal = llamadaLocal;
    }

    public Double getLlamadaLargaDistancia() {
        return llamadaLargaDistancia;
    }

    public void setLlamadaLargaDistancia(Double llamadaLargaDistancia) {
        this.llamadaLargaDistancia = llamadaLargaDistancia;
    }

    public Double getLlamadaCelu() {
        return llamadaCelu;
    }

    public void setLlamadaCelu(Double llamadaCelu) {
        this.llamadaCelu = llamadaCelu;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getNumeroCabina() {
        return numeroCabina;
    }

    public void setNumeroCabina(String numeroCabina) {
        this.numeroCabina = numeroCabina;
    }

    public int getLlamadasLocales() {
        return llamadasLocales;
    }

    public int getLlamadasLargaDistancia() {
        return llamadasLargaDistancia;
    }

    public int getLlamadasCelu() {
        return llamadasCelu;
    }

    public void registrarLlamadaLocal(int minutos) {
        this.minutos += minutos;
        this.llamadasLocales++;
    }

    public void registrarLlamadaLargaDistancia(int minutos) {
        this.minutos += minutos;
        this.llamadasLargaDistancia++;
    }

    public void registrarLlamadaCelu(int minutos) {
        this.minutos += minutos;
        this.llamadasCelu++;
    }

    public double calcularCostoTotal() {
        return (llamadasLocales * llamadaLocal * minutos) +
                (llamadasLargaDistancia * llamadaLargaDistancia * minutos) +
                (llamadasCelu * llamadaCelu * minutos);
    }

    public void reiniciarCabina() {
        this.minutos = 0;
        this.llamadasLocales = 0;
        this.llamadasLargaDistancia = 0;
        this.llamadasCelu = 0;
    }

    @Override
    public String toString() {
        return "Cabina{" +
                "numeroCabina='" + numeroCabina + '\'' +
                ", llamadasLocales=" + llamadasLocales +
                ", llamadasLargaDistancia=" + llamadasLargaDistancia +
                ", llamadasCelu=" + llamadasCelu +
                ", minutos=" + minutos +
                ", costoTotal=" + calcularCostoTotal() +
                '}';
    }
}