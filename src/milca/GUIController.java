package milca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.*;

@SuppressWarnings("unused")
public class GUIController<S> extends Pane implements Initializable {

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
	@FXML
    TableColumn colP;
    @FXML
    TableColumn colQ;
    @FXML
    TableColumn colR;
    @FXML
    TableColumn colS;
    @FXML
    TableColumn colT;
    @FXML
    TableColumn colU;
    @FXML
    TableColumn colSolution;
    
    
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
    {	//Formula formula = new Formula(input_formula.getText());
    	//Wahrheitstabelle truthtable = new Wahrheitstabelle(formula.getVariable().length);
    	
    	
    }
    public void processingTable()
    {	
    }
    public void processingKV()
    {	
    }
    public void pressP()
    {	input_formula.setText(input_formula.getText() + "P");
    }
    public void pressQ()
    {	input_formula.setText(input_formula.getText() + "Q");
    }
    public void pressR()
    {	input_formula.setText(input_formula.getText() + "R");
    }
    public void pressS()
    {	input_formula.setText(input_formula.getText() + "S");
    }
    public void pressT()
    {	input_formula.setText(input_formula.getText() + "T");
    }
    public void pressU()
    {	input_formula.setText(input_formula.getText() + "U");
    }
    public void pressW1()
    {	input_formula.setText(input_formula.getText() + "w");
    }
    public void pressF1()
    {	input_formula.setText(input_formula.getText() + "f");
    }
    public void pressW2()
    {	input_table.setText(input_table.getText() + "w");
    }
    public void pressF2()
    {	input_table.setText(input_table.getText() + "f");
    }
    public void pressW3()
    {	input_kv.setText(input_kv.getText() + "w");
    }
    public void pressF3()
    {	input_kv.setText(input_kv.getText() + "f");
    }
    public void pressAND()
    {	input_formula.setText(input_formula.getText() + "∧");
    }
    public void pressNAND()
    {	input_formula.setText(input_formula.getText() + "↑");
    }
    public void pressOR()
    {	input_formula.setText(input_formula.getText() + "∨");
    }
    public void pressNOR()
    {	input_formula.setText(input_formula.getText() + "↓");
    }
    public void pressEQU()
    {	input_formula.setText(input_formula.getText() + "⇔");
    }
    public void pressIMP()
    {	input_formula.setText(input_formula.getText() + "⇒");
    }
    public void pressNOT()
    {	input_formula.setText(input_formula.getText() + "¬");
    }
    public void pressLBR()
    {	input_formula.setText(input_formula.getText() + "(");
    }
    public void pressRBR()
    {	input_formula.setText(input_formula.getText() + ")");
    }
    
}
