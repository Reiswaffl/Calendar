package XML;

//Imports
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Writer {
    XMLReader xmlReader;
    Reader reader = new Reader();

    public Writer(){
        xmlReader = new XMLReader();
    }
    public void AddUser(String name){

    }
    public void AddPeriod(String user, String date, String period, String content){
    }
    public void SetDayBusy(String user, String date, String content){}
    public void SetDayBusy(String user, String date){}

}
