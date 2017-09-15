package Json;

import javax.swing.JOptionPane;

public class Metadata {

    private String StoreName;
    private String Atributo;
    private String Valor;
    private String Nombre;
    private String Requerido;
    private String Defecto;

    public Metadata(String atributo, String valor, String nombre, String defecto, String requerido, String store) {
        this.StoreName = store;
        this.Atributo = atributo;
        this.Valor = valor;
        this.Nombre = nombre;
        this.Defecto = defecto;
        this.Requerido = requerido;
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

    private String Validacion() {
        try {
            switch (getAtributo()) {
                case "int":
                    Integer.parseInt(getValor());
                    break;

                case "float":
                    Float.parseFloat(getValor());
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema con la validacion", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return getValor();
    }
    public static Metadata StringToStore(String valor) {
        //String = nombre-valor-atributo-defecto-requiered-storename
        String[] array = valor.split("-", 0);
        return new Metadata(array[0], array[1], array[2], array[3], array[4], array[5]);
    }}
//    public static Metadata StoreToString(String valor) {
//        String
//        
//    }
//}
