package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Main.Main;

import java.awt.*;
import java.io.IOException;

public class SwitchUserSceneController{
    @FXML private TextField select;
    @FXML private TextField add;
    @FXML private Label selectedUser;
    Main main = new Main();


    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        Parent addAppiontment = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene addAppiontmentScene = new Scene(addAppiontment);
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(addAppiontmentScene);
        window.show();
    }

    @FXML
    public void handleSelect(){
        selectedUser.setText(select.getText());
        main.SwitchUser(select.getText());
        select.clear();
    }
    @FXML
    public void handleAdd(){
        selectedUser.setText(add.getText());
        add.clear();
        //add to XML-File
    }

}
