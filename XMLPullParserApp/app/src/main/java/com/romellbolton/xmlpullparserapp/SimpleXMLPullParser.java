package com.romellbolton.xmlpullparserapp;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by romellbolton on 3/22/18.
 */

// Create XML Parsing class
public class SimpleXMLPullParser {

    // Define a list
    List<Employee> employeesList;

    // Define an Employee object
    private Employee employee;

    // Define a String text
    private String text;

    // Create constructor for Parser class
    public SimpleXMLPullParser() {

        // Initialize list, and specify the type as Employee objects
        employeesList = new ArrayList<Employee>();
    }

    // Getter method for the list
    public List<Employee> getEmployeesList() {

        // Return the list of employees
        return employeesList;
    }

    // Method returns a list of employees, and
    // receives an XML file in the form of an input stream
    public List<Employee> parse(InputStream is) {

        // Create XML Parser and factory objects and initialize them to null
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try {

            // Initialize the factory object
            factory = XmlPullParserFactory.newInstance();

            // Set the name space on the factory
            factory.setNamespaceAware(true);

            // Initialize the XML parser using the Factory object
            parser = factory.newPullParser();

            // Set the input of the the parser
            parser.setInput(is, null);

            // Get the event type of the parser
            int eventType = parser.getEventType();

            // While the document is not at the end...
            while (eventType != XmlPullParser.END_DOCUMENT) {

                // Get the name of the tag
                String tagname = parser.getName();

                // Test the event type of the parser
                switch (eventType) {

                    // If the event type is a start tag...
                    case XmlPullParser.START_TAG:

                        if (tagname.equalsIgnoreCase("employee")) {
                            // create a new instance of employee
                            employee = new Employee();
                        }

                        // Break from the switch statement
                        break;

                    // If the event type is a text...
                    case XmlPullParser.TEXT:

                        // Get the text of the current tag
                        text = parser.getText();

                        // Break from the switch statement
                        break;

                    // If the event type is a end tag...
                    case XmlPullParser.END_TAG:

                        // If the end tag's name is "employee"
                        if (tagname.equalsIgnoreCase("employee")) {

                            // Add the employee object to list
                            employeesList.add(employee);

                            // If the end tag's name is "name"
                        } else if (tagname.equalsIgnoreCase("name")) {

                            // Set the text as the "name" of the employee object
                            employee.setName(text);

                            // If the end tag's name is "id"
                        } else if (tagname.equalsIgnoreCase("id")) {

                            // Set the text as the "id" of the employee object
                            employee.setId(Integer.parseInt(text));

                            // If the end tag's name is "department"
                        } else if (tagname.equalsIgnoreCase("department")) {

                            // Set the text as the "department" of the employee object
                            employee.setDepartment(text);

                            // If the end tag's name is "email"
                        } else if (tagname.equalsIgnoreCase("email")) {

                            // Set the text as the "email" of the employee object
                            employee.setEmail(text);

                            // If the end tag's name is "type"
                        } else if (tagname.equalsIgnoreCase("type")) {

                            // Set the text as the "type" of the employee object
                            employee.setType(text);
                        }

                        // Break from the switch statement
                        break;

                    // In the case if default...
                    default:

                        // Break from the switch statement
                        break;

                }

                // Go to the next event type until the document is at it's END
                eventType = parser.next();
            }

            // Exception Handle
        } catch (XmlPullParserException e) {

            // Print stack trace
            e.printStackTrace();

            // Exception Handle
        } catch (IOException e) {

            // Print stack trace
            e.printStackTrace();

        }

        // Return the list of employees
        return employeesList;
    }

}
