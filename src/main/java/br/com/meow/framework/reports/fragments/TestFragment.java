package br.com.meow.framework.reports.fragments;

import br.com.meow.framework.reports.models.StepModel;
import br.com.meow.framework.reports.models.TestModel;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestFragment {
    public TestModel fragment(Element test, int testCount) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<Map<String, String>> testTimeInfo = new ArrayList<>();
        Map<String, String> mapTimeInfo = new HashMap<>();
        List<StepModel> stepModel = new ArrayList<>();

        String testName = test.select("span[class='test-name']").text();

        Elements testTimeObj = test.select("span[class='test-time']");
        LocalDateTime testTime;

        if(!testTimeObj.isEmpty()) {
            testTime = LocalDateTime.parse(testTimeObj.text(), formatter);
        } else {
            testTime = LocalDateTime.now();
        }

        String testStatus = test.select("span[class*='test-status']").get(0).text();

        mapTimeInfo.put("startTime",
                test.select("div[class='test-content hide'] .test-time-info span[class*='start-time']").text());
        mapTimeInfo.put("endTime",
                test.select("div[class='test-content hide'] .test-time-info span[class*='end-time']").text());
        mapTimeInfo.put("timeTaken",
                test.select("div[class='test-content hide'] .test-time-info span[class*='time-taken']").text());
        testTimeInfo.add(mapTimeInfo);

        StepFragment stepFragment = new StepFragment();

        if(!stepFragment.fragment(test, testCount).isEmpty()) {
            stepModel = stepFragment.fragment(test, testCount);
        }

        return new TestModel(testName, testTime, testStatus, testTimeInfo, stepModel);
    }
}