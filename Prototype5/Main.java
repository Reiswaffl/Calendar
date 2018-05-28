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
public class Main {
    String currentUser;
    Writer writer;
    Reader reader;
    int[] daysInMonth;
    public Main(){
        writer = new Writer();
        currentUser = "Eric";
        reader = new Reader();
        daysInMonth = new int[12];
        daysInMonth[0] = 31;
        daysInMonth[1] = 28;
        daysInMonth[2] = 31;
        daysInMonth[3] = 30;
        daysInMonth[4] = 31;
        daysInMonth[5] = 30;
        daysInMonth[6] = 31;
        daysInMonth[7] = 31;
        daysInMonth[8] = 30;
        daysInMonth[9] = 31;
        daysInMonth[10] = 30;
        daysInMonth[11] = 31;
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //HH:mm:ss
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void AddAppiontment(String user,String date, String period, String content){
        writer.AddPeriod(user,date,period,content);
    }
    public String  GetCurrentDayInfo() {
        String totaldate = TransformToString();
        System.out.println(totaldate);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(totaldate))!=null) {
             returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(totaldate));
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
    public String GetDay1Info(){
        String date = DayMonth(1);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(date));
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
    public String GetDay2Info(){
        String date = DayMonth(2);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(date));
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
    public String GetDay3Info(){
        String date =DayMonth(3);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(date));
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
    public String GetDay4Info(){
        String date = DayMonth(4);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(date));
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
    public String GetDay5Info(){
        String date = DayMonth(5);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(date));
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
    public String GetDay6Info(){
        String date = DayMonth(6);
        ReturnValue returnValue = null;
        if(reader.GetDayInformation(currentUser,Integer.parseInt(date))!=null) {
            returnValue = reader.GetDayInformation(currentUser, Integer.parseInt(date));
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

    public void SwitchUser(String user){
        writer.SwitchUser(user);
    }
    public String GetCurrentUser(){
        return writer.GetCurrentUser();
    }

    public String[] DaysInOrder(){
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
    private String TransformToString(){
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
    private String DayMonth(int add){
        String date = TransformToString();
        int totaldate = Integer.parseInt(date);
        int month = totaldate % 10000;
        month /= 100;
        int day = totaldate % 100;

        if(daysInMonth[month-1] < day + add ){

            // day is in next month
            month += 1;
            day += add;
            day -= daysInMonth[month-1];
            System.out.println(month+" "+day);
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
        System.out.println(date);
        return date;
    }
    private int GetID(String dayname){
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
    private String GetDayName(int id){
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
}
