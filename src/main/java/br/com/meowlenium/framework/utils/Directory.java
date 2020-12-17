package br.com.meowlenium.framework.utils;

import java.io.File;

public class Directory {
    public static String ROOT_FOLDER = System.getProperty("user.dir");
    public static String REPORT_FOLDER = System.getProperty("user.dir") + File.separator + "report";
    public static String OBJECTS_FOLDER = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "test" + File.separator + "resources" + File.separator + "objects";
}