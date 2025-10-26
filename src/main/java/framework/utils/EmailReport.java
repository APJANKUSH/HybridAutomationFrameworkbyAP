package framework.utils;

																								
import java.util.Properties;
import java.util.ResourceBundle;

import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Authenticator;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;

class EmailReport {

	static String hashPassword = getURL().getString("password"); 
	static String email = getURL().getString("fromEmail");
	
	static ResourceBundle getURL(){
		ResourceBundle router =  ResourceBundle.getBundle("router");
		return router;
	}
	public static void sendReport(String fromEmail1, String password1, String toEmail1,
            String reportFilePath, int total, int passed, int failed, int skipped) 
	{
        // === SMTP Configuration ===
        final String fromEmail = email;  // sender
        final String password = hashPassword;     // use App Password (not real Gmail password)
        final String toEmails = email;  // receiver

        // Mail properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

       
        
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Compose Message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmails));
            msg.setSubject("Automation Test Execution Report");
//            msg.setText("Hi Team,\n\nPlease find attached the latest automation test report.\n\nRegards,\nAutomation Framework");
            String htmlBody = "<html>"
            		+ "<body style='font-family: Arial, sans-serif;'>"
                    + "<h3 style='color: #2E86C1;'>Hi Team,</h3>"
                    + "<p>The automation test execution has completed. Please find the summary below and the attached detailed report.</p>"
                    + "<table style='border-collapse: collapse; width: 50%;'>"
                    + "<tr>"
                    + "<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Total Tests</th>"
                    + "<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Passed</th>"
                    + "<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Failed</th>"
                    + "<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Skipped</th>"
                    + "</tr>"
                    + "<tr style='text-align: center;'>"
                    + "<td style='border: 1px solid #ddd; padding: 8px;'>" + total + "</td>"
                    + "<td style='border: 1px solid #ddd; padding: 8px; color: green;'>" + passed + "</td>"
                    + "<td style='border: 1px solid #ddd; padding: 8px; color: red;'>" + failed + "</td>"
                    + "<td style='border: 1px solid #ddd; padding: 8px; color: orange;'>" + skipped + "</td>"
                    + "</tr>"
                    + "</table>"
                    + "<p>For detailed results, please see the attached Extent Report.</p>"
                    + "<p><i>Regards,<br>Ankush Pawar- QA Engineer</i></p>"
                    + "</body>"
                    + "</html>";

            // Attach Report File
            
            InternetAddress emailAddr = new InternetAddress(toEmails);
            emailAddr.validate(); // validates RFC 5321
            msg.setRecipient(Message.RecipientType.TO, emailAddr);
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlBody, "text/html; charset=UTF-8");
            
         
            
//            messageBodyPart.setText("Hi Team,\\n\\nPlease find attached the latest automation test report.\\n\\nRegards,\\nAutomation Framework");
//            messageBodyPart.setText("Please find the attached Extent Report.");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            String reportFile = System.getProperty("user.dir") + "/reports/"+Reporting.repName;
            attachmentPart.attachFile(reportFile); 
            
            MimeBodyPart pdfAttachment = new MimeBodyPart();
            pdfAttachment.attachFile(reportFile);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            msg.setContent(multipart);

            // Send Email
            Transport.send(msg);
            System.out.println("Email sent successfully with report attachment!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}
