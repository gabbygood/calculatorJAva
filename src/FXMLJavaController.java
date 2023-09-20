import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;




public class FXMLJavaController {
   @FXML
   private Label prevnum;   

   @FXML
   private Label result;

   @FXML
    private Button clear;


   private double num1 = 0;
   private double total = 0;
   private String operator = "";
   private boolean check = true;

   @FXML
    void CloseButton(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    private ImageView aboutClose;

    private Scene scene;
    private Stage stage;
    public Parent roots;

    public void clear(ActionEvent event)
    {
        if (event.getSource() == clear)
        {
            result.setText("0");
            prevnum.setText("");
        }

    }
    

    public Double create(double num1, double num2, String operator)
    {
        switch(operator)
        {
            case "+": 
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/": 
                return (num1 / num2);
            case "%": 
                return (num1 % num2);
            default: break;
        }
        return 0.0;
    }

    public void operatorProcess(ActionEvent event)
    {
        Button button = (Button)event.getSource();
        String value = button.getText();

        if (!value.equals("Ans"))
        {
            if (!operator.isEmpty())
                return;
            operator = value;
            prevOperator(operator);
            num1 = Double.parseDouble(result.getText());
            result.setText("");
        }
        else 
        {
            if (operator.isEmpty())
            {
                return;
            }
            double num2 = Double.parseDouble(result.getText());
            total = create(num1, num2, operator);
            result.setText(String.valueOf(total));
            operator = "";
            check = true;
        }

    }

    public void prevOperator(String operator)
    {
        prevnum.setText(prevnum.getText() + " " + operator + " ");
    }

    public void number(String number)
    {
        result.setText(result.getText() + number);
    }

    public void prevNumber(String number)
    {
        prevnum.setText(prevnum.getText() + number);
    }

    public void computeProcess(ActionEvent event)
    {
        if (check)
        {
            result.setText("");
            prevnum.setText("");
            check = false;
        }
        Button button = (Button)event.getSource();

        String value = button.getText();

        number(value);
        prevNumber(value);
    }
    
    @FXML
    void switchToScene1(ActionEvent event) throws IOException
    {
        Parent roots = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(roots);
        stage.setScene(scene);
        stage.show();
    }

    public void aboutCloseBtn()
    {
        javafx.application.Platform.exit();
    }

    @FXML
    void switchToScene2(ActionEvent event) throws IOException {
        Parent roots = FXMLLoader.load(getClass().getResource("FXMLDocumentTwo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(roots);
        stage.setScene(scene);
        stage.show();
    }
}
