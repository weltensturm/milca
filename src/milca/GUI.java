package milca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.*;

public class GUI extends Pane implements Initializable {

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
    
    public void processEnter(ActionEvent event) {
        if (application == null){
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
//            errorMessage.setText("Hello " + userId.getText());
        } else {
//            if (!application.userLogging(userId.getText(), password.getText())){
//                errorMessage.setText("Username/Password is incorrect");
//            }
        }
    }
}
