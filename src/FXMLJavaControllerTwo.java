import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLJavaControllerTwo {
  private Scene scene;
  private Stage stage;
  private Parent parent;

  public void switchToScene2(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentTwo.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  public void switchToScene1(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }
}
