package milca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.geometry.Pos;

@SuppressWarnings("unused")
public class GUIController<S> extends Pane implements Initializable {

    @FXML
    MenuItem menu_new;
/*    @FXML
    MenuItem menu_open;
    @FXML
    MenuItem menu_save;
    @FXML
    MenuItem menu_saveas;
    @FXML
    MenuItem menu_close;
    @FXML
    MenuItem menu_help;*/
    @FXML
    TextField input_formula;
    @FXML
    TextField input_table;
/*    @FXML
    TextField input_kv;*/
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
    Button button_enter1;
    @FXML
    Button button_w2;
    @FXML
    Button button_f2;
    @FXML
    Button button_enter2;
    @FXML
    GridPane solutionPane1;
    @FXML
    AnchorPane anchorPane1;
    
    private Label[] tableHead = new Label[6];
    private Label[][] truthvalues = new Label[64][6];
    private Label[] solution = new Label[64];

    
    private App application;
    
    public void setApp(App copyOfMain){
        this.application = copyOfMain;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        input_formula.setPromptText("Eingabe");
        input_table.setPromptText("Eingabe");
        //input_kv.setPromptText("Eingabe");
    }
    
	public void newFile()
	{	Stage primaryStage = new Stage();
		closeWindow();
		application.start(primaryStage);
	}
    public void openFile()
    {	
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
    {	try
    	{
    	String string = input_formula.getText();
    	Formula formula = new Formula();
    	formula.setFormula(string);
    	Wahrheitstabelle truthtable = new Wahrheitstabelle(formula.variables.size());
    	truthtable.makeTabelleV();
    	
    	
    	for(int i = 1; i <= truthtable.tabelle.length; i++)
    	{	solutionPane1.getRowConstraints().get(i).setMaxHeight(25.0);
    		solutionPane1.getRowConstraints().get(i).setPrefHeight(25.0);
    	}
    	for(int i = (truthtable.tabelle.length + 1); i < truthvalues.length; i++)
    	{	solutionPane1.getRowConstraints().get(i).setMaxHeight(0.0);
    		solutionPane1.getRowConstraints().get(i).setPrefHeight(0.0);
    	}
    	solutionPane1.setPrefHeight(25.0 * truthtable.tabelle.length);
    	solutionPane1.setMaxHeight(25.0 *truthtable.tabelle.length);
    	anchorPane1.setPrefHeight(solutionPane1.getPrefHeight());
    	
    	for(int i = 0; i < truthtable.tabelle[0].length; i++)
    	{	if(tableHead[i] == null)
    		{	tableHead[i] = new Label();
    			solutionPane1.add(tableHead[i], i, 0);
    			tableHead[i].setAlignment(javafx.geometry.Pos.CENTER);
    		}
    		tableHead[i].setText(formula.variables.get(i).name);
    		solutionPane1.getColumnConstraints().get(i).setMaxWidth(25.0);
    		solutionPane1.getColumnConstraints().get(i).setPrefWidth(25.0);
    		solutionPane1.getColumnConstraints().get(i).setMinWidth(25.0);
    	}
    	for(int i = truthtable.tabelle[0].length; i < truthvalues[0].length; i++)
    	{	solutionPane1.getColumnConstraints().get(i).setMaxWidth(0.0);
    		solutionPane1.getColumnConstraints().get(i).setPrefWidth(0.0);
    		solutionPane1.getColumnConstraints().get(i).setMinWidth(0.0);
    	}
    	
    	//Gibt w oder f in Tabellenformat aus;
    	//TO-DO: Wenn man zuvor eine lange Tabelle errechnet hat und anschließend eine kurze, wird die Tabelle gequetscht!!!
    	for(int i = 1; i < truthvalues.length; i++)
    	{	for(int j = 0; j < truthvalues[i].length; j++)
    			if(truthvalues[i][j] != null)
    				truthvalues[i][j].setText("");
    		if(solution[i] != null)
    			solution[i].setText("");
    	}
    	
    	for(int i = 0; i < truthtable.tabelle.length; i++)
    	{	for(int j = 0; j < truthtable.tabelle[i].length; j++)
    		{	if(truthvalues[i][j] == null)
    			{	truthvalues[i][j] = new Label();
    				solutionPane1.add(truthvalues[i][j], j, i + 1);
    				truthvalues[i][j].setAlignment(javafx.geometry.Pos.CENTER);
    			}
				truthvalues[i][j].setText(truthtable.tabelle[i][j] ? "w": "f");
				formula.setVariable(formula.variables.get(j).name, truthtable.tabelle[i][j]);
    		}
    		if(solution[i] == null)
    		{	solution[i] = new Label();
    			solutionPane1.add(solution[i], 7, i + 1);
    			solution[i].setAlignment(javafx.geometry.Pos.CENTER);
    		}
    		solution[i].setText(formula.calculate() ? "w" : "f");
    	}
    	}
    	catch (Exception ex)
    	{
    		if(solution[0] == null)
    		{	solution[0] = new Label();
    			solutionPane1.add(solution[0], 7, 1);
    		}
			solution[0].setText("Fehlerhafte Eingabe");
			solutionPane1.getRowConstraints().get(1).setMinHeight(25.0);
			solutionPane1.getRowConstraints().get(1).setPrefHeight(25.0);
			solutionPane1.getRowConstraints().get(1).setMaxHeight(25.0);
    	}
    }
    public void processingTable()
    {	
    }
    /*public void processingKV()
    {	
    }*/
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
    public void pressW2()
    {	input_table.setText(input_table.getText() + "w");
    }
    public void pressF2()
    {	input_table.setText(input_table.getText() + "f");
    }
/*    public void pressW3()
    {	input_kv.setText(input_kv.getText() + "w");
    }
    public void pressF3()
    {	input_kv.setText(input_kv.getText() + "f");
    }*/
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
