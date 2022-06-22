package Archivos;

public class Resto {
    private int evaluarOperadores;
    private boolean sonIguales;
    private int numero1;
    private int numero2;
    private int numero3;

    public Resto(int numero1, int numero2, int numero3){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
        this.evaluarOperadores();
    }

    public boolean isSonIguales() {
        return sonIguales;
    }

    public void setSonIguales(boolean sonIguales) {
        this.sonIguales = sonIguales;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1){
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero3() {
        return numero3;
    }

    public void setNumero3(int numero3) {
        this.numero3 = numero3;
    }

    public int getEvaluarOperadores() {
        return evaluarOperadores;
    }

    public void setEvaluarOperadores(int evaluarOperadores) {
        this.evaluarOperadores = evaluarOperadores;
    }

    public void evaluarOperadores(){
        if (this.numero1 % this.numero2 == this.numero3 || this.numero2 % this.numero1 == this.numero3) {
            this.sonIguales = true;
        }  else {
            this.sonIguales = false;

        }

    }
    public static void main(String[] args){
        Resto resto = new Resto(245, 100, 45);
        System.out.println(resto.isSonIguales());
    }
}



