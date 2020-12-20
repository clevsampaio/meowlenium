package br.com.meowlenium.framework.reports;

import br.com.meowlenium.framework.reports.fragments.ReportFragment;
import br.com.meowlenium.framework.reports.fragments.TestFragment;
import br.com.meowlenium.framework.reports.models.LogModel;
import br.com.meowlenium.framework.reports.models.ReportModel;
import br.com.meowlenium.framework.reports.models.StepModel;
import br.com.meowlenium.framework.reports.models.TestModel;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public static ReportModel extract(File reportFile) {
        try {
            Document doc = Jsoup.parse(reportFile, "UTF-8");

            List<TestModel> testModel = new ArrayList<>();
            int testCount = 1;

            Elements tests = doc.select("#test-collection > li");

            for (Element test : tests) {
                TestFragment testFragment = new TestFragment();

                if (!testFragment.fragment(test, testCount).getName().isEmpty()) {
                    testModel.add(testFragment.fragment(test, testCount));
                }

                testCount++;
            }

            return new ReportFragment().fragment(doc, testModel, reportFile.getName());
        } catch (IOException e) {
            throw new RuntimeException("Erro de leitura no arquivo [" + reportFile + "].", e);
        }
    }

    public static String json(ReportModel report)
    {
        DateTimeFormatter formatter_ddMMyyyyHHmmss = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter_HHmmss = DateTimeFormatter.ofPattern("HH:mm:ss");

        StringBuilder sb = new StringBuilder();

        sb.append("{").
                append("\"fileName\":\"" + report.getFileName() + "\",").
                append("\"suiteStartTime\":\"" + report.getSuiteStartTime().format(formatter_ddMMyyyyHHmmss) + "\",").
                append("\"tests\":\"" + report.getTests() + "\",").
                append("\"steps\":\"" + report.getSteps() + "\",").
                append("\"start\":\"" + report.getStart().format(formatter_ddMMyyyyHHmmss) + "\",").
                append("\"end\":\"" + report.getEnd().format(formatter_ddMMyyyyHHmmss) + "\",").
                append("\"timeTaken\":\"" + report.getTimeTaken().toSeconds() + "\",").
                append("\"testModel\":[");

        int testModelCount = report.getTestModel().size();
        int testModelFor = 1;

        for (TestModel testModel : report.getTestModel()) {
            sb.append("{").
                    append("\"name\":\"" + testModel.getName() + "\",").
                    append("\"time\":\"" + testModel.getTime().format(formatter_ddMMyyyyHHmmss) + "\",").
                    append("\"status\":\"" + testModel.getStatus() + "\",").
                    append("\"stepModel\":[");

            int stepModelCount = testModel.getStepModel().size();
            int stepModelFor = 1;

            for (StepModel stepModel : testModel.getStepModel()) {
                sb.append("{").
                        append("\"name\":\"" + stepModel.getName() + "\",").
                        append("\"time\":\"" + stepModel.getTime().format(formatter_ddMMyyyyHHmmss) + "\",").
                        append("\"duration\":\"" + stepModel.getDuration() + "\",").
                        append("\"status\":\"" + stepModel.getStatus() + "\",").
                        append("\"logModel\":[");

                int logModelCount = stepModel.getLogModel().size();
                int logModelFor = 1;

                for (LogModel logModel : stepModel.getLogModel()) {
                    sb.append("{").
                            append("\"status\":\"" + logModel.getStatus() + "\",").
                            append("\"timeStamp\":\"" + logModel.getTimeStamp().format(formatter_HHmmss) + "\",").
                            append("\"details\":\"" + logModel.getDetails() + "\",").
                            append("\"base64img\":\"" + logModel.getBase64img() + "\"");

                    if (logModelCount == logModelFor) {
                        sb.append("}");
                    } else {
                        sb.append("},");
                    }

                    logModelFor++;
                }

                sb.append("]");
                if (stepModelCount == stepModelFor) {
                    sb.append("}");
                } else {
                    sb.append("},");
                }

                stepModelFor++;
            }

            sb.append("]");
            if (testModelCount == testModelFor) {
                sb.append("}");
            } else {
                sb.append("},");
            }

            testModelFor++;
        }

        sb.append("]").append("}");

        return sb.toString();
    }
}