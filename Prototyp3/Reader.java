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
        NodeList periods = day.getChildNodes();
        for (int i = 0; i < periods.getLength(); i++) {
            Node nperiod = periods.item(i);
            if (nperiod.getNodeType() == Node.ELEMENT_NODE) {
                Element eperiod = (Element) nperiod;
                returnValue.AddContent(eperiod.getTextContent(), eperiod.getAttribute("time"));
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
                            return (Integer.toString(lastday+1)+ " "+ em.getAttribute("id ") + " "+ "20" + ey.getAttribute("id"));
                        }
                    }

                }
            }
        }
        return "Gönn dir mal ne Pause!";
    }
    public String GetNextFreePeriod(){return null;}
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

}
