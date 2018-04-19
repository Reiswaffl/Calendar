import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class Interface {
    NodeList years;
    Interface() {
        try {
            File inputFile = new File("calendar.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //Console delete later and replace with GUI
            System.out.println("File read in!");
            System.out.println("-----------------------------");
            years = doc.getElementsByTagName("year");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Shows/returns the information of one day (from all periods)
    public void GetDayInformation(String date) { // yy,mm,dd
        int idate = Integer.parseInt(date);
        int year = idate - idate%10000;
        year = year / 10000;
        year += 2000;

        int month = idate - idate%100;
        month = month%1000;
        month = month/ 100;
        Node m;
        Node y = getYearById(Integer.toString(year));
        if(month < 10){
            String smonth = "0" + Integer.toString(month);
            m = getMonthById(smonth, y.getChildNodes());
        }else {
            m = getMonthById(Integer.toString(month), y.getChildNodes());
        }
        NodeList days = m.getChildNodes();
        System.out.println(m.getChildNodes().getLength());
        for(int i = 0; i < days.getLength(); i++){
            Node nday = days.item(i);
            if(nday.getNodeType() == Node.ELEMENT_NODE){
                Element eday = (Element) nday;
                if((date).equals(eday.getAttribute("date")) ){
                    if(nday.getChildNodes() != null){
                        NodeList periods = nday.getChildNodes();
                        for(int p = 0; i < periods.getLength(); p++){
                            if(eday.getElementsByTagName("period").item(p) != null) {
                                System.out.println(eday.getElementsByTagName("period").item(p).getTextContent());
                            }
                            }
                        }
                    }
                }
            }

        }


    //Shows/returns the information a special period
    public void GetPeriodInformation(String date, String period){
        int idate = Integer.parseInt(date);
        int year = idate - idate%10000;
        year = year / 10000;
        year += 2000;

        int month = idate - idate%100;
        month = month%1000;
        month = month/ 100;
        Node m;
        Node y = getYearById(Integer.toString(year));
        if(month < 10){
            String smonth = "0" + Integer.toString(month);
            m = getMonthById(smonth, y.getChildNodes());
        }else {
            m = getMonthById(Integer.toString(month), y.getChildNodes());
        }
        NodeList days = m.getChildNodes();
        System.out.println(m.getChildNodes().getLength());
        for(int i = 0; i < days.getLength(); i++){
            Node nday = days.item(i);
            if(nday.getNodeType() == Node.ELEMENT_NODE){
                Element eday = (Element) nday;
                if((date).equals(eday.getAttribute("date")) ){
                    if(nday.getChildNodes() != null){
                        NodeList periods = nday.getChildNodes();
                        for(int p = 0; p < periods.getLength(); p++){
                            Node nperiod = periods.item(p);
                            if(nperiod.getNodeType() == Node.ELEMENT_NODE){
                                Element eperiod = (Element) nperiod;
                                if(eperiod.getAttribute("time").equals(period)){
                                    System.out.println(eperiod.getTextContent());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //Returns the next free day
    public void getNextFreeDay(){
        Node y = getYearById("2018");
        Node m = getMonthById("01", y.getChildNodes());
        int lastday = 0;
        if(m.getChildNodes() != null)
        {
            NodeList days = m.getChildNodes();
            for (int i = 0 ; i < days.getLength(); i++){
                Node nday =  days.item(i);
                if(nday.getNodeType() == Node.ELEMENT_NODE){
                    Element eday = (Element) nday;
                    int currentday = Integer.parseInt(eday.getAttribute("date"));
                    currentday = currentday % 100;
                    if(currentday - lastday > 1){
                        // found free day
                        System.out.println("Found next Free day");
                        Element em = (Element) m;
                        Element ey = (Element) y;
                        System.out.println((lastday+1)+"."+ em.getAttribute("name") +"."+ ey.getAttribute("id") );
                    }else{
                        lastday = currentday;
                    }
                }
            }
        }else{
            Element em = (Element) m;
            Element ey = (Element) y;
            System.out.println((lastday+1)+"."+ em.getAttribute("name") +"."+ ey.getAttribute("id") );
        }
        System.out.println(m);

    }

    public Node getYearById(String  id ){
        for(int i = 0; i < years.getLength(); i++){
            Node nyear = years.item(i);
            if (nyear.getNodeType() == Node.ELEMENT_NODE){
                Element eyear = (Element) nyear;
                if(eyear.getAttribute("id").equals(id) ){
                    return nyear;
                }
            }
        }
        return null;
    }

    private Node getMonthById(String id , NodeList months){
        for(int i = 0; i < months.getLength(); i++){
            Node nmonth = months.item(i);
            if(nmonth.getNodeType() == Node.ELEMENT_NODE){
                Element emonth = (Element) nmonth;
                if(emonth.getAttribute("id").equals(id)){
                    return nmonth;
                }
            }
        }
        return null;
    }
    private Node getDayById(String id, NodeList days){

        return null;
    }

}
