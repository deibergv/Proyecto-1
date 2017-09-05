
package interfaz;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tabla { ///////////////Parametros base de Tabla////////////////////
    private final SimpleIntegerProperty carne;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty carrera;
    public Tabla(Integer carne, String nombre, String carrera) {
        super();
        this.carne = new SimpleIntegerProperty(carne);
        this.nombre = new SimpleStringProperty(nombre);
        this.carrera = new SimpleStringProperty(carrera);
    }
    public Integer getCarne() {
        return carne.get();
    }
    public String getNombre() {
        return nombre.get();
    }
    public String getCarrera() {
        return carrera.get();
    }  
}
