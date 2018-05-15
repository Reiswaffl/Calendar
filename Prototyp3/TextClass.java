package Main;

import ReturnValues.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import XML.*;


public class TextClass{
    public static void main(String[] args) {
        XMLReader xmlReader = new XMLReader();
        Reader reader = new Reader();
        Node user = xmlReader.GetUser("Eric");
        Node year = xmlReader.GetYearById("18",user.getChildNodes());
        xmlReader.CreateMonth(year,"01","Januar","31");
        Node month = xmlReader.GetMonthById("01",year.getChildNodes());
        xmlReader.CreateDay(month,"180102","Monday","false");
        xmlReader.CreateDay(month,"180103","Wednesday","false");
        System.out.println(reader.GetNextFreeDay("Eric"));


    }
}

