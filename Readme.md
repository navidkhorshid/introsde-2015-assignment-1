#SDE-Assignment #1 

## About the code
###- What is in '\src'?
![alt text](/code_structure.png?raw=true "Source Code Structure")
There are two main packages in \src:
#### \lab3
This includes the source code for the 1st part of the assignment (Lab#3) based on MVC architecture.  View is using Controller and Controller is connected to the Model where it talks with Business Logic (\bl\User.java).
- \view\Start: Including 'void main()' for running some tests based on Lab 3 instructions
- \controller\HealthRecords: Including all the methods which are going to be executed from View (Start Class)
- \model\bl\User: Including all the methods that are needed to run instructions of Lab 3
- \model\da\PersonDA: Including methods needed for running codes in BusinessLogic layer. These methods are using Person object in order to fetch data from 'people.xml' file
- \model\to\HealthProfile: Including 3 constructors, getters and setters, and a print method for HealthProfile data type.
- \model\to\Person: Including 3 constructors, getters and setters, and a print method for Person data type.

#### \people
This includes the source code for the 2nd part of the assignment (Lab#4)
- InitializeData: Including getSomePeople() method to create some data for JAXBMarshaller and JAXBMarshallerJSON
- Person_HealthProfile_Util: Including two methods which are used in 'people' project multiple times
- JAXMarshallerJSON: Printing and Generating JSON document from Java objects
- JAXMarshaller: Printing and Generating XML document from Java objects
- JAXUnMarshaller: Creating Java objects from an XML file and printing them.
 
###- 'build.xml', 'ivy.xml', 'people.xml', and 'people_data.xsd'
- build.xml is an ANT BUILD file for automation of running the program
- ivy.xml is taking care of dependencies using IVY
- people.xml includes information about 30 people. We need this for Lab#3 when we want to run the code. Basically this is the database of the Lab#3.
- people_data.xsd is our XML Schema, and we need this for Lab#4 when want to use JAXBUnMarshaller.

##Features and tasks
###Based on Lab 3
* Use xpath to implement methods like getWeight and getHeight (getWeight(personID) returns weight of a given person, the same for getHeight)
* Make a function that prints all people in the list with detail
* A function that accepts id as parameter and prints the HealthProfile of the person with that id
* A function which accepts a weight and an operator (=, > , <) as parameters and prints people that fulfill that condition (i.e., >80Kg, =75Kg, etc.).

###Based on Lab 4
* Write a java application that does the marshalling and un-marshalling using classes generated with JAXB XJC.
* Make your java application to convert also JSON

##How to run it
You simply need to type 'git clone https://github.com/navidkhorshid/introsde-2015-assignment-1.git' in terminal.
Then, change directory to 'introsde-2015-assignment-1' folder. Then run 'ant execute.evaluation'.
You will see the outputs of both lab3 and people in the console, and also two files 'people_type.xml' & 'people_type.json' will be added to the project folder as the result of running Marshallers.


##Student:
- Navid Shamsizadeh