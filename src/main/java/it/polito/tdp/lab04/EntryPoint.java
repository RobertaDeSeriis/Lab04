package it.polito.tdp.lab04;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.lab04.FXMLController;
import it.polito.tdp.lab04.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/Scene.fxml")); 
        Parent root = loader.load(); 
        
        //permette di avere il riferimento alla classe FXMLLoader
        FXMLController controller = loader.getController(); 
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        Model model= new Model(); //crea la classe libretto 
        controller.setModel(model); 
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
        /*
		 * Create and set the model here!
		 */
		// controller.setModel();
        
        

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
