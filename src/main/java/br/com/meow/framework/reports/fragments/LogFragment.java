package br.com.meow.framework.reports.fragments;

import br.com.meow.framework.reports.models.LogModel;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.Jsoup.clean;

public class LogFragment {
    public List<LogModel> fragment(Element test, int testCount, int stepCount) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
        List<LogModel> logModel = new ArrayList<>();

        Elements logs = test.select(":nth-child(" + testCount + ") ul li:nth-child(" + stepCount + ") div[class='collapsible-body'] table tbody tr");

        if (!logs.isEmpty()) {
            for (Element log : logs) {
                String status = log.select("td[class*='status']").attr("title");
                String timeStamp = log.select("td[class='timestamp']").text();
                String details = clean(log.select("td[class='step-details']").html(),
                        Whitelist.none().addTags("br")).replace("base64-img", "");

                String showMail = log.select("td[class='step-details'] #showMail").text();
                boolean addReport = true;

                if (showMail.isEmpty()) {
                    addReport = false;
                }

                String base64img = log.select("td[class='step-details'] a").attr("href");

                LocalTime logTimeStamp = LocalTime.parse(timeStamp, formatter);
                logModel.add(new LogModel(status, logTimeStamp, details, base64img));
            }
        }

        return logModel;
    }
}