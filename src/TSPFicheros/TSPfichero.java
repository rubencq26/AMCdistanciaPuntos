package TSPFicheros;


import Algoritmos.Heapsort;
import Algoritmos.HeapsortY;
import Utils.Punto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Random;


public class TSPfichero implements Cloneable{
    private String NAME;
    private String TYPE;
    private String COMMENT;
    private int DIMENSION;
    private String EDGE_WEIGHT_TYPE;
    private List<Punto> nodos;
    private boolean vacio;
    private double maxX;
    private double maxY;

    /**
     * Constructor de la clase, inicializa los nodos
     */
    public TSPfichero() {
        nodos = new ArrayList<>();
        vacio = true;
    }

    /**
     * Funcion para leer ficheros TSP
     *
     * @param path
     * @throws IOException
     */
    public void leerFichero(String path) throws IOException {
        NAME = path;
        path = "src/data/" + path;
        
        this.nodos = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(path));
        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.startsWith("TYPE")) {
                this.TYPE = linea.split(":")[1].trim();
            } //else if (linea.startsWith("COMMENT")) {
                //this.COMMENT = linea.split(":")[1].trim();
             else if (linea.startsWith("DIMENSION")) {
                this.DIMENSION = Integer.parseInt(linea.split(":")[1].trim());
            } else if (linea.startsWith("EDGE_WEIGHT_TYPE")) {
                this.EDGE_WEIGHT_TYPE = linea.split(":")[1].trim();
            } else if (linea.startsWith("NODE_COORD_SECTION")) {
                leerNodos(br);
            }
        }
        encuentraMaxX();
        encuentraMaxY();
        
        this.vacio = false;
    }

    /**
     * Funcion privada para leer los nodos del fichero TSP
     * @param reader
     * @throws IOException
     */
    private void leerNodos(BufferedReader reader) throws IOException {
        for (int i = 0; i < DIMENSION; i++) {
            String linea = reader.readLine().trim();
            String[] partes = linea.split("\\s+");
            // \\s+ divide la cadena cuando encuentra bloques de uno o mas espacios
            if (partes.length >= 3) {
                //int id = Integer.parseInt(partes[0]);
                double x = Double.parseDouble(partes[1]);
                double y = Double.parseDouble(partes[2]);
                this.nodos.add(new Punto(x, y, i));
            }
        }
        encuentraMaxX();
        encuentraMaxY();
    }

    public void generarFichero(String NAME, int DIMENSION) throws IOException {
        String path = "src/data/" + NAME + ".tsp";
        try(FileWriter writer = new FileWriter(path)){
            writer.write("NAME: " + NAME + "\n");
            writer.write("TYPE: TSP\n");
            writer.write("COMMENT: " + "Comentario" + "\n");
            writer.write("DIMENSION: " + DIMENSION + "\n");
            writer.write("EDGE_WEIGHT_TYPE: EUC_2D\n");
            writer.write("NODE_COORD_SECTION\n");
            this.nodos = new ArrayList<>();
            Random random = new Random(System.nanoTime());
            for (int i = 0; i < DIMENSION; i++) {
                double x = 450* random.nextDouble();
                x = Math.round(x * Math.pow(10,10)) / Math.pow(10,10);
                double y = random.nextDouble() * 450;
                y = Math.round(y * Math.pow(10,10)) / Math.pow(10,10);
                this.nodos.add(new Punto(x, y, i));
                writer.write((i + 1)+ " " + x + " " + y + "\n");
            }
            writer.write("EOF");
            this.NAME = NAME + ".tsp";
            this.DIMENSION = DIMENSION;
            this.COMMENT = "Comentario";
            this.TYPE = "TSP";
            this.EDGE_WEIGHT_TYPE = "EUC_2D";
            this.vacio = false;
            System.out.println("Fichero generado correctamente");
        }catch (IOException e){
            System.out.println("Ocurrio un error al escribir en el archivo: " + e.getMessage());
        }
        maxX = 450;
        maxY = 450;
    }

    public void generarDataset(int DIMENSION){
        this.nodos = new ArrayList<>();
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < DIMENSION; i++) {
            double x = 450* random.nextDouble();
            x = Math.round(x * Math.pow(10,10)) / Math.pow(10,10);
            double y = random.nextDouble() * 450;
            y = Math.round(y * Math.pow(10,10)) / Math.pow(10,10);
            this.nodos.add(new Punto(x, y, i));
        }
        NAME = "Generado" + DIMENSION;
        this.DIMENSION = DIMENSION;
        maxX = 450;
        maxY = 450;
        vacio = false;
        System.out.println("Dataset generado correctamente");
    }
    
    private void encuentraMaxX(){
        List<Punto> sorted = new ArrayList<>();
        for(Punto p : this.nodos){
            sorted.add(new Punto(p.getX(), p.getY(), p.getId()));
        }
        Heapsort heap = new Heapsort(sorted);
        sorted = heap.heapsort();
        this.maxX = sorted.get(sorted.size() - 1).getX();
    }
    
     private void encuentraMaxY(){
        List<Punto> sorted = new ArrayList<>();
        for(Punto p : this.nodos){
            sorted.add(new Punto(p.getX(), p.getY(), p.getId()));
        }
        HeapsortY heap = new HeapsortY(sorted);
        sorted = heap.heapsort();
        this.maxY = sorted.get(sorted.size() - 1).getX();
    }

    /**
     * Gettter del NAME
     * @return
     */
    public String getNAME() {return NAME;}

    /**
     * Getter de TYPE
     * @return
     */
    public String getTYPE() {return TYPE;}

    /**
     * Getter de COMMENT
     * @return
     */
    public String getCOMMENT() {return COMMENT;}

    /**
     * Getter de DIMENSION
     * @return
     */
    public int getDIMENSION() {return DIMENSION;}

    /**
     * Getter de EDGE_WEIGHT_TYPE
     * @return
     */
    public String getEDGE_WEIGHT_TYPE() {return EDGE_WEIGHT_TYPE;}

    public List<Punto> getNodos() {return nodos;}

    public Punto getNodo(int i) throws IndexOutOfBoundsException {
        if (DIMENSION >= i) {
            return nodos.get(i);
        }else{
            throw new IndexOutOfBoundsException("El indice no esta dentro del rango");
        }
    }
    
    public double getMaxX(){
        return maxX;
    }
    
    public double getMaxY(){
        return maxY;
    }
    
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        TSPfichero copia = (TSPfichero) super.clone();
        copia.nodos = new ArrayList<Punto>(this.nodos);
        return copia;
    }
    
    public boolean getVacio(){
        return vacio;
    }
}
