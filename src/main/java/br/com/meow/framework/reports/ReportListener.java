package br.com.meow.framework.reports;

import br.com.meow.framework.utils.Mailer;
import br.com.meow.framework.reports.models.ReportModel;
import br.com.meow.framework.utils.Directory;
import br.com.meow.framework.utils.Property;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.File;

public class ReportListener implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        if (!Property.getEnv().equals("hom")) {
            try {
                // TODO: É necessário aguardar ao menos 5 segundos para o reporte seja gerado e extraído
                Thread.sleep(5000);
                String fileReport = Directory.REPORT_FOLDER + File.separator + "report.html";
                ReportModel report = Report.extract(fileReport);
                String mailBody = Mailer.builder(report);
                Mailer.send(Property.get("email", "email.to"), mailBody);
            } catch (InterruptedException ignored) {
            }
        }
    }
}