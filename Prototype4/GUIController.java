package GUI;


import javafx.fxml.FXML;

import java.util.TimerTask;

import Main.Main;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GUIController{
    public GUI gui;
    private Main main;

    //Views
    @FXML public Label datetime;
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
    boolean running;

    // Methods
    public void setGui(GUI gui){
        main = new Main();
        Time();
        this.gui = gui;
    }

    public void Time(){
        running = true;
        final Thread thread = new Thread() {
            public void run() {
                while (running) {

                }
            }
        };
        thread.start();
    }
    @FXML
    public void AddAppiontment(){
        Sync();
    }
    private void Sync(){
        datetime.setText(main.getDateTime());
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
    }


}

