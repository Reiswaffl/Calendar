package GUI;


import XML.Reader;
import XML.Writer;
import javafx.fxml.FXML;

import java.io.IOException;

import Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GUIController{

    public GUI gui;

    //Views
    @FXML private Label datetime;
    @FXML private Label currentUser;
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
        Main.writer = new Writer();
        Main.reader = new Reader();
        Main.Update();
        Main.daysInMonth[0] = 31;
        Main.daysInMonth[1] = 28;
        Main.daysInMonth[2] = 31;
        Main.daysInMonth[3] = 30;
        Main.daysInMonth[4] = 31;
        Main.daysInMonth[5] = 30;
        Main.daysInMonth[6] = 31;
        Main.daysInMonth[7] = 31;
        Main.daysInMonth[8] = 30;
        Main.daysInMonth[9] = 31;
        Main.daysInMonth[10] = 30;
        Main.daysInMonth[11] = 31;
        Sync();
        this.gui = gui;
    }


    @FXML
    public void AddAppointment(javafx.event.ActionEvent event) throws IOException {
        Parent addAppiontment = FXMLLoader.load(getClass().getResource("AddAppointmentScene.fxml"));
        Scene addAppiontmentScene = new Scene(addAppiontment);
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(addAppiontmentScene);
        window.show();
    }
    @FXML
    public void AppointmentRequest(javafx.event.ActionEvent event) throws IOException {
        Parent appointmentRequest = FXMLLoader.load(getClass().getResource("AppointmentRequest.fxml"));
        Scene appointmentRequestScene = new Scene(appointmentRequest);
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(appointmentRequestScene);
        window.show();
    }
    @FXML
    public void GetNextFreeDay(javafx.event.ActionEvent event ){

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
        datetime.setText(Main.getDateTime());
        currentUser.setText(Main.GetCurrentUser());
        currentDayInfo.setText(Main.GetCurrentDayInfo(Main.GetCurrentUser()));
        day1Info.setText(Main.GetDay1Info(Main.GetCurrentUser()));
        day2Info.setText(Main.GetDay2Info(Main.GetCurrentUser()));
        day3Info.setText(Main.GetDay3Info(Main.GetCurrentUser()));
        day4Info.setText(Main.GetDay4Info(Main.GetCurrentUser()));
        day5Info.setText(Main.GetDay5Info(Main.GetCurrentUser()));
        day6Info.setText(Main.GetDay6Info(Main.GetCurrentUser()));
        Main.DaysInOrder();
        String[] daynames = Main.DaysInOrder();
        currentDay.setText(daynames[0]);
        day1.setText(daynames[1]);
        day2.setText(daynames[2]);
        day3.setText(daynames[3]);
        day4.setText(daynames[4]);
        day5.setText(daynames[5]);
        day6.setText(daynames[6]);
        currentUser.setText(Main.GetCurrentUser());
    }


}

