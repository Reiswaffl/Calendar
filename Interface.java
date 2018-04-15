import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class Interface {
    Interface() {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //Console delete later and replace with GUI
            System.out.println("File read in!");
            System.out.println("-----------------------------/n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Shows/returns the information of one day (from all periods)
    public void GetDayInformation(int date) {

    }
    //Shows/returns the information a special period
    public void GetPeriodInformation(int date, int period){

    }
    //Returns the next free day
    public void getNextFreeDay(){

    }

}
