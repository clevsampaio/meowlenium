package br.com.meow.framework.reports.fragments;

import br.com.meow.framework.reports.models.LogModel;
import br.com.meow.framework.reports.models.StepModel;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StepFragment {
    public List<StepModel> fragment(Element test, int testCount) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<StepModel> stepModel = new ArrayList<>();

        int stepCount = 1;

        Elements steps = test.select(":nth-child(" + testCount + ") ul li div[class='collapsible-header']");
        if (!steps.isEmpty()) {
            for (Element step : steps) {
                List<LogModel> logModel = new ArrayList<>();

                String stepName = step.select(".node-name").text();
                String stepTime = step.select(".node-time").text();
                String stepDuration = step.select(".node-duration").text();
                String stepStatus = step.select("span[class*='test-status']").text();

                LocalDateTime stepTimeLd = LocalDateTime.parse(stepTime, formatter);
                LogFragment logFragment = new LogFragment();

                if(!logFragment.fragment(test, testCount, stepCount).isEmpty()) {
                    logModel = logFragment.fragment(test, testCount, stepCount);
                }

                stepModel.add(new StepModel(stepName, stepTimeLd, stepDuration, stepStatus, logModel));
                stepCount++;
            }
        }

        return stepModel;
    }
}