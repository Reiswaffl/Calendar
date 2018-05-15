package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class XMLReader {
    NodeList users;
    Document doc;
    public XMLReader() {
        try {
            File inputFile = new File("calendar.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //Console delete later and replace with GUI
            System.out.println("File read in!");
            System.out.println("-----------------------------");
            users = doc.getElementsByTagName("user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Reading Information
    public Node GetUser(String id){
        for(int i = 0; i < users.getLength(); i++){
            Node nuser = users.item(i);
            if(nuser.getNodeType() == Node.ELEMENT_NODE){
                Element euser = (Element) nuser;
                if(euser.getAttribute("id").equals((id))){
                    return nuser;
                }
            }
        }
        return null;
    }
    public Node GetYearById(String  id, NodeList years ){
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
    public Node GetMonthById(String id , NodeList months) {
        for (int i = 0; i < months.getLength(); i++) {
            Node nmonth = months.item(i);
            if (nmonth.getNodeType() == Node.ELEMENT_NODE) {
                Element emonth = (Element) nmonth;
                if (emonth.getAttribute("id").equals(id)) {
                    return nmonth;
                }
            }
        }
        return null;
    }
    public Node GetDayById(String date, NodeList days){
        for(int i = 0; i < days.getLength(); i++){
            Node nday = days.item(i);
            if(nday.getNodeType() == Node.ELEMENT_NODE){
                Element eday = (Element) nday;
                if(eday.getAttribute("date").equals(date)){
                    return nday;
                }
            }
        }
        return null;
    }
    public Node GetPeriodById(String time, NodeList periods){
        for(int i = 0; i < periods.getLength(); i++){
            Node nperiod = periods.item(i);
            if(nperiod.getNodeType() == Node.ELEMENT_NODE){
                Element eperiod = (Element) nperiod;
                if(eperiod.getAttribute("time").equals(time)){
                    return nperiod;
                }
            }
        }
        return null;
    }
    //Writing Information
    public void CreateYear(Node parent, String id){
        Element year = doc.createElement("years");
        year.setAttribute("id",id);
        parent.appendChild(year);
    try {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("calendar.xml"));
        transformer.transform(source, result);
    }catch (Exception e){}
    }
    public void CreateMonth(Node parent, String id, String name,String maxdays) {
        Element month = doc.createElement("month");
        month.setAttribute("name", name);
        month.setAttribute("id", id);
        month.setAttribute("maxdays",maxdays);
        parent.appendChild(month);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("calendar.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
        }
    }
    public void CreateDay(Node parent, String date, String name,String blocked){
        Element day = doc.createElement("day");
        day.setAttribute("date", date);
        day.setAttribute("name",name);
        day.setAttribute("blocked", blocked);
        parent.appendChild(day);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("calendar.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {}

    }
    public void CreatePeriod(Node parent, String time, String content){
        Element period = doc.createElement("period");
        period.setAttribute("time", time);
        period.setTextContent(content);
        parent.appendChild(period);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("calendar.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {}
    }
}
