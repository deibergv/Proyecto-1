package GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 * Constructor de la tabla
 *
 * @author deiber
 */
public class Tabla { ///////////////Parametros base de Tabla////////////////////

    private final SimpleStringProperty carne;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty carrera;

    public Tabla(String carne, String nombre, String carrera) {
        super();
        this.carne = new SimpleStringProperty(carne);
        this.nombre = new SimpleStringProperty(nombre);
        this.carrera = new SimpleStringProperty(carrera);
    }

    public String getCarne() {
        return carne.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getCarrera() {
        return carrera.get();
    }
}
