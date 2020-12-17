package br.com.meowlenium.framework.reports;

import br.com.meowlenium.framework.utils.Mailer;
import br.com.meowlenium.framework.reports.models.ReportModel;
import br.com.meowlenium.framework.utils.Directory;
import br.com.meowlenium.framework.utils.Property;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.service.ExtentService;
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
        if (!Property.getEnv().equals("hom")) {
            try {
                // TODO: É necessário aguardar ao menos 3 segundos para o reporte seja gerado e extraído
                Thread.sleep(3000);
                File fileReport = new File(Directory.REPORT_FOLDER + File.separator + "report.html");
                ReportModel report = Report.extract(fileReport);
                String mailBody = Mailer.builder(report);
                Mailer.send(Property.get("email", "email.to"), mailBody, fileReport);
            } catch (InterruptedException ignored) {
            }
        }
    }
}