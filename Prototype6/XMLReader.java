package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import static com.sun.deploy.perf.DeployPerfUtil.*;

public class XMLReader {
    NodeList users;
    Document doc;

    public XMLReader() {
        //reads in file
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
            dbFactory = null;
            dBuilder = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Update-method to update the File (after changes were made)
    public void Update(){
    //reads in file
        try {
            doc = null;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            File inputFile = new File("calendar.xml");
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

    //Userinteraction
    public void SwitchUser(String user){
        NodeList currents = doc.getElementsByTagName("currentUser");
        Node currentUser = currents.item(0);
        //Changes attribute to the current user
        setAttribute((Element) currentUser,"id",user);
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("calendar.xml"));
                transformer.transform(source, result);
            }catch (Exception e){}
    }
    public String GetCurrentUser(){
        NodeList currents = doc.getElementsByTagName("currentUser");
        Node currentUser = currents.item(0);

        return ( (Element) currentUser).getAttribute("id");
    }
    //Reading Information
    public NodeList GetUsers(){
        NodeList Users = doc.getElementsByTagName("users");
        Node userList = Users.item(0);
        if(userList == null){
            return null;
        }
        System.out.println(userList.getChildNodes().getLength());
        return userList.getChildNodes();
    } //returns a NodeList with all possible Users
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
    public Element CreateUser(String id) throws TransformerException {
        Element user = doc.createElement("user");
        user.setAttribute("id",id);
        NodeList rootList = doc.getElementsByTagName("calendar");
        Node root = rootList.item(0);
        root.appendChild(user);

        Element User = doc.createElement("User");
        User.setAttribute("id",id);
        NodeList userList = doc.getElementsByTagName("users");
        Node userSave = userList.item(0);
        userSave.appendChild(User);

        NodeList currents = doc.getElementsByTagName("currentUser");
        Node currentUser = currents.item(0);

        setAttribute((Element) currentUser,"id",id);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("calendar.xml"));
            transformer.transform(source, result);
        }catch (Exception e){}

        return user;

    }
    public Element CreateYear(Node parent, String id){
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
    return year;
    }
    public Element CreateMonth(Node parent, String id,String maxdays) {
        Element month = doc.createElement("month");
        if(id.length() == 1){id = "0"+id;}
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
        return month;
    }
    public Element CreateDay(Node parent, String date, String name,String blocked){
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
        return day;
    }
    public Element CreatePeriod(Node parent, String time, String content){
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
        return period;
    }

    //Setting attributes
    public void setAttribute(Element node,String att, String value){
        node.setAttribute(att,value);
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("calendar.xml"));
            transformer.transform(source, result);
        }catch (Exception e){}
    }
}
