package Main;

import ReturnValues.*;
import XML.Reader;
import XML.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import ReturnValues.ReturnValue;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.transform.TransformerException;

public final class Main {
    public static Writer writer;
    public static Reader reader;
    public static int[] daysInMonth = new int[12];

    //Getter to get information for the MainWindow
    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //HH:mm:ss
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static boolean AddAppiontment(String date, String period, String content) throws TransformerException {
        if(reader.GetPeriodInformation(reader.GetCurrentUser(),Integer.parseInt(date),period) == null){
            //No Appiontment for that time
            writer.AddPeriod(reader.GetCurrentUser(),date,period,content);
            return true;
        }else{
            //Appiontment for that time
            return false;
        }

    }
    public static String  GetCurrentDayInfo(String currentUser) {
        String totaldate = TransformToString();

        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(totaldate))!=null) {
             returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(totaldate));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();
            ArrayList<String> p = returnValue.GetPeriod();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i)+"\n";
                }

            }
        }

        return ret;
    }
    public static String GetDay1Info(String currentUser){
        String date = DayMonth(1);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(date));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i) + "\n";
                }

            }
        }
        return ret;
    }
    public static String GetDay2Info(String currentUser){
        String date = DayMonth(2);

        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(date));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i) + "\n";
                }

            }
        }
        return ret;
    }
    public static String GetDay3Info(String currentUser){
        String date =DayMonth(3);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(date));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i) + "\n";
                }

            }
        }
        return ret;
    }
    public static String GetDay4Info(String currentUser){
        String date = DayMonth(4);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(date));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i) + "\n";
                }

            }
        }
        return ret;
    }
    public static String GetDay5Info(String currentUser){
        String date = DayMonth(5);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(date));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i) + "\n";
                }

            }
        }
        return ret;
    }
    public static String GetDay6Info(String currentUser){
        String date = DayMonth(6);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(reader.GetCurrentUser(),Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(reader.GetCurrentUser(), Integer.parseInt(date));
        }
        String ret = "-";
        if(returnValue != null) {
            ArrayList<String> a = returnValue.GetContent();

            for (int i = 0; i < a.size(); i++) {
                if(ret.equals( "-")){
                    ret += a.get(i) + "\n";
                }else{
                    ret += "-" + a.get(i) + "\n";
                }

            }
        }
        return ret;
    }

    //Change user
    public static void SwitchUser(String user){
        writer.SwitchUser(user);
    }
    public static String  AddUser(String username) throws TransformerException {
        return writer.AddUser(username);
    }
    public static String GetCurrentUser(){
        return writer.GetCurrentUser();
    }


    public static String[] DaysInOrder(){
        String[] daynames = new String[7];
        Date date = new Date();
        DateFormat format2=new SimpleDateFormat("EEEE");
        String currentDay=format2.format(date);

        int startid = GetID(currentDay);
        int id = 0;
        for(int i = startid; i < 7; i++){
            daynames[id] = GetDayName(i);
            id++;
        }
        for(int i = 0; i < startid; i++){
            daynames[id] = GetDayName(i);
            id++;
        }

        return daynames;
    }
    private static String TransformToString(){
        Date date = new Date();

        DateFormat dayFormat = new SimpleDateFormat("dd");
        String day = dayFormat.format(date);

        DateFormat monthFormat = new SimpleDateFormat("MM");
        String month = monthFormat.format(date);

        DateFormat yearFormat = new SimpleDateFormat("yyyy");
        String year = yearFormat.format(date);
        int iyear = Integer.parseInt(year);
        iyear %= 100;
        year = Integer.toString(iyear);

        if (year.length() == 1) {
            year = "0" + year;
        }
        String totaldate = year + month + day;
        return totaldate;
    }
    private static String DayMonth(int add){
        String date = TransformToString();
        int totaldate = Integer.parseInt(date);
        int month = totaldate % 10000;
        month /= 100;
        int day = totaldate % 100;

        if(daysInMonth[month-1] < day + add ){

            // day is in next month
            month += 1;
            day += add;
            day -= daysInMonth[month-1]+1;
        }else{
            day = day +add;
        }
        String smonth = Integer.toString(month);
        String sday = Integer.toString(day);
        if(smonth.length() == 1){
            smonth = "0" + smonth;
        }
        if(sday.length() == 1){
            sday = "0" +sday;
        }

        int year = totaldate / 10000;
        String syear = Integer.toString(year);
        date = syear + smonth + sday;
        return date;
    }
    private static int GetID(String dayname){
        switch (dayname){
            case "Montag":
                return 0;
            case "Dienstag":
                return 1;
            case "Mittwoch":
                return 2;
            case "Donnerstag":
                return 3;
            case "Freitag":
                return 4;
            case "Samstag":
                return 5;
            case "Sonntag":
                return 6;
            default:
                return 10;
        }
    }
    private static String GetDayName(int id){
        switch (id){
            case 0:
                return "Montag";
            case 1:
                return "Dienstag";
            case 2:
                return "Mittwoch";
            case 3:
                return "Donnerstag";
            case 4:
                return "Freitag";
            case 5:
                return "Samstag";
            case 6:
                return "Sonntag";
            default:
                return null;
        }
    }


    public static void Update(){
        writer.Update();
    }   
}
