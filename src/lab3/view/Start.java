package lab3.view;

import lab3.controller.HealthRecords;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by Navid on 10/22/2015.
 */
public class Start {
    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException
    {
        HealthRecords hR = new HealthRecords();

        //3.1
        System.out.println("\nInstruction 1 of Lab 3: getWeight() AND getHeight() method");
        hR.lab3_1_1(5); //get weight for personId 5
        hR.lab3_1_2(5); //get height for personId 5

        //3.2
        System.out.println("\nInstruction 2 of Lab 3: Printing all people in the list with detail");
        hR.lab3_2();

        //3.3
        System.out.println("\nInstruction 3 of Lab 3: Printing the Health Profile of the person by his ID");
        hR.lab3_3(5);

        //3.4
        System.out.println("\nInstruction 4 of Lab 3: Printing people with specific weight condition");
        hR.lab3_4("90",">");
    }
}
