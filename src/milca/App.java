package milca;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.fxml.*;

public class App extends Application {

    private Stage stage;
    private final double WINDOW_WIDTH = 616.0;
    private final double WINDOW_HEIGHT = 446.0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(App.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Milca Logics");

            stage.setMinWidth(WINDOW_WIDTH);
            stage.setMinHeight(WINDOW_HEIGHT);
            stage.setMaxWidth(WINDOW_WIDTH);
            stage.setMaxHeight(WINDOW_HEIGHT);
            stage.setHeight(WINDOW_HEIGHT);
            stage.setWidth(WINDOW_WIDTH);
            
            gotoGUI();
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoGUI() {
        try {
        	GUIController login = (GUIController) replaceSceneContent("GUI1.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = App.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(App.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    public Stage getStage()
    {	return stage;
    }
}
