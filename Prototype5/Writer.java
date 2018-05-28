package XML;

//Imports
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Writer {
    XMLReader xmlReader;
    Reader reader = new Reader();
    int[] daysInMonth;

    public Writer(){
        xmlReader = new XMLReader();
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
    public void SwitchUser(String user){
        xmlReader.SwitchUser(user);
    }
    public String GetCurrentUser(){
        return xmlReader.GetCurrentUser();
    }
    public boolean AddUser(String name){
        if(xmlReader.GetUser(name) == null){
            //allready existing
            return false;
        }else {
            xmlReader.CreateUser(name);
            return true;
        }
    }
    public void AddPeriod(String user, String date, String period, String content) {
        Node usr = xmlReader.GetUser(user);

        NodeList years = null;
        int iyear = Integer.parseInt(date);
        iyear /= 10000;
        int month = Integer.parseInt(date);
        month %= 10000;
        month /= 100;
        if(usr != null){ // usr allready exists
            iyear = Integer.parseInt(date);
            iyear /= 10000;
            years = usr.getChildNodes();
            Node year = null;
            if(years != null) {
                year = xmlReader.GetYearById(Integer.toString(iyear), years);
            }
            month = Integer.parseInt(date);
            month %= 10000;
            month /= 100;
            if(year != null){ // year allready exists
                NodeList months = year.getChildNodes();
                Node nmonth = null;
                if(months != null) {
                    nmonth = xmlReader.GetMonthById(Integer.toString(month), months);
                }
                if(nmonth != null){ // month allready exists
                    NodeList days = nmonth.getChildNodes();
                    Node day = null;
                    if(days != null) {
                        day = xmlReader.GetDayById(date,days);
                    }
                    if(day != null){
                        xmlReader.CreatePeriod(day,period,content);
                    }else{
                        day = xmlReader.CreateDay(nmonth,date,"--","false");
                    }

                }else{
                    nmonth = xmlReader.CreateMonth(year,Integer.toString(month),GetDayName(month-1),Integer.toString(daysInMonth[month-1]));
                    Node nday = xmlReader.CreateDay(nmonth,date,"--","false");
                    xmlReader.CreatePeriod(nday,period,content);
                }
            }else{
                Node nyear = xmlReader.CreateYear(usr,Integer.toString(iyear));
                Node nmonth = xmlReader.CreateMonth(nyear,Integer.toString(month),GetDayName(month-1),Integer.toString(daysInMonth[month-1]));
                Node nday = xmlReader.CreateDay(nmonth,date,"--","false");
                xmlReader.CreatePeriod(nday,period,content);

            }
        }else{
            usr = xmlReader.CreateUser(user);
            Node nyear = xmlReader.CreateYear(usr,Integer.toString(iyear));
            Node nmonth = xmlReader.CreateMonth(nyear,Integer.toString(month),GetDayName(month-1),Integer.toString(daysInMonth[month-1]));
            Node nday = xmlReader.CreateDay(nmonth,date,"--","false");
            xmlReader.CreatePeriod(nday,period,content);
        }
    }
    public void SetDayBusy(String user, String date, String content){}
    public void SetDayBusy(String user, String date){}
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
