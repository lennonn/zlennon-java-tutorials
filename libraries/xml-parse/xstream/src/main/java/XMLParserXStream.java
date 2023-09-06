import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class XMLParserXStream {

    public static void main(String[] args) {

        String xmlFilePath = "test.xml"; // Replace with the actual path

        // Get the class loader for the current thread
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();


        // Load the XML file as an InputStream
        try (InputStream inputStream =  XMLParserXStream.class.getResourceAsStream(xmlFilePath)) {
            if (inputStream != null) {
                // Initialize XStream
                XStream xstream = new XStream(new DomDriver());
                xstream.addPermission(AnyTypePermission.ANY);

                // Register the class to be used for parsing
                xstream.processAnnotations(Project.class); // Replace with your own class

                // Parse the XML and extract the object
                Project mavenPom = (Project) xstream.fromXML(inputStream);

                // Access the extracted information
                System.out.println(mavenPom.toString());
                objectToXml(mavenPom);
            } else {
                System.err.println("XML file not found on the classpath: " + xmlFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    static void   objectToXml(Project person){
        // Initialize XStream
        XStream xstream = new XStream();

        // Convert the Person object to XML
        String xml = xstream.toXML(person);

        String filePath = "D:\\IdeaProject\\zlennon-tutorials\\libraries\\xml-parse\\xstream\\src\\main\\resources\\gen_pom.xml";


        try {
            InputStream resourceStream = XMLParserXStream.class.getResourceAsStream(filePath);
            // Create a FileWriter to write the XML to the file
            FileWriter fileWriter = new FileWriter(filePath);

            // Write the XML to the file
            fileWriter.write(xml);

            // Close the FileWriter
            fileWriter.close();

            System.out.println("XML saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
