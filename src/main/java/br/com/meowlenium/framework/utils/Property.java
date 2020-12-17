package br.com.meowlenium.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Property {
    public static String get(String test, String property) {
        String filePath = "settings/" + getEnv() + "/" + test + ".properties";

        try (InputStream propertyFile = Property.class.getClassLoader().getResourceAsStream(filePath)) {
            Properties properties = new Properties();
            properties.load(propertyFile);

            return properties.getProperty(property);
        } catch (IOException ex) {
            throw new RuntimeException("Arquivo (" + filePath + ") não encontrado!", ex);
        }
    }

    public static String getEnv() {
        if (Objects.nonNull(System.getProperty("property.env"))) {
            return System.getProperty("property.env");
        }

        return "hom";
    }
}