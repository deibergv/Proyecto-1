package Json;

import javax.swing.JOptionPane;

/**
 * Contrucctor de la clase Metadata
 *
 * @author deiber
 */
public class Metadata {

    private String StoreName;
    private String Atributo;
    private String Valor;
    private String Nombre;
    private String Requerido;
    private String Defecto;

    /**
     * Inicializacion de parametros base
     *
     * @param store
     * @param atributo
     * @param valor
     * @param nombre
     * @param requerido
     * @param defecto
     */
    public Metadata(String store, String atributo, String valor, String nombre, String requerido, String defecto) {
        this.StoreName = store;
        this.Atributo = atributo;
        this.Valor = valor;
        this.Nombre = nombre;
        this.Requerido = requerido;
        this.Defecto = defecto;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }

    public String getAtributo() {
        return Atributo;
    }

    public void setAtributo(String Atributo) {
        this.Atributo = Atributo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRequerido() {
        return Requerido;
    }

    public void setRequerido(String Requerido) {
        this.Requerido = Requerido;
    }

    public String getDefecto() {
        return Defecto;
    }

    public void setDefecto(String Defecto) {
        this.Defecto = Defecto;
    }

    /**
     * Validacion respectiva de datos entrantes
     *
     * @return
     */
    public String ValidacionDeDatos() {
        try {
            switch (getAtributo()) {
                case "int":
                    Integer.parseInt(getValor());
                    break;
                case "float":
                    Float.parseFloat(getValor());
                    break;
            }
        } catch (RuntimeException e) {
            System.out.print("RuntimeException: ");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problema con la validacion de los Datos", "Error", JOptionPane.WARNING_MESSAGE);//////////////
        } catch (Exception e) {
            System.out.print("Exception: ");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problema con la validacion de los Datos", "Error", JOptionPane.WARNING_MESSAGE);/////////////////
        }
        return getValor();
    }

    public static Metadata StringToStore(String Dato) {
        //Orden = StoreName-atributo-valor-nombre-requerido-defecto
        String[] array = Dato.split("-", 0);
        return new Metadata(array[0], array[1], array[2], array[3], array[4], array[5]);
    }

    public static String StoreToString(Metadata Store) {
        String StoreToString = "";
        StoreToString += Store.getStoreName();
        StoreToString += ("-" + Store.getAtributo());
        StoreToString += ("-" + Store.getValor());
        StoreToString += ("-" + Store.getNombre());
        StoreToString += ("-" + Store.getRequerido());
        StoreToString += ("-" + Store.getDefecto());
        return StoreToString;
    }
//string a = "StoreName-atributo-valor-nombre-requerido-defecto";

}
