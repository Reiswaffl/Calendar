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
        System.out.println(reader.GetNextFreePeriod("Eric","04","19","2"));


    }
}

