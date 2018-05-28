package GUI;


import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.TimerTask;

import Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.ws.Action;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class GUIController{

    public GUI gui;
    private Main main;

    //Views
    @FXML public Label datetime;
    @FXML public Label currentUser;
    @FXML private Label currentDay;
    @FXML private Label day1;
    @FXML private Label day2;
    @FXML private Label day3;
    @FXML private Label day4;
    @FXML private Label day5;
    @FXML private Label day6;
    @FXML private Label currentDayInfo;
    @FXML private Label day1Info;
    @FXML private Label day2Info;
    @FXML private Label day3Info;
    @FXML private Label day4Info;
    @FXML private Label day5Info;
    @FXML private Label day6Info;


    // Methods
    public void setGui(GUI gui){
        main = new Main();
        Sync();
        this.gui = gui;
    }


    @FXML
    public void AddAppointment(javafx.event.ActionEvent event) throws IOException {
        Parent addAppiontment = FXMLLoader.load(getClass().getResource("AddAppiontmentScene.fxml"));
        Scene addAppiontmentScene = new Scene(addAppiontment);
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(addAppiontmentScene);
        window.show();
    }
    @FXML
    public void SyncButton(){
        Sync();
    }
    @FXML void SwitchUser(javafx.event.ActionEvent event) throws IOException {
        Parent addAppiontment = FXMLLoader.load(getClass().getResource("SwitchUserScene.fxml"));
        Scene addAppiontmentScene = new Scene(addAppiontment);
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(addAppiontmentScene);
        window.show();
    }
    public void Sync(){
        main = new Main();
        datetime.setText(main.getDateTime());
        currentUser.setText(main.GetCurrentUser());
        currentDayInfo.setText(main.GetCurrentDayInfo());
        day1Info.setText(main.GetDay1Info());
        day2Info.setText(main.GetDay2Info());
        day3Info.setText(main.GetDay3Info());
        day4Info.setText(main.GetDay4Info());
        day5Info.setText(main.GetDay5Info());
        day6Info.setText(main.GetDay6Info());
        main.DaysInOrder();
        String[] daynames = main.DaysInOrder();
        currentDay.setText(daynames[0]);
        day1.setText(daynames[1]);
        day2.setText(daynames[2]);
        day3.setText(daynames[3]);
        day4.setText(daynames[4]);
        day5.setText(daynames[5]);
        day6.setText(daynames[6]);
        currentUser.setText(main.GetCurrentUser());
    }


}

