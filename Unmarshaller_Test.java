import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Unmarshaller_Test {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("year");
             for(int i = 0; i < nList.getLength(); i++){
                 Node nNode = nList.item(i);
                 // System.out.println("Current Element: "+ nNode.getNodeName());
                 NodeList months = nNode.getChildNodes();
                 for(int m = 0; m < months.getLength(); m++){
                     Node month =  months.item(m);
                     //System.out.println("Current Element:"+month.getNodeName());
                     if(month.getNodeType() == Node.ELEMENT_NODE){
                         Element emonth = (Element) month;
                         System.out.println("Month by Name: "+ emonth.getAttribute("name"));
                     }
                     NodeList days = month.getChildNodes();
                     for(int d = 0; d < days.getLength(); d++){
                         Node day = days.item(d);
                         if(day.getNodeType() == Node.ELEMENT_NODE){
                             Element eday = (Element) day;
                             System.out.println("      "+ eday.getAttribute("date")+ "  "+ day.getTextContent());
                         }
                     }
                 }


                 }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

