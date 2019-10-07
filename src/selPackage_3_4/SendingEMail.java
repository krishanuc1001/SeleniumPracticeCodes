package selPackage_3_4;

import org.apache.commons.mail.*;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.MultiPartEmail;
//import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendingEMail {

	@Test(priority = 1, description = "This method sends a Simple text email.")
	public void SimpleEmail() throws EmailException {

		System.out.println("<====SIMPLE EMAIL IS GOING TO BE SENT====>");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("krishanuc1001@gmail.com", "********");
		email.setSSLOnConnect(true);
		email.setFrom("krishanuc1001@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("krish.shanu100@gmail.com");
		email.send();
		System.out.println("<====SIMPLE EMAIL HAS BEEN SENT====>");

	}

	// Sending emails with attachments
	// To add attachments to an email, you will need to use the MultiPartEmail
	// class. This class works just like SimpleEmail except that it adds several
	// overloaded attach() methods to add attachments to the email. You can add an
	// unlimited number of attachments either inline or attached. The attachments
	// will be MIME encoded.
	// The simplest way to add the attachments is by using the EmailAttachment class
	// to reference your attachments.
	// In the following example, we will create an attachment for a picture. We will
	// then attach the picture to the email and send it.

	// Create the attachment
	@Test(priority = 2)
	public void EmailWithAttachment() throws EmailException {

		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("mypictures/john.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of John");
		attachment.setName("John");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("mail.myserver.com");
		email.addTo("jdoe@somewhere.org", "John Doe");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}

}