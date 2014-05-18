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
    private final double MINIMUM_WINDOW_WIDTH = 616.0;
    private final double MINIMUM_WINDOW_HEIGHT = 446.0;
    private final double MAXIMUM_WINDOW_WIDTH = 616.0;
    private final double MAXIMUM_WINDOW_HEIGHT = 446.0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(App.class, (java.lang.String[])null);
    }

	private Formula formula;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Milca Logics");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            stage.setMaxWidth(MAXIMUM_WINDOW_WIDTH);
            stage.setMaxHeight(MAXIMUM_WINDOW_HEIGHT);
            
            formula = new Formula();
            formula.setFormula("(a & b) | c");
            formula.setVariable("c", true);
            System.out.println(formula.calculate());
            
            gotoGUI();
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoGUI() {
        try {
        	GUI login = (GUI) replaceSceneContent("GUI1.fxml");
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
}
