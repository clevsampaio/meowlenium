package br.com.meowlenium.framework.reports;

import br.com.meowlenium.framework.reports.models.ReportModel;
import br.com.meowlenium.framework.utils.Directory;
import br.com.meowlenium.framework.utils.Mailer;
import br.com.meowlenium.framework.utils.Property;
import br.com.meowlenium.framework.utils.Rest;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.service.ExtentService;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.File;

public class ReportListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
        ExtentService.getInstance().setSystemInfo("Ambiente", Property.getEnv());
        ExtentService.getInstance().setSystemInfo("Sistema", System.getProperty("os.name"));
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            // TODO: É necessário aguardar ao menos 3 segundos para o reporte seja gerado e extraído
            Thread.sleep(3000);

            String email = System.getProperty("property.email");
            String report = System.getProperty("property.report");

            if (!StringUtils.isEmpty(email) && email.equals("true")) {
                File fileReport = new File(Directory.REPORT_FOLDER + File.separator + "report.html");
                ReportModel reportExtract = Report.extract(fileReport);
                String mailBody = Mailer.builder(reportExtract);
                Mailer.send(Property.get("email", "email.to"), mailBody, fileReport);
            }

            if (!StringUtils.isEmpty(report) && report.equals("true")) {
                File fileReport = new File(Directory.REPORT_FOLDER + File.separator + "report.html");
                ReportModel reportExtract = Report.extract(fileReport);
                String path = "/api/project/" + Property.get("report", "token");
                Rest rest = new Rest(Property.get("report", "url"));
                rest.post(path, 200, Report.json(reportExtract));
            }
        } catch (InterruptedException ignored) {
        }
    }
}