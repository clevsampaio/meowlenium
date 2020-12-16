package br.com.meow.framework.reports.fragments;

import br.com.meow.framework.reports.models.ReportModel;
import br.com.meow.framework.reports.models.TestModel;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportFragment {
    public ReportModel fragment(Document doc, List<TestModel> testModel, String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Elements suiteStartTime = doc.select(".suite-start-time");
        Elements suiteTests = doc.select("#dashboard-view > div > div > div:nth-child(1) > div > div");
        Elements suiteSteps = doc.select("#dashboard-view > div > div > div:nth-child(2) > div > div");
        Elements suiteStart = doc.select("#dashboard-view > div > div > div:nth-child(3) > div > div");
        Elements suiteEnd = doc.select("#dashboard-view > div > div > div:nth-child(4) > div > div");

        LocalDateTime startTime = LocalDateTime.parse(suiteStartTime.text(), formatter);
        int quantTests = Integer.parseInt(suiteTests.text());
        int quantSteps = Integer.parseInt(suiteSteps.text());
        LocalDateTime reportStart = LocalDateTime.parse(suiteStart.text(), formatter);
        LocalDateTime reportEnd = LocalDateTime.parse(suiteEnd.text(), formatter);
        Duration timeTaken = Duration.between(reportStart, reportEnd);

        return new ReportModel(fileName, startTime, quantTests, quantSteps, reportStart, reportEnd, timeTaken, testModel);
    }
}