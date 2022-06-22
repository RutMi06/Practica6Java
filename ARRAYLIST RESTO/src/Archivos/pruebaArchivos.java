package Archivos;

import java.io.*;
import java.util.ArrayList;

public class pruebaArchivos {

    private ArrayList<String> contenidoArchivo = new ArrayList<>();
    private ArrayList<Resto> listaEntrada = new ArrayList<>();
    private final String rutaWindows = "C:\\Cursos\\FundamentosJava\\ARRAYLIST RESTO\\LISTASDELACLASERESTO.txt";
    private final String rutaLinux = "/Volumes/KINGSTON/PRACTICA 6 JAVA/ARRAYLIST RESTO/LISTASDELACLASERESTO.txt";
    public ArrayList<String> getContenidoArchivo () {
        return contenidoArchivo;
    }

    public ArrayList <Resto> getListaEntrada() {
        return listaEntrada;
    }
    public void leerArchivo(){
        LeerArchivo leer = new LeerArchivo();
        this.contenidoArchivo = leer.leerArchivo(rutaWindows);
        for (int i=0; i < this.contenidoArchivo.size();i++){
            String linea = this.contenidoArchivo.get(i);
            String elementosLinea[] = linea.split("#");
            try {
                int numero1 = Integer.parseInt(elementosLinea[0]);
                int numero2 = Integer.parseInt(elementosLinea[1]);
                int numero3 = Integer.parseInt(elementosLinea[2]);
                listaEntrada.add(new Resto(numero1, numero2, numero3));
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                listaEntrada.add(new Resto(0, 0, 0));
            }
        }
    }
    public void escribirArchivo(ArrayList<Resto> lista){
        String archivo = "resultados.csv";
        File f = new File(archivo);
        //Escritura
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("");
            wr.append("numero1, numero2, numero3\n");
            for (int i=0; i < lista.size(); i++){
                wr.append(lista.get(i).getNumero1() +
                        "," + lista.get(i).getNumero2() +
                        "," + lista.get(i).getNumero3() +
                        "," + lista.get(i).isSonIguales() + "\n");
            }
            wr.close();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main (String args[]){
        pruebaArchivos prueba = new pruebaArchivos();
        prueba.leerArchivo();
        for (int i=0; i < prueba.getListaEntrada().size(); i++){
            System.out.println(prueba.getListaEntrada().get(i).getNumero1() +
                    "\t" + prueba.getListaEntrada().get(i).getNumero2() +
                    "\t" + prueba.getListaEntrada().get(i).getNumero3() +
                    "\t" + prueba.getListaEntrada().get(i).isSonIguales());

        }
        prueba.escribirArchivo(prueba.getListaEntrada());

    }
}



