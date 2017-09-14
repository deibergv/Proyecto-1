package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stagePrincipal;
    private AnchorPane rootPane;

    public void CreadorDeVentanas(String NombreDeVentana) {
        
        String Ventana = NombreDeVentana;
        
        if ("VentanaPrincipal".equals(NombreDeVentana)) {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaPrincipal.fxml"));
                rootPane = (AnchorPane) loader.load();
                Scene scene = new Scene(rootPane);
                stagePrincipal.setTitle("Sistema Estudiantil");
                stagePrincipal.setResizable(false);
                stagePrincipal.setScene(scene);
                ControladorVentanaPrincipal controller = loader.getController();
                controller.setProgramaPrincipal(this);
                stagePrincipal.show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Error con la Ventana");
            }
        } else if ("VentanaBusqueda".equals(NombreDeVentana)) {
            String TituloDeVentana = "Busqueda";
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource(Ventana + ".fxml"));
                AnchorPane ventanaDos = (AnchorPane) loader.load();
                Stage ventana = new Stage();
                ventana.setTitle(TituloDeVentana);
                ventana.setResizable(false);
                ventana.initModality(Modality.WINDOW_MODAL);
                ventana.initOwner(stagePrincipal);
                Scene scene = new Scene(ventanaDos);
                ventana.setScene(scene);
                ControladorVentanaBusqueda controller = loader.getController();
                controller.setStagePrincipal(ventana);
                ventana.show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Error en Ventana");
            }

        }

        /*if ("VentanaPrincipal".equals(NombreDeVentana)) {
            String Ventana = NombreDeVentana;
            String Controlador = "Controlador"+NombreDeVentana;
        } else if ("VentanaBusqueda".equals(NombreDeVentana)) {
            System.out.println("si la enconthré");
        } else if ("VentanaActualizacion".equals(NombreDeVentana)) {
            System.out.println("si la enconthré");
        } else if ("VentanaNuevoCurso".equals(NombreDeVentana)) {
            System.out.println("si la enconthré");
        } else if ("VentanaNuevoEstudiante".equals(NombreDeVentana)) {
            System.out.println("si la enconthré");
        }
        System.out.println(Ventana);
        System.out.println(Controlador);*/
    }

    public void MostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaPrincipal.fxml"));
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Sistema Estudiantil");
            stagePrincipal.setResizable(false);
            stagePrincipal.setScene(scene);
            ControladorVentanaPrincipal controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Error con la Ventana");
        }
    }

    public void MostrarVentanaBusqueda() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaBusqueda.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Busqueda");
            ventana.setResizable(false);
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            ControladorVentanaBusqueda controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Error en Ventana");
        }
    }

    public void MostrarVentanaActualizacion() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaActualizacion.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Actualizacion");
            ventana.setResizable(false);
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            ControladorVentanaActualizacion controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Error en Ventana");
        }
    }

    public void MostrarVentanaNuevoCurso() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaNuevoCurso.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Nuevo Curso");
            ventana.setResizable(false);
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            ControladorVentanaNuevoCurso controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Error en Ventana");
        }
    }

    public void MostrarVentanaNuevoEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaNuevoEstudiante.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Nuevo Estudiante");
            ventana.setResizable(false);
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            ControladorVentanaNuevoEstudiante controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Error en Ventana");
        }
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        MostrarVentanaPrincipal();

        CreadorDeVentanas("VentanaPrincipal");                          ///////////////PRUEBA DEL IF para montar FACTORY
    }

    public static void main(String[] args) {
        System.out.println("Prueba");
        launch(args);
    }

}
