package lab3.view;

import lab3.controller.HealthRecords;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by Navid on 10/22/2015.
 *
 * Class Start
 * including 'void main()' for running some tests based on Lab 3 instructions
 */
public class Start {
    public static void main(String[] args) throws Exception
    {
        HealthRecords hR = new HealthRecords();
        //running test based on 3.1
        System.out.println("\nInstruction 1 of Lab 3: getWeight() AND getHeight() method");
        hR.lab3_1_1(5); hR.lab3_1_2(5); //get Weight and Height for personId 5
        //running test based on 3.2
        System.out.println("\nInstruction 2 of Lab 3: Printing all people in the list with detail");
        hR.lab3_2();
        //running test based on 3.3
        System.out.println("\nInstruction 3 of Lab 3: Printing the Health Profile of the person by his ID");
        hR.lab3_3(5); //prints healthprofile of ID #5
        //running test based on 3.4
        System.out.println("\nInstruction 4 of Lab 3: Printing people with specific weight condition");
        hR.lab3_4("90",">"); //prints people with weight more than 90kg.
    }
}
