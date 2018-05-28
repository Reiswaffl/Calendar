package XML;

//Imports
import ReturnValues.ReturnValue;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Reader {
    XMLReader xmlReader;
    public Reader(){
        xmlReader = new XMLReader();
    }
    public ReturnValue GetDayInformation(String user, int date) {
        ReturnValue returnValue = new ReturnValue();
        int y = date / 10000;
        String idy = FormToString(y);
        NodeList years = xmlReader.GetUser(user).getChildNodes();
        Node year = xmlReader.GetYearById(idy, years);

        int m = date % 10000;
        m /= 100;
        String idm = FormToString(m);

        Node month = null;
        if (year != null) {
            month = xmlReader.GetMonthById(idm, year.getChildNodes());

        } else {
            return returnValue;
        }

        Node day = null;
        if (month != null) {
            day = xmlReader.GetDayById(Integer.toString(date), month.getChildNodes());
        } else {
            return returnValue;
        }
        if (day != null) {
            NodeList periods = null;
            if (day.getChildNodes() != null) {
                periods = day.getChildNodes();
            }
            if (periods != null) {
                for (int i = 0; i < periods.getLength(); i++) {
                    Node nperiod = periods.item(i);
                    if (nperiod.getNodeType() == Node.ELEMENT_NODE) {
                        Element eperiod = (Element) nperiod;

                        returnValue.AddContent(eperiod.getTextContent(), eperiod.getAttribute("time"));
                    }
                }
            }
        }
        return  returnValue;
    }
    public String GetPeriodInformation(String user, int date, String time){

        int y = date/10000;
        String idy = FormToString(y);
        NodeList years = xmlReader.GetUser(user).getChildNodes();
        Node year = xmlReader.GetYearById(idy, years);

        int m = date%10000;
        m /= 100;
        String idm = FormToString(m);
                Node month = null;
        if(year != null) { month = xmlReader.GetMonthById(idm, year.getChildNodes());}
        else{return " y Nicht vorhanden!";}
        Node day = null;
        if(month != null){ day = xmlReader.GetDayById(Integer.toString(date), month.getChildNodes());}
        else{return " m Nicht vorhanden!";}
        Node p = null;
        if(day != null){p = xmlReader.GetPeriodById(time, day.getChildNodes());}
        else {return " d Nicht vorhanden!";}
        return p.getTextContent();
    }
    public String GetNextFreeDay(String usr){
        Node user = xmlReader.GetUser(usr);
        Node year =null;
        if(user != null){
            year = xmlReader.GetYearById("18",user.getChildNodes()); //change later to aktuall year (with datetime)
        }
        NodeList months;
        if(year != null){
            months = year.getChildNodes();
            for(int m = 0; m < months.getLength(); m++){
                Node nmonth = months.item(m);
                NodeList days = nmonth.getChildNodes();
                int lastday = 0;
                for(int d = 0; d < days.getLength(); d++){
                    Node nday = days.item(d);
                    if(nday.getNodeType() == Node.ELEMENT_NODE){
                        Element eday = (Element) nday;
                        int currentday = Integer.parseInt(eday.getAttribute("date"));
                        currentday = currentday % 100;
                        if(currentday -lastday > 1){
                            //Free day found
                            Element em = (Element) nmonth;
                            Element ey = (Element) year;
                            return (Integer.toString(lastday+1)+ " "+ em.getAttribute("name") + " "+ "20" + ey.getAttribute("id"));
                        }
                    }

                }
            }
        }
        return "Gönn dir mal ne Pause!";
    }
    public String GetNextFreePeriod(String usr, String mintime, String maxtime, String hours){
        //Not possible, because searches intervall is bigger than the possible one
        if(Integer.parseInt(maxtime) - Integer.parseInt(mintime) < Integer.parseInt(hours)){
            return "Leider nicht möglich, der Zeitraum und die Anzahl der gewünschten Stunden ist zu groß!";
        }
        Node user = xmlReader.GetUser(usr);
        Node year = xmlReader.GetYearById("18",user.getChildNodes());
        NodeList months = year.getChildNodes();
        for(int m = 0; m < months.getLength(); m++){
            Node nmonth = months.item(m);
            NodeList days = nmonth.getChildNodes();
            int lasttime = Integer.parseInt(mintime);
            for(int d = 0; d < days.getLength(); d++){
                Node nday = days.item(d);
                NodeList periods = nday.getChildNodes();

                for(int p = 0; p < periods.getLength(); p++){
                    Node nperiod = periods.item(p);
                    if(nperiod.getNodeType() == Node.ELEMENT_NODE){
                        Element eperiod = (Element) nperiod;
                        int currenttime = Integer.parseInt(eperiod.getAttribute("time"));
                        if(InTime(lasttime,currenttime,Integer.parseInt(mintime),Integer.parseInt(maxtime))) {
                            if (currenttime - lasttime >= Integer.parseInt(hours)) {
                                return Integer.toString(lasttime) + "/" + Integer.toString(currenttime);
                            }
                        }
                    }
                }
            }
        }

        return "Leider keinen passenden Zeitraum gefunden!";
    }
    public ArrayList<Integer> GetMonthInformation(){
        return null;
    }
    private String FormToString(int input){
        if(Integer.toString(input).length() > 1){
            return Integer.toString(input);
        }else{
            return "0"+Integer.toString(input);
        }
    }
    private boolean InTime(int lasttime, int currenttime, int mintime, int maxtime){
        if(lasttime > currenttime){
            if(lasttime < mintime){
                return false;
            }
            if(lasttime > maxtime){
                return false;
            }
        }
        return true;
    }

}
