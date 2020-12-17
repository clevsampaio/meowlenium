package br.com.meowlenium.framework.reports;

import br.com.meowlenium.framework.utils.Mailer;
import br.com.meowlenium.framework.reports.models.ReportModel;
import br.com.meowlenium.framework.utils.Directory;
import br.com.meowlenium.framework.utils.Property;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.File;

public class ReportListener implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        if (!Property.getEnv().equals("hom")) {
            try {
                // TODO: É necessário aguardar ao menos 5 segundos para o reporte seja gerado e extraído
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