package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileReader reader=new FileReader("src/main/resources/prop/environment.property");
        properties.load(reader);
        System.out.println(properties.getProperty("endpoint"));
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key + " - " + properties.getProperty(key));
        }
    }


}
