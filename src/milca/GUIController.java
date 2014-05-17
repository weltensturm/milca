package milca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.*;

@SuppressWarnings("unused")
public class GUIController extends Pane implements Initializable {

    @FXML
    MenuItem menu_new;
    @FXML
    MenuItem menu_open;
    @FXML
    MenuItem menu_save;
    @FXML
    MenuItem menu_saveas;
    @FXML
    MenuItem menu_close;
    @FXML
    MenuItem menu_help;
    @FXML
    TextField input_formula;
    @FXML
    TextField input_table;
    @FXML
    TextField input_kv;
    @FXML
    Button button_p;
    @FXML
    Button button_q;
    @FXML
    Button button_r;
    @FXML
    Button button_s;
    @FXML
    Button button_t;
    @FXML
    Button button_u;
    @FXML
    Button button_and;
    @FXML
    Button button_nand;
    @FXML
    Button button_or;
    @FXML
    Button button_nor;
    @FXML
    Button button_equ;
    @FXML
    Button button_imp;
    @FXML
    Button button_not;
    @FXML
    Button button_lbr;
    @FXML
    Button button_rbr;
    @FXML
    Button button_w1;
    @FXML
    Button button_f1;
    @FXML
    Button button_enter1;
    @FXML
    Button button_w2;
    @FXML
    Button button_f2;
    @FXML
    Button button_enter2;
    @FXML
    Button button_w3;
    @FXML
    Button button_f3;
    @FXML
    Button button_enter3;
    
    private App application;
    
    public void setApp(App copyOfMain){
        this.application = copyOfMain;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        input_formula.setPromptText("Eingage");
        input_table.setPromptText("Eingage");
        input_kv.setPromptText("Eingage");
    }
    
	public void newFile()
	{	Stage primaryStage = new Stage();
		closeWindow();
		application.start(primaryStage);
	}
    public void openFile()
    {	/* FileChooser fileChooser = new FileChooser();
    	 * fileChooser.setTitle("Öffnen");
    	 * fileChooser.showOpenDialog(application.getStage());
    	 * Neue Klasse für FileChooser
    	 */
    }
    public void save()
    {	
    }
    public void saveAs()
    {	
    }
    public void closeWindow()
    {	application.getStage().close();
    }
    public void help()
    {	
    }
    public void processingFormula()
    {	
    }
    public void processingTable()
    {	
    }
    public void processingKV()
    {	
    }
    public void pressP()
    {	
    }
    public void pressQ()
    {	
    }
    public void pressR()
    {	
    }
    public void pressS()
    {	
    }
    public void pressT()
    {	
    }
    public void pressU()
    {	
    }
    public void pressW1()
    {	
    }
    public void pressF1()
    {	
    }
    public void pressW2()
    {	
    }
    public void pressF2()
    {	
    }
    public void pressW3()
    {	
    }
    public void pressF3()
    {	
    }
    public void pressAND()
    {	
    }
    public void pressNAND()
    {	
    }
    public void pressOR()
    {	
    }
    public void pressNOR()
    {	
    }
    public void pressEQU()
    {	
    }
    public void pressIMP()
    {	
    }
    public void pressNOT()
    {	
    }
    public void pressLBR()
    {	
    }
    public void pressRBR()
    {	
    }
}
