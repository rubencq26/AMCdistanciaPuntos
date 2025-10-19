package TSPFicheros;


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
    }

    public void generarFichero(String NAME, String COMMENT, int DIMENSION) throws IOException {
        String path = "src/data/" + NAME + ".tsp";
        try(FileWriter writer = new FileWriter(path)){
            writer.write("NAME: " + NAME + "\n");
            writer.write("TYPE: TSP\n");
            writer.write("COMMENT: " + COMMENT + "\n");
            writer.write("DIMENSION: " + DIMENSION + "\n");
            writer.write("EDGE_WEIGHT_TYPE: EUC_2D\n");
            writer.write("NODE_COORD_SECTION\n");
            this.nodos = new ArrayList<>();
            Random random = new Random(System.nanoTime());
            for (int i = 0; i < DIMENSION; i++) {
                double x = 800* random.nextDouble();
                x = Math.round(x * Math.pow(10,10)) / Math.pow(10,10);
                double y = random.nextDouble() * 600;
                y = Math.round(y * Math.pow(10,10)) / Math.pow(10,10);
                this.nodos.add(new Punto(x, y, i));
                writer.write((i + 1)+ " " + x + " " + y + "\n");
            }
            writer.write("EOF");
            this.NAME = NAME + ".tsp";
            this.DIMENSION = DIMENSION;
            this.COMMENT = COMMENT;
            this.TYPE = "TSP";
            this.EDGE_WEIGHT_TYPE = "EUC_2D";
            this.vacio = false;
            System.out.println("Fichero generado correctamente");
        }catch (IOException e){
            System.out.println("Ocurrio un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void generarDataset(int DIMENSION){
        this.nodos = new ArrayList<>();
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < DIMENSION; i++) {
            double x = 800* random.nextDouble();
            x = Math.round(x * Math.pow(10,10)) / Math.pow(10,10);
            double y = random.nextDouble() * 600;
            y = Math.round(y * Math.pow(10,10)) / Math.pow(10,10);
            this.nodos.add(new Punto(x, y, i));
        }
        System.out.println("Dataset generado correctamente");
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
