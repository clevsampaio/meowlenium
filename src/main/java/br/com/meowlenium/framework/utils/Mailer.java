package br.com.meowlenium.framework.utils;

import br.com.meowlenium.framework.reports.models.ReportModel;
import br.com.meowlenium.framework.reports.models.TestModel;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Date;
import java.util.Properties;

public class Mailer {
    public static void send(String toEmail, String body, File file){
        final String fromEmail = Property.get("email", "email.from");
        final String password = Property.get("email", "email.pass");

        Properties props = new Properties();
        props.put("mail.smtp.host", Property.get("email", "email.host"));
        props.put("mail.smtp.socketFactory.port", Property.get("email", "email.port"));
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", Property.get("email", "email.auth"));
        props.put("mail.smtp.port", Property.get("email", "email.port"));

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, "Equipe de Automação"));
            message.setReplyTo(InternetAddress.parse(fromEmail, false));
            message.setSubject(Property.get("email", "email.subject"));
            message.setText(body);
            message.setSentDate(new Date());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Multipart multiPart = new MimeMultipart();
            MimeBodyPart mpb = new MimeBodyPart();
            mpb.setContent(body, "text/html; charset=utf-8");
            multiPart.addBodyPart(mpb);

            MimeBodyPart report = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(file.getPath());
            report.setDataHandler(new DataHandler(fds));
            report.setFileName(fds.getName());
            multiPart.addBodyPart(report);

            message.setContent(multiPart, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String builder(ReportModel report) {
        StringBuilder sb = new StringBuilder();

        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" style=\"width:100%;margin:0;padding:0;transform:scale(0.513548,0.513548);transform-origin:center top;\" min-scale=\"0.5135483870967742\">\n" +
                "\t\t<tbody>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td align=\"center\" valign=\"top\" style=\"width:100%;margin:0;padding:0;\">\n" +
                "\t\t\t\t\t<table width=\"775\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"x_m-shell\">\n" +
                "\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td class=\"x_td\" style=\"width:775px; min-width:775px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal\">\n" +
                "\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td class=\"x_p-80 x_mpy-35 x_mpx-15\" bgcolor=\"#212429\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding:80px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t   cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"x_img x_pb-45\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:0pt; line-height:0pt; text-align:left; padding-bottom:45px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   target=\"_blank\" rel=\"noopener noreferrer\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   data-auth=\"NotApplicable\"><img\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-imagetype=\"External\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc='" + Property.get("email", "image.url") + "'\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth='" + Property.get("email", "image.width") + "' height='" + Property.get("email", "image.height") + "' border=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talt=\"\"></a></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"x_title-36 x_pb-30 x_c-grey6 x_fw-b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:36px; line-height:42px; font-family:'Motiva Sans',Helvetica,Arial,sans-serif; text-align:left; padding-bottom:30px; color:#bfbfbf; font-weight:bold\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOlá <span style='font-size:42px;'>&#128075;</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:20px; line-height:25px; font-family:'Motiva Sans',Helvetica,Arial,sans-serif; text-align:left; color:#dbdbdb;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEste e-mail foi gerado devido a uma execução automatizada, dados desta execução foram coletadas e para seu conforto, \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tenviamos-lhe um resumo dos testes que passaram ou falharam pelo nosso controle de qualidade, veja abaixo:\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br><br><br>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>");


        for (TestModel testModel : report.getTestModel()) {
            String testStatus;

            if(testModel.getStatus().equals("pass")) {
                testStatus = "<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/success.png' />";
            } else if(testModel.getStatus().equals("warning")) {
                testStatus = "<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/warning.png' />";
            } else if(testModel.getStatus().equals("fail")) {
                testStatus = "<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/error.png' />";
            } else {
                testStatus = "<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/minus.png' />";
            }


            sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"line-height:40px;\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width='35'>" + testStatus + "</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:22px\">" + testModel.getName() + "</span>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n");
        }

        sb.append("</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br><br>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/success.png' />\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:22px\">Passou</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/warning.png' />\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:22px\">Alerta</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/error.png' />\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:22px\">Falhou</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src='https://raw.githubusercontent.com/clevsampaio/resources/master/minus.png' />\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:22px\">Desconhecido</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr height=\"50\"></tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px; line-height:22px; font-family:'Motiva Sans',Helvetica,Arial,sans-serif; text-align:left;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:18px;color:#999;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tVersão completa do reporte segue em anexo!\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr height=\"50\"></tr>" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"x_img\" width=\"3\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#F16A70\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:0pt; line-height:0pt; text-align:left\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"x_img\" width=\"37\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:0pt; line-height:0pt; text-align:left\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   cellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   cellpadding=\"0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"x_text-16 x_py-20 x_c-grey4 x_fallback-font\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:16px; line-height:22px; font-family:'Motiva Sans',Helvetica,Arial,sans-serif; text-align:left; padding-top:20px; padding-bottom:20px; color:#f1f1f1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAté a próxima,<br>A\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tequipe de Automação\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"width:100%;font-size:18px;line-height:25px;color:#000001;font-family:'Motiva Sans',Helvetica,Arial,sans-serif;text-align:center;padding:60px 0\">\n" +
                "\t\t\t\t\t\t\t\tEsta mensagem foi gerada automaticamente. Não\n" +
                "\t\t\t\t\t\t\t\tresponda a este e-mail.\n" +
                "\t\t\t\t\t\t\t\t<br>Caso necessite de ajuda,\n" +
                "\t\t\t\t\t\t\t\tentre em contato com nosso suporte.<br><br>\n" +
                "\t\t\t\t\t\t\t\t<a href='mailto:" + Property.get("email", "email.support") + "' target=\"_blank\" rel=\"noopener noreferrer\" data-auth=\"NotApplicable\" \n" +
                "\t\t\t\t\t\t\t\t\tclass=\"x_link-u x_c-black\" style=\"text-decoration:underline; color:#000001\">\n" +
                "\t\t\t\t\t\t\t\t\t<span class=\"x_link-u x_c-black\" style=\"text-decoration:underline; color:#000001\">" + Property.get("email", "email.support") + "</span>\n" +
                "\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</tbody>\n" +
                "\t</table>");

        return sb.toString();
    }
}