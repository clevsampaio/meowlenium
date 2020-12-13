package br.com.meow.framework.reports;

import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;

public class Report {
    public static void log(Status status, String details) {
        ExtentTestManager.getTest().log(status, details);
    }

    public static void log(Status status, String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().log(status, details, provider);
    }

    public static void pass(String details) {
        ExtentTestManager.getTest().pass(details);
    }

    public static void pass(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().pass(details, provider);
    }

    public static void info(String details) {
        ExtentTestManager.getTest().info(details);
    }

    public static void info(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().info(details, provider);
    }

    public static void warning(String details) {
        ExtentTestManager.getTest().warning(details);
    }

    public static void warning(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().warning(details, provider);
    }

    public static void fail(String details) {
        ExtentTestManager.getTest().fail(details);
    }

    public static void fail(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().fail(details, provider);
    }

    public static void error(String details) {
        ExtentTestManager.getTest().error(details);
    }

    public static void error(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().error(details, provider);
    }

    public static void fatal(String details) {
        ExtentTestManager.getTest().fatal(details);
    }

    public static void fatal(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().fatal(details, provider);
    }

    public static void skip(String details) {
        ExtentTestManager.getTest().skip(details);
    }

    public static void skip(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().skip(details, provider);
    }

    public static void debug(String details) {
        ExtentTestManager.getTest().debug(details);
    }

    public static void debug(String details, MediaEntityModelProvider provider) {
        ExtentTestManager.getTest().debug(details, provider);
    }
}